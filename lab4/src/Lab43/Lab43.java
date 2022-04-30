package Lab43;

public class Lab43 {
    public static void printBuildingInfo(Building building) {
        System.out.print(building.getType() + " " + building.getAddress() + " ");
        System.out.println(((PublicBuilding)building).getName());
    }

    public static void lab4_3() {
        TheatreBuilding theatre = new TheatreBuilding("Театр", "ул. Бауманская, 5");
        printBuildingInfo(theatre);
    }
}
