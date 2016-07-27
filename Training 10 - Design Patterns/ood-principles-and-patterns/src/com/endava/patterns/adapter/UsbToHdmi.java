package com.endava.patterns.adapter;

/**
 * Created by Andra on 7/21/2016.
 */
public class UsbToHdmi implements Hdmi {

    private Usb usb;

    public UsbToHdmi(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void transferHdmi() {
        usb.transferUsb();
        System.out.println("... to hdmi");
    }
}
