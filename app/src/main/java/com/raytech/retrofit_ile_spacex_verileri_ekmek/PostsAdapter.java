package com.raytech.retrofit_ile_spacex_verileri_ekmek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Repo> postsList;

    public PostsAdapter(List<Repo> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtRocketId.setText(postsList.get(position).getRocket().rocketId);
        holder.txtRocketName.setText(postsList.get(position).getRocket().rocketName);
        holder.txtRocketType.setText(postsList.get(position).getRocket().rocketType);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRocketId;
        TextView txtRocketName;
        TextView txtRocketType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRocketId = itemView.findViewById(R.id.txtRocketId);
            txtRocketName = itemView.findViewById(R.id.txtRocketName);
            txtRocketType=itemView.findViewById(R.id.txtRocketType);
        }
    }
}
