package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btnUpdate;
    EditText nis, nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this);
        nis = findViewById(R.id.nis);
        nama = findViewById(R.id.nama);
        btnUpdate = findViewById(R.id.btnUpdate);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM siswa WHERE nama = '"+
                getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0 ){
            cursor.moveToPosition(0);
            nis.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("UPDATE siswa SET nis = '" +
                        nis.getText().toString() + "', nama = '" +
                        nama.getText().toString() + "' WHERE nama = '" +
                        getIntent().getStringExtra("nama") + "'");
                Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}