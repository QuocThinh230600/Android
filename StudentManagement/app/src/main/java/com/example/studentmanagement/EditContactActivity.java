package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagement.model.ContactModel;

public class EditContactActivity extends AppCompatActivity {

    int position = 0;
    Button btnEditUpdate, btnEditCancel;
    EditText editName, editBirthday, editPhone, editCode, editAddress;
    String mName = "", mBirthday = "", mPhone = "", mCode = "", mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        onInit();
        onGetValue();

        btnEditUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactModel model = ValidateForm();
                if(model != null){
                    ContactActivity.modelList.add(position, model);
                    ContactActivity.adapter.notifyDataSetChanged();
                    finish();
                }
            }
        });

        btnEditCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private ContactModel ValidateForm(){
        int id = ContactActivity.modelList.get(ContactActivity.modelList.size() - 1).getId() + 1;
        mName     = editName.getText().toString();
        mBirthday = editBirthday.getText().toString();
        mPhone    = editPhone.getText().toString();
        mCode     = editCode.getText().toString();
        mAddress  = editAddress.getText().toString();
        String errorText = "null";

        if(mName.length() < 1){
            editName.setError(errorText);
            return null;
        }
        if(mBirthday.length() < 1){
            editBirthday.setError(errorText);
            return null;
        }
        if(mPhone.length() < 1){
            editPhone.setError(errorText);
            return null;
        }
        if(mCode.length() < 1){
            editCode.setError(errorText);
            return null;
        }
        if(mAddress.length() < 1){
            editAddress.setError(errorText);
            return null;
        }

        ContactModel model = new ContactModel(id, mName, mBirthday, mPhone, mCode, mAddress);

        return model;
    }

    private void onGetValue() {
        Intent intent = getIntent();
        position = intent.getIntExtra("POS",0);
        ContactModel model = (ContactModel) intent.getSerializableExtra("Update_Item");

        editName.setText(model.getName());
        editBirthday.setText(model.getBirthday());
        editPhone.setText(model.getPhone());
        editCode.setText(model.getCode());
        editAddress.setText(model.getAddress());
    }

    private void onInit() {
        editName      = findViewById(R.id.contact_edit_Name);
        editBirthday  = findViewById(R.id.contact_edit_Birthday);
        editPhone     = findViewById(R.id.contact_edit_Phone);
        editCode      = findViewById(R.id.contact_edit_Code);
        editAddress   = findViewById(R.id.contact_edit_Address);
        btnEditUpdate = findViewById(R.id.contact_edit_btnUpdate);
        btnEditCancel = findViewById(R.id.contact_edit_btnCancel);
    }
}