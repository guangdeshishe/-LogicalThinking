package com.agilezhu.logicalthinking

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.Transformation


/**
 * TODO 请添加说明
 *
 * @author zhujie
 * @date 2019/8/6
 * @time 18:00
 */
class Rotate3dAnimation
/**
 * 在Y轴上创建一个新的3D旋转。旋转是由它的开始角和它的结束角来定义的。
 *
 *
 * 旋转围绕在二维空间的一个中心点，确定由一对X和Y坐标，称为centerX 和 centerY.
 *
 *
 * 当动画开始时，执行z轴（深度）上的转化。可以指定转化的长度，以及转化是否应该及时倒转。
 *
 * @param fromDegrees the start angle of the 3D rotation：3D旋转 起始角度
 * @param toDegrees   the end angle of the 3D rotation：3D旋转 结束角度
 * @param centerX     the X center of the 3D rotation：3D旋转 x轴中心
 * @param centerY     the Y center of the 3D rotation：3D旋转 Y轴中心
 * @param reverse     true if the translation should be reversed, false otherwise
 */
    (
    private val mFromDegrees: Float,
    private val mToDegrees: Float,
    private val mCenterX: Float,
    private val mCenterY: Float,
    private val mDepthZ: Float,
    private val mReverse: Boolean
)//
    : Animation() {
    private var mCamera: Camera? = null

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCamera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        val fromDegrees = mFromDegrees
        //根据动画播放的时间来计算出当前旋转的角度
        val degrees = fromDegrees + (mToDegrees - fromDegrees) * interpolatedTime

        val centerX = mCenterX
        val centerY = mCenterY
        val camera = mCamera

        val matrix = t.getMatrix()

        camera!!.save()
        //让Camera根据动画播放的时间在Z轴进行一定的偏移，使视图有远离视角的感觉。
        if (mReverse) {
            // z的偏移会越来越大。这就会形成这样一个效果，view从近到远
            camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime)
        } else {
            // z的偏移会越来越小。这就会形成这样一个效果，
            //我们的View从一个很远的地方向我们移过来，越来越近，最终移到了我们的窗口上面
            camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime))
        }
        //让视图围绕Y轴进行旋转，从而产生立体旋转的效果
        camera.rotateY(degrees)
        camera.getMatrix(matrix)
        camera.restore()

        //通过Matrix来确定旋转的中心点的位置。
        matrix.preTranslate(-centerX, -centerY)
        matrix.postTranslate(centerX, centerY)
    }
}