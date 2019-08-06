package com.agilezhu.logicalthinking

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.widget.FrameLayout
import android.widget.TextView
import com.agilezhu.logicalthinking.bean.QuestionDataBean

/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/6
 * @time 17:01
 */
class QuestionView(context: Context) : FrameLayout(context) {
    private lateinit var mQuestionData: QuestionDataBean
    private val mQuestionText: TextView
    private val mQuestionCardView: View
    private var isQuestionView = true//默认为问题
    private val mQuestionTitleView: TextView

    init {
        View.inflate(context, R.layout.question_item_content_view, this)
        mQuestionText = findViewById(R.id.mQuestionText)
        mQuestionCardView = findViewById(R.id.mQuestionCardView)
        mQuestionTitleView = findViewById(R.id.mQuestionTitleView)
        setOnClickListener {
            var rotation =
                Rotate3dAnimation(0f, 180f, mQuestionCardView.width / 2.0f, 0f, 0f, false)
            rotation.duration = 500
            val listener = object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    if (isQuestionView) {
                        mQuestionTitleView.text = "答案"
                        mQuestionText.text = mQuestionData.answer
                    } else {
                        mQuestionTitleView.text = "问题"
                        mQuestionText.text = mQuestionData.question
                    }
                    isQuestionView = !isQuestionView
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            }
            rotation.setAnimationListener(listener)
            mQuestionCardView.startAnimation(rotation)
        }
    }

    fun initData(data: QuestionDataBean) {
        mQuestionData = data
        mQuestionText.text = data.question
    }
}