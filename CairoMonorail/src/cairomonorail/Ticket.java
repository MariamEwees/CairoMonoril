package cairomonorail;
import java.util.*;
public class Ticket implements Information{
    private static Scanner input=new Scanner(System.in);
    private static int idCounter = 0;
    private int id;
    private String travelDate;
    private String departTime;
    private Passenger passenger;
    private Route route;
    private Train train;
    private Seat seat;
    private Station departStation;

    public Ticket() {
        id = ++idCounter;
        Database.add(this);
    }
    
    public Ticket(Passenger passenger, Train train, Seat seat) {
        this.passenger = passenger;
        this.train = train;
        this.seat = seat;
        id = ++idCounter;
        this.seat.setTicket(this);
        Database.add(this);
    }
    
    public Ticket(String travelDate, Passenger passenger, Train train, Seat seat) {
        this.travelDate = travelDate;
        this.passenger = passenger;
        this.train = train;
        this.seat = seat;
        id = ++idCounter;
        this.seat.setTicket(this);
        Database.add(this);
    }

    public Ticket(String travelDate, String departTime, Passenger passenger, Route route, Train train, Seat seat, Station departStation) {
        this.travelDate = travelDate;
        this.departTime = departTime;
        this.passenger = passenger;
        this.route = route;
        this.train = train;
        this.seat = seat;
        this.departStation = departStation;
    }
    
    public void fillInformation() {
        System.out.println("Enter travel Date: ");
        setTravelDate(input.next());
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the route ID: ");
        setRoute(Database.getRouteById(input.nextInt()));
        while (getRoute() == null) {
            System.out.println("Please enter a valid route ID: ");
            setRoute(Database.getRouteById(input.nextInt()));
        }
        //printing all the trains in the choosen route with the choosen time slot to select from
        for(int i=0;i<route.getStations().size();i++){
            System.out.printf("%d. %s%n",i+1,route.getStations().get(i));
        }
        System.out.println("Enter the number of the station you want to depart from: ");
        int stnum = input.nextInt();
        while (stnum < 0 || stnum >= route.getStations().size()) {
            System.out.println("Enter a valid station number: ");
            stnum = input.nextInt();
        }
        setDepartStation(route.getStations().get(stnum));
        ArrayList<String> runningTimes = departStation.getTrainsRT(route);
        for (int i = 0; i < runningTimes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, runningTimes.get(i));
        }
        System.out.println("Enter the number of depart time you want: ");
        int dnum = input.nextInt();
        while (dnum < 0 || dnum >= runningTimes.size()) {
            System.out.println("Enter a valid depart time number");
            dnum = input.nextInt();
        }
        setTrain(route.getTrains().get(dnum));
        //printing all the available seats in the chosen train to choose from.
        System.out.println(getTrain().getAvailableSeats());
        System.out.println("Enter the id of the seat you want to set in: ");
        setSeat(getTrain().getSeatById(input.nextInt()));
        while (getSeat() == null || !getSeat().isAvailable()) {
            System.out.println("Please enter a valid seat id number: ");
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTravelDate() {
        return travelDate;
    }
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public double getPrice() {
        double price = route.getTicketFair();
        price += price * seat.getDegreeClass().getValue();
        return price;
    }
    
    public Station getDepartStation() {
        return departStation;
    }

    public void setDepartStation(Station departStation) {
        this.departStation = departStation;
    }
    
    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    @Override
    public String toString() {
        return "[ID: "+id+"Travel Date: "+travelDate + "Passenger: " + passenger + "Train" + train
                + "Seat: " + seat + "Price: " + getPrice() + "]\n";
    }
}
