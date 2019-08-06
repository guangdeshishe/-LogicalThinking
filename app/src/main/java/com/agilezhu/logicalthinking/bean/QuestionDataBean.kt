package com.agilezhu.logicalthinking.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/6
 * @time 16:33
 */
class QuestionDataBean() : BaseBean {
    var question: String? = null
    var answer: String? = null

    constructor(parcel: Parcel) : this() {
        question = parcel.readString()
        answer = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionDataBean> {
        override fun createFromParcel(parcel: Parcel): QuestionDataBean {
            return QuestionDataBean(parcel)
        }

        override fun newArray(size: Int): Array<QuestionDataBean?> {
            return arrayOfNulls(size)
        }
    }
}