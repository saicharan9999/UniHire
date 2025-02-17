package com.example.unihire.uiRec.dashboardRec;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.unihire.MainActivity;
import com.example.unihire.R;
import com.google.firebase.auth.FirebaseAuth;


public class DashboardFragment extends Fragment {


    TextView text;
    Button SignOut;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_dashboard_rec, container, false);

        text=(TextView) view.findViewById(R.id.dashBoardText); //This is how you from xml
        SignOut=view.findViewById(R.id.signOutBtn);

        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent =new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}