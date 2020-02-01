package com.example.policemodule.Drawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.policemodule.R;
import com.example.policemodule.police.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {
    @BindView(R.id.tv_profile)
    TextView tvProfile;
    @BindView(R.id.tv_profile_phone_number)
    TextView tvPhno;
    @BindView(R.id.tv_profile_email)
    TextView tvEmail;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, parent);
        firebaseAuth = FirebaseAuth.getInstance();
        Toast.makeText(getActivity(),firebaseAuth.getUid(),Toast.LENGTH_SHORT).show();

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user=dataSnapshot.child(firebaseAuth.getUid()).getValue(User.class);
                if(user==null)
                {
                    Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
                    return;
                }
                tvProfile.setText(user.getName());
                tvPhno.setText(user.getPhoneno());
                tvEmail.setText(user.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                
            }
        });

        return parent;
    }
}
