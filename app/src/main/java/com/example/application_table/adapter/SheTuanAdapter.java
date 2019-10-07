package com.example.application_table.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.application_table.R;
import com.example.application_table.SheTuan;

import java.util.List;

public class SheTuanAdapter extends RecyclerView.Adapter<SheTuanAdapter.ViewHolder> {

    private Context mContext;

    private List<SheTuan> mSheTuanList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView ;
        ImageView shetuanImage;
        TextView shetuanName;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            shetuanImage = (ImageView) view.findViewById(R.id.photo_image);
            shetuanName = (TextView)view.findViewById(R.id.photo_name);
        }
    }

    public SheTuanAdapter(List<SheTuan> shetuanList){
       mSheTuanList = shetuanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.shetuan_item,
                parent,false);
        return new ViewHolder(view);
        /**final ViewHolder holder = new ViewHolder(view);
         holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        int position = holder.getAdapterPosition();
        Photo photo = mPhotoList.get(position);
        Intent intent = new Intent(mContext,PhotoActivity.class);
        intent.putExtra(PhotoActivity.FRUIT_NAME,photo.getName());
        intent.putExtra(PhotoActivity.FRUIT_IMAGE_ID,photo.getImageId());
        mContext.startActivity(intent);
        }
        });
         return holder;*/
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        SheTuan shetuan = mSheTuanList.get(position);
        holder.shetuanName.setText(shetuan.getName());
        Glide.with(mContext).load(shetuan.getImageId()).into(holder.shetuanImage);
    }

    @Override
    public int getItemCount(){
        return mSheTuanList.size();
    }
}

