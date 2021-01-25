package com.davud.apps.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.davud.apps.chat.R;
import com.davud.apps.chat.models.FriendsModel;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    ArrayList<FriendsModel> models;
    Context context;

    private OnItemClickListener mListener;
    public interface OnItemClickListener   {
        void onItemClick (int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public FriendsAdapter(ArrayList<FriendsModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_recyclerview_item,parent,false);
        return new ViewHolder(view , mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(models.get(position).getImage()).into(holder.image);
        holder.name.setText(models.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        View mView;
        public ViewHolder(@NonNull View itemView  , final FriendsAdapter.OnItemClickListener listener) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);



            mView = itemView;
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }

}
