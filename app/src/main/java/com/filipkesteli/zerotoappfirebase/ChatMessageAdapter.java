package com.filipkesteli.zerotoappfirebase;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 8.6.2016..
 */
public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageViewHolder> {

    private static final String TAG = "ChatMessageAdapter";
    private final Activity activity;
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    public ChatMessageAdapter(Activity activity) {
        this.activity = activity;
    }

    public void addMessage(ChatMessage chatMessage) {
        chatMessageList.add(chatMessage);
        notifyItemInserted(this.chatMessageList.size());
    }

    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatMessageViewHolder(activity, activity.getLayoutInflater().inflate(android.R.layout.two_line_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        holder.bind(this.chatMessageList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.chatMessageList.size();
    }
}
