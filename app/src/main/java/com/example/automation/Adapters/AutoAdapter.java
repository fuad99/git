package com.example.automation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.automation.CardFragment;
import com.example.automation.R;
import com.example.automation.models.AutoModel;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.MyViewHolder> {

    private Context context;
    private List<AutoModel> list;



    public void setDevices(List<AutoModel> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AutoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item
                ,parent,false);


        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AutoAdapter.MyViewHolder holder, int position) {
        AutoModel model = list.get(position);
        holder.tvTitle.setText(model.getCardName());
        holder.imgAuto.setImageResource(Integer.parseInt(model.getImgId()));
        holder.imgAuto.setTag(list.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgAuto;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.titleTextView);
            imgAuto = itemView.findViewById(R.id.coverImageView);


        }
    }
}
