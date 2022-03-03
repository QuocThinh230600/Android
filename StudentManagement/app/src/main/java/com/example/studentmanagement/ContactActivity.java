package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentmanagement.model.ContactModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    FloatingActionButton floatButton;
    ListView listView;

    static List<ContactModel> modelList;
    static ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        
        onInit();
        onSetData();

        adapter = new ContactAdapter(ContactActivity.this, R.layout.contact_item, modelList);
        listView.setAdapter(adapter);

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this, CreateContactActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onSetData() {
        modelList = new ArrayList<>();
        modelList.add(new ContactModel(0, "thinh 0", "23/06/2000", "+84 779 803 198", "0" , "Tp.HCM"));
        modelList.add(new ContactModel(1, "thinh 1", "23/06/2000", "+84 779 803 198", "1" , "Tp.HCM"));
        modelList.add(new ContactModel(2, "thinh 2", "23/06/2000", "+84 779 803 198", "2" , "Tp.HCM"));
        modelList.add(new ContactModel(3, "thinh 3", "23/06/2000", "+84 779 803 198", "3" , "Tp.HCM"));
        modelList.add(new ContactModel(4, "thinh 4", "23/06/2000", "+84 779 803 198", "4" , "Tp.HCM"));
        modelList.add(new ContactModel(5, "thinh 5", "23/06/2000", "+84 779 803 198", "5" , "Tp.HCM"));
        modelList.add(new ContactModel(6, "thinh 6", "23/06/2000", "+84 779 803 198", "6" , "Tp.HCM"));
        modelList.add(new ContactModel(7, "thinh 7", "23/06/2000", "+84 779 803 198", "7" , "Tp.HCM"));
        modelList.add(new ContactModel(8, "thinh 8", "23/06/2000", "+84 779 803 198", "8" , "Tp.HCM"));
        modelList.add(new ContactModel(9, "thinh 9", "23/06/2000", "+84 779 803 198", "9" , "Tp.HCM"));
        modelList.add(new ContactModel(10, "thinh 10", "23/06/2000", "+84 779 803 198", "10" , "Tp.HCM"));
        modelList.add(new ContactModel(11, "thinh 11", "23/06/2000", "+84 779 803 198", "11" , "Tp.HCM"));
    }

    private void onInit() {
        listView    = findViewById(R.id.lv_Contact);
        floatButton = findViewById(R.id.add_contact);
    }
}