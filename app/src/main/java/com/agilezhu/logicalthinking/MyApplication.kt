package com.agilezhu.logicalthinking

import android.app.Application
import android.util.Log
import android.widget.Toast
import cn.leancloud.core.AVOSCloud
import io.reactivex.plugins.RxJavaPlugins

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/7
 * @time 14:40
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG)
        // 提供 this、App ID 和 App Key 作为参数
        AVOSCloud.initialize("2YYzof3KDCLXqVjdGvwThMsQ-gzGzoHsz", "iPVje8kfLUw3Ks4AycQ7CoY6")
        Thread.setDefaultUncaughtExceptionHandler(CrashHandler())

        RxJavaPlugins.setErrorHandler {
            Log.e("crash", " $it")
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }
}