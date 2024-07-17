package cairomonorail;
import java.util.*;
public class Train implements Information{
    private static Scanner input=new Scanner(System.in);
    private static int idCounter = 1;
    //(optional)we can add a ticket member arrayList or we can retrieve the tickets from the arrayList of seats
    private int id;
    private Route route;
    private int firstClassSeats, businessSeats, economySeats;
    private ArrayList<Seat> seats = new ArrayList<>();
    private ArrayList<String> stationsRunningTimes = new ArrayList<>();

    public Train() {
        id = idCounter++;
        Database.add(this);
    }
    
    public Train(Route route) {
        id = idCounter++;
        Database.add(this);
        this.route = route;
        this.route.addTrain(this);
    }
    public Train(Route route, int firstClassSeats, int businessSeats, int economySeats) {
        id = idCounter++;
        Database.add(this);
        this.route = route;
        this.firstClassSeats = firstClassSeats;
        this.businessSeats = businessSeats;
        this.economySeats = economySeats;
        createSeats();
        this.route.addTrain(this);
    }

    private void createSeats() {
        for (int i = 0; i < firstClassSeats; i++) {
            seats.add(new Seat(DegreeClassEnum.FirstClass));
        }
        for (int i = 0; i < businessSeats; i++) {
            seats.add(new Seat(DegreeClassEnum.Business));
        }
        for (int i = 0; i < economySeats; i++) {
            seats.add(new Seat(DegreeClassEnum.Economy));
        }
    }

    public void fillInformation() {
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the ID of the route: ");
        setRoute(Database.getRouteById(input.nextInt()));
        while (getRoute() == null) {
            System.out.println("Enter a valid route id: ");
            setRoute(Database.getRouteById(input.nextInt()));
        }
        System.out.println("Enter the running times at each station");
        for (Station station : route.getStations()) {
            System.out.println("Enter departure time from station: HH:MM ");
            System.out.print(station);
            stationsRunningTimes.add(input.next());
        }
        System.out.println("Enter the number of First Class Seats: ");
        setFirstClassSeats(input.nextInt());
        System.out.println("Enter the number of Business Class Seats: ");
        setBusinessSeats(input.nextInt());
        System.out.println("Enter the number of Economy Class Seats: ");
        setEconomySeats(input.nextInt());
        createSeats();
    }
    
    public ArrayList<Seat> getAvailableSeats(){
        //this function should return an arraylist of all available seats
        //(optional) we can make it to display all the available seats directly
        ArrayList<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
    public ArrayList<Seat> getBookedSeats(){
        //this function should return an arrayList of all booked seats
        ArrayList<Seat> bookedSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isAvailable()) {
                bookedSeats.add(seat);
            }
        }
        return bookedSeats;
    }
    
    public ArrayList<Ticket> getBookedTickets(){
        //this function should return an arrayList of all the booked tickets on the train
        //(optional) we can make it to display all the booked tickets directly or make another function for that
        ArrayList<Ticket> bookedTickets = new ArrayList<>();
        ArrayList<Seat> bookedSeats = getBookedSeats();
        for (Seat seat : bookedSeats) {
            bookedTickets.add(seat.getTicket());
        }
        return bookedTickets;
    }

    public ArrayList<Passenger> getBoardedPassengers() {
        //this function should return an arrayList of all the passengers on board
        ArrayList<Passenger> boardedPassengers = new ArrayList<>();
        ArrayList<Ticket> bookedTicket = getBookedTickets();
        for (Ticket ticket : bookedTicket) {
            boardedPassengers.add(ticket.getPassenger());
        }
        return boardedPassengers;
    }
    public String getStationRunningTime(Station station){
        return stationsRunningTimes.get(route.getStations().indexOf(station));
    }
    public int getNoPassenger() {
        int pass;
        ArrayList<Seat> bookedSeats = getBookedSeats();
        pass = bookedSeats.size();
        return pass;
    }

    public double getTotalFair() {
        double totalFair = 0;
        ArrayList<Ticket> bookedTickets = getBookedTickets();
        for (Ticket ticket : bookedTickets) {
            totalFair += ticket.getPrice();
        }
        return totalFair;
    }

    public Seat getSeatById(int id) {
        for (Seat seat : seats) {
            if (seat.getId() == id)
                return seat;
        }
        return null;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Train.idCounter = idCounter;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(int firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    
    public ArrayList<String> getStationsRunningTimes() {
        return stationsRunningTimes;
    }

    public void setStationsRunningTimes(ArrayList<String> stationsRunningTimes) {
        this.stationsRunningTimes = stationsRunningTimes;
    }
    @Override
    public String toString() {
        return "Train [id=" + id + ", route=" + route + "]\n";
    }
}
