package daos;

import model.Location;
import model.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeatherRepository {

    SessionFactory sf = new Connection().getConnection();

    public Weather getWeatherByCityLocation(String city) {
        Session s = sf.openSession();

        s.beginTransaction();
        Query query = s.createQuery("From Weather where location.city =: city");
        query.setParameter("city", city);
        List<Weather> weatherList = query.list();
        Weather weather = weatherList.get(weatherList.size()-1);
        return weather;
    }

    public void addWeather(Weather weather) throws IOException{
        Session s = sf.openSession();

            try {
                s.beginTransaction();
                s.save(weather);
                s.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                s.close();
            }
    }

    public Weather getWeatherByCityNameAndDate(String city, Date date) {
        Weather weather = new Weather();
        //  query weather where location.city equal to given city and date equal to given date
        Session s = sf.openSession();
       try {
           s.beginTransaction();
           Query query = s.createQuery("From Weather where location.city =: city and actualDate =: date");
           query.setParameter("city",city);
           date = Calendar.getInstance().getTime();
           query.setParameter("date",date);
           weather = (Weather)query.getSingleResult();
           s.getTransaction().commit();
       }catch (Exception e){
           System.out.println(e);
           return null;
       }

        s.close();

        return weather;

    }


    public Double getAverageTempByCity (Location location){

        Session s = sf.openSession();
        Double avgTemp = 0.0;

        try {
            s.beginTransaction();
            Query query = s.createQuery("select avg(temperature) from Weather  where location=: location ");
            query.setParameter("location",location );
            avgTemp = (Double) query.getSingleResult();


        } catch (Exception e) {
            System.out.println(e);
        }finally {
            s.close();
        }

        return avgTemp;
    }



}

