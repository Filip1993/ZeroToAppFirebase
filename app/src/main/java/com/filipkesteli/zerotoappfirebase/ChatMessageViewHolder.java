package com.filipkesteli.zerotoappfirebase;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Filip on 8.6.2016..
 */
public class ChatMessageViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "ChatMessageViewHolder";
    private final Activity activity;

    private TextView name;
    private TextView message;
    private ImageView image;


    public ChatMessageViewHolder(Activity activity, View itemView) {
        super(itemView);
        this.activity = activity;
        this.name = (TextView) itemView.findViewById(android.R.id.text1);
        this.message = (TextView) itemView.findViewById(android.R.id.text2);
        this.image = new ImageView(activity);
        ((ViewGroup) itemView).addView(image);
    }

    public void bind(ChatMessage chatMessage) {
        this.name.setText(chatMessage.getName());
        if (chatMessage.getMessage().startsWith("https://firebasestorage.googleapis.com/")) {
            this.message.setVisibility(View.INVISIBLE);
            this.image.setVisibility(View.VISIBLE);
            Glide
                    .with(activity)
                    .load(chatMessage.getMessage())
                    .into(this.image);
        } else {
            this.message.setVisibility(View.VISIBLE);
            this.image.setVisibility(View.GONE);
            this.message.setText(chatMessage.getMessage());
        }
    }
}
