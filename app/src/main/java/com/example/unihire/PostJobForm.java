package com.example.unihire;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PostJobForm extends AppCompatActivity {

    TextView jobTitle,dept,spec,jobDesc,weightage1,weightage2,weightage3;
    Spinner p1Spinner,p2Spinner,p3Spinner;
    CheckBox NameInput,GenderInput,PhoneInput,EmailInput,AddressInput,WorkExpInput,EducationInput,PublicationInput,AwardInput,ResearchInput,ResumeInput;
    Button SaveDraftBtn, PostJobFinalBtn;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job_form);
        fAuth=FirebaseAuth.getInstance();
        String uid=fAuth.getUid();
        jobTitle=findViewById(R.id.jobTitle);
        String job_title=jobTitle.getText().toString();
        dept=findViewById(R.id.dept);
        String department=dept.getText().toString();
        spec=findViewById(R.id.spec);
        String specialization=spec.getText().toString();
        jobDesc=findViewById(R.id.jobDesc);
        String jd=jobDesc.getText().toString();
        weightage1=findViewById(R.id.weightage1);
        int w1=Integer.parseInt(weightage1.getText().toString());
        weightage2=findViewById(R.id.weightage2);
        int w2=Integer.parseInt(weightage2.getText().toString());
        weightage3=findViewById(R.id.weightage3);
        int w3=Integer.parseInt(weightage3.getText().toString());
        p1Spinner=findViewById(R.id.p1Spinner);
        @SuppressLint("ResourceType") ArrayAdapter adapter1=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,R.array.priority_array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p1Spinner.setAdapter(adapter1);
        p2Spinner=findViewById(R.id.p2Spinner);
        @SuppressLint("ResourceType") ArrayAdapter adapter2=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,R.array.priority_array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p2Spinner.setAdapter(adapter2);
        p3Spinner=findViewById(R.id.p3Spinner);
        @SuppressLint("ResourceType") ArrayAdapter adapter3=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,R.array.priority_array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p3Spinner.setAdapter(adapter3);
        NameInput=findViewById(R.id.NameInput);
        GenderInput=findViewById(R.id.GenderInput);
        PhoneInput=findViewById(R.id.PhoneInput);
        EmailInput=findViewById(R.id.EmailInput);
        boolean emailInp=EmailInput.isChecked();
        AddressInput=findViewById(R.id.AddressInput);
        boolean addressInp=AddressInput.isChecked();
        WorkExpInput=findViewById(R.id.WorkExpInput);
        boolean workexpInp=WorkExpInput.isChecked();
        EducationInput=findViewById(R.id.EducationInput);
        boolean educationInp=EducationInput.isChecked();
        PublicationInput=findViewById(R.id.PublicationInput);
        boolean publicationInp=PublicationInput.isChecked();
        AwardInput=findViewById(R.id.AwardInput);
        boolean awardInp=AwardInput.isChecked();
        ResearchInput=findViewById(R.id.ResearchInput);
        boolean researchInp=ResearchInput.isChecked();
        ResumeInput=findViewById(R.id.ResumeInput);
        boolean resumInp=ResearchInput.isChecked();

        SaveDraftBtn=findViewById(R.id.SaveDraftBtn);
        PostJobFinalBtn=findViewById(R.id.PostJobFinalBtn);

        PostJobFinalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String dateTime=formatter.format(date);
                String p1=p1Spinner.getSelectedItem().toString();
                String p2=p2Spinner.getSelectedItem().toString();
                String p3=p3Spinner.getSelectedItem().toString();
                Job job=new Job(
                        uid,dateTime,job_title,department,specialization,jd,p1,p2,p3,w1,
                        w2,w3,workexpInp,educationInp,publicationInp,awardInp,researchInp,researchInp
                        ,false
                );
            }
        });

    }
}