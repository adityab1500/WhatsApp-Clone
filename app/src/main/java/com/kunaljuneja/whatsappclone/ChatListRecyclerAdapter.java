package com.kunaljuneja.whatsappclone;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatListRecyclerAdapter extends RecyclerView.Adapter<ChatListRecyclerAdapter.MyViewHolder> {

    List<String> mChatList;
    Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onPictureClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView chatName;
        public ImageView profilePicture;

        public MyViewHolder(@NonNull View view) {
            super(view);
            chatName = view.findViewById(R.id.chat_name);
            profilePicture = view.findViewById(R.id.profile_picture_chat);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                            mListener.onItemClick(position);
                    }
                }
            });

            profilePicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                            mListener.onPictureClick(position);
                    }
                }
            });
        }
    }

    public ChatListRecyclerAdapter(Context context, List<String> chats) {
        this.mChatList = chats;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.chatview_recycler_element, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = mChatList.get(position);

        holder.chatName.setText(name);
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }
}
