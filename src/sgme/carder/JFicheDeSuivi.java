/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Senghor AKOMINON
 */
public class JFicheDeSuivi extends javax.swing.JFrame {

   private JDBConnection connection ;
   private Statement chargeur;
   private JReparationEffectueModel model;
    
    public JFicheDeSuivi(JFrame parent) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        initializer();
        
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plDesRenseignements = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboCategorie = new javax.swing.JComboBox();
        comboMateriel = new javax.swing.JComboBox();
        btAfiche = new javax.swing.JButton();
        plDuTableauDUSuivi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableauDuSuivi = new javax.swing.JTable();
        btImprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fiche de suivi de matériel");

        plDesRenseignements.setBackground(new java.awt.Color(204, 255, 204));
        plDesRenseignements.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Renseignements", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(51, 51, 255))); // NOI18N
        plDesRenseignements.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        plDesRenseignements.setName(""); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Catégorie du matériel");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText(" Matériel");

        comboCategorie.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboCategorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir catégorie" }));
        comboCategorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategorieItemStateChanged(evt);
            }
        });

        comboMateriel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboMateriel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir matériel" }));

        btAfiche.setBackground(new java.awt.Color(204, 204, 255));
        btAfiche.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btAfiche.setText("Afficher");
        btAfiche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAficheMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plDesRenseignementsLayout = new javax.swing.GroupLayout(plDesRenseignements);
        plDesRenseignements.setLayout(plDesRenseignementsLayout);
        plDesRenseignementsLayout.setHorizontalGroup(
            plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDesRenseignementsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plDesRenseignementsLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(plDesRenseignementsLayout.createSequentialGroup()
                        .addComponent(comboMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(btAfiche)
                        .addGap(19, 19, 19))))
        );
        plDesRenseignementsLayout.setVerticalGroup(
            plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDesRenseignementsLayout.createSequentialGroup()
                .addGroup(plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(plDesRenseignementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAfiche))
                .addGap(25, 25, 25))
        );

        tableauDuSuivi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableauDuSuivi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Ordre", "Nature Réparation", "Date entrée en réparation", "Date sortie de réparation", "Coût pièces", "Main d'oeuvre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableauDuSuivi);

        btImprimer.setBackground(new java.awt.Color(204, 204, 255));
        btImprimer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btImprimer.setText("Imprimer");
        btImprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plDuTableauDUSuiviLayout = new javax.swing.GroupLayout(plDuTableauDUSuivi);
        plDuTableauDUSuivi.setLayout(plDuTableauDUSuiviLayout);
        plDuTableauDUSuiviLayout.setHorizontalGroup(
            plDuTableauDUSuiviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDuTableauDUSuiviLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btImprimer)
                .addGap(489, 489, 489))
        );
        plDuTableauDUSuiviLayout.setVerticalGroup(
            plDuTableauDUSuiviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDuTableauDUSuiviLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(btImprimer))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(plDesRenseignements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
            .addComponent(plDuTableauDUSuivi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDesRenseignements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plDuTableauDUSuivi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Connection() throws SQLException
    {
        connection = new JDBConnection();
        chargeur = connection.getJDBConnection().createStatement();
    }
    private void initializer() throws SQLException
    {
        Connection();
        plDuTableauDUSuivi.setVisible(false);
        model = new JReparationEffectueModel();
        initListCategorie();
        icon(); 
    }
    private void initListCategorie() throws SQLException
    {
        String requette = "select libelle from Categorie";
        ResultSet rs = chargeur.executeQuery(requette);
        while(rs.next()) comboCategorie.addItem(rs.getString("libelle"));
    }
    private void icon()
    {
        Image img = null;
        try {
            img = ImageIO.read(new File("images\\icon1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(img);
    }
    private void btAficheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAficheMouseClicked
       String requete = null;
        if(comboCategorie.getSelectedItem().toString().equalsIgnoreCase("Choisir catégorie")&& comboMateriel.getSelectedItem().toString().equalsIgnoreCase("Choisir matériel"))
            JOptionPane.showMessageDialog(this, "choisir catégorie et matériel");
        else{ if(comboMateriel.getSelectedItem().toString().equalsIgnoreCase("Choisir matériel")) JOptionPane.showMessageDialog(this, "choisissez  matériel");
             else {if(comboMateriel.getSelectedItem().toString().equalsIgnoreCase("Choisir catégorie")) JOptionPane.showMessageDialog(this, "choisissez  catégorie");
             else { requete = " select natureReparation, dateEntreeRepar, dateSortieRepar, coutpiece, mainOeuvre from LigneReparation l, BonReparation b, Reparation r,  Materiel m, Categorie c "
                + " where c.codCategorie = m.codCategorie and m.codMat = r.codMat and l.numRepar = r.numRepar and l.refBR = b.refBR  and   "
                + " c.libelle="+comboCategorie.getSelectedItem().toString()+" and m.libelle="+comboMateriel.getSelectedItem().toString()+" ";
        }}}
        if(!requete.isEmpty())
        {try {
           ResultSet rs = chargeur.executeQuery(requete);
           if(!rs.isFirst())JOptionPane.showMessageDialog(this, "Pas d'opération pour le matériel "+comboMateriel.getSelectedItem().toString()+"");
           else while(rs.next())model.add(new JReparationEffectuee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5)));
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
       }}
       if(!model.isEmpty()){
       tableauDuSuivi.setModel(model);
        plDuTableauDUSuivi.setVisible(true);}
       else if(plDuTableauDUSuivi.isVisible())plDuTableauDUSuivi.setVisible(false);
    }//GEN-LAST:event_btAficheMouseClicked

    private void btImprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btImprimerMouseClicked

    private void comboCategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategorieItemStateChanged
        String requette = "select m.libelle from Materiel m, Categorie c where m.codCategorie = c.codCategorie and c.libelle = "+comboCategorie.getSelectedItem().toString()+" ";
        ResultSet rs;
       try {
           rs = chargeur.executeQuery(requette); 
           if(comboMateriel.getItemCount()>1)
        {   int i = comboMateriel.getItemCount();
            while(i>1){comboMateriel.removeItemAt(i-1);i = comboMateriel.getItemCount();}
        }
           while(rs.next()) comboMateriel.addItem(rs.getString("libelle"));
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de chargement depuis la base de données");
       }              
    }//GEN-LAST:event_comboCategorieItemStateChanged

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
            java.util.logging.Logger.getLogger(JFicheDeSuivi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFicheDeSuivi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFicheDeSuivi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFicheDeSuivi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JFicheDeSuivi(null).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFicheDeSuivi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAfiche;
    private javax.swing.JButton btImprimer;
    private javax.swing.JComboBox comboCategorie;
    private javax.swing.JComboBox comboMateriel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel plDesRenseignements;
    private javax.swing.JPanel plDuTableauDUSuivi;
    private javax.swing.JTable tableauDuSuivi;
    // End of variables declaration//GEN-END:variables
}
