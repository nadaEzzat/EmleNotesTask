package com.example.emlenotestask.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emlenotestask.R;
import com.example.emlenotestask.chat.ChatActivity;
import com.example.emlenotestask.model.RecentData;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class recent extends RecyclerView.Adapter<recent.recentHolder> {

    final int sdk = android.os.Build.VERSION.SDK_INT;
    private List<RecentData> list;
    private Context context;

    public recent(List<RecentData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public recentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater in = LayoutInflater.from(parent.getContext());
        View v = in.inflate(R.layout.chats_item, parent, false);
        recent.recentHolder vh = new recent.recentHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull recentHolder holder, int position) {
        holder.chat_message.setText(list.get(position).getMessage());
        holder.chat_name.setText(list.get(position).getName());
        holder.chat_time.setText(list.get(position).getTime());
        if (list.get(position).getNew() == 0) {
            holder.numberOfMessages.setVisibility(View.INVISIBLE);
        } else {
            holder.numberOfMessages.setVisibility(View.VISIBLE);
            holder.numberOfMessages.setText(list.get(position).getNew().toString());
        }
        Picasso.get().load(list.get(position).getPic()).into(holder.chat_image);

        holder.chat_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                context.startActivity(intent);
            }
        });
        if (position % 2 == 0) {
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                (holder.chat_layout).setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.recent_background));
            } else {
                (holder.chat_layout).setBackground(ContextCompat.getDrawable(context, R.drawable.recent_background));
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class recentHolder extends RecyclerView.ViewHolder {
        CircleImageView chat_image;
        TextView chat_name;
        TextView chat_message;
        TextView chat_time;
        TextView numberOfMessages;
        ConstraintLayout chat_layout;

        public recentHolder(View v) {
            super(v);
            chat_image = v.findViewById(R.id.chat_image);
            chat_message = v.findViewById(R.id.chat_message);
            chat_name = v.findViewById(R.id.chat_name);
            chat_time = v.findViewById(R.id.chat_time);
            numberOfMessages = v.findViewById(R.id.numberOfMessages);
            chat_layout = v.findViewById(R.id.chat_layout);
        }
    }
}
