package com.example.myapplication.activity.web

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val link = intent.getStringExtra("link")
        //startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link))) //调用系统浏览器
        binding.webView.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                binding.progress.visibility = View.VISIBLE
                binding.progress.progress = newProgress
            }
        }
        binding.webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progress.visibility = View.GONE
            }
        }
        binding.webView.settings.javaScriptEnabled = true  // 启用JavaScript支持
        //binding.webView.settings.builtInZoomControls = true  // 启用缩放功能
        binding.webView.loadUrl(link!!)
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()){
            binding.webView.goBack()
            return
        }
        super.onBackPressed()
    }
}