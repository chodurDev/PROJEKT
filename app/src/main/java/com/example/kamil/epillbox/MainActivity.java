package com.example.kamil.epillbox;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    private Button button;
    private ListaLekarstwAdapter listaLekarstwAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AktywnoscDodajLek(v);

            }
        });



        dbHelper =  new DatabaseHelper(this);
        ListView lvLekarstwa=findViewById(R.id.listView);
        Cursor cursor = dbHelper.getAllData();
        if(cursor!=null){
            listaLekarstwAdapter=new ListaLekarstwAdapter(getApplicationContext(),cursor,0);
            lvLekarstwa.setAdapter(listaLekarstwAdapter);
        }

        Intent listaLekarstw = new Intent(MainActivity.this,ListaLekarstwAdapter.class);
        startActivity(listaLekarstw);
    }
    public void AktywnoscDodajLek(View view){
        Intent intent = new Intent(this,Drug_options.class);
        startActivity(intent);

    }
}
