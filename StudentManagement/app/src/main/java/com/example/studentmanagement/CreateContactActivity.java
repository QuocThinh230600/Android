package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanagement.model.ContactModel;

public class CreateContactActivity extends AppCompatActivity {

    Button btnSave, btnCancel;
    EditText editName, editBirthday, editPhone, editCode, editAddress;
    String mName = "", mBirthday = "", mPhone = "", mCode = "", mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        onInit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ValidateForm()){
                    int id = ContactActivity.modelList.get(ContactActivity.modelList.size() - 1).getId() + 1;
                    ContactModel model = new ContactModel(id, mName, mBirthday, mPhone, mCode, mAddress);
                    ContactActivity.adapter.add(model);
                    ContactActivity.adapter.notifyDataSetChanged();
                    Toast.makeText(CreateContactActivity.this, "thêm thành công", Toast.LENGTH_SHORT).show();
                    onClearForm();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean ValidateForm(){
        mName     = editName.getText().toString();
        mBirthday = editBirthday.getText().toString();
        mPhone    = editPhone.getText().toString();
        mCode     = editCode.getText().toString();
        mAddress  = editAddress.getText().toString();

        if (mName.length() < 1){
            editName.setError("Name can't be null!!!");
            return false;
        }
        if (mBirthday.length() < 1){
            editBirthday.setError("Address can't be null!!!");
            return false;
        }
        if (mPhone.length() < 1){
            editPhone.setError("Phone can't be null!!!");
            return false;
        }
        if (mCode.length() < 1){
            editCode.setError("Phone can't be null!!!");
            return false;
        }
        if (mAddress.length() < 1){
            editAddress.setError("Phone can't be null!!!");
            return false;
        }
        return true;
    }

    private void onClearForm(){
        editName.clearComposingText();
        editBirthday.clearComposingText();
        editPhone.clearComposingText();
        editCode.clearComposingText();
        editAddress.clearComposingText();
    }

    private void onInit() {
        btnSave      = findViewById(R.id.contact_create_btnSave);
        btnCancel    = findViewById(R.id.contact_create_btnCancel);
        editName     = findViewById(R.id.contact_create_Name);
        editBirthday = findViewById(R.id.contact_create_Birthday);
        editPhone    = findViewById(R.id.contact_create_Phone);
        editCode     = findViewById(R.id.contact_create_Code);
        editAddress  = findViewById(R.id.contact_create_Address);
    }
}