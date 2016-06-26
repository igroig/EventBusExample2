package com.example.gio.eventbusexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        textViewA = (TextView) findViewById(R.id.textViewA);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusStation.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusStation.getBus().unregister(this);
    }

    @Subscribe
    public void resieveMessage(Message message){
        textViewA.setText(message.getMessage());
    }
}
