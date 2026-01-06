package com.example.activitytest1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // 必须先调用父类逻辑，否则会崩溃
        setContentView(R.layout.activity_main) // 加载布局：把 XML 画布贴到这个 Activity 窗体上
        Log.d(TAG, "onCreate")

        // 2. 找到布局里的按钮
        val button1: Button = findViewById(R.id.button1)

        // 3. 设置点击事件
        button1.setOnClickListener {
            // 1. 创建 Intent (显式 Intent)
            val intent = Intent(this, SecondActivity::class.java)//创建意图：从 this(我) 去 B(目的地)

            // 2. 存入数据：参数 1 是 Key (钥匙)，参数 2 是 Value (具体内容)
            intent.putExtra("extra_data", "Hello SecondActivity! 我是来自 A 的消息")

            // 3. 执行跳转,发送请求：通知 Android 系统，“请帮我打开 B 页面”
            startActivity(intent)

            Log.d("MainActivity", "跳转已发出，附带了数据")

            }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)// 动作：我不说找谁，我只说我要“看东西” (VIEW)
            intent.data = Uri.parse("https://www.baidu.com")//  数据：我要看的内容是一个网址
            startActivity(intent)
            Log.d(TAG, "跳转到百度浏览器")
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }// 12. 可见：页面出现在屏幕上，但用户还不能点

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }// 13. 焦点：页面可以交互了，它是当前的“主角”

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }// 14. 失去焦点：新页面正在盖过来，这通常是保存重要数据的最后机会

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }// 15. 不可见：页面完全被挡住了

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }// 16. 销毁： Activity 被杀掉，回收内存

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        // 1. 打印日志，证明它被触发了
        Log.d(TAG, "onNewIntent: 收到了一次复用的跳转请求！")

        // 2. 关键点：如果你想拿到 SecondActivity 传回来的新数据，必须更新 Intent
        setIntent(intent)

        // 3. 现在你可以尝试获取新数据了
        val newData = intent?.getStringExtra("return_msg")
        Log.d(TAG, "新收到的数据是: $newData")
    }
}
