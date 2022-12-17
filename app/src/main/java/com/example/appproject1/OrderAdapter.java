package com.example.appproject1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

List<Model> modelList;
Context context;
    public OrderAdapter(Context context, List<Model>modelList) {
        this.context=context;
        this.modelList=modelList;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String nameofSushi=modelList.get(position).getmSushiName();
        String descriptionofSushi=modelList.get(position).getmSushiDetails();
        int images =modelList.get(position).getmSushiPhoto();

        holder.mSushiName.setText(nameofSushi);
        holder.mSushiDescription.setText(descriptionofSushi);
        holder.imageView.setImageResource(images);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mSushiName, mSushiDescription;
        ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);

            mSushiName=itemView.findViewById(R.id.sushiName);
            mSushiDescription=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.sushiImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();

            if (position==0){

                Intent intent = new Intent(context,InfoActivity.class);
                context.startActivity(intent);
            }

        }
    }





}
