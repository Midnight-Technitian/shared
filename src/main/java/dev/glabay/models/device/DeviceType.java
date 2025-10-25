package dev.glabay.models.device;

/**
 * @author Glabay | Glabay-Studios
 * @project frontend
 * @social Discord: Glabay
 * @since 2025-10-24
 */
public enum DeviceType {
    DESKTOP(0, "Desktop"),
    LAPTOP(1, "Laptop"),
    TABLET(2, "Tablet"),
    MOBILE(3, "Mobile"),
    SMART_DEVICE(4, "Smart device"),
    SERVER(5, "Server"),
    IOT_DEVICE(6, "IOT device"),
    ;

    private final Integer id;
    private final String name;

    DeviceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
