package es.proyecto.apiproyecto.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvitationDTO {

    private Integer id;

    private UserDTO user = null;

    private EventDTO event = null;

    private float invoiceAmount;
    private float discounet;
    private float totalAmount;
    private boolean accept;


    public InvitationDTO() {
    }

    public InvitationDTO(Integer id, UserDTO user, EventDTO event, float invoiceAmount, float discounet, float totalAmount, boolean accept) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.invoiceAmount = invoiceAmount;
        this.discounet = discounet;
        this.totalAmount = totalAmount;
        this.accept = accept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public float getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(float invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public float getDiscounet() {
        return discounet;
    }

    public void setDiscounet(float discounet) {
        this.discounet = discounet;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
