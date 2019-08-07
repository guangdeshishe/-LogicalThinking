package com.agilezhu.logicalthinking

import android.util.Log

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/7
 * @time 15:07
 */
class CrashHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        Log.e("crash", e?.message)
    }
}