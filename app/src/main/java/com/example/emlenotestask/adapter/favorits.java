package com.example.emlenotestask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emlenotestask.R;
import com.example.emlenotestask.model.FavoritesData;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class favorits extends RecyclerView.Adapter<favorits.favoritsHolder> {

    private List<FavoritesData> list;
    private Context context;

    public favorits(List<FavoritesData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public favorits.favoritsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater in = LayoutInflater.from(parent.getContext());
        View v = in.inflate(R.layout.friends_item, parent, false);
        favoritsHolder vh = new favoritsHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull favorits.favoritsHolder holder, int position) {
        holder.friend_name.setText(list.get(position).getName());
        Picasso.get().load(list.get(position).getPic()).into(holder.friend_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class favoritsHolder extends RecyclerView.ViewHolder {
        CircleImageView friend_image;
        TextView friend_name;

        public favoritsHolder(@NonNull View itemView) {
            super(itemView);
            friend_image = itemView.findViewById(R.id.friend_image);
            friend_name = itemView.findViewById(R.id.friend_name);
        }
    }
}
