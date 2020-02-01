package com.example.policemodule.police;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.PoliceAdapter;
import com.example.policemodule.R;
import com.example.policemodule.map.Coordinate;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Police_fragment extends Fragment
{

    @BindView(R.id.police_frag_rv)
    RecyclerView recyclerView;

    ArrayList<Police_Info> infos;

    RecyclerView.LayoutManager layoutManager;

    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent=inflater.inflate(R.layout.police_fragment,container,false);
        ButterKnife.bind(this,parent);
        infos=new ArrayList<>();
        mRef= FirebaseDatabase.getInstance().getReference();
        final Coordinate[] coordinate = new Coordinate[1];
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                coordinate[0] =dataSnapshot.child("message").getValue(Coordinate.class);

                double lat= coordinate[0].getLatitude();
                double lon= coordinate[0].getLongitude();
                Toast.makeText(getActivity(), Double.toString(lat), Toast.LENGTH_SHORT).show();
                infos.add(new Police_Info(R.drawable.ic_launcher_background,Double.toString(lat),"Crime"));
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //String add=getAddress(lat,lon);

        infos.add(new Police_Info(R.drawable.ic_launcher_background,Double.toString(coordinate[0].getLatitude()),"Crime"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"Location","Crime"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"Location","Crime"));
        infos.add(new Police_Info(R.drawable.ic_launcher_background,"Location","Crime"));
        initrecycleadapter(getContext());
        return  parent;
    }

    private void initrecycleadapter(Context context)
    {
        layoutManager = new LinearLayoutManager(getContext());
        PoliceAdapter policeAdapter=new PoliceAdapter(infos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(policeAdapter);
    }
    public String getAddress(double lat, double lng) {
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);
            String add = obj.getAddressLine(0);
            add = add + "\n" + obj.getCountryName();
            add = add + "\n" + obj.getCountryCode();
            add = add + "\n" + obj.getAdminArea();
            add = add + "\n" + obj.getPostalCode();
            add = add + "\n" + obj.getSubAdminArea();
            add = add + "\n" + obj.getLocality();
            add = add + "\n" + obj.getSubThoroughfare();

            Log.v("IGA", "Address" + add);
            // Toast.makeText(this, "Address=>" + add,
            // Toast.LENGTH_SHORT).show();
            return add;
            // TennisAppActivity.showDialog(add);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
