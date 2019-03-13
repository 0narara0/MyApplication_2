package com.narara.myapplication_2.activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.narara.myapplication_2.R;
import com.narara.myapplication_2.models.CardItem;

import java.util.List;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {
    private final List<CardItem> mDataList;
    private CardRecyclerViewClickListener mListener;

    public void setOnClickListener(CardRecyclerViewClickListener listener) {
        mListener = listener;
    }

    public interface CardRecyclerViewClickListener {
        // 아이템 전체 부분의 클릭
        void onItemClicked(int i);

        // Share 버튼 클릭
        void onShareButtonClicked(int i);

        // Learn More 버튼 클릭
        void onLearnMoreButtonClicked(int i);
    }


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
        // 클릭 이벤트
        if (mListener != null) {
            //현재 위치
            final int pos = i;
            cardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                    //mListener.onItemClicked(cardViewHolder.getAdapterPosition());  위에 행과 같은 것
                }
            });
            cardViewHolder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShareButtonClicked(pos);
                }
            });
            cardViewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onLearnMoreButtonClicked(pos);
                }
            });
        }
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
        Button share;
        Button more;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            contents = itemView.findViewById(R.id.contents_text);
            share = itemView.findViewById(R.id.share_button);
            more = itemView.findViewById(R.id.move_button);
        }
    }




}
