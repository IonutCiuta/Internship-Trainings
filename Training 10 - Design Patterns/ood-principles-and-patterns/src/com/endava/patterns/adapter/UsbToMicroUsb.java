package com.endava.patterns.adapter;

/**
 * Created by Andra on 7/21/2016.
 */
public class UsbToMicroUsb implements MicroUsb {

    private Usb usb;

    public UsbToMicroUsb(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void transferMicroUsb() {
        usb.transferUsb();
        System.out.println(" ... to microUsb");
    }
}
