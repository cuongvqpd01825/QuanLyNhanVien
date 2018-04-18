package com.example.pc.quanlynhanvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.quanlynhanvien.Database.CustomAdapter;
import com.example.pc.quanlynhanvien.Database.DBManager;
import com.example.pc.quanlynhanvien.Database.NhanVien;

import java.util.List;

public class QLNVActivity extends AppCompatActivity {
    private EditText edCode, edName, edEmail, edPhone, edAddress;
    private Button btAdd, btDelete, btListView, btEdit;
    private DBManager dbManager;
    private List<NhanVien> nvlist;
    CustomAdapter customAdapter;
    ListView lvManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlnv);

        Init();

        dbManager = new DBManager(this);
        nvlist = dbManager.getAllNhanVien();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = createNV();
                if (nv!=null){
                    dbManager.addNhanVien(nv);
                    Toast.makeText(getApplicationContext()
                            ,"Add Employees Successfuly",Toast.LENGTH_SHORT).show();
                }
                nvlist.clear();
                nvlist.addAll(dbManager.getAllNhanVien());

            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edCode.setText("");
                edName.setText("");
                edEmail.setText("");
                edPhone.setText("");
                edAddress.setText("");
            }
        });
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLNVActivity.this,DanhSachActivity.class);
                startActivity(intent);
            }
        });
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QLNVActivity.this,DanhSachActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext()
                        ,"Choose Employees",Toast.LENGTH_SHORT).show();
            }
        });


    }
    private NhanVien createNV(){
        String code = edCode.getText().toString();
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String phone = edPhone.getText().toString();
        String address = edAddress.getText().toString();

        NhanVien nv = new NhanVien(code,name,email,phone,address);
        return nv;
    }
    public void Init(){
        edCode = (EditText) findViewById(R.id.edCode);
        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edAddress = (EditText) findViewById(R.id.edAddress);
        btAdd = (Button) findViewById(R.id.btAdd);
        btDelete = (Button) findViewById(R.id.btDelete);
        btListView = (Button) findViewById(R.id.btList);
        btEdit = (Button) findViewById(R.id.btEdit);

    }

}
