package com.davud.apps.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.davud.apps.chat.R;
import com.davud.apps.chat.models.AllChatModel;
import com.davud.apps.chat.models.FriendsModel;

import java.util.ArrayList;

public class AllChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final Context context;
    private ArrayList<AllChatModel> models;

    private AllChatAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener   {
        void onItemClick (int position);
    }
    public void setOnItemClickListener(AllChatAdapter.OnItemClickListener listener)
    {
        mListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView message;
        TextView date;
        LinearLayout isOnline;
        View mView;
        public MyViewHolder(View view , final AllChatAdapter.OnItemClickListener listener) {
            super(view);
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
            message =view.findViewById(R.id.message);
            date = view.findViewById(R.id.date);
            isOnline = view.findViewById(R.id.is_online);

            mView = view;
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

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView image2;
        TextView name;
        TextView message;
        TextView date;

        View mView;
        public MyViewHolder2(View view , final AllChatAdapter.OnItemClickListener listener) {
            super(view);

            image = view.findViewById(R.id.image);
            image2 = view.findViewById(R.id.image2);
            name = view.findViewById(R.id.name);
            message =view.findViewById(R.id.message);
            date = view.findViewById(R.id.date);

            mView = view;
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

    public AllChatAdapter(ArrayList<AllChatModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(!models.get(position).isGroup())
        {
            return 1;
        }

        else{
            return  2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_chat_recyclerview_item, parent, false);
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_chat_recyclerview_item_group, parent, false);

        switch (viewType) {
            case 1:
                return new MyViewHolder(itemView, mListener);
            case 2:
                return new MyViewHolder2(itemView2, mListener);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                final MyViewHolder viewHolder1 = (MyViewHolder) holder;
                viewHolder1.name.setText(models.get(position).getName());
                viewHolder1.message.setText(models.get(position).getLastMessage());
                viewHolder1.date.setText(models.get(position).getLastMessageDate());
                Glide.with(context).load(models.get(position).getImage()).into(viewHolder1.image);
                if(models.get(position).isOnline())
                {
                    viewHolder1.isOnline.setBackgroundResource(R.drawable.online);
                }
                else{
                    viewHolder1.isOnline.setBackgroundResource(R.drawable.offline);
                }


                break;
            case 2:
                final MyViewHolder2 viewHolder2 = (MyViewHolder2) holder;
                viewHolder2.name.setText(models.get(position).getName());
                viewHolder2.message.setText(models.get(position).getLastMessage());
                viewHolder2.date.setText(models.get(position).getLastMessageDate());
                Glide.with(context).load(models.get(position).getImages().get(0)).into(viewHolder2.image);
                Glide.with(context).load(models.get(position).getImages().get(1)).into(viewHolder2.image2);


                break;
        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

}

