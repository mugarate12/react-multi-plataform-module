package com.example.reactnavigationmodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reactnavigationmodule.ui.theme.ReactNavigationModuleTheme

import android.webkit.WebViewClient
import android.webkit.WebView
import android.webkit.WebChromeClient
import android.graphics.Bitmap
import android.webkit.ConsoleMessage
import android.webkit.SslErrorHandler
import android.net.http.SslError
import android.util.Log
import android.webkit.WebSettings
import androidx.activity.addCallback
import android.content.res.AssetManager
import android.webkit.WebResourceRequest

class MainActivity : ComponentActivity() {
    private lateinit var webView: WebView

    private fun logAssets(path: String = "") {
        try {
            val assets = assets.list(path)
            assets?.forEach { name ->
                val fullPath = if (path.isEmpty()) name else "$path/$name"
                Log.d("ASSETS", fullPath)


            }
        } catch (e: Exception) {
            Log.e("ASSETS", "Erro ao listar assets", e)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webView = findViewById(R.id.web_view)
        // puts access from web view
        with(webView.settings) {
            allowFileAccess = true
            allowContentAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        webView.webViewClient = WebViewClientCustom()
        webView.webChromeClient = WebChromeClientCustomPoster()
        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.domStorageEnabled = true
//        webView.settings.setSupportZoom(true)
        webView.settings.mediaPlaybackRequiresUserGesture = false
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.settings.setSupportMultipleWindows(false)
        webView.clearCache(true)
//        webView.addJavascriptInterface(DeviceProvider(this), "AndroidInterface")
        logAssets()
        webView.loadUrl("file:///android_asset/index.html")


        onBackPressedDispatcher.addCallback {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                finish()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello little $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReactNavigationModuleTheme {
        Greeting("Android")
    }
}

class WebViewClientCustom : WebViewClient(){
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        request?.url?.let { uri ->
            // qualquer navegação interna volta para o index.html
            if (uri.scheme == "file") {
                view?.loadUrl("file:///android_asset/index.html")
                return true
            }
        }
        return false
    }
}

class WebChromeClientCustomPoster : WebChromeClient() {
    override fun getDefaultVideoPoster(): Bitmap {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
    }

    override fun onConsoleMessage(message: ConsoleMessage): Boolean {
        Log.d("WebViewConsole", "${message.message()} -- From line ${message.lineNumber()} of ${message.sourceId()}")
        return true
    }
}