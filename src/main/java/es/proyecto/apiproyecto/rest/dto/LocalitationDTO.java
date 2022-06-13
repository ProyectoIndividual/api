package es.proyecto.apiproyecto.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocalitationDTO {

    private Integer id;

    private String postalCode;
    private String cityName;
    private String country;
    private String street;


    public LocalitationDTO() {
    }

    public LocalitationDTO(Integer id, String postalCode, String cityName, String country, String street) {
        this.id = id;
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.country = country;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
