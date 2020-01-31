package com.example.policemodule.Drawer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.PoliceAdapter;
import com.example.policemodule.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AboutUsFragment extends Fragment {
    @BindView(R.id.aboutus_frag_rv)
    RecyclerView recyclerView;

    AboutUsAdapter aboutUsAdapter;

    ArrayList<AboutUsModel> list;

    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View parent=inflater.inflate(R.layout.fragment_aboutus,container,false);
        ButterKnife.bind(this,parent);
        list=new ArrayList<>();
        list.add(new AboutUsModel(R.drawable.asis,"ASIS KUMAR ROY","Machine Learing"));
        list.add(new AboutUsModel(R.drawable.yash,"YASH SRIVASTAVA","Android Developer"));
        list.add(new AboutUsModel(R.drawable.nandini,"NANDINI AGARWAL","Android Developer"));
        list.add(new AboutUsModel(R.drawable.trishna,"TRISHNA KALITA","Android Developer"));
        initrecycleradapter(getContext());

         return parent;

    }
    public void initrecycleradapter(Context context)
    {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        AboutUsAdapter aboutUsAdapter=new AboutUsAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(aboutUsAdapter);
    }
}
