package kr.hs.emirim.ksmj0211.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by appcreator26 on 2016. 9. 26..
 */
public class MyImage extends View{
    int choose = MainActivity.ORIGINAL;
    Bitmap picture;

    MyImage(Context context){
        super(context);
        picture = BitmapFactory.decodeResource(getResources(), R.drawable.lsy);
    }

    public void setChoose(int choose){
        this.choose = choose;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float cx = getWidth()/2.0f;
        float cy = getHeight()/2.0f;
        float x = (getWidth()-picture.getWidth())*0.5f;
        float y = (getHeight()-picture.getHeight())*0.3f;
        switch(choose) {
            //회전
            case MainActivity.ROTATE:
                canvas.rotate(45, cx, cy);
                break;
            //이동
            case MainActivity.TRANSLATE:
                canvas.translate(-300, 200);
                break;
            //크기
            case MainActivity.SCALE:
                canvas.scale(0.3f, 0.3f, cx, cy);
                break;
            //비틀기
            case MainActivity.SKEW:
                canvas.skew(0.4f, 0.4f);
                break;
        }
        canvas.drawBitmap(picture, x, y, null);
        //picture.recycle();
    }
}
