package com.kunaljuneja.whatsappclone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChatListRecyclerAdapter mChatListAdapter;
    private List<String> mChatList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.chat_list_recyclerview);

        //Adding elements to recyclerview
        for(int i=0; i<20; i++)
            mChatList.add("Kunal Juneja " + (i+1));

        mChatListAdapter = new ChatListRecyclerAdapter(getContext(), mChatList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mChatListAdapter);

        mChatListAdapter.setOnItemClickListener(new ChatListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "Clicked Item of RecyclerView", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPictureClick(int position) {
                pictureClickDialog(position);
            }
        });
    }

    public void pictureClickDialog(int position) {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.view_profile_image);
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(R.color.transparent_black_75);
        window.setGravity(Gravity.CENTER);
        dialog.show();

        ImageView messages = dialog.findViewById(R.id.message_dialog);
        ImageView info = dialog.findViewById(R.id.info_dialog);
        TextView name = dialog.findViewById(R.id.contact_name_dialog);
        name.setText(mChatList.get(position));

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Messages Clicked!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Info Clicked!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
