package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.studentmanagement.model.ContactModel;

public class ContactDetailActivity extends AppCompatActivity {

    TextView tvUserName;
    TextView tvBirthday;
    TextView tvPhone;
    TextView tvCode;
    TextView tvAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        onInint();
        onSetIntent();
    }

    private void onSetIntent() {
        Intent intent = getIntent();
        ContactModel model =(ContactModel)intent.getSerializableExtra("ContactModel");

        tvUserName.setText("Name: " + model.getName());
        tvBirthday.setText("Birthday: " + model.getBirthday());
        tvPhone.setText("Phone: " + model.getPhone());
        tvCode.setText("Code: " + model.getCode());
        tvAddress.setText("Address: " + model.getAddress());
    }

    private void onInint() {
        tvUserName = findViewById(R.id.contact_detail_tvName);
        tvBirthday = findViewById(R.id.contact_detail_tvBirthday);
        tvPhone    = findViewById(R.id.contact_detail_tvPhone);
        tvCode     = findViewById(R.id.contact_detail_tvCode);
        tvAddress  = findViewById(R.id.contact_detail_tvAddress);
    }
}