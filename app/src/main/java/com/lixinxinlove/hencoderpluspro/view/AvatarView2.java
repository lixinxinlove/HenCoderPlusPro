package com.lixinxinlove.hencoderpluspro.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lixinxinlove.hencoderpluspro.R;

/**
 * @description: 圆形头像
 * @author: lixinxin
 * @date: 2019/4/28 14:57
 * @version: 1.0
 */
public class AvatarView2 extends View {


    private Paint paint;

    // 第一个 Shader：头像的 Bitmap
    private Bitmap bitmap1;
    private Shader shader1;
    // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
    private Bitmap bitmap2;
    private Shader shader2;
    // ComposeShader：结合两个 Shader
    private Shader shader;


    public AvatarView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.meinu);
        shader1 = new BitmapShader(bitmap1, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP);

        bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.logo);
        shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER);

        paint = new Paint();
        //setLayerType(LAYER_TYPE_SOFTWARE, null);  //关闭硬件加速

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawRect(0,0,500, 500, paint);

        paint.setColor(getResources().getColor(R.color.colorAccent));

        canvas.drawOval(0, 0, bitmap1.getWidth() + 5, bitmap1.getHeight() + 5, paint);

        int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        canvas.drawOval(5, 5, bitmap1.getWidth(), bitmap1.getHeight(), paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap1, 5, 5, paint);

        paint.setXfermode(null);

        canvas.restoreToCount(sc);


    }


}
