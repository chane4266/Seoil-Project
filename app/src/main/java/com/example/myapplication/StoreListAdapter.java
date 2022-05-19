package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder>{
    Context mContext;
    ArrayList<StoreListitem> items = new ArrayList<>();

    public StoreListAdapter(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.recyclerview_l, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreListitem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(StoreListitem item){//아이템을 추가할수있는
        items.add(item);
   }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView store_img;
        TextView store_title;
        TextView store_de;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            store_img = itemView.findViewById(R.id.storeimage);
            store_title = itemView.findViewById(R.id.titletxt);
            store_de = itemView.findViewById(R.id.detxt);
        }
        public void setItem(StoreListitem item){
            store_img.setImageResource(item.resId);
            store_title.setText(item.title);
            store_de.setText(item.content);
        }
    }
}
