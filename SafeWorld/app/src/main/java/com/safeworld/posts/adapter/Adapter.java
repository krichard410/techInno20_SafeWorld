package com.safeworld.posts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.safeworld.R;
import com.safeworld.posts.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/**
 * The Adapter class using for displaying the posts list
 * @author nieruize
 * @version 1.0
 */
public class Adapter extends RecyclerView.Adapter<Adapter.PostViewHolder>{
    private Context mContext;
    private List<Post> mData;

    // constructor
    public Adapter(Context context, List<Post> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    // inflater the content to view
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.fragment_posts_items,parent,false);
        return new PostViewHolder(row);
    }

    @Override
    // bind the view into view holder
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Picasso.get().load(R.drawable.userphoto).into(holder.img_user);
        holder.tv_name.setText(mData.get(position).getTitle());
        holder.tv_content.setText(mData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView img_user;
        TextView tv_name,tv_content;

        public PostViewHolder(View itemView) {
            super(itemView);
            img_user = itemView.findViewById(R.id.post_user_img);
            tv_name = itemView.findViewById(R.id.post_username);
            tv_content = itemView.findViewById(R.id.post_content);
        }
    }
}
