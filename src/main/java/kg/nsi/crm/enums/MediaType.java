package kg.nsi.crm.enums;

public enum MediaType {
    PDF("application/pdf"),
    PNG("image/png"),
    SVG("image/svg");
    private String value;

    MediaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
