package services;

import beans.Root;
import com.mysql.cj.xdevapi.Client;
import daos.LocationRepository;
import daos.WeatherRepository;
import model.Location;
import model.Weather;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class WeatherService {
    WeatherRepository weatherRepository;
    LocationRepository locationRepository;
    ClientService clientService;

    public WeatherService() {
        this.weatherRepository = new WeatherRepository();
        this.locationRepository = new LocationRepository();
        this.clientService = new ClientService();
    }

    public Weather getWeather(String city) throws IOException {
        Weather weather = weatherRepository.getWeatherByCityNameAndDate(city, new Date());
        if (weather == null || weather.getId() == null) {
            Root response = this.clientService.getInformationFromWeather(city);
            weather = webServiceResponseToModel(response);
            Location location = locationRepository.searchLocationByName(city);
            if(location == null) {
                location = new Location();
                location.setCity(city);
                location.setRegion(city);
                location.setLongitude(response.getCoord().getLon());
                location.setLatitude(response.getCoord().getLat());
                location.setCountryName(response.getSys().getCountry());
            }
            weather.setLocation(location);
        }
        return weather;
    }

    public Weather addWeather(Weather weather) throws IOException {
        weatherRepository.addWeather(weather);
        return weather;
    }

    private Weather webServiceResponseToModel(Root root) {
       Weather weather = new Weather();
        weather.setActualDate(Calendar.getInstance().getTime());
        weather.setDateFrom(Instant.ofEpochSecond(root.getSys().getSunrise()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        weather.setDateTo(Instant.ofEpochSecond(root.getSys().getSunset()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        weather.setDirection(root.getWind().getDeg());
        weather.setHumidity(root.getMain().getHumidity());
        weather.setPressure(root.getMain().getPressure());
        weather.setSpeed(root.getWind().getSpeed());
        weather.setTemperature(root.getMain().getTemp());
        return  weather;
    }
}
