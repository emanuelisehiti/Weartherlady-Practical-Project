package model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Weather extends BaseModel {
    @Temporal(TemporalType.DATE)
    private Date actualDate;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private Integer direction;
    private Integer humidity;
    private Integer pressure;
    private Double speed;
    private Double temperature;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    public Weather(Date actualDate,
                   LocalDateTime dateFrom,
                   LocalDateTime dateTo,
                   Integer direction,
                   Integer humidity,
                   Integer pressure,
                   Double speed,
                   Double temperature,
                   Location location) {
        this.actualDate = actualDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.direction = direction;
        this.humidity = humidity;
        this.pressure = pressure;
        this.speed = speed;
        this.temperature = temperature;
        this.location = location;
    }

    public Weather() {

    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "actualDate=" + actualDate +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", direction=" + direction +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", speed=" + speed +
                ", temperature=" + temperature +
                '}';
    }
}
