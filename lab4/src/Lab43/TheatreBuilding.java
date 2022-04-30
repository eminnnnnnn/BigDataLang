package Lab43;

public class TheatreBuilding extends PublicBuilding {
    private String name;

    public TheatreBuilding(String name, String address) {
        super(address);
        this.name = new String(name);
    }

    public String getName() {
        return name;
    }
}
