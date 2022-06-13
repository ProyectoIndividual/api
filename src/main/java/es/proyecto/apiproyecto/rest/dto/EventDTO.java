package es.proyecto.apiproyecto.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDTO {

    private Integer id;

    private LocalitationDTO localitation;


    private UserDTO user = null;

    private String details;
    private Date startTimePlanned;
    private Date endTimePlanned;
    private Date startTimeActual;
    private Date endTimeActual;

    private float price;
    private boolean isPublic;

    private byte[] image;


    public EventDTO() {
    }

    public EventDTO(Integer id, LocalitationDTO localitation, UserDTO user, String details, Date startTimePlanned, Date endTimePlanned, Date startTimeActual, Date endTimeActual, float price, boolean isPublic, byte[] image) {
        this.id = id;
        this.localitation = localitation;
        this.user = user;
        this.details = details;
        this.startTimePlanned = startTimePlanned;
        this.endTimePlanned = endTimePlanned;
        this.startTimeActual = startTimeActual;
        this.endTimeActual = endTimeActual;
        this.price = price;
        this.isPublic = isPublic;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalitationDTO getLocalitation() {
        return localitation;
    }

    public void setLocalitation(LocalitationDTO localitation) {
        this.localitation = localitation;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getStartTimePlanned() {
        return startTimePlanned;
    }

    public void setStartTimePlanned(Date startTimePlanned) {
        this.startTimePlanned = startTimePlanned;
    }

    public Date getEndTimePlanned() {
        return endTimePlanned;
    }

    public void setEndTimePlanned(Date endTimePlanned) {
        this.endTimePlanned = endTimePlanned;
    }

    public Date getStartTimeActual() {
        return startTimeActual;
    }

    public void setStartTimeActual(Date startTimeActual) {
        this.startTimeActual = startTimeActual;
    }

    public Date getEndTimeActual() {
        return endTimeActual;
    }

    public void setEndTimeActual(Date endTimeActual) {
        this.endTimeActual = endTimeActual;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
