package com.endava.patterns.proxy;

public class MyServiceSecurityProxy implements Service {

    Service myService;
    String role;

    public MyServiceSecurityProxy(Service myService, String role) {
        this.myService = myService;
        this.role = role;
    }

    @Override
    public void viewPage() {
        if (checkRole()) {
            myService.viewPage();
        } else {
            System.out.println("ALERT! Security breach!");
        }
    }

    private boolean checkRole() {
        if ("GOOD_GUY".equals(role)) {
            return true;
        } else {
            return false;
        }
    }
}
