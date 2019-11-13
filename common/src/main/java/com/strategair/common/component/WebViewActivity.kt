package com.strategair.common.component

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.strategair.common.R
import com.strategair.common.service.tintDrawable
import com.strategair.common.utils.getApplicationLabel
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.view_toolbar.*

class WebViewActivity : ImmersiveActivity() {

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
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
        webView.setDownloadListener(DownloadListener())
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
            savePassword = false
            allowFileAccess = false
            setAppCacheEnabled(true)

            // Allow both HTTP and HTTPS resource.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
        }
    }

    override fun onResume() {
        webView.onResume()
        webView.resumeTimers()
        super.onResume()
    }

    override fun onPause() {
        webView.onPause()
        webView.pauseTimers()
        super.onPause()
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
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
        private const val ABOUT_BLANK = "about:blank"

        fun startActivity(context: Context, url: String) {
            Intent(context, WebViewActivity::class.java)
                .putExtra(EXTRA_URL, url)
                .run { context.startActivity(this) }
        }
    }

    inner class WebChromeClient : com.tencent.smtt.sdk.WebChromeClient() {
        override fun onReceivedTitle(view: WebView, title: String) {
            toolbar.title = title
        }

        override fun onProgressChanged(WebView: WebView, newProgress: Int) {
            progressBar.progress = newProgress
        }
    }

    inner class WebViewClient : com.tencent.smtt.sdk.WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            progressBar.isVisible = true
        }

        override fun onPageFinished(view: WebView, p1: String) {
            progressBar.isVisible = false
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return if (url.startsWith("tel:")) {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(url)))
                true
            } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
                val i = Intent(Intent.ACTION_VIEW).setData(Uri.parse(url))
                val n = i.resolveActivity(packageManager)
                if (n != null) {
                    val label = getApplicationLabel(n.packageName)
                    Log.i("WebViewClient", "Received label:${label}")
                }
                true
            } else {
                super.shouldOverrideUrlLoading(view, url)
            }
        }
    }

    inner class DownloadListener : com.tencent.smtt.sdk.DownloadListener {
        override fun onDownloadStart(url: String, userAgent: String, contentDisposition: String,
                                     mimetype: String, contentLength: Long) {
        }
    }
}
