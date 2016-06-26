package com.example.gio.eventbusexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager ;
    EditText editText;
    Button senMdg;
    Button senToA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fr1, new Fragment1(), "f1").add(R.id.fr2, new Fragment2()).commit();

        editText = (EditText)findViewById(R.id.editText);
        senMdg = (Button)findViewById(R.id.button);

        senToA = (Button)findViewById(R.id.buttonActivity);

        senMdg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 BusStation.getBus().post(new Message(editText.getText().toString()));
            }
        });

        senToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusStation.getBus().post(new Message(editText.getText().toString()));
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
