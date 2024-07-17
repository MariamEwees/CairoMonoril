package cairomonorail;
import java.util.ArrayList;
import java.util.Scanner;
public class Station implements Information {
    
    private static Scanner input = new Scanner(System.in);
    private static int idCounter = 1;
    private int id;
    private String name;
    private ArrayList<Route> routes = new ArrayList<>();

    public void fillInformation() {
        System.out.println("Enter the name of the station: ");
        setName(input.next());
    }

    public void addRoute(Route route) {
        if(routes.indexOf(route)==-1)
            routes.add(route);
    }

    public void removeRoute(Route route) {
        routes.remove(route);
    }
    
    public Station() {
        id = idCounter++;
        Database.add(this);
    }
    
    public Station(String name) {
        this.name = name;
        id = idCounter++;
        Database.add(this);
    }

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getTrainsRT(Route route) {
        ArrayList<String> trainsRunningTimes = new ArrayList<>();
        int stIndx=route.getStations().indexOf(this);
        ArrayList<Train> trainsByRoute=route.getTrains();
        for (Train train : trainsByRoute) {
            trainsRunningTimes.add(train.getStationsRunningTimes().get(stIndx));
        }
        return trainsRunningTimes;
    }
    @Override
    public String toString() {
        return "Station [id=" + id + ", name=" + name + "]\n";
    }
}
