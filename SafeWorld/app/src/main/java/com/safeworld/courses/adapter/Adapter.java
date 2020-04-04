package com.safeworld.courses.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.safeworld.R;
import com.safeworld.courses.Course;
import com.safeworld.news.NewsDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.CourseViewHolder> {
    private Context mContext;
    private List<Course> mData;

    public Adapter(Context context, List<Course> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.fragment_courses_item,parent,false);
        return new CourseViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        final Course course = mData.get(position);

        Picasso.get().load(mData.get(position).getImg()).into(holder.course_img);
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_desc.setText(mData.get(position).getDescription());
        holder.course_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewsDetails.class);
                intent.putExtra("url", course.getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{

        ImageView course_img;
        TextView tv_title,tv_desc;
        Button course_button;

        public CourseViewHolder(View itemView) {
            super(itemView);
            course_img = itemView.findViewById(R.id.course_img);
            tv_title = itemView.findViewById(R.id.course_title);
            tv_desc = itemView.findViewById(R.id.course_desc);
            course_button = itemView.findViewById(R.id.course_button);
        }
    }
}
