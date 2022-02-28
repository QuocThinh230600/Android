package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentmanagement.model.ContactModel;

public class EditContactActivity extends AppCompatActivity {

    EditText editName;
    EditText editBirthday;
    EditText editPhone;
    EditText editCode;
    EditText editAddress;
    Button btnEditUpdate;
    Button btnEditCancel;
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
                if(onValidateForm()){
                    int id = ContactActivity.modelList.get(ContactActivity.modelList.size()).getId();
                    ContactModel model = new ContactModel(id, mName, mBirthday, mPhone, mCode, mAddress);
                    ContactActivity.adapter.remove(model);
                    ContactActivity.adapter.add(model);
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

    private boolean onValidateForm(){
        String errorText = "null";

        mName = editName.getText().toString();
        if(mName.length() < 1){
            editName.setError(errorText);
            return false;
        }

        mBirthday = editBirthday.getText().toString();
        if(mBirthday.length() < 1){
            editBirthday.setError(errorText);
            return false;
        }

        mPhone = editPhone.getText().toString();
        if(mPhone.length() < 1){
            editPhone.setError(errorText);
            return false;
        }

        mCode = editCode.getText().toString();
        if(mCode.length() < 1){
            editCode.setError(errorText);
            return false;
        }

        mAddress = editAddress.getText().toString();
        if(mAddress.length() < 1){
            editAddress.setError(errorText);
            return false;
        }

        return true;
    }

    private void onGetValue() {
        Intent intent = getIntent();
        ContactModel item = (ContactModel) intent.getSerializableExtra("Update_Item");

        editName.setText(item.getName());
        editBirthday.setText(item.getBirthday());
        editPhone.setText(item.getPhone());
        editCode.setText(item.getCode());
        editAddress.setText(item.getAddress());
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