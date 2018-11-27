package com.example.kamil.epillbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static final int DB_VERSION =1;
    public static final String DB_NAME="BazaLekarstw.db";
    public static final String TABLE_NAME="lekarstwa";
    public static final String COL_1 = "ID";
    public static final String COL_2="NAZWA_LEKU";
    public static final String COL_3="ILOSC_W_OPAKOWANIU";
    public static final String COL_4="DATA_WAZNOSCI";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME
                +" ("
                +COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_2+" TEXT NOT NULL, "
                +COL_3+" TEXT NOT NULL , "
                +COL_4+" TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nazwa_leku, String ilosc, String data_waznosci){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nazwa_leku);
        contentValues.put(COL_3,ilosc);
        contentValues.put(COL_4,data_waznosci);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
            return false;
        else
            return true;

    }
//TODO ZROBIC POBIERANIE DANYCH DO LISTY
    public Cursor getAllData(){
        String[] columns={COL_2,COL_3,COL_4};
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }


}
