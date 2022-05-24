package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder>{
    Context mContext;
    private ArrayList<StoreListitem> items = new ArrayList<>();

    public StoreListAdapter(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();

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

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView store_img;
        TextView store_title;
        TextView store_de;
        TextView store_score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            store_img = itemView.findViewById(R.id.storeimage);
            store_title = itemView.findViewById(R.id.titletxt);
            store_de = itemView.findViewById(R.id.detxt);
            store_score = itemView.findViewById(R.id.scoretxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { //아이템뷰 -> 아이템뷰가 가리키는 영역만큼 클릭이벤트 생성
                    int currentp = getAdapterPosition();
                      StoreListitem storeListitem = items.get(currentp); //각 카드뷰마다 저장된 정보

                    /*if(currentp != RecyclerView.NO_POSITION){
                        Intent intent1 = new Intent(mContext,StoreInfoActivity.class).
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent1.putExtra("TEXT", (Parcelable) items.get(currentp));
                        mContext.startActivity(intent1);
                    }*/

                       Toast.makeText(mContext,storeListitem.title + "\n"
                            + storeListitem.score + "\n"
                            + storeListitem.content
                            ,Toast.LENGTH_SHORT).show();  //각 카드뷰마다 저장된 정보를 토스트로 보여줌
                                                          //-----식당정보페이지완성되면 그기능으로 바꾸기-----*/
                }
            });
        }


        public void setItem(StoreListitem item){
            store_img.setImageResource(item.resId);
            store_title.setText(item.title);
            store_de.setText(item.content);
            store_score.setText(item.score);
        }
    }
}
