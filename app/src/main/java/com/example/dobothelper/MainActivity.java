package com.example.dobothelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.text.DecimalFormat;

public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{

    private int screenWidth = 0;
    private int screenHeight = 0;
    private ImageView imageViewBase;
    private ImageView imageViewSmall;
    private ImageView imageViewBig;
    private ImageView imageViewEnd;
    private Button rotateBtn;
    private Button blueToothBtn;
    private Matrix matrix=new Matrix();
    private float angle=0;
    private Animation animation;
    private Animation translate;
    //formation of degree
    DecimalFormat df = new DecimalFormat("#0.00");

    private float bigRotateDegree;
    private float smallRotateDegree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 获取屏幕大小
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        //设置View的Touch事件
        //final Button btn1 = (Button)findViewById(R.id.btn1);
        //final Button btn2 = (Button)findViewById(R.id.btn2);
        //final Button btn3 = (Button)findViewById(R.id.btn3);
        imageViewBase=(ImageView)findViewById(R.id.imageBase);
        imageViewBig=(ImageView)findViewById(R.id.imageBig);
        imageViewSmall=(ImageView)findViewById(R.id.imageSmall);
        SeekBar seekBar=(SeekBar)findViewById(R.id.seekbarX);
        seekBar.setProgress(90);
        seekBar.setOnSeekBarChangeListener(this);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_item_bluetooth:
                        Intent intent = new Intent(MainActivity.this, SearchDeviceActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        rotateBtn=(Button)findViewById(R.id.rotateBtn);
        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double X=imageViewBig.getLeft()+75+(135/Math.sqrt(2));
//                double Y=imageViewBig.getTop()+75+(135/Math.sqrt(2));
//                Log.i("====ARM_LOACATION====","small:"+imageViewSmall.getLeft()+"  big:"+imageViewBig.getLeft());
//                animation = new RotateAnimation(0, -45,
//                        Animation.RELATIVE_TO_SELF, 0f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
                //animation = new RotateAnimation(0, -45, 0, 0);
//                animation.setDuration(500);
//                animation.setFillAfter(true);
//                imageViewBig.startAnimation(animation);

                //imageViewBig.setTranslationX((float) (135 / Math.sqrt(2)));
                //imageViewBig.setTranslationY(-(float)(135/Math.sqrt(2)));
//                imageViewSmall.setTranslationX((float) X - imageViewSmall.getLeft());
//                imageViewSmall.setTranslationY(imageViewSmall.getTop() - (float) Y);
                //imageViewSmall.layout(100,100,0,0);

//                Log.i("====ARM_LOACATION====","small:"+imageViewSmall.getLeft()+"  big:"+imageViewBig.getLeft());
//                Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.dabi))).getBitmap();
//                matrix.setRotate(angle-=45,0, 0); //设置翻转的角度
//                //重新绘制翻转后的图片
//                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//                imageViewBig.setImageBitmap(bitmap);
                setRotate(400, 400);
                Log.i("====Rotate degree====", "small:" + smallRotateDegree + "  big:" + bigRotateDegree);
                Animation animationSmall = new RotateAnimation(0, 45,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 1f);
                Animation animationBig = new RotateAnimation(0, -45,
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animationBig.setDuration(1500);
                animationBig.setFillAfter(true);
                animationSmall.setDuration(1500);
                animationSmall.setFillAfter(true);
                imageViewBig.startAnimation(animationBig);
                imageViewSmall.startAnimation(animationSmall);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId())
        {
            case R.id.seekbarX:
                //imageViewBase.setLayoutParams(new LinearLayout.LayoutParams(250, 300));
//                Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.dabi))).getBitmap();
//                matrix.setRotate(45,0, 300); //设置翻转的角度
//                //重新绘制翻转后的图片
//                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//                imageViewBig.setImageBitmap(bitmap);

                //旋转大臂
                animation = new RotateAnimation(angle, progress-90,
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                //移动小臂translate
                translate=new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,151,Animation.ABSOLUTE,0,Animation.ABSOLUTE,413);

                animation.setDuration(500);
                animation.setFillAfter(true);
                translate.setDuration(500);
                translate.setFillAfter(true);
                imageViewBig.startAnimation(animation);
                angle=progress-90;
                int[] location=new int[2];
                //imageViewBig.getLocationInWindow(location);
                imageViewBig.getLocationOnScreen(location);
                //imageViewSmall.setTranslationX(160);
                //imageViewSmall.startAnimation(translate);
                imageViewSmall.setX(151);
                imageViewSmall.setY(409-150);
                //imageViewBig.setTranslationY(420);
                Log.i("====BIG_ARM_LOCATION===","X:"+location[0]+" Y:"+location[1]);
                break;
            case R.id.seekbarY:
                //animation = new TranslateAnimation();
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void setRotate(float x,float y)
    {
        float thirdLength=(float)Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
        bigRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100 * 100)/2*100*thirdLength));
        smallRotateDegree=(float)Math.acos(((100 * 100 + thirdLength * thirdLength - 100*100)/2*100*thirdLength));
        float big=(float)Math.toDegrees(bigRotateDegree);
        float small=(float)Math.toDegrees(smallRotateDegree);
        float thirdAngle=180-big-small;
        String str_big = df.format(big);
        String str_small = df.format(small);
        Log.i("====setRotate====","small:"+str_small+"  big:"+str_big+" third:"+thirdLength);
    }

    ///根据触摸坐标，将小臂动画移动至坐标点
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
//        int x = (int) event.getX();
//        int y = (int) event.getY();
        float downX, downY;
        float moveX, moveY;
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                downX = event.getRawX();
                downY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();
                moveY = event.getY();
                setRotate(0, 100);
                imageViewSmall.setX(moveX-300);
                imageViewSmall.setY(moveY-220);


                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }
}
