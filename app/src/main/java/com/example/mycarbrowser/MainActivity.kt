package com.example.mycarbrowser

import android.app.Activity
import android.os.Bundle
import android.webkit.*
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = 1

        val url = EditText(this)
        url.hint = "اكتب الموقع أو ابحث"
        layout.addView(url)

        val web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.webViewClient = WebViewClient()

        val go = Button(this)
        go.text = "اذهب"
        go.setOnClickListener {
            val text = url.text.toString().trim()
            if (text.isNotEmpty()) {
                web.loadUrl(
                    if (text.contains(".") && !text.contains(" "))
                        "https://$text"
                    else "https://www.google.com/search?q=$text"
                )
            }
        }

        layout.addView(go)
        layout.addView(web, LinearLayout.LayoutParams(-1, 0, 1f))
        setContentView(layout)

        web.loadUrl("https://www.google.com")
    }
}
