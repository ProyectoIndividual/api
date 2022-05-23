package es.proyecto.apiproyecto.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private String surnames;
    private String description;
    private String email;
    private String phone;

    @Lob
    @Column(name="image")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;

    private String password;
    private Date registrationDate;
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localitation_id")
    private Localitation localitation;

    @OneToMany(mappedBy = "user")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Invitation> invitations= new ArrayList<>();

    public User() {
    }

    public User(Integer id, String name, String surnames, String description, String email, String phone, byte[] image, String password, Date registrationDate, String token, Localitation localitation, List<Event> events, List<Invitation> invitations) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.password = password;
        this.registrationDate = registrationDate;
        this.token = token;
        this.localitation = localitation;
        this.events = events;
        this.invitations = invitations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Localitation getLocalitation() {
        return localitation;
    }

    public void setLocalitation(Localitation localitation) {
        this.localitation = localitation;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }
}
