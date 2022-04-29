package com.company.lab38;

public class LibAdmin {
    private LibManager libManager;
    private static LibAdmin libAdmin = null;

    private LibAdmin() {}
    public static LibAdmin loginAsAdmin() {
        if (libAdmin == null) {
//            System.out.println("Created singletone admin");
            libAdmin = new LibAdmin();
        }
        return libAdmin;
    }

    public static boolean isSignedIn() { return libAdmin != null; }

    public void setLibManager(LibManager libManager) {
        this.libManager = libManager;
    }

//    public LibManager getLibManager() {
//        return libManager;
//    }

    public void addToBlackList(LibVisitor visitor) {
        libManager.addToBlackList(visitor);
    }
}
