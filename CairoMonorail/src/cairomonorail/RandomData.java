package cairomonorail;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomData {
    private static Scanner input=new Scanner(System.in);
    private static String nameList[]={
        "Abdirahman", "Abdisalam", "Abdul", "Abdul-Aziz", "Abdulbasir", "Abdulkadir", "Abdulkarem", 
        "Abdulkhader", "Abdullah", "Abdul-Majeed", "Abdulmalik", "Abdul-Rehman", "Abdur", "Abdurraheem", 
        "Bekim", "Believe", "Ben", "Bendeguz", "Benedict", "Benjamin", "Benjamyn", "Benji", "Benn", "Bennett",
        "Cahl", "Cahlum", "Cai", "Caidan", "Caiden", "Caiden-Paul", "Caidyn", "Caie",
        "Daood", "Dara", "Darach", "Daragh", "Darcy", "D'arcy", "Dareh", "Daren", "Darien",
        "Efe", "Ege", "Ehsan", "Ehsen", "Eiddon", "Eidhan", "Eihli", "Eimantas", "Eisa",
        "Feden", "Felix", "Fergal", "Fergie", "Fergus", "Ferre", "Fezaan", "Fiachra", "Fikret", "Filip", 
        "Georgia", "Georgy", "Gerard", "Ghyll", "Giacomo", "Gian", "Giancarlo", "Gianluca", "Gianmarco", 
        "Gideon", "Gil", "Gio", "Girijan", "Girius", "Gjan", "Glascott", "Glen", "Glenn",
        "Henri", "Henry", "Herbert", "Heyden", "Hiro", "Hirvaansh", "Hishaam", "Hogan",
        "Jacki", "Jackie", "Jack-James", "Jackson", "Jacky", "Jacob", "Jacques", "Jad",
        "Keeton", "Kehinde", "Keigan", "Keilan", "Keir", "Keiran", "Keiren", "Keiron", "Keiryn",
        "Lukmaan", "Luqman", "Lyall", "Lyle", "Lyndsay", "Lysander", "Maanav", "Maaz", "Mac", "Macallum", 
        "Macaulay", "Macauley", "Macaully", "Machlan", "Maciej", "Mack", "Mackenzie",
        "Nihaal", "Nihal", "Nikash", "Nikhil", "Niki", "Nikita", "Nikodem", "Nikolai", "Nikos", "Nilav",
        "Pavit", "Pawel", "Pawlo", "Pearce", "Pearse", "Pearsen", "Pedram", "Pedro", "Peirce",
        "Sam", "Saman", "Samar", "Samarjit", "Samatar", "Sambrid", "Sameer", "Sami",
        "Taegen", "Tai", "Tait", "Taiwo", "Talha", "Taliesin", "Talon", "Talorcan", "Tamar", "Tamiem",
        "Zakariya", "Zakary", "Zaki", "Zakir", "Zakk", "Zamaar", "Zander", "Zane", "Zarran", "Zayd", "Zayn",
    };
    private static String domainList[] = { "@gmail.com", "@hotmail.com", "@yahoo.com" };

    RandomData() {
        int option;
        do{
            System.out.println("Choose the data you want to generate: ");
            System.out.println("1.Admins");
            System.out.println("2.Passengers");
            System.out.println("3.Stations");
            System.out.println("4.Routes");
            System.out.println("5.Trains");
            System.out.println("6.Tickets");
            System.out.println("0.Exit");
            System.out.println("Choose an option: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    generateAdmins();
                    break;
                case 2:
                    generatePassengers();
                    break;
                case 3:
                    generateStations();
                    break;
                case 4:
                    generateRoutes();
                    break;
                case 5:
                    generateTrains();
                    break;
                case 6:
                    generateTickets();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (option != 0);
    }

    public int generateInteger(int l, int r) {
        Random rand = new Random();
        int diff = r - l;
        return rand.nextInt(diff + 1) + l;
    }

    public double generateDouble(double l, double r) {
        Random rand=new Random();
        return Math.min(l + rand.nextDouble(),r);
    }

    public String makeName() {
        int idx=generateInteger(0, nameList.length-1);
        return nameList[idx];
    }

    public String makePhoneNum(int length) {
        String pnum = "01";
        pnum += generateInteger(0, 5);
        for (int i = 0; i < length - 3; i++) {
            pnum += generateInteger(0, 9);
        }
        return pnum;
    }

    public String makeEmail() {
        String email = makeName();
        email += generateInteger(1, 100);
        email += domainList[generateInteger(0, domainList.length - 1)];
        return email;
    }

    public String makeEmail(String username) {
        String email = username;
        email += generateInteger(1, 100);
        email += domainList[generateInteger(0, domainList.length - 1)];
        return email;
    }

    public String makeUsername() {
        String username = makeName();
        username += generateInteger(1, 10);
        return username;
    }

    public String makeUsername(String name) {
        String username = name;
        username += generateInteger(1, 10);
        return username;
    }
    public String makeDate() {
        String date = "";
        date += generateInteger(1, 30);
        date += '/';
        date += generateInteger(1, 12);
        date += "/20";
        date += generateInteger(20, 21);
        return date;
    }

    public String makeTime() {
        String time = "";
        time += generateInteger(0, 1);
        time += generateInteger(0, 9);
        time+=":";
        time += generateInteger(0, 5);
        time += generateInteger(0, 9);
        return time;
    }
    public String makeAccountNumber(int length) {
        String num = "";
        for (int i = 0; i < length; i++) {
            num += generateInteger(0, 9);
        }
        return num;
    }

    public String makePassword(int length) {
        String pass = "";
        for (int i = 0; i < length; i++) {
            int chance = generateInteger(0, 1);
            if (chance == 1) {
                pass += 'a' + generateInteger(0, 25);
            } else {
                pass += generateInteger(0, 9);
            }
        }
        return pass;
    }

    public BankAccount generateBankAccount() {
        BankAccount bankAccount = new BankAccount(makeAccountNumber(10), makePassword(5));
        bankAccount.setBalance(generateDouble(500, 10000));
        bankAccount.setMinimumBalance(generateDouble(100, bankAccount.getBalance()));
        return bankAccount;
    }

    public void generateAdmins() {
        System.out.println("Enter the number of admins you want: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            String fname=makeName();
            String lname = makeName();
            String phoneNumber = makePhoneNum(14);
            String username = makeUsername(fname);
            String email = makeEmail(username);
            String password = makePassword(generateInteger(8, 16));
            new Admin(fname, lname, phoneNumber, email, username, password);
        }
    }

    public void generatePassengers() {
        System.out.println("Enter the number of passengers you want: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            String fname = makeName();
            String lname = makeName();
            String phoneNumber = makePhoneNum(14);
            String username = makeUsername(fname);
            String email = makeEmail(username);
            String password = makePassword(generateInteger(8, 16));
            Passenger pass = new Passenger(fname, lname, phoneNumber, email, username, password);
            pass.setBankAccount(generateBankAccount());
        }
    }
    
    public void generateStations() {
        System.out.println("Enter the number of stations you want: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            String name = "";
            name += makeName();
            name += " ";
            name += makeName();
            name += " St.";
            new Station(name);
        }
    }

    public void generateTrains() {
        int routeSZ = Database.getRoutesDBList().size();
        if (routeSZ == 0) {
            System.out.println("You must add some routes first");
            return;
        }
        System.out.println("Enter the number of trains you want: ");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            Route route = Database.getRoutesDBList().get(generateInteger(0, routeSZ - 1));
            int fc = generateInteger(1, 10);
            int bc = generateInteger(10, 20);
            int ec = generateInteger(20, 50);
            Train train = new Train(route, fc, bc, ec);
            ArrayList<String> runningTimes = new ArrayList<>();
            for (int j = 0; j < route.getStations().size(); j++) {
                runningTimes.add(makeTime());
            }
            train.setStationsRunningTimes(runningTimes);
        }
    }
    public void generateRoutes() {
        int stationSZ = Database.getStationsDBList().size();
        if (stationSZ < 2) {
            System.out.println("You must add at least two stations first");
            return;
        }
        System.out.println("Enter the number of routes you want");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            Station originStation = Database.getStationsDBList().get(generateInteger(0, stationSZ - 1));
            Station destStation = Database.getStationsDBList().get(generateInteger(0, stationSZ - 1));
            double ticketFair = generateDouble(1, 20);
            new Route(originStation, destStation, ticketFair);
        }
    }
    public void generateTickets() {
        System.out.println("Do you want to generate a ticket for a specific passenger? (Y|N)");
        System.out.println("If you choose 'N' the system will generate tickets for all passengers");
        Character c = input.next().charAt(0);
        if (c == 'Y') {
            System.out.println("Enter the passenger username");
            Person pass = Database.getPersonByUsername(input.next());
            while (pass == null || !(pass instanceof Passenger)) {
                pass = Database.getPersonByUsername(input.next());
            }
            int trainsSZ = Database.getTrainDBList().size();
            if (trainsSZ == 0) {
                System.out.println("You must add some trains first");
                return;
            }
            String date = makeDate();
            Train train = Database.getTrainDBList().get(generateInteger(0, trainsSZ - 1));
            int seatSZ=train.getAvailableSeats().size();
            Seat seat = train.getAvailableSeats().get(generateInteger(0, seatSZ - 1));
            new Ticket(date, (Passenger)pass, train, seat);
        } else {
            int trainsSZ = Database.getTrainDBList().size();
            if (trainsSZ == 0) {
                System.out.println("You must add some trains first");
                return;
            }
            ArrayList<Passenger>passengers=Database.getPassengersDBList();
            int passSZ = Database.getPassengersDBList().size();
            if (passSZ == 0) {
                System.out.println("You must add some passengers first");
                return;
            }
            System.out.println("Enter the number of tickets you want for each passenger");
            int num = input.nextInt();
            for (Passenger passenger : passengers) {
                for (int i = 0; i < num; i++) {
                    String date = makeDate();
                    Train train = Database.getTrainDBList().get(generateInteger(0, trainsSZ - 1));
                    int seatSZ = train.getAvailableSeats().size();
                    if (seatSZ == 0)
                        break;
                    Seat seat = train.getAvailableSeats().get(generateInteger(0, seatSZ - 1));
                    new Ticket(date, (Passenger) passenger, train, seat);
                }
            }
        }
    }
}
