package com.example.admin.nycshcool.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.nycshcool.R;
import com.example.admin.nycshcool.data.SchoolDetail;
import com.example.admin.nycshcool.model.SchoolModel;
import com.example.admin.nycshcool.presenter.ActivityPresenter;
import com.example.admin.nycshcool.presenter.Contract;

public class SchoolDetails extends AppCompatActivity implements Contract.SchoolInfo {

    private TextView sName, sFax, sPNumber, sCity, sSAT;

    ActivityPresenter presenter;
    SchoolModel xul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);



        initValues();

        presenter = new ActivityPresenter(this);
        xul = SchoolModel.getInstance();

        presenter.getSchoolInfo(xul.getSchoolName());

    }

    private void initValues() {

        sName = findViewById(R.id.sdName);
        sFax = findViewById(R.id.sdFax);
        sPNumber = findViewById(R.id.sdPhone);
        sCity = findViewById(R.id.sdCity);
        sSAT = findViewById(R.id.sdSAT);

    }


    @Override
    public void displaySchoolInfo(SchoolDetail schoolDetail) {

        sName.setText(schoolDetail.getSchoolName());
        sFax.setText("Fax : "+xul.getFaxNumber());
        sPNumber.setText("Phone Number : "+xul.getPhoneNumber());
        sCity.setText("City : "+xul.getSchoolCity());
        sSAT.setText("Math SAT AVG : "+schoolDetail.getSatMathAvgScore()
                +"\n"+"Reading SAT AVG : "+schoolDetail.getSatCriticalReadingAvgScore()
                +"\n"+"Writing SAT AVG : "+schoolDetail.getSatWritingAvgScore());

    }

    @Override
    public void noInfo() {
        Toast.makeText(this, "No Information on school found.", Toast.LENGTH_LONG).show();
        sName.setText(xul.getSchoolName());
        sFax.setText("Fax : [No Information]");
        sPNumber.setText("Phone Number : [No Information]");
        sCity.setText("City : [No Information]");
        sSAT.setText("SAT\n[No Information]");

    }
}
