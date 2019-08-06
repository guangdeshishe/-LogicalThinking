package com.agilezhu.logicalthinking

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.agilezhu.logicalthinking.bean.QuestionDataBean

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/6
 * @time 16:28
 */
class ViewPagerAdapter(val context: Context) : PagerAdapter() {
    val mDatas = ArrayList<QuestionDataBean>()
    val mQuestionView = ArrayList<QuestionView>()
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1//判断是否同一个对象
    }

    override fun getCount(): Int {
        return mDatas.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: QuestionView? = null
        if (position >= 0 && position < mQuestionView.size) {
            view = mQuestionView[position]
        }
        if (view == null) {
            view = QuestionView(context)
            view.initData(mDatas[position])
            mQuestionView.add(view)
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    fun initData(datas: ArrayList<QuestionDataBean>) {
        mDatas.clear()
        if (!datas.isNullOrEmpty()) {
            mDatas.addAll(datas)
        }
        notifyDataSetChanged()
    }

}