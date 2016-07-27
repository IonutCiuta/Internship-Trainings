package com.endava.patterns.adapter;

/**
 * Created by Andra on 7/21/2016.
 */
public class UsbImpl implements Usb {

    @Override
    public void transferUsb() {
        System.out.print("Usb");
    }
}
