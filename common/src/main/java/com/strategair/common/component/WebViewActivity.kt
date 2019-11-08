package com.strategair.common.component

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.strategair.common.R
import com.strategair.common.service.tintDrawable
import com.tencent.smtt.export.external.interfaces.*
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        setNavigationIcon()
        initWebView()
        webView.loadUrl(intent.getStringExtra(EXTRA_URL))
    }

    private fun setNavigationIcon() {
        val d = ContextCompat.getDrawable(this, R.drawable.icon_close)
        toolbar.navigationIcon = d?.tintDrawable(Color.BLACK)
    }

    @Suppress("DEPRECATION")
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.webChromeClient = XWebChromeClient()
        webView.webViewClient = XWebViewClient()
        webView.setDownloadListener(XDownloadListener())
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT

            savePassword = false
            allowFileAccess = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
        }
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
            return
        } else {
            return super.onBackPressed()
        }
    }

    companion object {
        private const val EXTRA_URL = "URL"
        private const val EXTRA_TITLE = "TITLE"
        private const val ABOUT_BLANK = "about:blank"

        fun startActivity(activity: Activity, url: String) {
            Intent(activity, WebViewActivity::class.java)
                    .putExtra(EXTRA_URL, url)
                    .run { activity.startActivity(this) }
        }

        fun startActivity(activity: Activity, url: String, title: String) {
            Intent(activity, WebViewActivity::class.java)
                    .putExtra(EXTRA_URL, url)
                    .putExtra(EXTRA_TITLE, title)
                    .run { activity.startActivity(this) }
        }
    }

    inner class XWebChromeClient : WebChromeClient() {
        override fun onReceivedTitle(view: WebView, title: String) {
            if (title.isNotEmpty() && !title.startsWith("http")) {
                toolbar.title = title
            }
        }

        override fun onProgressChanged(WebView: WebView, newProgress: Int) {
            if (newProgress in 1..99) {
                progressBar.progress = newProgress
                progressBar.isVisible = true
            } else {
                progressBar.isVisible = false
            }
        }
    }

    class XWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView, p1: String) {
            super.onPageFinished(view, p1)
        }

        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            super.onReceivedSslError(view, handler, error)
        }

        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            super.onReceivedError(view, request, error)
        }

        override fun onReceivedHttpError(view: WebView, resourceRequest: WebResourceRequest, response: WebResourceResponse) {
            super.onReceivedHttpError(view, resourceRequest, response)
        }
    }

    class XDownloadListener : com.tencent.smtt.sdk.DownloadListener {
        override fun onDownloadStart(url: String, userAgent: String, contentDisposition: String,
                                     mimetype: String, contentLength: Long) {
        }
    }
}
