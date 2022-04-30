package Lab44;

public abstract class SiemensMobile implements Mobile {
    private String modelName;

    public SiemensMobile(String modelName) {
        this.modelName = new String(modelName);
    }

    public String getManufacturerName() {
        return "Siemens";
    }

    public String getOSName() {
        return "Symbian";
    }

    public String getModelName() {
        return modelName;
    }

    public abstract String getModelInfo();
}
