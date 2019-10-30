package com.pittvandewitt.dinogame

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mWebView = WebView(this)

        mWebView.clearCache(true)
        mWebView.clearHistory()
        mWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        val activity = this

        mWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }
        }

        mWebView.loadUrl("https://dinogame-client.netlify.com/")
        setContentView(mWebView)
    }
}

