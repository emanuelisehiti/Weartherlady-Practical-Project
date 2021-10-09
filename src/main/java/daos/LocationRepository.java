package daos;

import beans.Root;
import model.Location;

import model.Weather;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import services.ClientService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class LocationRepository {

    SessionFactory sf = new Connection().getConnection();


    public void addLocation(Location location) {
        Session s = sf.openSession();
        try {
            s.beginTransaction();
            s.save(location);
            s.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            s.close();
        }
    }

    public List<Location> getAllLocations (){
         try (Session s = sf.openSession()) {
             s.beginTransaction();
             Query query = s.createQuery("FROM Location");
             List<Location> locations = query.list();
             if (locations.size() > 0) {
                 return locations;
             }
         } catch (Exception e) {
             System.out.println(e);
         }
         return null;
     }

    public void updateLocation(Location location) {
        try (Session s = sf.openSession()) {
            s.beginTransaction();
            s.update(location);
            s.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     public void deleteLocation (Location location){
        Session s = sf.openSession();
            try{
                s.beginTransaction();
                s.delete(location);
                s.getTransaction().commit();
            }catch (Exception e){
                System.out.println(e);
            }finally {
                s.close();
            }
    }

    public Location searchLocationByName(String cityName){
        Session s = sf.openSession();
        Location location = new Location();
        try  {
            Query query = s.createQuery("From Location where city=:city");
            query.setParameter("city", cityName);
             location = (Location) query.getSingleResult();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }finally {
            s.close();
        }
        return location;
    }



}
