package com.example.activitytest1 // 注意检查这里的包名是否和你的 MainActivity 一致

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object {
        // 改成 SecondActivity，方便在 Log 里区分
        private const val TAG = "SecondActivity"
    }

    // ... 之前的 import 不要删，确保 import android.widget.Button 和 android.content.Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 1. 之前的接收数据逻辑
        val dataReceived = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "成功拆快递！内容是: $dataReceived")

        // 2. 找到新加的按钮并设置点击事件
        val buttonBack: Button = findViewById(R.id.buttonBackToMain)
        buttonBack.setOnClickListener {
            // 这里就是你要的跳转代码
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("return_msg", "我是从 SecondActivity 游回来的鱼")
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}