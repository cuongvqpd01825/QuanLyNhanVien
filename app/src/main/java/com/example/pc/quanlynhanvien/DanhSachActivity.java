package com.example.pc.quanlynhanvien;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.quanlynhanvien.Database.CustomAdapter;
import com.example.pc.quanlynhanvien.Database.DBManager;
import com.example.pc.quanlynhanvien.Database.NhanVien;

import java.util.List;

public class DanhSachActivity extends AppCompatActivity {
    private ListView lvList;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<NhanVien> nvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        lvList = (ListView) findViewById(R.id.lvList);
        dbManager = new DBManager(this);
        nvList = dbManager.getAllNhanVien();
        setAdapter();
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nvList.get(i);
                final int result = dbManager.deleteStudent(nv.getId());
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DanhSachActivity.this);
                alertDialog.setTitle("Xóa");
                alertDialog.setMessage("Bạn có muốn xóa không?");
                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (result >= 0) {
                            Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            updateListNV();
                            nvList.clear();
                            nvList.addAll(dbManager.getAllNhanVien());
                            customAdapter.notifyDataSetChanged();
                        }
                    }
                });
                alertDialog.setNeutralButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Đã hủy xóa", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                alertDialog.show();
                return;
            }
        });
    }
    public void updateListNV(){
        nvList.clear();
        nvList.addAll(dbManager.getAllNhanVien());
        customAdapter.notifyDataSetChanged();
    }
    private void setAdapter(){
        if (customAdapter== null){
            customAdapter = new CustomAdapter(this,R.layout.item_list_nv, nvList);
            lvList.setAdapter(customAdapter);
        }else {
            customAdapter.notifyDataSetChanged();
        }
    }
}
