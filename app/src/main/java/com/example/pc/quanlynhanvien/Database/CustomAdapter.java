package com.example.pc.quanlynhanvien.Database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pc.quanlynhanvien.R;

import java.util.List;

/**
 * Created by PC on 4/18/2018.
 */

public class CustomAdapter extends ArrayAdapter<NhanVien> {

    private Context context;
    private int resoure;
    private List<NhanVien> listNV;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resoure = resource;
        this.listNV = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_nv,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvCode = (TextView) convertView.findViewById(R.id.tv_code);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
            convertView.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();

        }
        NhanVien nv = listNV.get(position);
        viewHolder.tvId.setText(String.valueOf(nv.getId()));
        viewHolder.tvCode.setText(nv.getCode());
        viewHolder.tvName.setText(nv.getName());
        viewHolder.tvEmail.setText(nv.getEmail());
        viewHolder.tvPhone.setText(nv.getPhone());
        viewHolder.tvAddress.setText(nv.getAddress());

        return convertView;
    }

    public class ViewHolder{
        private TextView tvId;
        private TextView tvCode;
        private TextView tvName;
        private TextView tvEmail;
        private TextView tvPhone;
        private TextView tvAddress;
    }
}
