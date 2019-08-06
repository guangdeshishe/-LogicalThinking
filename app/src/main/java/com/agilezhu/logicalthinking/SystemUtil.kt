package com.agilezhu.logicalthinking

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/6
 * @time 19:49
 */
class SystemUtil {

    companion object {
        /**
         * 复制文本到系统剪切板
         *
         * @param content
         */
        fun copy(context: Context, content: String) {
            val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

            clipboardManager.primaryClip = ClipData.newPlainText("复制文本", content)
        }
    }

}