package com.pittvandewitt.dinogame

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mWebView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mWebView = WebView(this)
            .apply {
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                }
                loadUrl("https://dinogame-client.netlify.com/")
            }
        setContentView(mWebView)
    }

    override fun onPause() {
        super.onPause()
        mWebView?.onPause()
    }

    override fun onResume() {
        super.onResume()
        mWebView?.onResume()
    }
}
