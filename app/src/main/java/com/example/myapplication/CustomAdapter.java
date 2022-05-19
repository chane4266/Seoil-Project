package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
// 뷰홀더 클래스
    private ArrayList<String> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
       private TextView textview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textView);
        }
        public TextView getTextview(){
            return textview;
        }
    }
//-----------------------
    //생성자
    //생성자를 통해 데이터 전달받기
    public CustomAdapter (ArrayList<String> dataset){
        localDataSet = dataset;
    }
//-----------------------
    @NonNull
    @Override //viewholder객체를 생성하여 리턴
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.recyclerview_item, parent, false);
            CustomAdapter.ViewHolder viewHolder = new CustomAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override //viewholder안에 내용을 position에 해당되는 데이터로 교체
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
            String text = localDataSet.get(position);
            holder.textview.setText(text);
    }

    @Override //전체 데이터의 갯수를 리턴
    public int getItemCount() {
        return localDataSet.size();
    }
}
