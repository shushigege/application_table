package com.example.application_table;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.application_table.adapter.SheTuanAdapter;
import com.leaf.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bmob.v3.Bmob;
//import com.google.android.material.material:1.0.0;

public class Sort extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private SheTuan[] sheTuans = {new SheTuan("国学社",R.drawable.guoxue),new SheTuan("古筝社",R.drawable.guzheng),
            new SheTuan("棋社",R.drawable.qishe),new SheTuan("书法社",R.drawable.shufa),
            new SheTuan("尖峰创业社",R.drawable.chuangye),new SheTuan("就业服务社",R.drawable.jiuye),
            new SheTuan("爱心社",R.drawable.aixin),new SheTuan("青年志愿者协会",R.drawable.qingnianzhiyuanzhe),
            new SheTuan("环境保护协会",R.drawable.huanjingbaohu),new SheTuan("机器人社",R.drawable.jiqiren),
            new SheTuan("建云大数据社",R.drawable.bigdata),new SheTuan("BIM社",R.drawable.bim),
            new SheTuan("电子爱好者社",R.drawable.dianzi),new SheTuan("法律社",R.drawable.falv),
            new SheTuan("IT社",R.drawable.it),new SheTuan("篮球社",R.drawable.lanqiu),
            new SheTuan("跆拳道社",R.drawable.taiquandao),new SheTuan("足球社",R.drawable.zuqiu),
            new SheTuan("演讲辩论社",R.drawable.bianlun),new SheTuan("动漫社",R.drawable.dongman),
            new SheTuan("话剧社",R.drawable.huaju),new SheTuan("轮滑社",R.drawable.lunhua),
            new SheTuan("文学社",R.drawable.wenxue),new SheTuan("英语社",R.drawable.yingyu)

    };

    private List<SheTuan>sheTuanList = new ArrayList<>();

    private SheTuanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_club);
        mToolbar = findViewById(R.id.toolbar);
        StatusBarUtil.setGradientColor(this, mToolbar);
        initSheTuans();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SheTuanAdapter(sheTuanList);
        recyclerView.setAdapter(adapter);

        Bmob.initialize(this,"094e520dd470d703c4c79bccaad7bd09");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
       // LinearLayoutCompat liview = (LinearLayoutCompat)findViewById(R.id.li_view);
       // ListView liview = (ListView)findViewById(R.id.li_view);
       // NestedScrollView liview = (NestedScrollView)findViewById(R.id.li_view);
        NavigationView navView = (NavigationView)findViewById(R.id.na_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu2);
        }

    }

    private void initSheTuans(){
        sheTuanList.clear();
        for (int i = 0;i<100;i++){
            Random random  = new Random();
            int index = random.nextInt(sheTuans.length);
            sheTuanList.add(sheTuans[index]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
                default:
        }
        return true;
    }
}
