/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Senghor AKOMINON
 */
public class JSectionAdministrateur extends javax.swing.JFrame {
    
    private JDBConnection connexion ;
    private Statement chargeur;
    private JInsererModele model;
    private JStructureModel modelStructure;
    private List<String> tables ;
    private int nombre = 0,  numUtilisateur=0;String Host = null, user = null, Password =null;
    
    public JSectionAdministrateur(int numUtilisateur, String Host, String User, String Password) 
    {
        initComponents();
        this.numUtilisateur = numUtilisateur;this.Host = Host;this.user = User; this.Password = Password;
        actuelMotPasse.setEchoChar('*'); confirmerNouveauMotDePasse.setEchoChar('*');
        Image img = null;
        try 
        {
            img = ImageIO.read(new File("icon1.jpg"));
        } catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        this.setIconImage(img);
        connexion = new JDBConnection();
        this.setLocationRelativeTo(null);
        try 
        {
            chargeur = connexion.getJDBConnection(Host, User, Password).createStatement();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Un problème s'est produit lors du chargement  !!! \n"+e.getMessage());
        }   
        ResultSet rs; tables = new LinkedList();
        try
        {
            rs = chargeur.executeQuery(" SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'dbCarder' ");            
            while(rs.next())
            {
                 comboInserer.addItem(rs.getString(1));
                comboAfficher.addItem(rs.getString(1));
                comboStructure.addItem(rs.getString(1));
                tables.add(rs.getString(1));
            }
        }catch(SQLException e) {JOptionPane.showMessageDialog(null, e);}
        
        this.tableauInserer.setRowHeight(40);
        this.tableauStructure.setRowHeight(40);
        this.tableauAfficher.setRowHeight(40);
        this.tableauUtilisateur.setRowHeight(40);
        tableauInserer.getColumn("Valeur").setWidth(100);
        tableauInserer.getColumn("Longeur").setWidth(30);
        tableauInserer.getColumn("Types").setWidth(150);
        tableauInserer.getColumn("Colonnes").setWidth(150);
         initTableauAfficher(); initTableauUtilisateur();
        this.textError.setVisible(false);
        this.modifyPassword.setVisible(false); 
  }
    
    private void initTableauAfficher() {
        DefaultTableModel dtm  = new DefaultTableModel();
                Vector<String> entete = new Vector();
                nombre++;
                 entete.add("Tables");entete.add("Type de table");entete.add("Date de création");entete.add("Nombre d'enregistrements");entete.add("Taille moyenne par enregistrement");
                 entete.add("Taille de la table"); this.btModifier.setVisible(false);this.btSupprimer.setVisible(false);

                dtm.setColumnIdentifiers(entete);
                Vector<String> enregistrement;   ResultSet rd = null;   
               String req=" select table_name , table_type , date(create_time) , table_rows , avg_row_length , data_length  from information_schema.tables where table_schema='dbcarder'";
                 try 
                 {   
                     rd  = chargeur.executeQuery(req);
                     while(rd.next())
                     {   
                         enregistrement = new Vector();
                         int i=0, t=rd.getMetaData().getColumnCount();
                         while(i<t){ enregistrement.addElement(rd.getString(i+1));i++;}
                         dtm.addRow(enregistrement);
                     }
                     this.tableauAfficher.setModel(dtm); 
                 } catch (Exception ex) 
                 {
                     JOptionPane.showMessageDialog(this, ex);
                 }
    }
    
    private void initTableauUtilisateur()
    {
        DefaultTableModel dtm  = new DefaultTableModel();
                Vector<String> entete = new Vector();
                
                 entete.add("Utilisateur");entete.add("Poste");entete.add("Protéger par un mot de passe");entete.add("Droit d'attribution");

                dtm.setColumnIdentifiers(entete);
                Vector<String> enregistrement;   ResultSet rd = null;   
               String req=" select user, host, password, grant_priv from mysql.user ";
                 try 
                 {   
                     rd  = chargeur.executeQuery(req);
                     while(rd.next())
                     {   
                         enregistrement = new Vector();
                         int i=0, t=rd.getMetaData().getColumnCount();
                         while(i<t)
                         { 
                             if(i==2)
                             {
                                 if(rd.getString(i+1).equalsIgnoreCase(""))enregistrement.add("Non");
                                 else enregistrement.add("Oui");
                             }
                             else 
                             {  
                                    if(i==3)
                                    {
                                        if(rd.getString(i+1).equalsIgnoreCase("y"))enregistrement.add("Oui");
                                        else if(rd.getString(i+1).equalsIgnoreCase("N"))enregistrement.add("Non");
                                    }
                                    else enregistrement.addElement(rd.getString(i+1));
                             }
                             i++;
                         }
                         dtm.addRow(enregistrement);
                     }
                     this.tableauUtilisateur.setModel(dtm); 
                 } catch (Exception ex) 
                 {
                     JOptionPane.showMessageDialog(this, ex);
                 }
    }
    
     private String getDayMonthFormat(int element)
    {
       String element3 = null, element2= ""+element+"";int taille = element2.length();
        switch(taille)
        {
            case 1: element3 = "0";break;
            case 2: element3= ""; break;
            default : break;
        } return element3+element2;
    }
    private String getSelectedDate(JDateChooser dateChooser)
    {
        int annee = dateChooser.getCalendar().get(Calendar.YEAR);
        int moi  = dateChooser.getCalendar().get(Calendar.MONTH)+1;
        int jour = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);        
        return annee+"/"+getDayMonthFormat(moi)+"/"+getDayMonthFormat(jour);
    }
    private String reference(int nombreTuple, String nomPiece)
    {
        String nombre2 = ""+nombreTuple+"";
        String nombreZero = null;
        int taille = nombre2.length();
        switch(taille)
        {
            case 1: nombreZero = "000";break;
            case 2: nombreZero = "00";break;
            case 3: nombreZero = "0";break;
            default:
        }
        String reference = Calendar.getInstance().get(Calendar.YEAR)+nomPiece+nombreZero+nombreTuple;
        return reference;
    }
    private String getDate(String dateFormat) {
        String date = null;
        String s1 = dateFormat.substring(8), s2 = dateFormat.substring(5, 7), s3 = dateFormat.substring(0, 4);
        date =  s1+"-"+s2+"-"+s3;
        return date;
    }
    // référence BR 
    private void referenceBR() throws SQLException {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refBR from BonReparation where refBR like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBR").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon de réparation !");
        }
        nombre++;
        tableauInserer.setValueAt(reference(nombre,"BR"), 0, 3);
    }
    private void referenceBC() throws SQLException 
    {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refBC from BonCaisse where refBC like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try 
        {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) 
            {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBC").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon de caisse !");
        }
        nombre++;
        tableauInserer.setValueAt(reference(nombre,"BC"), 0, 3);
    }
    private void referenceBCde() throws SQLException 
    {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refBCde from BonCommande where refBCde like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try 
        {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) 
            {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBCde").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon de commande !");
        }
        nombre++; String ref =reference(nombre,"BCde");
        tableauInserer.setValueAt( ref, 0, 3);
    }
    private void referenceAD() throws SQLException 
    {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refAutorisation from AutorisationDepense where refAutorisation like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try 
        {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) 
            {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refAutorisation").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation d'autorisation !");
        }
        nombre++;
        tableauInserer.setValueAt(reference(nombre,"AD"), 0, 3);
    }
    private void referenceBE() throws SQLException 
    {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refBE from BonEntree where refBE like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try 
        {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) 
            {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBE").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon d'entrée !");
        }
        nombre++;
        tableauInserer.setValueAt(reference(nombre,"BE"), 0, 3);
    }
    private void referenceBS() throws SQLException 
    {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBR = "select refBS from BonSortie where refBS like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try 
        {
          ResultSet  resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) 
            {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBS").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon de sortie !");
        }
        nombre++;
        tableauInserer.setValueAt(reference(nombre,"BS"), 0, 3);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane37 = new javax.swing.JTabbedPane();
        tbPTables = new javax.swing.JTabbedPane();
        Afficher = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableauAfficher = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        comboAfficher = new javax.swing.JComboBox();
        btModifier = new javax.swing.JButton();
        btSupprimer = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboStructure = new javax.swing.JComboBox();
        plStructure = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableauStructure = new javax.swing.JTable();
        plSQL = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        textSQL = new javax.swing.JTextPane();
        jButton7 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableauSQL = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textError = new javax.swing.JTextPane();
        Inserer = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableauInserer = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboInserer = new javax.swing.JComboBox();
        conteneurUtilisateur = new javax.swing.JTabbedPane();
        creerUtilisateur = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        IP = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fonction = new javax.swing.JComboBox();
        motDePasse = new javax.swing.JPasswordField();
        confirmerMotDePasse = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        select = new javax.swing.JCheckBox();
        insert = new javax.swing.JCheckBox();
        update = new javax.swing.JCheckBox();
        delete = new javax.swing.JCheckBox();
        administration = new javax.swing.JPanel();
        grant = new javax.swing.JCheckBox();
        showTables = new javax.swing.JCheckBox();
        dropUser = new javax.swing.JButton();
        createUser = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        AD = new javax.swing.JCheckBox();
        BC = new javax.swing.JCheckBox();
        BCde = new javax.swing.JCheckBox();
        BR = new javax.swing.JCheckBox();
        BE = new javax.swing.JCheckBox();
        BS = new javax.swing.JCheckBox();
        Cat = new javax.swing.JCheckBox();
        Fac = new javax.swing.JCheckBox();
        FacEE = new javax.swing.JCheckBox();
        FacR = new javax.swing.JCheckBox();
        FacT = new javax.swing.JCheckBox();
        Frs = new javax.swing.JCheckBox();
        Mag = new javax.swing.JCheckBox();
        Mat = new javax.swing.JCheckBox();
        Repar = new javax.swing.JCheckBox();
        ReparV = new javax.swing.JCheckBox();
        Ser = new javax.swing.JCheckBox();
        User = new javax.swing.JCheckBox();
        compteUtilisateur = new javax.swing.JPanel();
        revoke = new javax.swing.JButton();
        drop = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableauUtilisateur = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        NouveauMotDePasse = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        modifyPassword = new javax.swing.JButton();
        actuelMotPasse = new java.awt.TextField();
        confirmerNouveauMotDePasse = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration du SGME");

        jTabbedPane37.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tbPTables.setBackground(new java.awt.Color(0, 102, 102));
        tbPTables.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        tbPTables.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbPTables.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbPTablesStateChanged(evt);
            }
        });

        Afficher.setBackground(new java.awt.Color(255, 255, 255));
        Afficher.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableauAfficher.setAutoCreateRowSorter(true);
        tableauAfficher.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableauAfficher.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableauAfficher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "Ref BR", "Ref DR", "Nature Réparation", "Date édition BR", "C/Ch-ME"
            }
        ));
        tableauAfficher.setRowHeight(30);
        jScrollPane8.setViewportView(tableauAfficher);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tables");

        comboAfficher.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboAfficher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir la table" }));
        comboAfficher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAfficherItemStateChanged(evt);
            }
        });

        btModifier.setBackground(new java.awt.Color(255, 255, 255));
        btModifier.setText("Modifier ");
        btModifier.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 255))));
        btModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierMouseClicked(evt);
            }
        });

        btSupprimer.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimer.setText("Supprimer");
        btSupprimer.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 255))));
        btSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AfficherLayout = new javax.swing.GroupLayout(Afficher);
        Afficher.setLayout(AfficherLayout);
        AfficherLayout.setHorizontalGroup(
            AfficherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AfficherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(AfficherLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboAfficher, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(468, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AfficherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btModifier)
                .addGap(18, 18, 18)
                .addComponent(btSupprimer)
                .addGap(251, 251, 251))
        );
        AfficherLayout.setVerticalGroup(
            AfficherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AfficherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AfficherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboAfficher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(AfficherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btModifier)
                    .addComponent(btSupprimer))
                .addGap(34, 34, 34))
        );

        tbPTables.addTab("Afficher", Afficher);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Tables");

        comboStructure.setEditable(true);
        comboStructure.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboStructure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choisir la table" }));
        comboStructure.setFocusable(false);
        comboStructure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStructureItemStateChanged(evt);
            }
        });

        tableauStructure.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableauStructure.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableauStructure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tableauStructure);

        javax.swing.GroupLayout plStructureLayout = new javax.swing.GroupLayout(plStructure);
        plStructure.setLayout(plStructureLayout);
        plStructureLayout.setHorizontalGroup(
            plStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        plStructureLayout.setVerticalGroup(
            plStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboStructure, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(plStructure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        tbPTables.addTab("Structure", jPanel14);

        plSQL.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane9.setViewportView(textSQL);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/ok.png"))); // NOI18N
        jButton7.setText("Exécuter");
        jButton7.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 153, 153))));
        jButton7.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        tableauSQL.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableauSQL.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tableauSQL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane10.setViewportView(tableauSQL);

        textError.setEditable(false);
        jScrollPane2.setViewportView(textError);

        javax.swing.GroupLayout plSQLLayout = new javax.swing.GroupLayout(plSQL);
        plSQL.setLayout(plSQLLayout);
        plSQLLayout.setHorizontalGroup(
            plSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plSQLLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(plSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane9))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(58, 58, 58))
            .addGroup(plSQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                .addContainerGap())
        );
        plSQLLayout.setVerticalGroup(
            plSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plSQLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plSQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tbPTables.addTab("SQL", plSQL);

        Inserer.setBackground(new java.awt.Color(255, 255, 255));

        tableauInserer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableauInserer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableauInserer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colonnes", "Types", "Longeur", "Valeur"
            }
        ));
        jScrollPane11.setViewportView(tableauInserer);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/ok.png"))); // NOI18N
        jButton8.setText("Exécuter");
        jButton8.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 0))));
        jButton8.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Tables");

        comboInserer.setEditable(true);
        comboInserer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboInserer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir la table" }));
        comboInserer.setFocusable(false);
        comboInserer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboInsererItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout InsererLayout = new javax.swing.GroupLayout(Inserer);
        Inserer.setLayout(InsererLayout);
        InsererLayout.setHorizontalGroup(
            InsererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsererLayout.createSequentialGroup()
                .addGroup(InsererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InsererLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InsererLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboInserer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InsererLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        InsererLayout.setVerticalGroup(
            InsererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsererLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(InsererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboInserer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(92, 92, 92))
        );

        tbPTables.addTab("Insérer", Inserer);

        jTabbedPane37.addTab("Gérer les tables", tbPTables);

        conteneurUtilisateur.setBackground(new java.awt.Color(204, 204, 204));
        conteneurUtilisateur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 51, 51)));
        conteneurUtilisateur.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        creerUtilisateur.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations pour la connexion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nom d'utilisateur");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Adresse de l'hôte");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mot de passe");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Confirmer mot de passe");

        nom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });

        IP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        prenom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        prenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Prénom(s) d'utilisateur");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fonction d'utilisateur");

        fonction.setEditable(true);
        fonction.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        fonction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir fonction Utilisateur", "Administrateur", "Ch-ME", "C/Ch-ME", "Magasinier" }));
        fonction.setFocusable(false);
        fonction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fonctionItemStateChanged(evt);
            }
        });

        motDePasse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        confirmerMotDePasse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fonction, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prenom, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(IP, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(motDePasse)
                            .addComponent(confirmerMotDePasse))))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(motDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(confirmerMotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilèges globaux", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Données", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 102, 51))); // NOI18N

        select.setBackground(new java.awt.Color(255, 255, 255));
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        insert.setBackground(new java.awt.Color(255, 255, 255));
        insert.setText("INSERT");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete)
                    .addComponent(update)
                    .addComponent(insert)
                    .addComponent(select))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete))
        );

        administration.setBackground(new java.awt.Color(255, 255, 255));
        administration.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 102, 51))); // NOI18N

        grant.setBackground(new java.awt.Color(255, 255, 255));
        grant.setText("GRANT");
        grant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grantActionPerformed(evt);
            }
        });

        showTables.setBackground(new java.awt.Color(255, 255, 255));
        showTables.setText("SHOW TABLES");
        showTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTablesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout administrationLayout = new javax.swing.GroupLayout(administration);
        administration.setLayout(administrationLayout);
        administrationLayout.setHorizontalGroup(
            administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrationLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(grant)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, administrationLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(showTables)
                .addContainerGap())
        );
        administrationLayout.setVerticalGroup(
            administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grant)
                .addGap(18, 18, 18)
                .addComponent(showTables)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(administration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(administration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dropUser.setBackground(new java.awt.Color(255, 255, 255));
        dropUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dropUser.setText("Annuler");
        dropUser.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 153, 153))));
        dropUser.setMargin(new java.awt.Insets(2, 1, 2, 1));
        dropUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropUserMouseClicked(evt);
            }
        });

        createUser.setBackground(new java.awt.Color(255, 255, 255));
        createUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        createUser.setText("Créer un compte utilisateur");
        createUser.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 153, 153))));
        createUser.setMargin(new java.awt.Insets(2, 1, 2, 1));
        createUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createUserMouseClicked(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tables sur lesquelles ses opérations sont autorisées", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(51, 0, 255))); // NOI18N

        AD.setBackground(new java.awt.Color(255, 255, 255));
        AD.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        AD.setText("Autorisation de dépense");
        AD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADActionPerformed(evt);
            }
        });

        BC.setBackground(new java.awt.Color(255, 255, 255));
        BC.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        BC.setText("Bon de caisse");
        BC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCActionPerformed(evt);
            }
        });

        BCde.setBackground(new java.awt.Color(255, 255, 255));
        BCde.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        BCde.setText("Bon de commande");
        BCde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCdeActionPerformed(evt);
            }
        });

        BR.setBackground(new java.awt.Color(255, 255, 255));
        BR.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        BR.setText("Bon de réparation");
        BR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRActionPerformed(evt);
            }
        });

        BE.setBackground(new java.awt.Color(255, 255, 255));
        BE.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        BE.setText("Bon d'entrée");
        BE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEActionPerformed(evt);
            }
        });

        BS.setBackground(new java.awt.Color(255, 255, 255));
        BS.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        BS.setText("Bon de sortie");
        BS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSActionPerformed(evt);
            }
        });

        Cat.setBackground(new java.awt.Color(255, 255, 255));
        Cat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cat.setText("Catégorie");
        Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatActionPerformed(evt);
            }
        });

        Fac.setBackground(new java.awt.Color(255, 255, 255));
        Fac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Fac.setText("Facture");
        Fac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacActionPerformed(evt);
            }
        });

        FacEE.setBackground(new java.awt.Color(255, 255, 255));
        FacEE.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        FacEE.setText("Facture d'Electricité et d'eau");
        FacEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacEEActionPerformed(evt);
            }
        });

        FacR.setBackground(new java.awt.Color(255, 255, 255));
        FacR.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        FacR.setText("Facture de réparation");
        FacR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacRActionPerformed(evt);
            }
        });

        FacT.setBackground(new java.awt.Color(255, 255, 255));
        FacT.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        FacT.setText("Facture de téléphone");
        FacT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacTActionPerformed(evt);
            }
        });

        Frs.setBackground(new java.awt.Color(255, 255, 255));
        Frs.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Frs.setText("Fournisseur");
        Frs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrsActionPerformed(evt);
            }
        });

        Mag.setBackground(new java.awt.Color(255, 255, 255));
        Mag.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Mag.setText("Magasin");
        Mag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MagActionPerformed(evt);
            }
        });

        Mat.setBackground(new java.awt.Color(255, 255, 255));
        Mat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Mat.setText("Matériel");
        Mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatActionPerformed(evt);
            }
        });

        Repar.setBackground(new java.awt.Color(255, 255, 255));
        Repar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Repar.setText("Réparation");
        Repar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReparActionPerformed(evt);
            }
        });

        ReparV.setBackground(new java.awt.Color(255, 255, 255));
        ReparV.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ReparV.setText("Réparation de véhicule");
        ReparV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReparVActionPerformed(evt);
            }
        });

        Ser.setBackground(new java.awt.Color(255, 255, 255));
        Ser.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Ser.setText("Service");
        Ser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerActionPerformed(evt);
            }
        });

        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        User.setText("Utilisateur");
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User)
                    .addComponent(Ser)
                    .addComponent(ReparV)
                    .addComponent(Repar)
                    .addComponent(Mat)
                    .addComponent(Mag)
                    .addComponent(Frs)
                    .addComponent(FacT)
                    .addComponent(FacR)
                    .addComponent(Fac, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BS, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BE, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BR, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCde, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BC, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AD, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacEE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BCde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Fac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FacEE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FacR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FacT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Frs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Repar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReparV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(User))
        );

        javax.swing.GroupLayout creerUtilisateurLayout = new javax.swing.GroupLayout(creerUtilisateur);
        creerUtilisateur.setLayout(creerUtilisateurLayout);
        creerUtilisateurLayout.setHorizontalGroup(
            creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creerUtilisateurLayout.createSequentialGroup()
                .addGroup(creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creerUtilisateurLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creerUtilisateurLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dropUser)
                        .addGap(43, 43, 43)
                        .addComponent(createUser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)))
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        creerUtilisateurLayout.setVerticalGroup(
            creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creerUtilisateurLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(creerUtilisateurLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(creerUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createUser)
                            .addComponent(dropUser))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        conteneurUtilisateur.addTab("Ajouter un utilisateur", creerUtilisateur);

        compteUtilisateur.setBackground(new java.awt.Color(255, 255, 255));

        revoke.setBackground(new java.awt.Color(255, 255, 255));
        revoke.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        revoke.setText("Revoquer les droits d'utilisateur");
        revoke.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 0))));
        revoke.setMargin(new java.awt.Insets(2, 1, 2, 1));
        revoke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revokeMouseClicked(evt);
            }
        });
        revoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revokeActionPerformed(evt);
            }
        });

        drop.setBackground(new java.awt.Color(255, 255, 255));
        drop.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        drop.setText("Supprimer  compte Utilisateur");
        drop.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        drop.setMargin(new java.awt.Insets(2, 1, 2, 1));
        drop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropMouseClicked(evt);
            }
        });
        drop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropActionPerformed(evt);
            }
        });

        tableauUtilisateur.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableauUtilisateur.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tableauUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane3.setViewportView(tableauUtilisateur);

        javax.swing.GroupLayout compteUtilisateurLayout = new javax.swing.GroupLayout(compteUtilisateur);
        compteUtilisateur.setLayout(compteUtilisateurLayout);
        compteUtilisateurLayout.setHorizontalGroup(
            compteUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compteUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(compteUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(compteUtilisateurLayout.createSequentialGroup()
                        .addComponent(revoke)
                        .addGap(36, 36, 36)
                        .addComponent(drop)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        compteUtilisateurLayout.setVerticalGroup(
            compteUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compteUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(compteUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(revoke)
                    .addComponent(drop))
                .addGap(37, 37, 37))
        );

        conteneurUtilisateur.addTab("Les comptes utilisateurs", compteUtilisateur);

        jTabbedPane37.addTab("Profil Utilisateur", conteneurUtilisateur);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "Changer votre mot de passe", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(51, 51, 255)))); // NOI18N
        jPanel1.setToolTipText("Changer votre mot de passe");

        NouveauMotDePasse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        NouveauMotDePasse.setForeground(new java.awt.Color(0, 0, 255));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Confirmer mot de passe");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Nouveau mot de passe");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Actuel mot de passe");

        modifyPassword.setBackground(new java.awt.Color(255, 255, 255));
        modifyPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        modifyPassword.setText("Modifier mot de passe");
        modifyPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 153, 153))));
        modifyPassword.setMargin(new java.awt.Insets(2, 1, 2, 1));
        modifyPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyPasswordMouseClicked(evt);
            }
        });

        actuelMotPasse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        actuelMotPasse.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                actuelMotPasseTextValueChanged(evt);
            }
        });

        confirmerNouveauMotDePasse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        confirmerNouveauMotDePasse.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                confirmerNouveauMotDePasseTextValueChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NouveauMotDePasse)
                    .addComponent(actuelMotPasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmerNouveauMotDePasse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(modifyPassword)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(actuelMotPasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(NouveauMotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(confirmerNouveauMotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(modifyPassword)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(597, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        jTabbedPane37.addTab("Paramétrage", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane37, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane37)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void grantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grantActionPerformed

    private void showTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showTablesActionPerformed

    private void ADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADActionPerformed

    private void BCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCActionPerformed

    private void BCdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCdeActionPerformed

    private void BRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BRActionPerformed

    private void BEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BEActionPerformed

    private void BSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BSActionPerformed

    private void CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatActionPerformed

    private void FacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacActionPerformed

    private void FacEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacEEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacEEActionPerformed

    private void FacRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacRActionPerformed

    private void FacTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FacTActionPerformed

    private void FrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FrsActionPerformed

    private void MagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MagActionPerformed

    private void MatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatActionPerformed

    private void ReparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReparActionPerformed

    private void ReparVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReparVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReparVActionPerformed

    private void SerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SerActionPerformed

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        String requete = this.textSQL.getText(); boolean isResultSet = false; 
         DefaultTableModel dtm  = new DefaultTableModel();
        Vector<String> entete = new Vector();
        Vector<String>  enregistrement;     
        if(!requete.isEmpty())
        {
            try 
            { 
                isResultSet = chargeur.execute(requete); 
                ResultSet rs = null;
                if(isResultSet == true)
                {
                    rs= chargeur.getResultSet();
                    int i = rs.getMetaData().getColumnCount(), t=0;
                    while(t<i) { entete.add(rs.getMetaData().getColumnName(t+1));t++;}
                    dtm.setColumnIdentifiers(entete);
                    while(rs.next())
                    {   
                        enregistrement = new Vector(); int u=0;
                        while(u<entete.size()){ enregistrement.add(rs.getString(u+1));u++;} 
                        dtm.addRow(enregistrement);        
                    }
                    this.tableauSQL.setModel(dtm);
                    this.textError.setVisible(false);
                }
                else
                {     
                    comboAfficher.setSelectedIndex(0);
                    this.tbPTables.setSelectedComponent(this.Afficher);
                    comboAfficher.setSelectedItem(getTableName(requete));
                }
                
            } catch (SQLException ex) 
            {
                this.textError.setText("Erreur SQL: "+ex.getMessage());
                this.textError.setVisible(true);
            }           
        }
    }//GEN-LAST:event_jButton7MouseClicked
public String getTableName(String requete)
{
    int  index = -1, t = 0, u = tables.size();
        while(t<u && index == -1)
        {
            index = requete.indexOf(tables.get(t).toString()); t++;   
        }
      return tables.get(t--).toString();
}
    
    private void comboAfficherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAfficherItemStateChanged
      int selectedRow=comboAfficher.getSelectedIndex();
        if(selectedRow > -1)
   {    
       DefaultTableModel dtm  = new DefaultTableModel();
       Vector<String> entete = new Vector();
       if(selectedRow!=0) 
          {
              String requete = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'dbCarder' AND TABLE_NAME='"+comboAfficher.getSelectedItem().toString()+"'";
              try 
                {
                     ResultSet rs = chargeur.executeQuery(requete);

                         while(rs.next())  
                         {                
                           entete.add(rs.getString(1));
                         }

                 } catch (SQLException ex) 
                 {
                     JOptionPane.showMessageDialog(this, ex);
                 }
              this.btModifier.setVisible(true);this.btSupprimer.setVisible(true);
            }
       else
            {
                entete.add("Tables");entete.add("Type de table");entete.add("Date de création");entete.add("Nombre d'enregistrements");entete.add("Taille moyenne par enregistrement");
                entete.add("Taille de la table"); this.btModifier.setVisible(false);this.btSupprimer.setVisible(false);
            }
       dtm.setColumnIdentifiers(entete);
       Vector<String> enregistrement;  String req = null;       
      if(selectedRow!=0) req = " select * from "+comboAfficher.getSelectedItem().toString()+" ";
      else  req=" select table_name , table_type , date(create_time) , table_rows , avg_row_length , data_length  from information_schema.tables where table_schema='dbcarder'";
        try 
        {   
            ResultSet rd = chargeur.executeQuery(req);
            while(rd.next())
            {   
                enregistrement = new Vector();
                int i=0, t=rd.getMetaData().getColumnCount();
                while(i<t){ enregistrement.addElement(rd.getString(i+1));i++;}
                dtm.addRow(enregistrement);
            }
            this.tableauAfficher.setModel(dtm); 
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
     }
    }//GEN-LAST:event_comboAfficherItemStateChanged

    private void comboStructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStructureItemStateChanged
           String  requete = "SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_OCTET_LENGTH, IS_NULLABLE, COLUMN_DEFAULT, COLUMN_KEY, EXTRA, ORDINAL_POSITION " +
            "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'dbCarder' AND TABLE_NAME='"+comboStructure.getSelectedItem().toString()+"'";
            modelStructure = new JStructureModel();
           try 
           {
            ResultSet rs = chargeur.executeQuery(requete);
            while(rs.next()) 
            {
              modelStructure.addStructure(new JStructure(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getInt(8)));
            }
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        } 
           this.tableauStructure.setModel(modelStructure);
           tableauStructure.getColumn("Colonnes").setWidth(100);
    }//GEN-LAST:event_comboStructureItemStateChanged

    private void comboInsererItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboInsererItemStateChanged
        ResultSet rs; model =new JInsererModele();
        try
        {
            rs= chargeur.executeQuery("SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_OCTET_LENGTH FROM INFORMATION_SCHEMA.COLUMNS " +
                "WHERE TABLE_SCHEMA = 'dbCarder' AND TABLE_NAME='"+comboInserer.getSelectedItem().toString()+"'");
              while(rs.next()) model.add(new JInserer(rs.getString("COLUMN_NAME"), rs.getString("DATA_TYPE"), rs.getInt("CHARACTER_OCTET_LENGTH")));
        }catch(SQLException e){JOptionPane.showMessageDialog(this, "Erreur SQL: "+e.getMessage());}
        
        tableauInserer.setDefaultRenderer(MyTextField.class, new JTableComponent());
        tableauInserer.setDefaultEditor(MyTextField.class, new DefaultCellEditor(new MyTextField()));
            tableauInserer.setModel(model);
        // Initialisons les clés primaires
        int i = comboInserer.getSelectedIndex();
        switch(i)
        {   case 1:try 
            {
                referenceAD();
            } catch (SQLException e) 
            {
            JOptionPane.showMessageDialog(this, e);
            }  break;
        case 2:try {
                referenceBC();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }break;
        case 3:try {
                referenceBCde();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }break;
        case 4:try {
                referenceBE();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }break;
            case 5:try {
                referenceBR();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } break;
            case 6:try {
                referenceBS();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }break;
            default: 
                if(i==8||i==13||i==18||i==20||i==23)
                { int compteur = 0;
            try {
                ResultSet rss = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='"+comboInserer.getSelectedItem().toString()+"' ");
                while(rss.next()) compteur = rss.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(JSectionAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
            } tableauInserer.setValueAt(""+compteur+"", 0,3);
                }break;
        }
    }//GEN-LAST:event_comboInsererItemStateChanged

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        boolean isInsert = false;String requete = null; String currentItem = comboInserer.getSelectedItem().toString();      
        try 
        {ResultSet rd = null;
            if(tableauInserer.getValueAt(0, 1).equals("double")||tableauInserer.getValueAt(0, 1).equals("int")||tableauInserer.getValueAt(0, 1).equals("tinyint")||tableauInserer.getValueAt(0, 1).equals("smallint")||tableauInserer.getValueAt(0, 1).equals("bigint"))
            {
                int ty = Integer.parseInt(model.getValue(0,3).toString());
                rd= chargeur.executeQuery("select "+tableauInserer.getValueAt(0, 0)+" from "+currentItem+" where "+tableauInserer.getValueAt(0, 0)+"= "+ty+" ");
            }
            else rd= chargeur.executeQuery("select "+tableauInserer.getValueAt(0, 0)+" from "+currentItem+" where "+tableauInserer.getValueAt(0, 0)+"= '"+model.getValue(0,3).toString()+"' ");
              isInsert =rd.first();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, " Erreur de vérification:  "+ex.getMessage());
        }
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(this, " Erreur de type de données:  "+ex.getMessage());
        }
       
       try{
        if(isInsert != true )
        {   boolean isAuto =false;
        requete = "insert  into "+currentItem+" values( ";ResultSet re = null;
        try
        {
            re = chargeur.executeQuery("select * from information_schema.columns where table_schema = 'dbCarder' and table_name='"+currentItem+"' and extra='auto_increment' ");
            if(re.isFirst()) isAuto =true;
        } catch (SQLException ex)
        {
            Logger.getLogger(JSectionAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i =0, t = model.getRowCount();
        while(i<t)
        {
            if(i==0)
            {   if(isAuto != true)
                {
                   if(tableauInserer.getValueAt(i, 1).equals("double")||tableauInserer.getValueAt(i, 1).equals("int")||tableauInserer.getValueAt(i, 1).equals("tinyint")||tableauInserer.getValueAt(i, 1).equals("smallint")||tableauInserer.getValueAt(i, 1).equals("bigint"))
                    {int ty = Integer.parseInt(model.getValue(i,3).toString());requete+= ""+ty+""; }
                   else requete+= "'"+model.getValue(i,3)+"'";
                   i++;
                }
                else requete+="null";
            }
            else
            {    
                if(tableauInserer.getValueAt(i, 1).equals("double")||tableauInserer.getValueAt(i, 1).equals("int")||tableauInserer.getValueAt(i, 1).equals("tinyint")||tableauInserer.getValueAt(i, 1).equals("smallint")||tableauInserer.getValueAt(i, 1).equals("bigint"))
                   {int ty = Integer.parseInt(model.getValue(i,3).toString());requete+= ","+ty+""; }
                else   requete+= ",'"+model.getValue(i,3)+"'";
                i++;
            }
        }
        requete+= ")";
        }
       else
        {
            requete = "update "+currentItem+" set " ;
            int i =1, t = model.getRowCount();
            while(i<t)
            {
                if(i==1)
                {  if(tableauInserer.getValueAt(i, 1).equals("double")||tableauInserer.getValueAt(i, 1).equals("int")||tableauInserer.getValueAt(i, 1).equals("tinyint")||tableauInserer.getValueAt(i, 1).equals("smallint")||tableauInserer.getValueAt(i, 1).equals("bigint"))
                {int ty = Integer.parseInt(model.getValue(i,3).toString());requete+= ""+tableauInserer.getValueAt(i, 0)+"="+ty+""; }
                else   requete+= ""+tableauInserer.getValueAt(i, 0)+"='"+model.getValue(i,3)+"'";
                i++;
                }
                else
                {    if(tableauInserer.getValueAt(i, 1).equals("double")||tableauInserer.getValueAt(i, 1).equals("int")||tableauInserer.getValueAt(i, 1).equals("tinyint")||tableauInserer.getValueAt(i, 1).equals("smallint")||tableauInserer.getValueAt(i, 1).equals("bigint"))
                {int ty = Integer.parseInt(model.getValue(i,3).toString());requete+= ","+tableauInserer.getValueAt(i, 0)+"="+ty+""; }
                else   requete+= ","+tableauInserer.getValueAt(i, 0)+"='"+model.getValue(i,3)+"'";
                i++;
                }
            }
            if(tableauInserer.getValueAt(0, 1).equals("double")||tableauInserer.getValueAt(0, 1).equals("int")||tableauInserer.getValueAt(0, 1).equals("tinyint")||tableauInserer.getValueAt(0, 1).equals("smallint")||tableauInserer.getValueAt(0, 1).equals("bigint"))
            {int ty = Integer.parseInt(model.getValue(0,3).toString());requete+= " where "+tableauInserer.getValueAt(0, 0)+"="+ty+""; }
            else requete+= " where "+tableauInserer.getValueAt(0, 0)+"= '"+model.getValue(0,3).toString()+"' ";
        }
       }catch (NumberFormatException ex) 
       {
            JOptionPane.showMessageDialog(this, " Erreur de format de données:  \n Veillez arrondir les nombres à virgule aux entiers près");
        }
        try 
        {   comboAfficher.setSelectedIndex(0);
            int a = chargeur.executeUpdate(requete);
            if(a==1)JOptionPane.showMessageDialog(this, "Insertion  ou modification réussie");
            this.tbPTables.setSelectedComponent(this.Afficher);
            comboAfficher.setSelectedItem(currentItem);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, " Erreur d'insertion ou de modification:  "+ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton8MouseClicked

    private void btModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierMouseClicked
        this.tbPTables.setSelectedComponent(this.Inserer);
        comboInserer.setSelectedItem(comboAfficher.getSelectedItem().toString());
        int i=0, t= tableauAfficher.getColumnCount(), s=tableauAfficher.getSelectedRow();
        if(s!=-1) {while(i<t){tableauInserer.setValueAt(tableauAfficher.getValueAt(s, i).toString(), i, 3);i++;}}
        else JOptionPane.showMessageDialog(this, "Selectionez un enregistrement !!! ");
    }//GEN-LAST:event_btModifierMouseClicked

    private void btSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerMouseClicked
         int i  = tableauAfficher.getSelectedRow(), t=comboAfficher.getSelectedIndex();
         if(i!=-1)
         {
             try 
             { int b=0;
                 if(tableauAfficher.getValueAt(i, 1).equals("double")||tableauAfficher.getValueAt(i, 1).equals("int")||tableauAfficher.getValueAt(i, 1).equals("tinyint")||tableauAfficher.getValueAt(i, 1).equals("smallint")||tableauAfficher.getValueAt(i, 1).equals("bigint"))            
                 b = chargeur.executeUpdate("delete from "+comboAfficher.getSelectedItem().toString()+" where "+tableauAfficher.getColumnName(0)+" = "+tableauAfficher.getValueAt(i, 0)+" ");
                 else b = chargeur.executeUpdate("delete from "+comboAfficher.getSelectedItem().toString()+" where "+tableauAfficher.getColumnName(0)+" = '"+tableauAfficher.getValueAt(i, 0)+"' ");
                  if(b==1){ comboAfficher.setSelectedIndex(0);JOptionPane.showMessageDialog(this, "La suppression a été bien effectuée");comboAfficher.setSelectedIndex(t);}
             } catch (SQLException ex) 
             {
                 JOptionPane.showMessageDialog(this, "Erreur SQL: "+ex.getMessage());
             }
         }
         else JOptionPane.showMessageDialog(this, "Selectionez un enregistrement !!! ");
    }//GEN-LAST:event_btSupprimerMouseClicked

    private void fonctionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fonctionItemStateChanged
        String fonction = this.fonction.getSelectedItem().toString();
        switch(fonction)
        {
            case "Administrateur": 
                this.select.setSelected(true); this.AD.setSelected(true);  this.BC.setSelected(true); this.BCde.setSelected(true);
                this.BE.setSelected(true); this.BR.setSelected(true); this.BS.setSelected(true);this.Cat.setSelected(true);
                this.Fac.setSelected(true);this.FacEE.setSelected(true);this.FacR.setSelected(true);this.FacT.setSelected(true);
                this.Frs.setSelected(true);this.Mag.setSelected(true);this.Mat.setSelected(true); this.Repar.setSelected(true);
                this.ReparV.setSelected(true);this.Ser.setSelected(true);this.User.setSelected(true);this.delete.setSelected(true);
                this.grant.setSelected(true);this.insert.setSelected(true);this.showTables.setSelected(true);this.update.setSelected(true);
                this.grant.setEnabled(true);this.showTables.setEnabled(true);
                this.AD.setEnabled(true);this.BC.setEnabled(true);this.BCde.setEnabled(true);this.BR.setEnabled(true);
                this.Fac.setEnabled(true);this.FacEE.setEnabled(true);this.FacR.setEnabled(true);this.FacT.setEnabled(true);
                this.Repar.setEnabled(true);this.ReparV.setEnabled(true);this.User.setEnabled(true); 
                this.BE.setEnabled(true);this.BS.setEnabled(true);this.Mag.setEnabled(true);
                break;
            case "C/Ch-ME":
                this.select.setSelected(true); this.AD.setSelected(true);  this.BC.setSelected(true); this.BCde.setSelected(true);
                this.BR.setSelected(true); this.Cat.setSelected(true);
                this.Fac.setSelected(true);this.FacEE.setSelected(true);this.FacR.setSelected(true);this.FacT.setSelected(true);
                this.Frs.setSelected(true);this.Mat.setSelected(true); this.Repar.setSelected(true);
                this.ReparV.setSelected(true);this.Ser.setSelected(true);this.delete.setSelected(true);
                this.insert.setSelected(true);this.update.setSelected(true);
                this.AD.setEnabled(true);this.BC.setEnabled(true);this.BCde.setEnabled(true);this.BR.setEnabled(true);
                this.Fac.setEnabled(true);this.FacEE.setEnabled(true);this.FacR.setEnabled(true);this.FacT.setEnabled(true);
                this.Repar.setEnabled(true);this.Repar.setEnabled(true);this.ReparV.setEnabled(true);
                this.BE.setEnabled(false);this.BS.setEnabled(false);this.Mag.setEnabled(false);
                this.grant.setEnabled(false);this.showTables.setEnabled(false);
                break;
            case "Magasinier":
                this.select.setSelected(true); this.insert.setSelected(true);this.update.setSelected(true);
                this.BE.setSelected(true);  this.BS.setSelected(true);this.Cat.setSelected(true); this.Frs.setSelected(true);
                this.Mag.setSelected(true);this.Mat.setSelected(true); this.Ser.setSelected(true);this.delete.setSelected(true);
                this.AD.setEnabled(false);this.BC.setEnabled(false);this.BCde.setEnabled(false);this.BR.setEnabled(false);
                this.Fac.setEnabled(false);this.FacEE.setEnabled(false);this.FacR.setEnabled(false);this.FacT.setEnabled(false);
                this.Repar.setEnabled(false);this.Repar.setEnabled(false);this.ReparV.setEnabled(false);
                this.BE.setEnabled(true);this.BS.setEnabled(true);this.Mag.setEnabled(true);
                this.grant.setEnabled(false);this.showTables.setEnabled(false);
                break;
            case "Ch-ME":
                this.select.setSelected(true); this.AD.setSelected(true);  this.BC.setSelected(true); this.BCde.setSelected(true);
                this.BE.setSelected(true); this.BR.setSelected(true); this.BS.setSelected(true);this.Cat.setSelected(true);
                this.Fac.setSelected(true);this.FacEE.setSelected(true);this.FacR.setSelected(true);this.FacT.setSelected(true);
                this.Frs.setSelected(true);this.Mag.setSelected(true);this.Mat.setSelected(true); this.Repar.setSelected(true);
                this.ReparV.setSelected(true);this.Ser.setSelected(true);this.delete.setSelected(true);
                this.insert.setSelected(true);this.update.setSelected(true);
                this.User.setEnabled(false);this.grant.setEnabled(false);this.showTables.setEnabled(false);
                this.Repar.setEnabled(true);this.Repar.setEnabled(true);this.ReparV.setEnabled(true);
                this.BE.setEnabled(true);this.BS.setEnabled(true);this.Mag.setEnabled(true);
                break;
            default: 
                this.select.setSelected(false); this.AD.setSelected(false);  this.BC.setSelected(false); this.BCde.setSelected(false);
                this.BE.setSelected(false); this.BR.setSelected(false); this.BS.setSelected(false);this.Cat.setSelected(false);
                this.Fac.setSelected(false);this.FacEE.setSelected(false);this.FacR.setSelected(false);this.FacT.setSelected(false);
                this.Frs.setSelected(false);this.Mag.setSelected(false);this.Mat.setSelected(false); this.Repar.setSelected(false);
                this.ReparV.setSelected(false);this.Ser.setSelected(false);this.User.setSelected(false);this.delete.setSelected(false);
                this.grant.setSelected(false);this.insert.setSelected(false);this.showTables.setSelected(false);this.update.setSelected(false);
                this.AD.setEnabled(true);this.BC.setEnabled(true);this.BCde.setEnabled(true);this.BR.setEnabled(true);
                this.Fac.setEnabled(true);this.FacEE.setEnabled(true);this.FacR.setEnabled(true);this.FacT.setEnabled(true);
                this.Repar.setEnabled(true);this.ReparV.setEnabled(true);
                this.BE.setEnabled(true);this.BS.setEnabled(true);this.Mag.setEnabled(true);
                this.grant.setEnabled(true);this.showTables.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_fonctionItemStateChanged

    private void createUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createUserMouseClicked
        if(!nom.getText().isEmpty() && !prenom.getText().isEmpty()&& !IP.getText().isEmpty()&& !motDePasse.getText().isEmpty()&&!confirmerMotDePasse.getText().isEmpty() && fonction.getSelectedIndex()!=0)
        {
            this.creerUtilisateur.setEnabled(false);
            String utilisateur= "insert into Utilisateur values( null, '"+nom.getText()+"', '"+prenom.getText()+"', '"+motDePasse.getText()+"', '"+fonction.getSelectedItem().toString()+"', '"+IP.getText()+"')",
                revoke =null, grantt=null, user = "CREATE USER "+nom.getText()+prenom.getText()+"@"+IP.getText()+" IDENTIFIED BY '"+motDePasse.getText()+"'";
            int i =fonction.getSelectedIndex(); String[] g = null;
            if(motDePasse.getText().equalsIgnoreCase(confirmerMotDePasse.getText()))
            { int b =0,c=0,d=0;
               switch(i)
                    {
                        case 1: 
                             grantt = "GRANT ALL PRIVILEGES ON *.* TO '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' WITH GRANT OPTION";
                              try 
                              { 
                                  b= chargeur.executeUpdate(utilisateur); c=chargeur.executeUpdate(user); d=chargeur.executeUpdate(grantt);
                                 if(d==0&&c==0&&b==1)JOptionPane.showMessageDialog(this,"Cet utilisateur a été bien ajouté ! \n Son mot de passe est '"+motDePasse.getText()+"' ");

                              } catch (SQLException ex) 
                              {
                                   try{
                                   JOptionPane.showMessageDialog(this, "Erreur SQL 1: "+ex+"\n Veillez reprendre l'opération");
                                   if(c==0&&b==1)
                                   {                                        
                                        int compteur = 0;
                                        ResultSet rs = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='utilisateur' ");
                                        while(rs.next()) compteur = rs.getInt(1)-1;
                                        chargeur.executeUpdate("drop USER  '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' ");
                                        chargeur.executeUpdate("delete from Utilisateur where numUtilisateur ="+compteur+"");
                                  }
                                else
                                  {
                                    if(b==1)
                                    {
                                        int compteur = 0;

                                        ResultSet rs = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='utilisateur' ");
                                        while(rs.next()) compteur = rs.getInt(1)-1;
                                        chargeur.executeUpdate("drop USER  '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' ");
                                        chargeur.executeUpdate("delete from Utilisateur where numUtilisateur ="+compteur+"");
                                    }
                                }
                                }catch(SQLException e){JOptionPane.showMessageDialog(this, "Erreur SQL: "+ex+"\n Veillez reprendre l'opération");}   
                                 }
                             break;
                        default: 
                            grantt = "GRANT SELECT, INSERT, UPDATE, DELETE ON dbCarder.* TO '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' WITH GRANT OPTION";
                            revoke = "REVOKE SELECT, INSERT, UPDATE, DELETE ON dbCarder.Utilisateur from '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"'";
                        try 
                        {    b= chargeur.executeUpdate(utilisateur); c=chargeur.executeUpdate(user); d=chargeur.executeUpdate(grantt);//int e=chargeur.executeUpdate(revoke);
                            if(d==0&&/*e==0&&*/c==0&&b==1)JOptionPane.showMessageDialog(this,"Cet utilisateur a été bien ajouté ! \n Son mot de passe est '"+motDePasse.getText()+"' ");

                        } catch (SQLException ex) 
                           {JOptionPane.showMessageDialog(this, "Erreur SQL:2 "+ex+"\n Veillez reprendre l'opération");
                            try
                            {
                               
                               if(c==0&&b==1)
                               {                                   
                                   int compteur = 0;
                                   ResultSet rs = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='utilisateur' ");
                                   while(rs.next()) compteur = rs.getInt(1)-1;
                                   chargeur.executeUpdate("drop USER  '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' ");
                                   chargeur.executeUpdate("delete from Utilisateur where numUtilisateur ="+compteur+"");
                              }
                              else
                              {
                                   if(b==1)
                                   {   
                                       int compteur = 0;
                                       ResultSet rs = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='utilisateur' ");
                                       while(rs.next()) compteur = rs.getInt(1)-1;
                                       chargeur.executeUpdate("drop USER  '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' ");
                                       chargeur.executeUpdate("delete from Utilisateur where numUtilisateur ="+compteur+"");
                                   }
                               }
                           }catch(SQLException e){JOptionPane.showMessageDialog(this, "Erreur SQL: "+ex+"\n Veillez reprendre l'opération");}    
                                      break;
                       }
               }          
                                           
            }
            else JOptionPane.showMessageDialog(this, "Les deux mots de passe ne sont pas conformes !\n Veillez les uniformiser ");
            conteneurUtilisateur.setSelectedComponent(compteUtilisateur);initTableauUtilisateur();
        }
        else JOptionPane.showMessageDialog(this, " Veillez renseigner tous les champs ");
        this.creerUtilisateur.setEnabled(true);
        
    }//GEN-LAST:event_createUserMouseClicked

    private void revokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revokeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_revokeActionPerformed

    private void dropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropActionPerformed

    private void dropUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropUserMouseClicked
    try {   
              int compteur = 0;
              ResultSet rs = chargeur.executeQuery("select auto_increment from information_schema.tables where table_schema = 'dbCarder' and table_name='utilisateur' ");
              while(rs.next()) compteur = rs.getInt(1)-1;
              chargeur.executeUpdate("delete from Utilisateur where numUtilisateur ="+compteur+"");                                    
              chargeur.executeUpdate("drop USER  '"+nom.getText().concat(prenom.getText())+"'@'"+IP.getText()+"' ");
              JOptionPane.showMessageDialog(this, "Opération denregistrement annulé");
         }catch(SQLException e){JOptionPane.showMessageDialog(this, "Un problème est survenu \n Veillez supprimer ce compte plus tard !");}
    }//GEN-LAST:event_dropUserMouseClicked

    private void revokeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revokeMouseClicked
         int i = tableauUtilisateur.getSelectedRow();
         if(i!=0)
         {
             
         }
    }//GEN-LAST:event_revokeMouseClicked

    private void tbPTablesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbPTablesStateChanged
        if(tbPTables.getSelectedComponent()==Afficher && nombre !=0)
        {             
                initTableauAfficher();nombre++;
               comboAfficher.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tbPTablesStateChanged

    private void dropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropMouseClicked
         int ligne = tableauUtilisateur.getSelectedRow();
         if(ligne!=-1)
         {
            int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cet Utilisateur ", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION)
            {
                try 
                {
                    chargeur.executeUpdate("drop USER  '"+tableauUtilisateur.getValueAt(ligne, 0)+"'@'"+tableauUtilisateur.getValueAt(ligne, 1)+"' ");
                } catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(this, "Un problème est survenu \n Veillez reprendre la suppression de ce compte plus tard !");
                }initTableauUtilisateur();
            }
         }
    }//GEN-LAST:event_dropMouseClicked

    private void nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c))&& (c!=KeyEvent.VK_SPACE) && (c!=KeyEvent.VK_BACK_SPACE))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_nomKeyTyped

    private void modifyPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyPasswordMouseClicked
        String text1 = NouveauMotDePasse.getText(), text2= confirmerNouveauMotDePasse.getText(),text = actuelMotPasse.getText();
        if(text2.equals(text1))
        {
            int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier votre mot de passe ", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION)
            {      
                try {                    
                    chargeur.executeUpdate("update Utilisateur set motDePas='"+text1+"' where numUtilisateur="+this.numUtilisateur+" and motDePas ='"+text+"' ");
                    chargeur.executeUpdate("UPDATE mysql.user SET Password = PASSWORD('"+text1+"') WHERE User = '"+this.user+"' AND Host = '"+this.Host+"'");
                    chargeur.executeUpdate("FLUSH PRIVILEGES");
                    JOptionPane.showMessageDialog(this, "Modification réussie");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur SQL: "+ex.getMessage()+" \n Veillez les uniformiser !");
                }
            }
        }
        else JOptionPane.showMessageDialog(this, "Les deux (2) nouveaux mots de passe ne sont conformes \n Veillez les uniformiser !");
    }//GEN-LAST:event_modifyPasswordMouseClicked

    private void actuelMotPasseTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_actuelMotPasseTextValueChanged
        String text = actuelMotPasse.getText();ResultSet rs;
        if(text.equals(this.Password)){modifyPassword.setVisible(true);}
            else modifyPassword.setVisible(false);
    }//GEN-LAST:event_actuelMotPasseTextValueChanged

    private void confirmerNouveauMotDePasseTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_confirmerNouveauMotDePasseTextValueChanged
        String text1 = NouveauMotDePasse.getText(), text2= confirmerNouveauMotDePasse.getText();
        if(text2.equals(text1))
        {
            confirmerNouveauMotDePasse.setForeground(new java.awt.Color(0,0,255));
        }
        else confirmerNouveauMotDePasse.setForeground(new java.awt.Color(255, 0, 51));
    }//GEN-LAST:event_confirmerNouveauMotDePasseTextValueChanged

    /**
     * 
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
            java.util.logging.Logger.getLogger(JSectionAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSectionAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSectionAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSectionAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
          public void run() {
               new JSectionAdministrateur(26,"localhost","AKS","1990").setVisible(true);
         }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AD;
    private javax.swing.JPanel Afficher;
    private javax.swing.JCheckBox BC;
    private javax.swing.JCheckBox BCde;
    private javax.swing.JCheckBox BE;
    private javax.swing.JCheckBox BR;
    private javax.swing.JCheckBox BS;
    private javax.swing.JCheckBox Cat;
    private javax.swing.JCheckBox Fac;
    private javax.swing.JCheckBox FacEE;
    private javax.swing.JCheckBox FacR;
    private javax.swing.JCheckBox FacT;
    private javax.swing.JCheckBox Frs;
    private javax.swing.JTextField IP;
    private javax.swing.JPanel Inserer;
    private javax.swing.JCheckBox Mag;
    private javax.swing.JCheckBox Mat;
    private javax.swing.JPasswordField NouveauMotDePasse;
    private javax.swing.JCheckBox Repar;
    private javax.swing.JCheckBox ReparV;
    private javax.swing.JCheckBox Ser;
    private javax.swing.JCheckBox User;
    private java.awt.TextField actuelMotPasse;
    private javax.swing.JPanel administration;
    private javax.swing.JButton btModifier;
    private javax.swing.JButton btSupprimer;
    private javax.swing.JComboBox comboAfficher;
    private javax.swing.JComboBox comboInserer;
    private javax.swing.JComboBox comboStructure;
    private javax.swing.JPanel compteUtilisateur;
    private javax.swing.JPasswordField confirmerMotDePasse;
    private java.awt.TextField confirmerNouveauMotDePasse;
    private javax.swing.JTabbedPane conteneurUtilisateur;
    private javax.swing.JButton createUser;
    private javax.swing.JPanel creerUtilisateur;
    private javax.swing.JCheckBox delete;
    private javax.swing.JButton drop;
    private javax.swing.JButton dropUser;
    private javax.swing.JComboBox fonction;
    private javax.swing.JCheckBox grant;
    private javax.swing.JCheckBox insert;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane37;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JButton modifyPassword;
    private javax.swing.JPasswordField motDePasse;
    private javax.swing.JTextField nom;
    private javax.swing.JPanel plSQL;
    private javax.swing.JPanel plStructure;
    private javax.swing.JTextField prenom;
    private javax.swing.JButton revoke;
    private javax.swing.JCheckBox select;
    private javax.swing.JCheckBox showTables;
    private javax.swing.JTable tableauAfficher;
    private javax.swing.JTable tableauInserer;
    private javax.swing.JTable tableauSQL;
    private javax.swing.JTable tableauStructure;
    private javax.swing.JTable tableauUtilisateur;
    private javax.swing.JTabbedPane tbPTables;
    private javax.swing.JTextPane textError;
    private javax.swing.JTextPane textSQL;
    private javax.swing.JCheckBox update;
    // End of variables declaration//GEN-END:variables
     
}
