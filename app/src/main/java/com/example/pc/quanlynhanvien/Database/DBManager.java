package com.example.pc.quanlynhanvien.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 4/18/2018.
 */

public class DBManager extends SQLiteOpenHelper {

    private final String TAG="DBManager";
    private static final String DATABASE_NAME="NHANVIEN_MANAGER";
    private static final String TABLE_NAME="nhanvien";
    private static final String ID="id";
    private static final String CODE="code";
    private static final String NAME="name";
    private static final String EMAIL="email";
    private static final String PHONE="phone";
    private static final String ADDRESS="address";
    private static int VERSION=1;

    private Context context;
    private String SQLQuery = "CREATE TABLE "+TABLE_NAME+" ("+ID +" integer primary key, "
            +CODE + " TEXT, "
            +NAME + " TEXT, "
            +EMAIL + " TEXT, "
            +PHONE + " TEXT, "
            +ADDRESS+" TEXT)";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        Log.d(TAG,"onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpgrade: ");
    }
    public void addNhanVien(NhanVien nv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CODE,nv.getCode());
        values.put(NAME,nv.getName());
        values.put(EMAIL,nv.getEmail());
        values.put(PHONE,nv.getPhone());
        values.put(ADDRESS,nv.getAddress());
        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"Add Employees Successfuly: ");

    }
    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> listNV = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
                NhanVien nv = new NhanVien();
                nv.setId(cursor.getInt(0));
                nv.setCode(cursor.getString(1));
                nv.setName(cursor.getString(2));
                nv.setEmail(cursor.getString(3));
                nv.setPhone(cursor.getString(4));
                nv.setAddress(cursor.getString(5));
                listNV.add(nv);

            }while (cursor.moveToNext());
        }
        db.close();
        return listNV;

    }
    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID + "=?",new String[]{String.valueOf(id)});
    }
}
