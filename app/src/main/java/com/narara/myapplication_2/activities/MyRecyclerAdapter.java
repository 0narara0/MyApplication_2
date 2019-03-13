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

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private final List<CardItem> mDataList;
    private MyRecyclerViewClickListener mListener;

    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        mListener = listener;
    }

    public interface MyRecyclerViewClickListener {
        void onItemClicked(int position);
        void onShareButtonClicked(int position);
        void onLearnMoreClicked(int position);

    }

    public MyRecyclerAdapter(List<CardItem> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CardItem item = mDataList.get(i);
        viewHolder.title.setText(item.getTitle());
        viewHolder.contents.setText(item.getContents());

        if(mListener != null){
            final int pos = i;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            viewHolder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShareButtonClicked(pos);
                }
            });
            viewHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onLearnMoreClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView contents;
        Button share;
        Button more;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            contents = itemView.findViewById(R.id.contents_text);
            share = itemView.findViewById(R.id.share_button);
            more = itemView.findViewById(R.id.more_button);
        }
    }
}
