package com.example.policemodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.police.Police_Info;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.ViewHolder>
{
    private ArrayList<Police_Info> info;

    public PoliceAdapter(ArrayList<Police_Info> info) {
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.police_fragment_list_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.stationimage.setImageResource(info.get(position).getImage());
        holder.location.setText(info.get(position).getLocation());


    }
    @Override
    public int getItemCount()
    {

         return  info.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.police_frag_tv_stationimage)
        ImageView stationimage;
        @BindView(R.id.police_frag_tv_locationplace)
        TextView location;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
