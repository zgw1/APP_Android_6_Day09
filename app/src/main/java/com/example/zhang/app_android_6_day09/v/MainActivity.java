package com.example.zhang.app_android_6_day09.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.zhang.app_android_6_day09.Data.Bean;
import com.example.zhang.app_android_6_day09.R;
import com.example.zhang.app_android_6_day09.p.MVPBridge;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MVPView{


    private RecyclerView mRv;
    private MVPBridge bridge;
    private List<Bean.DataBean> data = new ArrayList<>();
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        bridge = new MVPBridge(this);
        bridge.handleData();

    }

    private void initView() {
        mRv =  findViewById(R.id.mRv);
        adapter = new MyAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
        mRv.setItemAnimator(new DefaultItemAnimator());
        mRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRv.setAdapter(adapter);


    }

    @Override
    public void setListItem(List<Bean> list) {
        for (Bean b : list){
            data = b.getData();
            Log.e("zgw"," " + data.get(0).getTitle());
        }

        adapter.setData(data);
    }
}
