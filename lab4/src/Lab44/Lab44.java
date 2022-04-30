package Lab44;

public class Lab44 {

    public static void printModelInfo(Mobile mobile) {
        System.out.println("Производитель: " + mobile.getManufacturerName());
        System.out.println("Операционная система: " + mobile.getOSName());
        System.out.println(((SiemensMobile)mobile).getModelInfo());
    }
    public static void lab4_4() {
        Model siemens4510 = new Model("4510", "China");
        printModelInfo(siemens4510);
    }
}
