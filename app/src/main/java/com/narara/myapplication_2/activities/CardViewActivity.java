package com.narara.myapplication_2.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.narara.myapplication_2.R;
import com.narara.myapplication_2.models.CardItem;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

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
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        // 레이아웃 매니저로 GridLayoutManager를 설정
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        // 레이아웃 매니저로 StaggeredGridLayoutManager를 설정

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 설정
        CardRecyclerAdapter adapter = new CardRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public static class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {
        private final List<CardItem> mDataList;

        public CardRecyclerAdapter(List<CardItem> mDataList) {
            this.mDataList = mDataList;
        }

        // 뷰 홀더를 생성하는 부분. 레이아웃을 만드는 부분
        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
            return new CardViewHolder(view);
        }
        // 뷰 홀더에 데이터를 설정하는 부분.
        @Override
        public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
            CardItem item = mDataList.get(i);
            cardViewHolder.title.setText(item.getTitle());
            cardViewHolder.contents.setText(item.getContents());
        }
        // 아이템 수
        @Override
        public int getItemCount() {
            return mDataList.size();
        }
        // 각각의 아이템의 레퍼런스를 저장할 뷰 홀더 클래스
        // 반드시 RecyclerView.ViewHolder를 상속해야 함
        public static class CardViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView contents;

            public CardViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title_text);
                contents = itemView.findViewById(R.id.contents_text);
            }
        }
    }


}
