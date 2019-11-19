package com.example.application_table;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.leaf.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    private ImageView imgFirst;//迎新主照片

    private ImageView imgRecruit;//社团招新
    private ImageView imgSort;//社团分类
    private ImageView imgRecommend;//社团推荐
    private ImageView imgFind;//寻找社团
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        StatusBarUtil.setGradientColor(this, mToolbar);


    }

    public void initVariable(){
        imgFirst = findViewById(R.id.img_first);
        imgRecruit = findViewById(R.id.img_recruit);
        imgSort = findViewById(R.id.img_sort);
        imgRecommend = findViewById(R.id.img_recommend);
        imgFind = findViewById(R.id.img_find);
        mToolbar = findViewById(R.id.mToolbar);
        button = findViewById(R.id.button);
        imgRecruit.setOnClickListener(this);
        imgSort.setOnClickListener(this);
        imgRecommend.setOnClickListener(this);
        imgFind.setOnClickListener(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.first_club);
        imgFirst.setImageDrawable(rectRoundBitmap(bitmap));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_recruit://点击"社团招新"
                Intent intent1 = new Intent(MainActivity.this,Club.class);
                startActivity(intent1);
                break;
            case R.id.img_sort://点击"社团分类"
                Intent intent2 = new Intent(MainActivity.this,Sort.class);
                startActivity(intent2);
                Toast.makeText(this, "你点击了社团分类！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_recommend://点击"社团推荐"
                Intent intent3 = new Intent(MainActivity.this,ScrollBanner.class);
                startActivity(intent3);
                break;
            case R.id.img_find://点击"寻找社团"
                break;
            case R.id.button:
//                Intent intent4 = new Intent(MainActivity.this,Main1Activity.class);
//                startActivity(intent4);
                Toast.makeText(this,"你点击了活动！",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private RoundedBitmapDrawable rectRoundBitmap(Bitmap bitmap){
//创建RoundedBitmapDrawable对象
        RoundedBitmapDrawable roundImg = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
//抗锯齿
        roundImg.setAntiAlias(true);
//设置圆角半径
        roundImg.setCornerRadius(50);
        return roundImg;
    }
}
