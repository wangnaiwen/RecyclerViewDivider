package com.study.wnw.recyclerviewdivider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //定义RecyclerView
    private RecyclerView mRecyclerView = null;

    //定义一个List集合，用于存放RecyclerView中的每一个数据
    private List<String> mData = null;

    //定义一个Adapter
    private MyAdapter mAdapter;

    //定义一个LinearLayoutManager
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView三步曲+LayoutManager
        initView();
        initData();
        mAdapter = new MyAdapter(this,mData);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
    }

    //初始化View
    private void initView(){
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
    }

    //初始化加载到RecyclerView中的数据, 我这里只是给每一个Item添加了String类型的数据
    private void initData(){
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            mData.add("Item" + i);
        }
    }
}
