package com.example.policemodule.Drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.policemodule.PoliceAdapter;
import com.example.policemodule.R;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingFragment extends Fragment
{
    @BindView(R.id.image_settings)
    ImageView image_set;

    @BindView(R.id.fragment_settings_website)
    Button website;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent=inflater.inflate(R.layout.fragment_settings,container,false);
        ButterKnife.bind(this,parent);

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openUrl("http://tecnoesis.org/hacks/");


            }
        });

        return parent;

    }
    public void openUrl(String url)
    {
        Uri uri=Uri.parse(url);
        Intent launcherweb= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launcherweb);

    }
}
