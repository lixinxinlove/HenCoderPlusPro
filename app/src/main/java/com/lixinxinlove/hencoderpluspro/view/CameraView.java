package com.lixinxinlove.hencoderpluspro.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lixinxinlove.hencoderpluspro.R;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/4/26 16:26
 * @version: 1.0
 */
public class CameraView extends View {

    private ObjectAnimator animator;

    private Paint mPaint;


    private Bitmap mBitmap;


    private Camera camera;


    private Point point1;
    private Point point2;


    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.meinu);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(context.getColor(R.color.colorAccent));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);


        // animator = ObjectAnimator.ofFloat(this, "progress", 0, 100);
        //animator.setDuration(4000);
        // animator.setRepeatCount(-1);
        //animator.setInterpolator(new BounceInterpolator());


        camera = new Camera();

        point1 = new Point(0, 0);
        point2 = new Point(200, 200);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int size = Math.min(measuredWidth, measuredHeight);

        setMeasuredDimension(size, size); // 保存测得的尺寸


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        camera.rotateX(10);
        canvas.translate(-100, -100);
        camera.applyToCanvas(canvas);
        canvas.translate(0, 0);
        canvas.drawBitmap(mBitmap, point1.x, point1.y, mPaint);
        canvas.restore();


    }
}
