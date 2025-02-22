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
import cairomonorail.Route;
public class RouteCard extends javax.swing.JPanel {
    Route route;
    /**
     * Creates new form RouteCard
     */
    public RouteCard(Route route) {
        initComponents();
        setRoute(route);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
        RouteIDLabel.setText("Route ID: "+this.route.getId());
        FromLabel.setText("From: "+this.route.getOriginStation().getName());
        ToLabel.setText("To: "+this.route.getDestStation().getName());
        revalidate();
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
        RouteIDLabel = new javax.swing.JLabel();
        ToLabel = new javax.swing.JLabel();
        FromLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 92, 5));

        jPanel1.setBackground(new java.awt.Color(38, 11, 1));
        jPanel1.setForeground(new java.awt.Color(242, 92, 5));

        RouteIDLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        RouteIDLabel.setForeground(new java.awt.Color(242, 92, 5));
        RouteIDLabel.setText("Route ID:");

        ToLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ToLabel.setForeground(new java.awt.Color(242, 92, 5));
        ToLabel.setText("To:");

        FromLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        FromLabel.setForeground(new java.awt.Color(242, 92, 5));
        FromLabel.setText("From:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(FromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(ToLabel)
                        .addGap(107, 107, 107))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RouteIDLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(RouteIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToLabel)
                    .addComponent(FromLabel))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FromLabel;
    private javax.swing.JLabel RouteIDLabel;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
