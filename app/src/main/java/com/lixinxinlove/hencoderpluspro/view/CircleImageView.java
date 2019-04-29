package com.lixinxinlove.hencoderpluspro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import com.lixinxinlove.hencoderpluspro.R;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/4/29 15:40
 * @version: 1.0
 */
public class CircleImageView extends androidx.appcompat.widget.AppCompatImageView {


    private int circleColor;
    private float circleWidth;

    private Paint circlePaint;

    private Paint bitmapPaint;

    private int size;

    public CircleImageView(Context context) {
        this(context, null, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);


        bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);

    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);
        circleColor = typedArray.getColor(R.styleable.CircleImageView_circleColor, context.getResources().getColor(R.color.colorAccent, context.getTheme()));
        circleWidth = typedArray.getDimension(R.styleable.CircleImageView_circleWidth, 40f);
        typedArray.recycle();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        // setMeasuredDimension(size, size);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }

        Log.e("onDraw", "sizw=" + size);

        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();


        int bitmapWH = Math.min(bitmap.getWidth(), bitmap.getHeight());


        circlePaint.setColor(circleColor);
        canvas.drawOval(10, 10, bitmapWH + circleWidth, bitmapWH + circleWidth, circlePaint);

        int sc = canvas.saveLayer(10, 10, bitmapWH + circleWidth, bitmapWH + circleWidth, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawOval(10 + circleWidth / 2, 10 + circleWidth / 2, bitmapWH + circleWidth / 2, bitmapWH + circleWidth / 2, bitmapPaint);

        bitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap, 10 + circleWidth / 2, 10 + circleWidth / 2, bitmapPaint);

        bitmapPaint.setXfermode(null);

        canvas.restoreToCount(sc);

    }
}
