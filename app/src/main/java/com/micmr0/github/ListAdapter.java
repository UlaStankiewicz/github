package com.micmr0.github;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private OnSendButtonClicked onSendButtonClick;
    private MainObject[] mDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkbox;
        public TextView message;
        public TextView sha;
        public TextView author;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.checkbox);
            message = itemView.findViewById(R.id.message);
            sha = itemView.findViewById(R.id.sha);
            author = itemView.findViewById(R.id.author);
        }
    }

    public ListAdapter(MainObject[] myDataSet, OnSendButtonClicked onSendButtonClicked) {
        this.mDataSet = myDataSet;
        this.onSendButtonClick = onSendButtonClicked;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onSendButtonClick.onButtonClick(isChecked, mDataSet[position]);
            }
        });

        if (mDataSet[position].getMessage() != null && !mDataSet[position].getMessage().isEmpty()) {
            holder.message.setText(mDataSet[position].getMessage());
        }

        if (mDataSet[position].getSha() != null && !mDataSet[position].getSha().isEmpty()) {
            holder.sha.setText(mDataSet[position].getSha());
        }

        if (mDataSet[position].getAuthor() != null && mDataSet[position].getCommit().getAuthor().getName() != null) {
            holder.author.setText(mDataSet[position].getCommit().getAuthor().getName());
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}