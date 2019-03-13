package com.narara.myapplication_2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.narara.myapplication_2.R;
import com.narara.myapplication_2.models.CardItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExamActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_exam);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_exam);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // 표시할 임시 데이터
        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("이것은 첫번째 아이템", "안드로이드 보이라고 합니다"));
        dataList.add(new CardItem("이것은 두번째 아이템", "두 줄 입력도 해 볼게요\n두 줄 입니다"));
        dataList.add(new CardItem("이것은 세번째 아이템", "이번엔 세줄\n두번째 줄\n세번째 줄 입니다"));
        dataList.add(new CardItem("이것은 네번째 아이템", "잘 되네요"));

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataList);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShareButtonClicked(int position) {
        Toast.makeText(this, "share " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLearnMoreClicked(int position) {
        Toast.makeText(this, "more " + position, Toast.LENGTH_SHORT).show();
    }
}
