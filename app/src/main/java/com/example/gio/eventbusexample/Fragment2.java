package com.example.gio.eventbusexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import org.w3c.dom.Text;


public class Fragment2 extends Fragment {
    TextView textView;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment2, container, false);
        textView = (TextView)v.findViewById(R.id.textView2);

        return v;
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
        textView.setText(message.getMessage());
    }
}
