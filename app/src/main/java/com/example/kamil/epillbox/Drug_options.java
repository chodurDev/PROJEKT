package com.example.kamil.epillbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Drug_options extends AppCompatActivity {
    EditText nazwa_leku;
    EditText ilosc;
    EditText data_waznosci;
    Button button_dodaj_do_bazy;

    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_options);

        dbHelper =  new DatabaseHelper(this);


        nazwa_leku=findViewById(R.id.editNazwaLeku);
        ilosc=findViewById(R.id.editIlosc);
        data_waznosci=findViewById(R.id.editDataWaznosci);
        button_dodaj_do_bazy=findViewById(R.id.button_dodaj_do_bazy);
        DodajDoBazy();

    }
    public void DodajDoBazy(){
        button_dodaj_do_bazy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dbHelper.insertData(nazwa_leku.getText().toString(),ilosc.getText().toString(),data_waznosci.getText().toString());
            if(isInserted==true)
                Toast.makeText(Drug_options.this,"Data inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Drug_options.this,"Data not inserted",Toast.LENGTH_LONG).show();

            }
        });
    }
}
