package com.endava.patterns.adapter;

/**
 * Created by Andra on 7/21/2016.
 */
public class AdapterDemo {

    public static void main(String[] args) {
        Usb usb = new UsbImpl();

        Hdmi hdmi = new UsbToHdmi(usb);
        hdmi.transferHdmi();

        MicroUsb microUsb = new UsbToMicroUsb(usb);
        microUsb.transferMicroUsb();

    }

}
