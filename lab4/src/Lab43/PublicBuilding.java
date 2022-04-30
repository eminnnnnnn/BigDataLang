package Lab43;

public abstract class PublicBuilding implements Building {
    private String address;
    private String type;

    public PublicBuilding(String address) {
        this.type = "Social Building";
        this.address = new String(address);
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public abstract String getName();
}
