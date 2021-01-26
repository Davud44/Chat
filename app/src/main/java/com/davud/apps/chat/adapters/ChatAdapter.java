package com.davud.apps.chat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.davud.apps.chat.R;
import com.davud.apps.chat.models.AllChatModel;
import com.davud.apps.chat.models.ChatModel;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final Context context;
    private ArrayList<ChatModel> models;

    private ChatAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener   {
        void onItemClick (int position);
    }
    public void setOnItemClickListener(ChatAdapter.OnItemClickListener listener)
    {
        mListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView message;
        View mView;
        public MyViewHolder(View view , final ChatAdapter.OnItemClickListener listener) {
            super(view);
            image = view.findViewById(R.id.image);
            message =view.findViewById(R.id.message);

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
        TextView message;
        LinearLayout isOnline;

        View mView;
        public MyViewHolder2(View view , final ChatAdapter.OnItemClickListener listener) {
            super(view);

            image = view.findViewById(R.id.image);
            isOnline = view.findViewById(R.id.is_online);
            message =view.findViewById(R.id.message);


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

    public class MyViewHolder3 extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView imageSend;
        View mView;
        public MyViewHolder3(View view , final ChatAdapter.OnItemClickListener listener) {
            super(view);
            image = view.findViewById(R.id.image);
            imageSend = view.findViewById(R.id.imageSend);

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

    public class MyViewHolder4 extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView imageSend;
        LinearLayout isOnline;

        View mView;
        public MyViewHolder4(View view , final ChatAdapter.OnItemClickListener listener) {
            super(view);

            image = view.findViewById(R.id.image);
            imageSend = view.findViewById(R.id.imageSend);
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

    public ChatAdapter(ArrayList<ChatModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(!models.get(position).isImage())
        {
            if(models.get(position).isMe())
            {
                return 11;
            }
            else{
                return 12;
            }
        }
        else{
            if(models.get(position).isMe())
            {
                return 21;
            }
            else{
                return 22;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View me = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_recyclerview_item_me, parent, false);
        View friend = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_recyclerview_item, parent, false);
        View imageMe = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_recyclerview_item_image_me, parent, false);
        View imageFriend = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_recyclerview_item_image, parent, false);

        switch (viewType) {
            case 11:
                return new MyViewHolder(me, mListener);
            case 12:
                return new MyViewHolder2(friend, mListener);
            case 21:
                return new MyViewHolder3(imageMe, mListener);
            case 22:
                return new MyViewHolder4(imageFriend, mListener);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 11:
                final MyViewHolder viewHolder1 = (ChatAdapter.MyViewHolder) holder;
                viewHolder1.message.setText(models.get(position).getMessage());
                Glide.with(context).load(models.get(position).getImage()).into(viewHolder1.image);

                break;
            case 12:
                final MyViewHolder2 viewHolder2 = (ChatAdapter.MyViewHolder2) holder;
                viewHolder2.message.setText(models.get(position).getMessage());
                Glide.with(context).load(models.get(position).getImage()).into(viewHolder2.image);

                if(models.get(position).isOnline())
                {
                    viewHolder2.isOnline.setBackgroundResource(R.drawable.online);
                }
                else{
                    viewHolder2.isOnline.setBackgroundResource(R.drawable.offline);
                }

                break;

            case 21:
                final MyViewHolder3 viewHolder3 = (ChatAdapter.MyViewHolder3) holder;
                Glide.with(context).load(models.get(position).getImage()).into(viewHolder3.image);
                Glide.with(context).load(models.get(position).getMessage()).into(viewHolder3.imageSend);
                break;

            case 22:
                final MyViewHolder4 viewHolder4 = (ChatAdapter.MyViewHolder4) holder;
                Glide.with(context).load(models.get(position).getImage()).into(viewHolder4.image);
                Glide.with(context).load(models.get(position).getMessage()).into(viewHolder4.imageSend);

                if(models.get(position).isOnline())
                {
                    viewHolder4.isOnline.setBackgroundResource(R.drawable.online);
                }
                else{
                    viewHolder4.isOnline.setBackgroundResource(R.drawable.offline);
                }
                break;

        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

}
