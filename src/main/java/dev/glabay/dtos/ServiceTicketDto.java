package dev.glabay.dtos;

import dev.glabay.models.ServiceNote;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-24
 */
public final class ServiceTicketDto {
    private String ticketId;
    private String status;
    private String title;
    private String description;
    private String customerId;
    private String customerDeviceId;
    private String employeeId;
    private String serviceId;
    private List<ServiceNote> notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDeviceId() {
        return customerDeviceId;
    }

    public void setCustomerDeviceId(String customerDeviceId) {
        this.customerDeviceId = customerDeviceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<ServiceNote> getNotes() {
        return notes;
    }

    public void setNotes(List<ServiceNote> notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ServiceTicketDto{" +
            "ticketId='" + ticketId + '\'' +
            ", status='" + status + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", customerId='" + customerId + '\'' +
            ", customerDeviceId='" + customerDeviceId + '\'' +
            ", employeeId='" + employeeId + '\'' +
            ", serviceId='" + serviceId + '\'' +
            ", notes=" + notes +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}