package com.endava.patterns.proxy;

public class ApplicationFramework {
    static Service applicationSecurity;

    static void viewPage() {
        applicationSecurity.viewPage();
    }

    static void login(String role) {
        applicationSecurity = new MyServiceSecurityProxy(new MyService(), role);
    }
}