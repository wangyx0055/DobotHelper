package com.example.dobothelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by XuToTo on 2016/3/2 0002.
 */
public class PaintView extends View {


    private boolean isDraw = false;
    private Canvas mCanvas;
    private Bitmap mBitmap;  //缓存绘制的内容
    private Bitmap backBitmap;
    private Path mPath;
    private Paint paint = new Paint();
    //清屏

    Paint redPaint=new Paint();
    Paint bluePaint = new Paint();

    Path bigPath = new Path();
    Path smallPath = new Path();

    float mouseX, mouseY;

    private int mLastX;
    private int mLastY;
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //mPath = new Path();
        mCanvas=new Canvas();
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(7);
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
        //mPath.moveTo(100, 300);
        redPaint.setColor(Color.RED);
        bluePaint.setColor(Color.BLUE);
        redPaint.setStrokeWidth(7);
        redPaint.setAntiAlias(true);
        redPaint.setStyle(Paint.Style.STROKE);
        bluePaint.setStrokeWidth(7);
        bluePaint.setAntiAlias(true);
        bluePaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.WHITE)
        canvas.drawPath(bigPath, bluePaint);
        canvas.drawPath(smallPath, redPaint);
        if (isDraw) {
            float distance = (float) Math.sqrt((mouseX - 100)*(mouseX - 100)+(mouseY-300)*(mouseY-300));
            float scale = 300 / distance;
            if (mouseY > 300 || mouseX > 300) {
                float x = mouseX * scale;
                float y = mouseY * scale;
                canvas.drawLine(100, 300, x, y, bluePaint);
            }
        }
    }

//    private void drawLine() {
//        float thirdLength=(float)Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
//        bigRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100 * 100)/2*100*thirdLength));
//        smallRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100*100)/2*100*thirdLength));
//        float big=(float)Math.toDegrees(bigRotateDegree);
//        float small=(float)Math.toDegrees(smallRotateDegree);
//        float thirdAngle=180-big-small;
//        String str_big = df.format(big);
//        String str_small = df.format(small);
//        Log.i("====setRotate====","small:"+str_small+"  big:"+str_big+" third:"+thirdLength);
//    }

    //绘制线条
    private void setXY(int x,int y){
        int startX=100;
        int startY=300;

        int length=(int)Math.sqrt((x-startX)*(x-startX)+(y-startY)*(y-startY));

        Log.d("PainView", "===length===:" + length);

    }

//    private void setRotate(float x,float y)
//    {
//        float thirdLength=(float)Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
//        bigRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100 * 100)/2*100*thirdLength));
//        smallRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100*100)/2*100*thirdLength));
//        float big=(float)Math.toDegrees(bigRotateDegree);
//        float small=(float)Math.toDegrees(smallRotateDegree);
//        float thirdAngle=180-big-small;
//        String str_big = df.format(big);
//        String str_small = df.format(small);
//        Log.i("====setRotate====", "small:" + str_small + "  big:" + str_big + " third:" + thirdLength);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        int x = (int) event.getX();
//        int y = (int) event.getY();

        mouseX = event.getX();
        mouseY = event.getY();


        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
//                setXY(x,y);
//                Log.d("PaintView","LX:"+mLastX);
//                Log.d("PaintView", "LY:" + mLastY);
//                Log.d("PaintView","TX:"+x);
//                Log.d("PaintView", "TY:" + y);
//                bigPath.moveTo(100,300);
//                bigPath.lineTo(mLastX, mLastY);
//                smallPath.moveTo(mLastX, mLastY);
//                smallPath.lineTo(x,y);

                isDraw = true;
                break;
            case MotionEvent.ACTION_MOVE:

                //mLastX = x;
                //mLastY = y;
                if (isDraw) {

                }

                break;
            case MotionEvent.ACTION_UP:
                //mPath.moveTo(mLastX, mLastY);
//                bigPath.moveTo(100, 300);
                isDraw = false;
                break;

        }
        this.postInvalidate();
        return true;
    }
}
