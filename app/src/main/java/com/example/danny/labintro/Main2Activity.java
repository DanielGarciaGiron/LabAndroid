package com.example.danny.labintro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//Daniel Garcia 14152
//Laboratorio introduccion a android

//en este hago lo mismo que el activity 1, solo que los items del list view los copio del main activity
public class Main2Activity extends AppCompatActivity {
    ListView myListView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        //guardo los valores que mande del main activity en variables locales para usarlas en el list view
        String text1 = intent.getStringExtra(MainActivity.Item1);
        String text2 = intent.getStringExtra(MainActivity.Item2);

        String[] items2 = {text1, text2};
        myListView2 = (ListView) findViewById(R.id.myListView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item, android.R.id.text1,items2);
        myListView2.setAdapter(adapter);
        myListView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivity();
            }
        });}

    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

