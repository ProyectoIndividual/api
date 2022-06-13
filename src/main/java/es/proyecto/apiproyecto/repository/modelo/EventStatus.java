package es.proyecto.apiproyecto.repository.modelo;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="event_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    private Date timeAssigned;
    private boolean end;

    public EventStatus() {
    }

    public EventStatus(Integer id, Event event, Date timeAssigned, boolean end) {
        this.id = id;
        this.event = event;
        this.timeAssigned = timeAssigned;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getTimeAssigned() {
        return timeAssigned;
    }

    public void setTimeAssigned(Date timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
