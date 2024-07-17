package cairomonorail;
public class Seat {
    private static int idCounter = 1;
    private int id;
    private DegreeClassEnum degreeClass;
    private boolean available;
    private Ticket ticket;

    
    public Seat(DegreeClassEnum degreeClass) {
        id = idCounter++;
        this.degreeClass = degreeClass;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        available = false;
    }
    public DegreeClassEnum getDegreeClass() {
        return degreeClass;
    }
    public void setDegreeClass(DegreeClassEnum degreeClass) {
        this.degreeClass = degreeClass;
    }
    @Override
    public String toString() {
        return "Seat [id=" + id + ", degreeClass=" + degreeClass + ", available=" + available+ "]\n";
    }
    
}
