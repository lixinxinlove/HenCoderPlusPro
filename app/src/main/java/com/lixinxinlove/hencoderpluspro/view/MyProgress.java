package com.lixinxinlove.hencoderpluspro.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import androidx.annotation.Nullable;

import com.lixinxinlove.hencoderpluspro.R;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/4/25 17:16
 * @version: 1.0
 */
public class MyProgress extends View {

    //  AccelerateDecelerateInterpolator	@android:anim/accelerate_decelerate_interpolator	其变化开始和结束速率较慢，中间加速
    //  AccelerateInterpolator	@android:anim/accelerate_interpolator	其变化开始速率较慢，后面加速
    //  DecelerateInterpolator	@android:anim/decelerate_interpolator	其变化开始速率较快，后面减速
    //  LinearInterpolator	@android:anim/linear_interpolator	其变化速率恒定
    //  AnticipateInterpolator	@android:anim/anticipate_interpolator	其变化开始向后甩，然后向前
    // AnticipateOvershootInterpolator	@android:anim/anticipate_overshoot_interpolator	其变化开始向后甩，然后向前甩，过冲到目标值，最后又回到了终值
    //  OvershootInterpolator	@android:anim/overshoot_interpolator	其变化开始向前甩，过冲到目标值，最后又回到了终值
    //  BounceInterpolator	@android:anim/bounce_interpolator	其变化在结束时反弹
    // CycleInterpolator	@android:anim/cycle_interpolator	循环播放，其速率为正弦曲线


    private Paint mPaint;
    private Paint mPaintText;

    private RectF rectF;

    private float progress;  // 0--100     0--240   * 2.4
    private int progressColor;  // 0--100     0--240   * 2.4

    private ObjectAnimator animator;
    private ObjectAnimator animatorColor;

    private AnimatorSet animationSet;

    public MyProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(context.getColor(R.color.colorAccent));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);


        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setStrokeWidth(10);
        mPaintText.setTextSize(40);


        rectF = new RectF(100, 100, 500, 450);
        progress = 0;
        animator = ObjectAnimator.ofFloat(this, "progress", 0, 100);
        animator.setDuration(4000);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new BounceInterpolator());


        animatorColor = ObjectAnimator.ofArgb(this, "progressColor", 0xffff0000, 0xff00ff00);
        animatorColor.setDuration(4000);
        animatorColor.setRepeatCount(-1);
        animatorColor.setInterpolator(new BounceInterpolator());

        animationSet = new AnimatorSet();
        animationSet.playTogether(animator, animatorColor);
        animationSet.start();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(progressColor);
        mPaintText.setColor(progressColor);
        canvas.drawArc(rectF, 150, progress * 2.4f, false, mPaint);
        canvas.drawText((int) progress + "%", 270, 260, mPaintText);
    }


    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
        invalidate();
    }
}
