package com.example.policemodule.Drawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUsAdapter extends RecyclerView.Adapter<AboutUsAdapter.ImageViewHolder>
{
    private List<AboutUsModel> alist;

    public AboutUsAdapter(List<AboutUsModel> alist)
    {
        this.alist = alist;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aboutus,parent,false);
        return new ImageViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position)
    {
    holder.imageView.setImageResource(alist.get(position).getImage());
    holder.membername.setText(alist.get(position).getMember_name());
    holder.memberwork.setText(alist.get(position).getMember_work());
    }

    @Override
    public int getItemCount() {
        return alist.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.card_item_tv_memberName)
         TextView membername;
        @BindView(R.id.card_item_img_member)
         ImageView imageView;
         @BindView(R.id.member_work)
         TextView memberwork;

        public ImageViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
