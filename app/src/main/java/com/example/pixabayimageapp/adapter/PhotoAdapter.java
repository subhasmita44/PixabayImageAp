package com.example.pixabayimageapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixabayimageapp.R;
import com.example.pixabayimageapp.activity.ImageActivity;
import com.example.pixabayimageapp.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoAdapter  extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    Context context;
    ArrayList<Photo> photos;

    public PhotoAdapter(Context context, ArrayList<Photo> photos) {
        this.context = context;
        this.photos = photos;

    }

    @NonNull
    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
        String id= photos.get(position).getLargeImageURL();
        Picasso.get().load(id).into(holder.ivPhoto);
        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ImageActivity.class);
                i.putExtra("image", id);
              context. startActivity(i);
                ((Activity)context).finish();


            }
        });

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {


        ImageView ivPhoto;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivNews);

        }
    }

}
