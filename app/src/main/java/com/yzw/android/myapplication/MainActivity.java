package com.yzw.android.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //原始图片控件
    private ImageView mOriginImg;

    //模糊后的图片控件
    private ImageView mBlurredImg;

    //seekBar
    private SeekBar mSeekBar;

    //进度条显示的文字
    private TextView mSeekBarView;

    //原始图片
    private Bitmap mOriginBitmap;

    //模糊后的图片
    private  Bitmap mBlurredBitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化视图
        mOriginImg=(ImageView) findViewById(R.id.origin_img);
        mBlurredImg=(ImageView) findViewById(R.id.blurred_img);
        mSeekBar=(SeekBar) findViewById(R.id.my_seekBar);
        mSeekBarView=(TextView) findViewById(R.id.seekBar_view);

        //获得原始图片
        mOriginBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.yule);
        //获取模糊化的图片
        mBlurredBitmap=BlurBitmap.blur(getApplicationContext(),mOriginBitmap);



        //在布局中填充原始图片和模糊的图片
        mBlurredImg.setImageBitmap(mBlurredBitmap);
        mOriginImg.setImageBitmap(mOriginBitmap);

        //设置SeekBar的滑动事件
        setSeekBar();

    }
    private void setSeekBar(){
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int mAlpha=progress;
                mOriginImg.setAlpha((int)(225-mAlpha*2.25));
                mSeekBarView.setText(String.valueOf(mAlpha));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
