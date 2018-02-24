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


public class MainActivity extends AppCompatActivity {
    ListView myListView;
    //creo dos variables estaticas las cuales van a mandar la info al otro activity
    public static final String Item1 = "com.example.danny.labintro.Item1";
    public static final String Item2 = "com.example.danny.labintro.Item2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo y pongo los datos de mi list view
        String[] items = {"Item #1", "Item #2"};
        myListView = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item, android.R.id.text1,items);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //si se presiona alguna de las opciones se va al metodo que carga el otro activity
                openActivity2();
            }
        });}

        public void openActivity2(){
            //cargo el activity 2, mando los items al otro activity
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(Item1, "Item #1");
            intent.putExtra(Item2, "Item #2");
            startActivity(intent);
        }
    }

