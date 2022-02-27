package com.example.studentmanagement;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studentmanagement.model.ContactModel;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<ContactModel> {

    private int mResource;
    private Context mContext;
    private List<ContactModel> mList;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<ContactModel> objects) {
        super(context, resource, objects);

        this.mContext  = context;
        this.mResource = resource;
        this.mList     = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null){
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.linearLayoutTest     = convertView.findViewById(R.id.contact_detail_Test);
            viewHolder.textViewName      = convertView.findViewById(R.id.contact_tv_name);
            viewHolder.textViewBirthday  = convertView.findViewById(R.id.contact_tv_birthday);
            viewHolder.textViewPhone     = convertView.findViewById(R.id.contact_tv_phone);
            viewHolder.textViewCode      = convertView.findViewById(R.id.contact_tv_code);
            viewHolder.textViewAddress   = convertView.findViewById(R.id.contact_tv_address);
            viewHolder.imageViewPhone    = convertView.findViewById(R.id.contact_item_imageViewPhone);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ContactModel model= mList.get(position);
        viewHolder.textViewName.setText(String.valueOf(model.getName()));
        viewHolder.textViewBirthday.setText(String.valueOf(model.getBirthday()));
        viewHolder.textViewPhone.setText(String.valueOf(model.getPhone()));
        viewHolder.textViewCode.setText(String.valueOf(model.getCode()));
        viewHolder.textViewAddress.setText(String.valueOf(model.getAddress()));
        viewHolder.linearLayoutTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ContactDetailActivity.class);
                intent.putExtra("ContactModel", model);
                mContext.startActivity(intent);
            }
        });
        viewHolder.imageViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + model.getPhone()));
                mContext.startActivity(intent);
            }
        });

        return convertView;

    }

    public class ViewHolder{
        LinearLayout linearLayoutTest;
        ImageView imageViewPhone;
        TextView textViewName;
        TextView textViewBirthday;
        TextView textViewPhone;
        TextView textViewCode;
        TextView textViewAddress;
    }
}
