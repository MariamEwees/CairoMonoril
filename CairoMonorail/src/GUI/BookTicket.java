/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Go
 */
import cairomonorail.*;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JOptionPane;
public class BookTicket extends javax.swing.JFrame {
    /**
     * Creates new form BookTicket
     */
    private Route selectedRoute;
    private Station selectedDepartStation;
    private Train selectedTrain;
    private Seat selectedSeat;
    private String selectedDepartTime;
    private String selectedDepartDate;
    private ArrayList<Route>routes;
    private ArrayList<Station>stations;
    private ArrayList<Train>trains;
    private ArrayList<Seat>seats;
    private MouseAdapter routeListener,stationListener,trainListener,seatListener;
    public BookTicket() {
        this.routeListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                RouteCard rc=(RouteCard)e.getSource();
                setSelectedRoute(rc.getRoute());
                setStations(getSelectedRoute().getStations());
            }
        };
        this.stationListener=new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                StationCard sc=(StationCard)e.getSource();
                setSelectedDepartStation(sc.getStation());
                setTrains(getSelectedRoute().getTrains());
            }
        };
        this.trainListener=new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                TrainCard tc=(TrainCard)e.getSource();
                setSelectedTrain(tc.getTrain());
                String departTime=getSelectedTrain().getStationRunningTime(selectedDepartStation);
                setSelectedDepartTime(departTime);
                setSeats(getSelectedTrain().getAvailableSeats());
            }
        };
        this.seatListener=new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                SeatCard sc=(SeatCard)e.getSource();
                setSelectedSeat(sc.getSeat());
            }
        };
        
        initComponents();
        setRoutes(Database.getRoutesDBList());
        System.out.println(Database.getRoutesDBList());
    }
    public void finalizeTicket(){
        String month=monthComboBox.getSelectedItem().toString();
        String day=dayComboBox.getSelectedItem().toString();
        String year=dayComboBox.getSelectedItem().toString();
        String date=month+"/"+day+"/"+year;
        setSelectedDepartDate(date);
        Ticket ticket=new Ticket(date,selectedDepartTime,(Passenger)Person.getActivePerson(),selectedRoute,selectedTrain,selectedSeat,selectedDepartStation);
        
    }
    public ArrayList<Route> getRoutes() {
        return routes;
    }
    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
        OptionLabel.setText("Choose Route: ");
        ListPanel.removeAll();
        ListPanel.setLayout(new GridLayout(Math.max(this.routes.size(), 3),1));
        for(Route route:this.routes){
            RouteCard rc=new RouteCard(route);
            rc.addMouseListener(routeListener);
            ListPanel.add(rc);
        }
        revalidate();
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
        OptionLabel.setText("Choose Depart Station: ");
        ListPanel.removeAll();
        ListPanel.setLayout(new GridLayout(Math.max(this.stations.size(), 3),1));
        for(Station station:this.stations){
            StationCard sc=new StationCard(station);
            sc.addMouseListener(stationListener);
            ListPanel.add(sc);
        }
        revalidate();
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
        OptionLabel.setText("Choose Train: ");
        ListPanel.removeAll();
        ListPanel.setLayout(new GridLayout(Math.max(this.trains.size(), 3),1));
        for(Train train:this.trains){
            TrainCard tc=new TrainCard(train);
            String runningTime=getSelectedTrain().getStationRunningTime(selectedDepartStation);
            tc.getRunningTimeLabel().setText("Running Time: "+runningTime);
            tc.addMouseListener(trainListener);
            ListPanel.add(tc);
        }
        revalidate();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
        OptionLabel.setText("Choose Seat: ");
        ListPanel.removeAll();
        ListPanel.setLayout(new GridLayout(Math.max(this.seats.size(), 3),1));
        for(Seat seat:this.seats){
            SeatCard sc=new SeatCard(seat);
            sc.addMouseListener(seatListener);
            ListPanel.add(sc);
        }
        revalidate();
    }

    public Route getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public Station getSelectedDepartStation() {
        return selectedDepartStation;
    }

    public void setSelectedDepartStation(Station selectedDepartStation) {
        this.selectedDepartStation = selectedDepartStation;
    }

    public Train getSelectedTrain() {
        return selectedTrain;
    }

    public void setSelectedTrain(Train selectedTrain) {
        this.selectedTrain = selectedTrain;
    }

    public Seat getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(Seat selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public String getSelectedDepartTime() {
        return selectedDepartTime;
    }

    public void setSelectedDepartTime(String selectedDepartTime) {
        this.selectedDepartTime = selectedDepartTime;
    }

    public String getSelectedDepartDate() {
        return selectedDepartDate;
    }

    public void setSelectedDepartDate(String selectedDepartDate) {
        this.selectedDepartDate = selectedDepartDate;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListPanel = new javax.swing.JPanel();
        OptionLabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        dayComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout ListPanelLayout = new javax.swing.GroupLayout(ListPanel);
        ListPanel.setLayout(ListPanelLayout);
        ListPanelLayout.setHorizontalGroup(
            ListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        ListPanelLayout.setVerticalGroup(
            ListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(ListPanel);

        OptionLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        OptionLabel.setText("Choose ");

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022" }));

        jLabel1.setText("Travel Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 188, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(OptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptionLabel)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListPanel;
    private javax.swing.JLabel OptionLabel;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
