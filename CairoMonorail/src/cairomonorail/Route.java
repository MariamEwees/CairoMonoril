package cairomonorail;
import java.util.ArrayList;
import java.util.Scanner;

public class Route implements Information {
    private static int idCounter=1;
    private int id;
    private double ticketFair;
    private Station originStation;
    private Station destStation;
    ArrayList<Station> stations = new ArrayList<>();
    ArrayList<Float> stationsDistances = new ArrayList<>();
    ArrayList<Train> trains = new ArrayList<>();
    private static Scanner input=new Scanner(System.in);
    Route() {
        this.id = idCounter++;
        Database.add(this);
    }
    Route(Station originStation, Station destStation) {
        this.originStation = originStation;
        this.destStation = destStation;
        stations.add(originStation);
        stations.add(destStation);
        addRouteToStation();
        id = idCounter++;
        Database.add(this);
    }

    Route(Station originStation, Station destStation, double ticketFair) {
        this.originStation = originStation;
        this.destStation = destStation;
        this.ticketFair = ticketFair;
        stations.add(originStation);
        stations.add(destStation);
        addRouteToStation();
        id = idCounter++;
        Database.add(this);
    }

    public void fillInformation() {
        System.out.println("Choose the origin destination: ");
        System.out.println(Database.getStationsDBList());
        System.out.println("Enter the id of the station: ");
        setOriginStation(Database.getStationById(input.nextInt()));
        while (originStation == null) {
            System.out.println("Enter a valid station: ");
            setOriginStation(Database.getStationById(input.nextInt()));
        }
        System.out.println("Choose the final destination: ");
        System.out.println("Enter the id of the station: ");
        setDestStation(Database.getStationById(input.nextInt()));
        while (destStation == null) {
            System.out.println("Enter a valid station: ");
            setDestStation(Database.getStationById(input.nextInt()));
        }
        System.out.print("Enter the number of Stations you want to add to this route: ");
        int stnum = input.nextInt();
        for (int i = 0; i < stnum; i++) {
            System.out.println("Enter the id of the station: ");
            Station tempStation = Database.getStationById(input.nextInt());
            while (tempStation == null) {
                System.out.println("Enter a valid station: ");
                tempStation = Database.getStationById(input.nextInt());
            }
            stations.add(tempStation);
        }
        addRouteToStation();
        System.out.println("Enter the distance between ");
        for (int i = 0; i < stations.size() - 1; i++) {
            System.out.println("Distance in KM between: ");
            System.out.print(stations.get(i) + "And\n" + stations.get(i + 1));
            stationsDistances.add(input.nextFloat());
        }
        System.out.print("Enter the number of trains you want to add to this route: ");
        int trnum = input.nextInt();
        for (int i = 0; i < trnum; i++) {
            System.out.println("Enter the id of the traim: ");
            Train tempTrain = Database.getTrainById(input.nextInt());
            while (tempTrain== null) {
                System.out.println("Enter a valid station: ");
                tempTrain = Database.getTrainById(input.nextInt());
            }
            trains.add(tempTrain);
        }
    }
    public int getNoPassenger(){
        int noPass=0;
        for(Train train:trains){
            noPass+=train.getNoPassenger();
        }
        return noPass;
    }

    public double getTotalFair() {
        double total = 0;
        for (Train train : trains) {
            total += train.getTotalFair();
        }
        return total;
    }

    public void addRouteToStation() {
        for (Station station : stations) {
            station.addRoute(this);
        }
    }
    public void addStation(Station station) {
        if (station != originStation && station != destStation && stations.indexOf(station)==-1) {
            stations.add(station);
        }
    }

    public void addTrain(Train train) {
        if (trains.indexOf(train) == -1) {
            trains.add(train);
        }
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }

    public void removeTrain(Train train) {
        trains.remove(train);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTicketFair() {
        return ticketFair;
    }

    public void setTicketFair(double ticketFair) {
        this.ticketFair = ticketFair;
    }

    public Station getOriginStation() {
        return originStation;
    }

    public void setOriginStation(Station originStation) {
        this.originStation = originStation;
    }

    public Station getDestStation() {
        return destStation;
    }

    public void setDestStation(Station destStation) {
        this.destStation = destStation;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "Route [id="+id+", destStation=" + destStation.getName() + ", originStation=" + originStation.getName() + ", ticketFair="
                + ticketFair + "]\n";
    }
    
}
