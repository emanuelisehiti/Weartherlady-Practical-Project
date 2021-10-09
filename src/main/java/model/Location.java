package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Location extends BaseModel {

    private String city;
    private String countryName;
    private Double latitude;
    private Double longitude;
    private String Region;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    @Cascade(CascadeType.DELETE)
    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List <Weather> weathers;

    public Location() {
    }

    public Location(String city, String countryName, Double latitude, Double longitude, String region) {
        this.city = city;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.Region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", countryName='" + countryName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", Region='" + Region + '\'' +
                ", weathers=" + weathers +
                '}';
    }
}
