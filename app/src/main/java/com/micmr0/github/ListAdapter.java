package com.micmr0.github;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private ArrayList<MainObject> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView sha;
        public TextView author;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public ListAdapter(ArrayList<MainObject> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.message.setText(mDataset.get(position).getMessage());
        holder.sha.setText(mDataset.get(position).getSha());
        holder.author.setText(mDataset.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}