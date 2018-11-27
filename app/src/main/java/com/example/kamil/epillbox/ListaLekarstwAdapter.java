package com.example.kamil.epillbox;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListaLekarstwAdapter extends CursorAdapter {

    public ListaLekarstwAdapter(Context context, Cursor cursor, int flag) {
        super(context, cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.lekarstwo,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView lekarstwoTxt= view.findViewById(R.id.lekarstwoTxt);
        String lekNazwa=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2));
        //TODO zrobic dla reszty wartosci tzn ilosc oraz data waznosci
        lekarstwoTxt.setText(lekNazwa);

    }
}
