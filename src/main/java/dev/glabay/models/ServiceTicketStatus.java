package dev.glabay.models;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-24
 */
public enum ServiceTicketStatus {
    PENDING("Pending"),
    OPEN("Open"),
    CLOSED("Closed"),
    IN_PROGRESS("In Progress"),
    ;
    private final String status;

    ServiceTicketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
