package cairomonorail;
import java.io.*;
import java.util.*;
public abstract class Database {
    private static ArrayList<Person> peopleDBList=new ArrayList<>();
    private static ArrayList<Train> trainDBList=new ArrayList<>();
    private static ArrayList<Route> routesDBList=new ArrayList<>();
    private static ArrayList<Station> stationsDBList = new ArrayList<>();
    private static ArrayList<Ticket> ticketsDBList = new ArrayList<>();
    private static Admin admin=new Admin("","","","admin@admin.com","admin","0000");
    public static void add(Object obj) {
        if (obj instanceof Passenger) {
            peopleDBList.add((Passenger) obj);
        } else if (obj instanceof Admin) {
            peopleDBList.add((Admin) obj);
        } else if (obj instanceof Train) {
            trainDBList.add((Train) obj);
        } else if (obj instanceof Route) {
            routesDBList.add((Route) obj);
        } else if (obj instanceof Station) {
            stationsDBList.add((Station) obj);
        } else if (obj instanceof Ticket) {
            ticketsDBList.add((Ticket) obj);
        }
    }

    public static void remove(Object obj) {
        if (obj instanceof Passenger) {
            peopleDBList.remove((Passenger) obj);
        } else if (obj instanceof Admin) {
            peopleDBList.remove((Admin) obj);
        } else if (obj instanceof Train) {
            trainDBList.remove((Train) obj);
        } else if (obj instanceof Route) {
            routesDBList.remove((Route) obj);
        } else if (obj instanceof Station) {
            stationsDBList.remove((Station) obj);
        } else if (obj instanceof Ticket) {
            ticketsDBList.remove((Ticket) obj);
        }
    }

    public static Person getPersonByEmail(String email) {
        for (Person person : peopleDBList) {
            if (person == null || person.getEmail() == null)
                continue;
            if (person.getEmail().equals(email))
                return person;
        }
        return null;
    }

    public static boolean isExistingEmail(String email) {
        return getPersonByEmail(email) != null;
    }

    public static Person getPersonByUsername(String username) {
        for (Person person : peopleDBList) {
            if (person == null || person.getUsername() == null)
                continue;
            if (person.getUsername().equals(username))
                return person;
        }
        return null;
    }

    public static boolean isExistingUsername(String username) {
        return (getPersonByUsername(username) != null);
    }

    public static Person getPersonById(int id) {
        for (Person person : peopleDBList) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }

    public static Train getTrainById(int id) {
        for (Train train : trainDBList) {
            if (train.getId() == id)
                return train;
        }
        return null;
    }

    public static Route getRouteById(int id) {
        for (Route route : routesDBList) {
            if (route.getId() == id)
                return route;
        }
        return null;
    }

    public static Station getStationById(int id) {
        for (Station station : stationsDBList) {
            if (station.getId() == id)
                return station;
        }
        return null;
    }

    public static Ticket getTicketById(int id) {
        for (Ticket ticket : ticketsDBList) {
            if (ticket.getId() == id)
                return ticket;
        }
        return null;
    }

    public static ArrayList<Person> getPeopleDBList() {
        return peopleDBList;
    }

    public static ArrayList<Passenger> getPassengersDBList() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for (Person person : peopleDBList) {
            if (person instanceof Passenger) {
                passengers.add((Passenger) person);
            }
        }
        return passengers;
    }
    public static ArrayList<Admin> getAdminsDBList() {
        ArrayList<Admin> admins = new ArrayList<>();
        for (Person person : peopleDBList) {
            if (person instanceof Admin) {
                admins.add((Admin) person);
            }
        }
        return admins;
    }
    
    public static void setPeopleDBList(ArrayList<Person> peopleDBList) {
        Database.peopleDBList = peopleDBList;
    }

    public static ArrayList<Train> getTrainDBList() {
        return trainDBList;
    }

    public static void setTrainDBList(ArrayList<Train> trainDBList) {
        Database.trainDBList = trainDBList;
    }

    public static ArrayList<Route> getRoutesDBList() {
        return routesDBList;
    }

    public static void setRoutesDBList(ArrayList<Route> routesDBList) {
        Database.routesDBList = routesDBList;
    }

    public static ArrayList<Station> getStationsDBList() {
        return stationsDBList;
    }

    public static void setStationsDBList(ArrayList<Station> stationsDBList) {
        Database.stationsDBList = stationsDBList;
    }

    public static ArrayList<Ticket> getTicketsDBList() {
        return ticketsDBList;
    }

    public static void setTicketsDBList(ArrayList<Ticket> ticketsDBList) {
        Database.ticketsDBList = ticketsDBList;
    }
    public static void readPeopleDBList(){
        //this function should read the file people.txt and to fill the peopleDBList;
        try{
            FileInputStream fis=new FileInputStream("people.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            peopleDBList=(ArrayList<Person>)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public static void writePeopleDBList(){
        //this function should write the peopleDBList to file people.txt
        //also should take care of object serialization
        try{
            FileOutputStream fos=new FileOutputStream("people.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(peopleDBList);
            oos.close();
            fos.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void readTrainsDBList(){
        //this function should read the file trains.txt to fill the trainDBList
        try{
            FileInputStream ftr=new FileInputStream("train.txt");
            ObjectInputStream trt=new ObjectInputStream(ftr);
            trainDBList=(ArrayList<Train>)trt.readObject();
            trt.close();
            ftr.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void writeTrainsDBList(){
        //this function should write the trainsDBList to file trains.txt
        //also should take care of object serialization
        try{
            FileOutputStream fot=new FileOutputStream("train.txt");
            ObjectOutputStream tos=new ObjectOutputStream(fot);
            tos.writeObject(trainDBList);
            tos.close();
            fot.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void readRoutesDBList(){
        //this function should read the file routes.txt and to fill the routesDBList
    }
    public static void writeRoutesDBList(){
        //this function should write the routesDBList to file routes.txt
        //also should take care of object serialization
    }
    public static void readStationsDBList(){
        //this function should read the file stations.txt and to fill the stationsDBList
    }
    public static void writeStationsDBList(){
        //this function should write the stationsDBList to file stations.txt
        //also should take care of object serialization
    }
    public static void readTicketsDBList(){
        //this function should read the file tickets.txt and to fill the ticketsDBList
    }
    public static void writeTicketsDBList(){
        //this function should write the ticketsDBList to file tickets.txt
        //also should take care of object serialization
    }
    public static void readAllDatabase(){
        //this function should call all the read functions for all the DBList
    }
    public static void writeAllDatabase(){
        //this function should call all the write functions for all the DBList txt files
    }
}
