package es.proyecto.apiproyecto.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name="invitacion")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event = null;

    private float invoiceAmount;
    private float discounet;
    private float totalAmount;
    private boolean accept;

    public Invitation() {
    }

    public Invitation(Integer id, User user, Event event, float invoiceAmount, float discounet, float totalAmount, boolean accept) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
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
