package cairomonorail;
import GUI.BookTicket;
import java.util.Scanner;
public class Admin extends Person {
    public Admin(String fname, String lname, String phoneNumber, String email, String username, String password) {
        super(fname, lname, phoneNumber, email, username, password);
        Database.add(this);
    }
    private static Scanner input=new Scanner(System.in);

    public void addPerson() {
        Passenger person = new Passenger();
        person.fillInformation();
    }

    public void deletePerson() {
        System.out.println(Database.getPeopleDBList());
        System.out.print("Enter the ID of the person you want to delete: ");
        removePerson(Database.getPersonById(input.nextInt()));
    }
    public void removePerson(Person person){
        Database.remove(person);
    }

    public void editPerson() {
        System.out.println(Database.getPeopleDBList());
        System.out.println("Enter the id of the person you want to edit: ");
        Person oldPerson = Database.getPersonById(input.nextInt());
        oldPerson.fillInformation();
    }
    public void addTrain(){
        Train train = new Train();
        train.fillInformation();
    }

    public void deleteTrain() {
        System.out.println(Database.getTrainDBList());
        System.out.println("Enter the id of the train you want to delete: ");
        removeTrain(Database.getTrainById(input.nextInt()));
    }
    public void removeTrain(Train train) {
        Database.remove(train);
    }
    public void editTrain(){
        System.out.println(Database.getTrainDBList());
        System.out.println("Enter the ID of the train you want to edit: ");
        Train train = Database.getTrainById(input.nextInt());
        while (train == null) {
            System.out.println("Enter a valid train id: ");
            train = Database.getTrainById(input.nextInt());
        }
        train.fillInformation();
    }
    public void addRoute(){
        Route route = new Route();
        route.fillInformation();
    }
    
    public void editRoute() {
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the id of the route you want to edit: ");
        Route route = Database.getRouteById(input.nextInt());
        while (route == null) {
            System.out.println("Enter a valid route id: ");
            route = Database.getRouteById(input.nextInt());
        }
        route.fillInformation();
    }

    public void deleteRoute() {
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the id of the route you want to delete: ");
        removeRoute(Database.getRouteById(input.nextInt()));
    }
    public void removeRoute(Route route){
        Database.remove(route);
    }
    public void addStation(){
        Station station=new Station();
        station.fillInformation();
    }

    public void editStation() {
        System.out.println(Database.getStationsDBList());
        System.out.println("Enter the id of the station you want to edit: ");
        Station station = Database.getStationById(input.nextInt());
        while (station == null) {
            System.out.println("Enter a valid station id: ");
            station = Database.getStationById(input.nextInt());
        }
        station.fillInformation();
    }

    public void deleteStation() {
        System.out.println(Database.getStationsDBList());
        System.out.println("Enter the id of the station you want to edit: ");
        removeStation(Database.getStationById(input.nextInt()));
    }
    public void removeStation(Station station){
        Database.remove(station);
    }
    public void banUser(){
        System.out.println("Enter user id: ");
        Database.getPersonById(input.nextInt()).ban();
    }
    public void unBanUser(){
        System.out.println("Enter user id: ");
        Database.getPersonById(input.nextInt()).unBan();
    }

    public void noPassengerBooked() {
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the route id: ");
        Database.getRouteById(input.nextInt()).getNoPassenger();
    }
    public void routeFairReport(){
        System.out.println(Database.getRoutesDBList());
        System.out.println("Enter the route id: ");
        Database.getRouteById(input.nextInt()).getTotalFair();
    }
    public void displayFunctionalities() {
      	int Option ;
        do{
            System.out.println("Functions avaliable for the admin:");
            System.out.println("1.Add Person");
            System.out.println("2.Edit Person");
            System.out.println("3.Delete Person");
            System.out.println("4.Add Train");
            System.out.println("5.Edit Train");
            System.out.println("6.Delete Train");
            System.out.println("7.Add Route");
            System.out.println("8.Edit Route");
            System.out.println("9.Delete Route");
            System.out.println("10.Add Station");
            System.out.println("11.Edit Staton");
            System.out.println("12.Delete Station");
            System.out.println("13.Ban User");
            System.out.println("14.Unban User");
            System.out.println("15.Report of Passenger Booked per Route");
            System.out.println("16.Report of Total Fair Collected per Route");
            System.out.println("17.Generate Random Data for Testing");
            System.out.println("18.Open book ticket (testing)");            
            System.out.println("0.Log out");
            
            System.out.println("Enter an Option:");
            Option = input.nextInt();
            
            switch(Option){
                case 1:
                    addPerson();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    addTrain();
                    break;
                case 5:
                    editTrain();
                    break;
                case 6:
                    deleteTrain();
                    break;
                case 7:
                    addRoute();
                    break;
                case 8:
                    editRoute();
                    break;
                case 9:
                    deleteRoute();
                    break;
                case 10:
                    addStation();
                    break;
                case 11:
                    editStation();
                    break;
                case 12:
                    deleteStation();
                    break;
                case 13:
                    banUser();
                    break;
                case 14:
                    unBanUser();
                    break;
                case 15:
                    noPassengerBooked();
                    break;
                case 16:
                    routeFairReport();
                    break;
                case 17:
                    new RandomData();
                    break;
                case 18:
                    new BookTicket().setVisible(true);
                    break;
                case 0:
                    logOut();
                    break;
                default:
                    System.out.println("Enter a valid option: ");
                    break;
            }
        }while(Option!=0);
    }
}
