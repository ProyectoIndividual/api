package es.proyecto.apiproyecto.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventStatusDTO {

    private Integer id;

    private EventDTO event;
    private Date timeAssigned;
    private boolean end;


    public EventStatusDTO() {
    }

    public EventStatusDTO(Integer id, EventDTO event, Date timeAssigned, boolean end) {
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

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
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
