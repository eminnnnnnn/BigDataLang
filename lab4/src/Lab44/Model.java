package Lab44;

public class Model extends SiemensMobile {
    private String countryMade;

    public Model(String modelName, String countryMade) {
        super(modelName);
        this.countryMade = new String(countryMade);
    }

    public String getModelInfo() {
        return "Модель: " + getModelName() + "\n" + "Made in " + countryMade;
    }
}
