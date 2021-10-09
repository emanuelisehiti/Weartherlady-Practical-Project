import beans.Root;
import daos.Connection;
import daos.LocationRepository;
import daos.WeatherRepository;
import javassist.bytecode.LineNumberAttribute;
import model.Location;
import model.Weather;
import model.Location;
import org.hibernate.SessionFactory;
import services.ClientService;
import services.WeatherService;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
     /*   WeatherService weatherService = new WeatherService();

        Weather weather = weatherService.getWeather("tirana");
        if(weather.getId() == null) {
            // save weather to database
            weatherService.addWeather(weather);
        }*/

       // SessionFactory sessionFactory = new Connection().getConnection();

    /*    ClientService clientService = new ClientService();
        Root root = clientService.getInformationFromWeather("Berlin");
        System.out.println(root.getWeather());*/

//        WeatherRepository weatherRepository = new WeatherRepository();
//        LocationRepository locationRepository = new LocationRepository();
        //Weather x = (Weather) locationRepository.getLocationByCity("Berlin");
//        weatherRepository.getWeatherByCity("London");

//        Location location = locationRepository.searchLocationByName("Tirana");
//        System.out.println( weatherRepository.getAverageTempByCity(location));
        //List<Location> locationList = locationRepository.getAllLocations();

        //System.out.println(x.getLocation());


      /*  ClientService clientService = new ClientService();
        Root root = clientService.getInformationFromWeather("Tirana");
        System.out.println(root);
*/
//        SessionFactory sessionFactory = new Connection().getConnection();

      /*  ClientService clientService = new ClientService();
        Root root = clientService.getInformationFromWeather("Berlin");
        System.out.println(root.getWeather());*/

       // locationRepository.deleteLocation(loccationObject());



    }
    static LocationRepository locationRepository = new LocationRepository();
    private static Location loccationObject(){
        Location location = new Location("Berlin","Germany",34.45,35.45,"Berlin Region");

        return location;
    }
}
