package com.example.gio.eventbusexample;

import android.os.Bundle;
import com.squareup.otto.Bus;

public class BusStation {

    public static Bus bus = new Bus();

    public static Bus getBus() {
        return bus;
    }
}
