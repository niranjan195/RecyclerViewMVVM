package com.example.recyclerviewmvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewmvvm.R;
import com.example.recyclerviewmvvm.model.Items;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private static ArrayList<Items> mItems;
    private OnItemClickListener mOnItemClickListener;

    public ItemsAdapter(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void createItems(List<Items> items) {
        mItems = (ArrayList) items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem, mOnItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        final Items currentItem = mItems.get(position);
        holder.mItemTextView.setText(currentItem.getDescription());
        holder.mItemImageView.setImageResource(currentItem.getImageResourceId());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Items item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mItemImageView;
        private TextView mItemTextView;
        private OnItemClickListener mOnItemClickListener;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            mItemImageView = (ImageView) itemView.findViewById(R.id.item_image_view);
            mItemTextView = (TextView) itemView.findViewById(R.id.item_text_view);
            mOnItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClick(mItems.get(getAdapterPosition()));
        }
    }

}
