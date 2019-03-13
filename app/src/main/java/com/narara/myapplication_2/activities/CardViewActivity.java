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


public class CardViewActivity extends AppCompatActivity implements CardRecyclerAdapter.CardRecyclerViewClickListener {


    private static final String TAG = CardViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        // 표시할 임시 데이터
        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("이것은 첫번째 아이템", "안드로이드 보이라고 합니다"));
        dataList.add(new CardItem("이것은 두번째 아이템", "두 줄 입력도 해 볼게요\n두 줄 입니다"));
        dataList.add(new CardItem("이것은 세번째 아이템", "이번엔 세줄\n두번째 줄\n세번째 줄 입니다"));
        dataList.add(new CardItem("이것은 네번째 아이템", "잘 되네요"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // 레이아웃 매니저는 xml에서 설정 가능
        // 레이아웃 매니저로 LinearLayoutManager를 설정
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        // 레이아웃 매니저로 GridLayoutManager를 설정
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        // 레이아웃 매니저로 StaggeredGridLayoutManager를 설정
        //RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 설정
        CardRecyclerAdapter adapter = new CardRecyclerAdapter(dataList);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClicked(int i) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        //Log.d(TAG, "onItemClicked: " + i);
    }

    @Override
    public void onShareButtonClicked(int i) {
        Toast.makeText(this, "Share " + i, Toast.LENGTH_SHORT).show();
//        //Log.d(TAG, "onShareButtonClicked: " + i);
    }

    @Override
    public void onLearnMoreButtonClicked(int i) {
        Toast.makeText(this, "More " + i, Toast.LENGTH_SHORT).show();
//        //Log.d(TAG, "onLearnMoreButtonClicked: " + i);
    }
}
