package com.example.emlenotestask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emlenotestask.R;
import com.example.emlenotestask.model.Messages;

import java.util.List;

public class chat extends RecyclerView.Adapter<chat.viewHolder> {

    private List<Messages> msg;

    public chat(List<Messages> msg) {
        this.msg = msg;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == 0) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.send_message_layout, parent, false);
            vh = new viewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recieve_message, parent, false);
            vh = new viewHolder(v);
        }
        return (viewHolder) vh;

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.msg.setText(msg.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return msg.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.msg.get(position).getSender() ;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView msg;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.text_content);
        }
    }

    public void insertItem(Messages item) {
        this.msg.add(item);
        notifyItemInserted(getItemCount());
    }
}
