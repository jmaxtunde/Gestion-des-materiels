package sgme.carder;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
  * @author Senghor AKOMINON
 */
public class JSectionCCME extends JFrame {

    private int  numUtilisateur = 0, lignePassee = -1, lignePasseeAuto = -1, lignePasseeBCde = -1,annee = 0, moi = 0, jour = 0;
    private String cod = null;
    private JDBConnection connexion = new JDBConnection();
    private Statement chargeur;
    private JTravailSignaleModel travauxSignaleModel = new JTravailSignaleModel();
    private JListeBRModel listeModel = new JListeBRModel();
    private JListeBCdeModel listeBCdeModel = new JListeBCdeModel();
    private JProduitCommandeModel listeProduitCde = new JProduitCommandeModel();
    private JListeAutorisationModel listeAutoModel = new JListeAutorisationModel();
    private JListeBCModel listeBCModel = new JListeBCModel();
    private String Host = null, User = null, Password =null;
    //private TableRowSorter<TableModel> trieur;

    public JSectionCCME(int numUtilisateur,String Host, String User, String Password) throws SQLException {
        this.numUtilisateur = numUtilisateur;this.Host = Host;this.User = User; this.Password = Password;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();this.setLocationRelativeTo(null);
        this.lb2.setVisible(false);
        this.tfRefADBC.setVisible(false);
        try {
            chargeur = connexion.getJDBConnection(Host, User, Password).createStatement();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Un problème s'est produit lors du chargement  !!! \n"+e.getMessage());
        }
        
        tfImmtriculation.setEnabled(false);
        btImprimerBR.setEnabled(false);
        Calendar calendrier;
        calendrier = Calendar.getInstance();
        annee = calendrier.get(Calendar.YEAR);
        moi = calendrier.get(Calendar.MONTH) + 1;
        jour = calendrier.get(Calendar.DATE);
        comboNomPrestataire.setForeground(new java.awt.Color(204,204,204));
        initialiser();
        // Icon de l'application
        Image img = null;
        try {
            img = ImageIO.read(new File("icon1.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(img);
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
        int annee1 = dateChooser.getCalendar().get(Calendar.YEAR);
        int moi1  = dateChooser.getCalendar().get(Calendar.MONTH)+1;
        int jour1 = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);        
        return annee1+"/"+getDayMonthFormat(moi1)+"/"+getDayMonthFormat(jour1);
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
    private void initialiser() throws SQLException {
        referenceBR();
        initialiserPrestataire();
        initialiserCategorie();
        initialiserMateriel();
        adressePrestataire();
        initialiserTableauBR();
        // Pour BCde
        referenceBCde();
        initialiserFournisseurs();
        initialiserCategorieMaterielCommande();
        initialiserMaterielCommande();
        initialiserTableauBCde();
        // pour Autorisation de dépense
        referenceAutorisation();
        initialiserTableauAutorisation();
        // Pour BC
        referenceBC();
        initialiserReferenceAD();
        initialiserTableauBC();
        initComponentFacture();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        tabbedPaneGererBonCommande = new javax.swing.JTabbedPane();
        panelGererBonCommande = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tfRechercheBCde = new javax.swing.JTextField();
        btRechercherBCde = new javax.swing.JButton();
        plNouveauBCde = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfRefBCde = new javax.swing.JTextField();
        tfLieuLivraison = new javax.swing.JTextField();
        comboFrs = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        comboCategorieMaterielCommande = new javax.swing.JComboBox();
        comboMaterielcommande = new javax.swing.JComboBox();
        btAjouterProduit = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableauProduitCommande = new javax.swing.JTable();
        tfQuantiteCommandee = new javax.swing.JTextField();
        tfDateLivraison = new com.toedter.calendar.JDateChooser();
        tfDateEditionBCde = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableauBCde = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        btEnregistrerBCde = new javax.swing.JButton();
        btModifierBCde = new javax.swing.JButton();
        btSupprimerBCde = new javax.swing.JButton();
        btImprimerBCde = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelGererAutorisationDepense = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        tfRecherche2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableauAutorisation = new javax.swing.JTable();
        plNouveauAD = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tfRefAD = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tfObjetAutorisation = new javax.swing.JTextArea();
        tfDateEditionAD = new com.toedter.calendar.JDateChooser();
        tfMontantDepense = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btEnregistrerAD = new javax.swing.JButton();
        btModifierAD = new javax.swing.JButton();
        btSupprimerAD = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btImprimerAD = new javax.swing.JButton();
        panelGererBonCaisse = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        tfRecherche3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableauBC = new javax.swing.JTable();
        plNouveauBC = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tfRefBC = new javax.swing.JTextField();
        comboRefAD = new javax.swing.JComboBox();
        tfRefADBC = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        tfDateEditionBC = new com.toedter.calendar.JDateChooser();
        jPanel18 = new javax.swing.JPanel();
        btEnregistrerBC = new javax.swing.JButton();
        btModifierBC = new javax.swing.JButton();
        btSupprimerBC = new javax.swing.JButton();
        btImprimerBC = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelGererBonReparation = new javax.swing.JPanel();
        plNouveauBR = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfNumeroBR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfRefDR = new javax.swing.JTextField();
        tfAdressePrestataire = new javax.swing.JTextField();
        tfImmtriculation = new javax.swing.JTextField();
        comboMateriel = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tReparation = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        comboNomPrestataire = new javax.swing.JComboBox();
        comboCategorie = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btAjouter = new javax.swing.JButton();
        tfMO = new javax.swing.JTextField();
        tfCoutPiece = new javax.swing.JTextField();
        tfTravailSignale = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableauTravauxSignales = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        tfNatureReparation = new javax.swing.JTextField();
        tfDateEditionBR = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        tfRecherche = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableauListeBR = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btEnregistrerBR = new javax.swing.JButton();
        btModifierBR = new javax.swing.JButton();
        btSupprimerBR = new javax.swing.JButton();
        btImprimerBR = new javax.swing.JButton();
        btFicheSuivi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelGererFacture = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        tfRecherche4 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableauFacture = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        tfDateEditionFac = new com.toedter.calendar.JDateChooser();
        comboTypeFacture = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        comboFsrFacture = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        lbDate = new javax.swing.JLabel();
        tfDateFacture = new com.toedter.calendar.JDateChooser();
        lbDestination = new javax.swing.JLabel();
        tfDestination = new javax.swing.JTextField();
        lbNumeroFacture = new javax.swing.JLabel();
        lbTelephone = new javax.swing.JLabel();
        tfNumeroFacture = new javax.swing.JTextField();
        tfTelephone = new javax.swing.JFormattedTextField();
        lbService = new javax.swing.JLabel();
        tfService = new javax.swing.JTextField();
        lbMontant = new javax.swing.JLabel();
        tfMontant = new javax.swing.JFormattedTextField();
        tfCompteur = new javax.swing.JFormattedTextField();
        lbCompteur = new javax.swing.JLabel();
        lbPolice = new javax.swing.JLabel();
        tfPolice = new javax.swing.JTextField();
        lbPeriode = new javax.swing.JLabel();
        tfPeriode = new javax.swing.JFormattedTextField();
        jPanel19 = new javax.swing.JPanel();
        btEnregistrerFac = new javax.swing.JButton();
        btModifierFac = new javax.swing.JButton();
        btSupprimerFac = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tabbedPaneGererBonCommande.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneGererBonCommande.setAutoscrolls(true);
        tabbedPaneGererBonCommande.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tabbedPaneGererBonCommande.setPreferredSize(new java.awt.Dimension(1216, 755));

        panelGererBonCommande.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 255));
        jLabel18.setText("CARDER Borgou / Alibori");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("********");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("Service de Matériels et d'entretiens");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)), "RECHERCHER UN BON DE COMMANDE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        tfRechercheBCde.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btRechercherBCde.setBackground(new java.awt.Color(255, 255, 255));
        btRechercherBCde.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btRechercherBCde.setText("Recherche");
        btRechercherBCde.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 204))));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfRechercheBCde, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRechercherBCde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRechercheBCde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRechercherBCde)))
        );

        plNouveauBCde.setBackground(new java.awt.Color(255, 255, 255));
        plNouveauBCde.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "NOUVEAU BON DE COMMANDE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Reférence Bon de Commande");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel31.setText("Date de  Livraison");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Lieu de Livraison");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Date d'édition");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("Fournisseur");

        tfRefBCde.setEditable(false);
        tfRefBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfRefBCde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRefBCde.setText("++++++++++++++++");
        tfRefBCde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRefBCdeActionPerformed(evt);
            }
        });

        tfLieuLivraison.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfLieuLivraison.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        comboFrs.setEditable(true);
        comboFrs.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboFrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir fournisseur" }));
        comboFrs.setFocusable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(153, 255, 255)), "AJOUTER UN MATERIEL A COMMANDER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N

        comboCategorieMaterielCommande.setEditable(true);
        comboCategorieMaterielCommande.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        comboCategorieMaterielCommande.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir catégorie" }));
        comboCategorieMaterielCommande.setBorder(null);
        comboCategorieMaterielCommande.setFocusable(false);

        comboMaterielcommande.setEditable(true);
        comboMaterielcommande.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        comboMaterielcommande.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choisir matériel" }));
        comboMaterielcommande.setBorder(null);
        comboMaterielcommande.setFocusable(false);

        btAjouterProduit.setBackground(new java.awt.Color(255, 255, 255));
        btAjouterProduit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btAjouterProduit.setText("Ajouter");
        btAjouterProduit.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btAjouterProduit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAjouterProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAjouterProduitMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Quantité commandée");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Matériel");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Catégorie matériel");

        tableauProduitCommande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        tableauProduitCommande.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tableauProduitCommande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"++++++++", "++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++", "++++++++"},
                {null, "", "Total", null, "++++++++"}
            },
            new String [] {
                "Catégorie", "Matériel", "Quantité ", "Prix Unitaire", "Montant"
            }
        ));
        tableauProduitCommande.setToolTipText("");
        tableauProduitCommande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableauProduitCommande.setGridColor(new java.awt.Color(255, 255, 255));
        tableauProduitCommande.setSelectionForeground(new java.awt.Color(255, 102, 51));
        jScrollPane13.setViewportView(tableauProduitCommande);

        tfQuantiteCommandee.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        tfQuantiteCommandee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQuantiteCommandeeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCategorieMaterielCommande, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(comboMaterielcommande, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel36)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfQuantiteCommandee)
                                .addGap(18, 18, 18)
                                .addComponent(btAjouterProduit))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel37)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAjouterProduit)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboMaterielcommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategorieMaterielCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfQuantiteCommandee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        tfDateLivraison.setBackground(new java.awt.Color(255, 255, 255));
        tfDateLivraison.setToolTipText("Date de livraison");
        tfDateLivraison.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tfDateEditionBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout plNouveauBCdeLayout = new javax.swing.GroupLayout(plNouveauBCde);
        plNouveauBCde.setLayout(plNouveauBCdeLayout);
        plNouveauBCdeLayout.setHorizontalGroup(
            plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(plNouveauBCdeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfRefBCde, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(tfLieuLivraison, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(comboFrs, 0, 187, Short.MAX_VALUE)
                    .addComponent(tfDateLivraison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDateEditionBCde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, plNouveauBCdeLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plNouveauBCdeLayout.setVerticalGroup(
            plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauBCdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRefBCde, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(tfDateLivraison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLieuLivraison, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDateEditionBCde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBCdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFrs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(421, 421, 421))
        );

        tableauBCde.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        tableauBCde.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tableauBCde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"}
            },
            new String [] {
                "Reférence", "Date Livraison", "Lieu Livraison", "Fournisseur"
            }
        ));
        tableauBCde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableauBCde.setSelectionForeground(new java.awt.Color(255, 153, 51));
        tableauBCde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauBCdeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableauBCde);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btEnregistrerBCde.setBackground(new java.awt.Color(255, 255, 255));
        btEnregistrerBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEnregistrerBCde.setText("Enregistrer");
        btEnregistrerBCde.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 255))));
        btEnregistrerBCde.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btEnregistrerBCde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBCdeMouseClicked(evt);
            }
        });

        btModifierBCde.setBackground(new java.awt.Color(255, 255, 255));
        btModifierBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModifierBCde.setText("Modifier");
        btModifierBCde.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 255))));
        btModifierBCde.setEnabled(false);
        btModifierBCde.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btModifierBCde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBCdeMouseClicked(evt);
            }
        });

        btSupprimerBCde.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimerBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSupprimerBCde.setText("Supprimer");
        btSupprimerBCde.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 255))));
        btSupprimerBCde.setEnabled(false);
        btSupprimerBCde.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btSupprimerBCde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBCdeMouseClicked(evt);
            }
        });

        btImprimerBCde.setBackground(new java.awt.Color(255, 255, 255));
        btImprimerBCde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btImprimerBCde.setText("Imprimer");
        btImprimerBCde.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 255))));
        btImprimerBCde.setEnabled(false);
        btImprimerBCde.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btImprimerBCde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBCdeMouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Retour");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 204, 255))));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEnregistrerBCde)
                .addGap(18, 18, 18)
                .addComponent(btImprimerBCde)
                .addGap(23, 23, 23)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btModifierBCde)
                .addGap(18, 18, 18)
                .addComponent(btSupprimerBCde)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btModifierBCde)
                    .addComponent(btSupprimerBCde)
                    .addComponent(btImprimerBCde)
                    .addComponent(btEnregistrerBCde)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGererBonCommandeLayout = new javax.swing.GroupLayout(panelGererBonCommande);
        panelGererBonCommande.setLayout(panelGererBonCommandeLayout);
        panelGererBonCommandeLayout.setHorizontalGroup(
            panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                .addGroup(panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plNouveauBCde, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                            .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                                .addGroup(panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addGroup(panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );
        panelGererBonCommandeLayout.setVerticalGroup(
            panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGererBonCommandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGererBonCommandeLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(plNouveauBCde, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        tabbedPaneGererBonCommande.addTab("Gérer les bons de commande", panelGererBonCommande);

        panelGererAutorisationDepense.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 255));
        jLabel21.setText("CARDER Borgou / Alibori");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("********");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("Service de Matériels et d'entretiens");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "RECHERCHER UNE AUTORISATION DE DEPENSE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N

        tfRecherche2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton8.setText("Recherche");
        jButton8.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        jButton8.setMargin(new java.awt.Insets(2, 1, 2, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(tfRecherche2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRecherche2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)))
        );

        tableauAutorisation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        tableauAutorisation.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tableauAutorisation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {"++++++++", "++++++++", null, "++++++++"}
            },
            new String [] {
                "Reférence", "Objet ", "Montant", "Date Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableauAutorisation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableauAutorisation.setSelectionForeground(new java.awt.Color(255, 153, 51));
        tableauAutorisation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauAutorisationMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableauAutorisation);

        plNouveauAD.setBackground(new java.awt.Color(255, 255, 255));
        plNouveauAD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "NOUVELLE AUTORISATION DE DEPENSE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N
        plNouveauAD.setForeground(new java.awt.Color(51, 0, 51));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel38.setText("Objet de l'autorisation");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel39.setText("Référence Autorisation");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel40.setText("Montant de la dépense");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel41.setText("Date d'édition Autorisation");

        tfRefAD.setEditable(false);
        tfRefAD.setColumns(12);
        tfRefAD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfRefAD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRefAD.setText("++++++++++++++++");

        tfObjetAutorisation.setColumns(25);
        tfObjetAutorisation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfObjetAutorisation.setRows(2);
        tfObjetAutorisation.setText("\n\n");
        jScrollPane9.setViewportView(tfObjetAutorisation);

        tfDateEditionAD.setBackground(new java.awt.Color(255, 255, 255));
        tfDateEditionAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tfMontantDepense.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfMontantDepense.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMontantDepenseKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout plNouveauADLayout = new javax.swing.GroupLayout(plNouveauAD);
        plNouveauAD.setLayout(plNouveauADLayout);
        plNouveauADLayout.setHorizontalGroup(
            plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauADLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plNouveauADLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDateEditionAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(plNouveauADLayout.createSequentialGroup()
                        .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tfRefAD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMontantDepense, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(25, 25, 25))
        );
        plNouveauADLayout.setVerticalGroup(
            plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauADLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRefAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plNouveauADLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(plNouveauADLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMontantDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(plNouveauADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDateEditionAD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btEnregistrerAD.setBackground(new java.awt.Color(255, 255, 255));
        btEnregistrerAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEnregistrerAD.setText("Enregistrer");
        btEnregistrerAD.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btEnregistrerAD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btEnregistrerAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerADMouseClicked(evt);
            }
        });

        btModifierAD.setBackground(new java.awt.Color(255, 255, 255));
        btModifierAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModifierAD.setText("Modifier");
        btModifierAD.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btModifierAD.setEnabled(false);
        btModifierAD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btModifierAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierADMouseClicked(evt);
            }
        });

        btSupprimerAD.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimerAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSupprimerAD.setText("Supprimer");
        btSupprimerAD.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btSupprimerAD.setEnabled(false);
        btSupprimerAD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btSupprimerAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerADMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Retour");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        jButton2.setMargin(new java.awt.Insets(2, 1, 2, 1));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        btImprimerAD.setBackground(new java.awt.Color(255, 255, 255));
        btImprimerAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btImprimerAD.setText("Imprimer");
        btImprimerAD.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btImprimerAD.setEnabled(false);
        btImprimerAD.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btImprimerAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerADMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEnregistrerAD)
                    .addComponent(btModifierAD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btImprimerAD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSupprimerAD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEnregistrerAD)
                            .addComponent(btImprimerAD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSupprimerAD)
                            .addComponent(btModifierAD)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGererAutorisationDepenseLayout = new javax.swing.GroupLayout(panelGererAutorisationDepense);
        panelGererAutorisationDepense.setLayout(panelGererAutorisationDepenseLayout);
        panelGererAutorisationDepenseLayout.setHorizontalGroup(
            panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addGroup(panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererAutorisationDepenseLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)))
                        .addContainerGap())
                    .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                        .addGroup(panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plNouveauAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererAutorisationDepenseLayout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererAutorisationDepenseLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))))
        );
        panelGererAutorisationDepenseLayout.setVerticalGroup(
            panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGererAutorisationDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelGererAutorisationDepenseLayout.createSequentialGroup()
                        .addComponent(plNouveauAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        tabbedPaneGererBonCommande.addTab("Gérer les autorisations de dépenses", panelGererAutorisationDepense);

        panelGererBonCaisse.setBackground(new java.awt.Color(255, 255, 255));
        panelGererBonCaisse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 255));
        jLabel24.setText("CARDER Borgou / Alibori");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("********");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("Service de Matériels et d'entretiens");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "RECHERCHER UN BON DE CAISSE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        tfRecherche3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton9.setText("Recherche");
        jButton9.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfRecherche3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRecherche3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tableauBC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        tableauBC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tableauBC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"},
                {"++++++", "+++++++", "+++++++", "+++++++"}
            },
            new String [] {
                "Objet", "Reférence BC", "Ref Autorisation", "Montant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableauBC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableauBC.setSelectionForeground(new java.awt.Color(255, 153, 51));
        tableauBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauBCMouseClicked(evt);
            }
        });
        tableauBC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableauBCFocusLost(evt);
            }
        });
        jScrollPane7.setViewportView(tableauBC);

        plNouveauBC.setBackground(new java.awt.Color(255, 255, 255));
        plNouveauBC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVEAU BON DE CAISSE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N

        lb1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb1.setText("Référence Autorisation dépense");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel43.setText("Référence Bon de Caisse");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel45.setText("Date d'édition de la dépense");

        tfRefBC.setEditable(false);
        tfRefBC.setColumns(12);
        tfRefBC.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfRefBC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRefBC.setText("++++++++++++++++");

        comboRefAD.setEditable(true);
        comboRefAD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboRefAD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir Autorisation de dépense" }));
        comboRefAD.setFocusable(false);

        tfRefADBC.setEditable(false);
        tfRefADBC.setBackground(new java.awt.Color(255, 255, 255));
        tfRefADBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfRefADBC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRefADBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRefADBCActionPerformed(evt);
            }
        });
        tfRefADBC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfRefADBCFocusGained(evt);
            }
        });

        lb2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb2.setText("Référence Autorisation dépense");

        tfDateEditionBC.setBackground(new java.awt.Color(255, 255, 255));
        tfDateEditionBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout plNouveauBCLayout = new javax.swing.GroupLayout(plNouveauBC);
        plNouveauBC.setLayout(plNouveauBCLayout);
        plNouveauBCLayout.setHorizontalGroup(
            plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauBCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfDateEditionBC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRefADBC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(comboRefAD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRefBC, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(213, 213, 213))
        );
        plNouveauBCLayout.setVerticalGroup(
            plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauBCLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRefBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRefAD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRefADBC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(plNouveauBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(tfDateEditionBC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btEnregistrerBC.setBackground(new java.awt.Color(255, 255, 255));
        btEnregistrerBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEnregistrerBC.setText("Enregistrer");
        btEnregistrerBC.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btEnregistrerBC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEnregistrerBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBCMouseClicked(evt);
            }
        });

        btModifierBC.setBackground(new java.awt.Color(255, 255, 255));
        btModifierBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModifierBC.setText("Modifier");
        btModifierBC.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btModifierBC.setEnabled(false);
        btModifierBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBCMouseClicked(evt);
            }
        });

        btSupprimerBC.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimerBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSupprimerBC.setText("Supprimer");
        btSupprimerBC.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btSupprimerBC.setEnabled(false);
        btSupprimerBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBCMouseClicked(evt);
            }
        });

        btImprimerBC.setBackground(new java.awt.Color(255, 255, 255));
        btImprimerBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btImprimerBC.setText("Imprimer");
        btImprimerBC.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btImprimerBC.setEnabled(false);
        btImprimerBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBCMouseClicked1(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Retour");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(btImprimerBC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1))
                    .addComponent(btEnregistrerBC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSupprimerBC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btModifierBC, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btModifierBC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btEnregistrerBC))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSupprimerBC)
                            .addComponent(btImprimerBC)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGererBonCaisseLayout = new javax.swing.GroupLayout(panelGererBonCaisse);
        panelGererBonCaisse.setLayout(panelGererBonCaisseLayout);
        panelGererBonCaisseLayout.setHorizontalGroup(
            panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                .addGroup(panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(plNouveauBC, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererBonCaisseLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererBonCaisseLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                .addGroup(panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel26))
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        panelGererBonCaisseLayout.setVerticalGroup(
            panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGererBonCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGererBonCaisseLayout.createSequentialGroup()
                        .addComponent(plNouveauBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tabbedPaneGererBonCommande.addTab("    Gérer les bons de caisses    ", panelGererBonCaisse);

        panelGererBonReparation.setBackground(new java.awt.Color(255, 255, 255));
        panelGererBonReparation.setPreferredSize(new java.awt.Dimension(1211, 690));

        plNouveauBR.setBackground(new java.awt.Color(255, 255, 255));
        plNouveauBR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "NOUVEAU BON DE REPARATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Bon de réparation N° :");

        tfNumeroBR.setEditable(false);
        tfNumeroBR.setBackground(new java.awt.Color(255, 255, 255));
        tfNumeroBR.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tfNumeroBR.setText("++++++++++++++++");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Référence demande de réparation :");

        tfRefDR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfRefDR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRefDRKeyTyped(evt);
            }
        });

        tfAdressePrestataire.setEditable(false);
        tfAdressePrestataire.setBackground(new java.awt.Color(255, 255, 255));
        tfAdressePrestataire.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfAdressePrestataire.setFocusable(false);

        tfImmtriculation.setEditable(false);
        tfImmtriculation.setBackground(new java.awt.Color(255, 255, 255));
        tfImmtriculation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        comboMateriel.setEditable(true);
        comboMateriel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboMateriel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir matériel réparé" }));
        comboMateriel.setFocusable(false);
        comboMateriel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMaterielItemStateChanged(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Nature Réparation:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Adresse :");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Catégorie du matériel :");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Désignation du Matériel:");

        tReparation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        tReparation.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tReparation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"+++***", null, "+++***", "++++++", "++++++", "++++++", "++++"}
            },
            new String [] {
                "Date entrée ", "Compteur", "Date sortie", "Durée immobilisation", "Main d'oeuvre", "pièces", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tReparation.setColumnSelectionAllowed(true);
        tReparation.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tReparation.setGridColor(new java.awt.Color(255, 255, 255));
        tReparation.setSelectionForeground(new java.awt.Color(255, 153, 51));
        jScrollPane3.setViewportView(tReparation);
        tReparation.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Immatriculation :");

        comboNomPrestataire.setEditable(true);
        comboNomPrestataire.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboNomPrestataire.setMaximumRowCount(99999);
        comboNomPrestataire.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir prestataire" }));
        comboNomPrestataire.setFocusable(false);
        comboNomPrestataire.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboNomPrestataireItemStateChanged(evt);
            }
        });
        comboNomPrestataire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomPrestataireActionPerformed(evt);
            }
        });

        comboCategorie.setEditable(true);
        comboCategorie.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboCategorie.setForeground(new java.awt.Color(0, 51, 51));
        comboCategorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir catégorie matériel" }));
        comboCategorie.setFocusable(false);
        comboCategorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategorieItemStateChanged(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Nom du prestataire :");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(204, 255, 255)), "TRAVAUX SIGNALES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N

        btAjouter.setBackground(new java.awt.Color(255, 255, 255));
        btAjouter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btAjouter.setText("Ajouter");
        btAjouter.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btAjouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAjouterMouseClicked(evt);
            }
        });

        tfMO.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfMO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMOKeyTyped(evt);
            }
        });

        tfCoutPiece.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfCoutPiece.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCoutPieceKeyTyped(evt);
            }
        });

        tfTravailSignale.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Coût Pièce :");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel15.setText("Main d'oeuvre :");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel16.setText("Travail Signalé");

        tableauTravauxSignales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        tableauTravauxSignales.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tableauTravauxSignales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"++++++++", "++++++++", "++++++++", "++++++++"},
                {null, "Total", "++++++++", "++++++++"}
            },
            new String [] {
                "N° ordre", "Travaux Signalés", "Main d'oeuvre", "Coût de pièces"
            }
        ));
        tableauTravauxSignales.setToolTipText("");
        tableauTravauxSignales.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tableauTravauxSignales.setGridColor(new java.awt.Color(255, 255, 255));
        tableauTravauxSignales.setSelectionForeground(new java.awt.Color(255, 102, 51));
        jScrollPane2.setViewportView(tableauTravauxSignales);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfTravailSignale, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tfMO, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCoutPiece, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(tfTravailSignale))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfMO, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfCoutPiece, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Date d'édition du BR :");

        tfNatureReparation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tfDateEditionBR.setBackground(new java.awt.Color(255, 255, 255));
        tfDateEditionBR.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        tfDateEditionBR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout plNouveauBRLayout = new javax.swing.GroupLayout(plNouveauBR);
        plNouveauBR.setLayout(plNouveauBRLayout);
        plNouveauBRLayout.setHorizontalGroup(
            plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauBRLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plNouveauBRLayout.createSequentialGroup()
                        .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(plNouveauBRLayout.createSequentialGroup()
                                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(plNouveauBRLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfImmtriculation)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAdressePrestataire, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboNomPrestataire, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNumeroBR)
                    .addComponent(tfRefDR, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDateEditionBR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNatureReparation)
                    .addComponent(comboMateriel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(159, 159, 159))
            .addGroup(plNouveauBRLayout.createSequentialGroup()
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plNouveauBRLayout.setVerticalGroup(
            plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plNouveauBRLayout.createSequentialGroup()
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNumeroBR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfRefDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNatureReparation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDateEditionBR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboNomPrestataire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfAdressePrestataire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(plNouveauBRLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plNouveauBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfImmtriculation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)))), "RECHERCHER UN BON DE REPARATION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        tfRecherche.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton5.setText("Recherche");
        jButton5.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tableauListeBR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 1, 24), java.awt.Color.magenta)); // NOI18N
        tableauListeBR.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tableauListeBR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", null},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"},
                {"+++++++++", "+++++++++", "+++++++++", "+++++++++"}
            },
            new String [] {
                "Numero", "Ref demande Réparation", "Matériel", "Nature Réparation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableauListeBR.setAutoscrolls(false);
        tableauListeBR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableauListeBR.setGridColor(new java.awt.Color(255, 255, 255));
        tableauListeBR.setSelectionForeground(new java.awt.Color(255, 153, 51));
        tableauListeBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauListeBRMouseClicked(evt);
            }
        });
        tableauListeBR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableauListeBRFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tableauListeBR);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("CARDER Borgou / Alibori");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("********");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Service de Matériels et d'entretiens");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btEnregistrerBR.setBackground(new java.awt.Color(255, 255, 255));
        btEnregistrerBR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEnregistrerBR.setText("Enregistrer");
        btEnregistrerBR.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btEnregistrerBR.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btEnregistrerBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBRMouseClicked(evt);
            }
        });

        btModifierBR.setBackground(new java.awt.Color(255, 255, 255));
        btModifierBR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModifierBR.setText("Modifier");
        btModifierBR.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btModifierBR.setEnabled(false);
        btModifierBR.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btModifierBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBRMouseClicked(evt);
            }
        });

        btSupprimerBR.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimerBR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSupprimerBR.setText("Supprimer");
        btSupprimerBR.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btSupprimerBR.setEnabled(false);
        btSupprimerBR.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btSupprimerBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBRMouseClicked(evt);
            }
        });

        btImprimerBR.setBackground(new java.awt.Color(255, 255, 255));
        btImprimerBR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btImprimerBR.setText("Imprimer");
        btImprimerBR.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btImprimerBR.setEnabled(false);
        btImprimerBR.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btImprimerBR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBRMouseClicked(evt);
            }
        });

        btFicheSuivi.setBackground(new java.awt.Color(255, 255, 255));
        btFicheSuivi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btFicheSuivi.setText("Fiche de suivi");
        btFicheSuivi.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        btFicheSuivi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFicheSuivi.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btFicheSuivi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFicheSuiviMouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Retour");
        jButton4.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 204))));
        jButton4.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btEnregistrerBR, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btImprimerBR, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFicheSuivi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btModifierBR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSupprimerBR)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btModifierBR)
                    .addComponent(btSupprimerBR)
                    .addComponent(btImprimerBR)
                    .addComponent(btEnregistrerBR)
                    .addComponent(btFicheSuivi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGererBonReparationLayout = new javax.swing.GroupLayout(panelGererBonReparation);
        panelGererBonReparation.setLayout(panelGererBonReparationLayout);
        panelGererBonReparationLayout.setHorizontalGroup(
            panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                .addGroup(panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jLabel3))
                    .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addGroup(panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                .addGroup(panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plNouveauBR, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererBonReparationLayout.createSequentialGroup()
                        .addGap(533, 533, 533)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        panelGererBonReparationLayout.setVerticalGroup(
            panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGererBonReparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGererBonReparationLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(plNouveauBR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        tabbedPaneGererBonCommande.addTab("Gérer les bons de réparation", panelGererBonReparation);

        panelGererFacture.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 255));
        jLabel27.setText("CARDER Borgou / Alibori");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("****0****");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("Service de Matériels et d'entretiens");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECHERCHER UNE FACTURE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        tfRecherche4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton10.setText("Recherche");
        jButton10.setActionCommand("");
        jButton10.setAutoscrolls(true);
        jButton10.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        jButton10.setMargin(new java.awt.Insets(2, 0, 2, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfRecherche4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRecherche4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)))
        );

        tableauFacture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"},
                {"+++++++", "+++++++", "+++++++", "++++++++", "+++++++", "+++++++"}
            },
            new String [] {
                "Date", "Destination", "n° Facture", "Teléphone", "Service", "Montant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableauFacture.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane8.setViewportView(tableauFacture);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVELLE FACTURE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FACTURE A ENREGISTRER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel42.setText("Type :");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel44.setText("Date d'Edition :");

        tfDateEditionFac.setDateFormatString("dd/MMM/yyyy");
        tfDateEditionFac.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        comboTypeFacture.setEditable(true);
        comboTypeFacture.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboTypeFacture.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir type facture", "Facture téléphonique", "Facture réparation", "Facture SONEB & SBEE" }));
        comboTypeFacture.setBorder(null);
        comboTypeFacture.setFocusable(false);
        comboTypeFacture.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTypeFactureItemStateChanged(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel46.setText("Fournisseur :");

        comboFsrFacture.setEditable(true);
        comboFsrFacture.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboFsrFacture.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir Prestateur" }));
        comboFsrFacture.setBorder(null);
        comboFsrFacture.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfDateEditionFac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboTypeFacture, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFsrFacture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfDateEditionFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTypeFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(comboFsrFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AUTRES RENSEIGNEMENTS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        lbDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbDate.setText("Date Départ:");

        tfDateFacture.setBackground(new java.awt.Color(255, 255, 255));
        tfDateFacture.setToolTipText("");
        tfDateFacture.setDateFormatString("dd MM yyyy");
        tfDateFacture.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbDestination.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDestination.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbDestination.setText("Destination:");

        tfDestination.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfDestination.setText("++++++++********");

        lbNumeroFacture.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNumeroFacture.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbNumeroFacture.setText("N° Facture:");

        lbTelephone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTelephone.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTelephone.setText("N° de téléphone:");

        tfNumeroFacture.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfNumeroFacture.setText("+++++++++*******");
        tfNumeroFacture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroFactureKeyTyped(evt);
            }
        });

        try {
            tfTelephone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelephone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTelephone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lbService.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbService.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbService.setText("Service:");

        tfService.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfService.setText("+++++++++********");

        lbMontant.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMontant.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbMontant.setText("Montant Facture:");

        tfMontant.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tfMontant.setText("+++++++++********");
        tfMontant.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfMontant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMontantKeyTyped(evt);
            }
        });

        tfCompteur.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tfCompteur.setText("+++++++++********");
        tfCompteur.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbCompteur.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbCompteur.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbCompteur.setText("Compteur:");

        lbPolice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbPolice.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPolice.setText("N°  Police :");

        tfPolice.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tfPolice.setText("+++++++++********");
        tfPolice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPoliceKeyTyped(evt);
            }
        });

        lbPeriode.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbPeriode.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPeriode.setText("Période Facture:");

        try {
            tfPeriode.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####/##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfPeriode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPeriode.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbCompteur, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCompteur))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbService, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfService, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(lbMontant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbNumeroFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNumeroFacture)
                                    .addComponent(tfPolice))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbDate)
                                .addGap(10, 10, 10)
                                .addComponent(tfDateFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbDestination, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfTelephone)
                                    .addComponent(tfPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbDestination)
                        .addComponent(tfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfDateFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPeriode)
                        .addComponent(tfPolice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPolice))
                    .addComponent(tfPeriode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNumeroFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNumeroFacture))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTelephone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCompteur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCompteur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMontant)
                    .addComponent(tfService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbService))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btEnregistrerFac.setBackground(new java.awt.Color(255, 255, 255));
        btEnregistrerFac.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btEnregistrerFac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/save.png"))); // NOI18N
        btEnregistrerFac.setText("Enregistrer");
        btEnregistrerFac.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btEnregistrerFac.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btEnregistrerFac.setIconTextGap(0);
        btEnregistrerFac.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btEnregistrerFac.setOpaque(false);
        btEnregistrerFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerFacMouseClicked(evt);
            }
        });

        btModifierFac.setBackground(new java.awt.Color(255, 255, 255));
        btModifierFac.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btModifierFac.setText("Modifier");
        btModifierFac.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btModifierFac.setEnabled(false);
        btModifierFac.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btModifierFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierFacMouseClicked(evt);
            }
        });

        btSupprimerFac.setBackground(new java.awt.Color(255, 255, 255));
        btSupprimerFac.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSupprimerFac.setText("Supprimer");
        btSupprimerFac.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        btSupprimerFac.setEnabled(false);
        btSupprimerFac.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btSupprimerFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerFacMouseClicked(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Retour");
        jButton6.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 204, 255))));
        jButton6.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEnregistrerFac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btModifierFac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSupprimerFac)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSupprimerFac)
                    .addComponent(btModifierFac)
                    .addComponent(jButton6))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btEnregistrerFac, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelGererFactureLayout = new javax.swing.GroupLayout(panelGererFacture);
        panelGererFacture.setLayout(panelGererFactureLayout);
        panelGererFactureLayout.setHorizontalGroup(
            panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererFactureLayout.createSequentialGroup()
                .addGap(464, 464, 464)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(459, 459, 459))
            .addGroup(panelGererFactureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE))
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGererFactureLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(panelGererFactureLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(412, 412, 412))
        );
        panelGererFactureLayout.setVerticalGroup(
            panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGererFactureLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel27)
                .addGap(24, 24, 24)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel29)
                .addGroup(panelGererFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGererFactureLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 42, Short.MAX_VALUE))
        );

        tabbedPaneGererBonCommande.addTab("Gérer les factures", panelGererFacture);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Fichier");

        jMenu3.setText("Enregistrer");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Bon de Réparation");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBRMouseClicked(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Bon de commande");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBCdeMouseClicked(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Bon de caisse");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerBCMouseClicked(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Autorisation de dépense");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerADMouseClicked(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem24.setText("Facture");
        jMenuItem24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEnregistrerFacMouseClicked(evt);
            }
        });
        jMenu3.add(jMenuItem24);

        jMenu1.add(jMenu3);

        jMenu6.setText("Modifier");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Bon de Réparation");
        jMenuItem11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBRMouseClicked(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText("Bon de Commande");
        jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBCdeMouseClicked(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Facture");
        jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierFacMouseClicked(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Bon de Caisse");
        jMenuItem14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierBCMouseClicked(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setText("Autorisation de dépense");
        jMenuItem15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModifierADMouseClicked(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenu1.add(jMenu6);

        jMenu7.setText("Supprimer");

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setText("Bon de Réparation");
        jMenuItem16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBRMouseClicked(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setText("Bon de Commande");
        jMenuItem17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBCdeMouseClicked(evt);
            }
        });
        jMenu7.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setText("Autorisation");
        jMenuItem18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerADMouseClicked(evt);
            }
        });
        jMenu7.add(jMenuItem18);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem19.setText("Bon de Caisse");
        jMenuItem19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerBCMouseClicked(evt);
            }
        });
        jMenu7.add(jMenuItem19);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem20.setText("Facture");
        jMenuItem20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSupprimerFacMouseClicked(evt);
            }
        });
        jMenu7.add(jMenuItem20);

        jMenu1.add(jMenu7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");

        jMenu4.setText("Imprimer");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem9.setText("Autorisation");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem21.setText("Bon de Caisse");
        jMenuItem21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBCMouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem21);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem22.setText("Bon de Commande");
        jMenuItem22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBCdeMouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem23.setText("Bon de Réparation");
        jMenuItem23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btImprimerBRMouseClicked(evt);
            }
        });
        jMenu4.add(jMenuItem23);

        jMenu2.add(jMenu4);

        jMenu5.setText("Liste");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Autorisation de dépense");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Bon de caisse");
        jMenu5.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Bon de commande");
        jMenu5.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Bon de réparation");
        jMenu5.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Facture");
        jMenu5.add(jMenuItem8);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Paramètre");

        jMenuItem25.setText("Changer Mot de Passe");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem25);

        jMenuItem26.setText("Personnalisation");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneGererBonCommande, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPaneGererBonCommande, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// Gestion des reparations
    private void referenceBR() throws SQLException {
        //incrementation du nombre par année
        int nombre = 0;ResultSet  resultatBR =null;
        String selectionRefBR = "select refBR from BonReparation where refBR like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try {
            resultatBR = chargeur.executeQuery(selectionRefBR);
            while (resultatBR.next()) {
              if(resultatBR.isLast())  nombre = Integer.parseInt(resultatBR.getString("refBR").substring(6)); 
            }
            resultatBR.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon de réparation !");
        }
        nombre++;
        tfNumeroBR.setText(reference(nombre,"BR"));
    }
   
    private void initialiserPrestataire() {
        try {
            ResultSet rs = null;
            String ListeNomPrestataire = "select nomFrs from Fournisseur where type='Prestataire'";
            rs = chargeur.executeQuery(ListeNomPrestataire);
            while (rs.next()) {
                comboNomPrestataire.addItem(rs.getString("nomFrs").toString());
                comboFsrFacture.addItem(rs.getString("nomFrs").toString());
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème avec la liste des prestataires");
        }
    }

    private void initialiserCategorie() {
        try {
            String libelleCategorie = " select libelle from Categorie ";
            ResultSet resultatlebelleCategorie = chargeur.executeQuery(libelleCategorie);
            while (resultatlebelleCategorie.next()) {
                comboCategorie.addItem(resultatlebelleCategorie.getString("libelle").toString());
            }
            resultatlebelleCategorie.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Un problème concernant la liste des  catégories");
        }
    }

    private void initialiserMateriel() {
        try {
            String libelleMateriel = " select libelle from Materiel ";
            ResultSet resultatlebelleMatereil = chargeur.executeQuery(libelleMateriel);
            while (resultatlebelleMatereil.next()) {
                comboMateriel.addItem(resultatlebelleMatereil.getString("libelle").toString());
            }
            resultatlebelleMatereil.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Un problème concernant la liste des matériel");
        }
    }

    private void adressePrestataire() {
        String nomPrestataire = comboNomPrestataire.getSelectedItem().toString();
        String adressePrestataire = "select adresse from Fournisseur where nomFrs ='" + nomPrestataire + "' and type='Prestataire' ";
        tfAdressePrestataire.setText("Adresse du prestataire");
        try {
            ResultSet resultatAdressePrestataire = chargeur.executeQuery(adressePrestataire);
            while (resultatAdressePrestataire.next()) {
                if (!resultatAdressePrestataire.getString("adresse").toString().isEmpty()) {
                    tfAdressePrestataire.setText(resultatAdressePrestataire.getString("adresse").toString());
                }
            }
            resultatAdressePrestataire.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème s'est produit lors de la determination de l'adresse du prestataire");
        }
    }

    private void materielParCategorie() {
        String categorie = comboCategorie.getSelectedItem().toString();
        if (categorie.equalsIgnoreCase("vehicule")) {
            listeParCategorie(categorie);
            tfImmtriculation.setEnabled(true);
            tfImmtriculation.setText("numéro d'immatriculation");
        } else {
            listeParCategorie(categorie);
            tfImmtriculation.setEnabled(false);
            tfImmtriculation.setText("++++++++++++++");
        }
    }

    private void listeParCategorie(String categorie) {
        String liste = "select libelle from Materiel "
                + "where codCategorie = (select codCategorie from Categorie where  libelle = '" + categorie + "' )";
        while (comboMateriel.getItemCount() > 1) {
            comboMateriel.removeItemAt(comboMateriel.getItemCount() - 1);
        }
        try {

            ResultSet resultatListeParCategorie = chargeur.executeQuery(liste);
            while (resultatListeParCategorie.next()) {
                comboMateriel.addItem(resultatListeParCategorie.getString("libelle").toString());
            }
            resultatListeParCategorie.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ereur dans la répartition des matériels par catégorie");
        }
    }

    private void immatriculation(String codeMateriel) {
        String numeroMatricule = "select immatriculation from Vehicule where codMat = '" + codeMateriel + "' ";
        try {
            ResultSet resultatImmatriculation = chargeur.executeQuery(numeroMatricule);
            while (resultatImmatriculation.next()) {
                tfImmtriculation.setText(resultatImmatriculation.getString("immatriculation"));
            }
            resultatImmatriculation.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ereur dans la détermination de l'immatriculation");
        }
    }

    private void initialiserTableauCoutReparation(double total) {
        tReparation.setValueAt(travauxSignaleModel.getValueAt(travauxSignaleModel.getRowCount() - 1, 2), 0, 4);
        tReparation.setValueAt(travauxSignaleModel.getValueAt(travauxSignaleModel.getRowCount() - 1, 3), 0, 5);
        tReparation.setValueAt(total, 0, 6);
    }

    private void initialiserTableauBR() {
        String liste = " select distinct BonReparation.refBR, refDemandeReparation, Materiel.libelle, natureReparation  "
                + " from  LigneReparation, BonReparation, Reparation, Materiel, Categorie   "
                + " where Categorie.codCategorie = Materiel.codCategorie and  Materiel.codMat = Reparation.codMat"
                + " and LigneReparation.numRepar = Reparation.numRepar and LigneReparation.refBR = BonReparation.refBR ";
        try {
            ResultSet resultatListe = chargeur.executeQuery(liste);
            while (resultatListe.next()) {
                listeModel.addListeBR(new JListeBR(resultatListe.getString("BonReparation.refBR"), resultatListe.getString("refDemandeReparation"),
                        resultatListe.getString("Materiel.libelle"), resultatListe.getString("natureReparation")));
            }
            resultatListe.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        this.tableauListeBR.setModel(listeModel);
    }

    private void remplirTravaux(String travailSignale, double mainOuvre, double coutPiece) {
        if (!travauxSignaleModel.isEmpty()) {
            travauxSignaleModel.removeTravailSignale(travauxSignaleModel.getRowCount() - 1);
        }
        travauxSignaleModel.addTravailSignale(new JTravailSignale(travailSignale, "" + mainOuvre + "", coutPiece));
        double total = travauxSignaleModel.total();
        travauxSignaleModel.addTravailSignale(new JTravailSignale("Total", "" + travauxSignaleModel.getMainOuvreTotal() + "", travauxSignaleModel.getCoutPieceTotal()));
        initialiserTableauCoutReparation(total);
    }

    private void comboNomPrestataireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomPrestataireActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboNomPrestataireActionPerformed

    private void comboNomPrestataireItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboNomPrestataireItemStateChanged

        adressePrestataire();
    }//GEN-LAST:event_comboNomPrestataireItemStateChanged

    private void comboCategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategorieItemStateChanged
        materielParCategorie();
    }//GEN-LAST:event_comboCategorieItemStateChanged

    private void comboMaterielItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMaterielItemStateChanged
        String categorie = comboCategorie.getSelectedItem().toString();
        if (categorie.equalsIgnoreCase("Vehicule")) {
            String materiel = comboMateriel.getSelectedItem().toString(),
                    codMat = " select codMat from Materiel where libelle = '" + materiel + "' ",
                    code = null;

            try {
                ResultSet codeMateriel = chargeur.executeQuery(codMat);
                while (codeMateriel.next()) {
                    code = codeMateriel.getString("codMat");
                }
                codeMateriel.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ereur dans la préparation de la détermination de l'immatriculation");
            }
            immatriculation(code);
        }
    }//GEN-LAST:event_comboMaterielItemStateChanged

    private void btAjouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAjouterMouseClicked
        try {
            remplirTravaux(tfTravailSignale.getText().toString(), Double.parseDouble(tfMO.getText()), Double.parseDouble(tfCoutPiece.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Il vous valoit ne entrer que des nombres decimaux pour la main d'ouvre et coût des pièces");
        }
        tableauTravauxSignales.setModel(travauxSignaleModel);
    }//GEN-LAST:event_btAjouterMouseClicked

    private void tableauListeBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauListeBRMouseClicked
        lignePassee = -1;
        int ligne = tableauListeBR.getSelectedRow();
        if (ligne != lignePassee) {
            tfNumeroBR.setText(tableauListeBR.getValueAt(ligne, 0).toString());
            tfRefDR.setText(tableauListeBR.getValueAt(ligne, 1).toString());
            tfNatureReparation.setText(tableauListeBR.getValueAt(ligne, 3).toString());

            String materiel = null, prestataire = null;
            String res = "select distinct nomFrs, adresse, dateEntreeRepar, dateSortieRepar, c.libelle, datEditionBR"
                    + " from Fournisseur f, Reparation r, Materiel m, LigneReparation l, BonReparation b, Categorie c"
                    + " where f.numFrs = r.numFrs"
                    + "  and c.codCategorie = m.codCategorie"
                    + " and m.codMat = r.codMat"
                    + " and l.numRepar = r.numRepar"
                    + " and b.refBR = l.refBR"
                    + " and b.refBR = '" + tableauListeBR.getValueAt(ligne, 0) + "'";
            try {

                ResultSet resultat = chargeur.executeQuery(res);
                while (resultat.next()) {

                    tfDateEditionBR.setDateFormatString(getDate(resultat.getString("datEditionBR")));
                    tfAdressePrestataire.setText(resultat.getString("adresse"));
                    tReparation.setValueAt(resultat.getString("dateEntreeRepar"), 0, 0);
                    tReparation.setValueAt(resultat.getString("dateSortieRepar"), 0, 2);
                    materiel = resultat.getString("libelle");
                    prestataire = resultat.getString("nomFrs");

                 // tReparation.setValueAt(Integer.parseInt(resultatRep.getString("dateSortieRepar"))-Integer.parseInt(resultatRep.getString("dateEntreeRepar")), 0, 4);
                }
                resultat.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erreur de choix");
            }
            comboNomPrestataire.setSelectedItem(prestataire);
            comboCategorie.setSelectedItem(materiel);
            comboMateriel.setSelectedItem(tableauListeBR.getValueAt(ligne, 2).toString());
            if (comboCategorie.getSelectedItem().toString().equalsIgnoreCase("Vehicule")) {
                try {
                    ResultSet resultatCompteur = chargeur.executeQuery("select compteurVehicule from ReparationVehicule where numRepar = (select Reparation.numRepar from Reparation , Materiel  , "
                            + "BonReparation , LigneReparation  where Reparation.codMat = Materiel.codMat "
                            + " and LigneReparation.numRepar = Reparation.numRepar"
                            + " and BonReparation.refBR = LigneReparation.refBR and libelle ='" + comboMateriel.getSelectedItem() + "' and BonReparation.refBR = '" + tableauListeBR.getValueAt(ligne, 0) + "')");
                    while (resultatCompteur.next()) {
                        tReparation.setValueAt(resultatCompteur.getString("compteurVehicule"), 0, 1);
                    }
                    resultatCompteur.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
            String travaux = "select travailSignale, mainOuvreTS, coutPieceTS "
                    + " from LigneReparation l, Reparation r, BonReparation b"
                    + " where r.numRepar = l.numRepar and b.refBR = l.refBR and b.refBR = '" + tableauListeBR.getValueAt(ligne, 0) + "' ";
            try {
                ResultSet resultatTS = chargeur.executeQuery(travaux);
                if (!travauxSignaleModel.isEmpty()) {
                    travauxSignaleModel.removeAll();
                }
                while (resultatTS.next()) {
                    // remplirTravaux(resultatTS.getString("travailSignale"), resultatTS.getDouble("mainOuvreTS"), resultatTS.getDouble("coutPieceTS"));
                    travauxSignaleModel.addTravailSignale(new JTravailSignale(resultatTS.getString("travailSignale"), resultatTS.getString("mainOuvreTS"), resultatTS.getDouble("coutPieceTS")));
                }
                double total = travauxSignaleModel.total();
                travauxSignaleModel.addTravailSignale(new JTravailSignale("Total", "" + travauxSignaleModel.getMainOuvreTotal() + "", travauxSignaleModel.getCoutPieceTotal()));
                initialiserTableauCoutReparation(total);
                tableauTravauxSignales.setModel(travauxSignaleModel);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            this.lignePassee = ligne;
        
        btImprimerBR.setEnabled(true);
        btEnregistrerBR.setEnabled(false);
        btModifierBR.setEnabled(false);
        btSupprimerBR.setEnabled(true);
        plNouveauBR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimer, Modifier ou Supprimer un Bon de Réparation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N
       }
    }//GEN-LAST:event_tableauListeBRMouseClicked

    private void tableauListeBRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableauListeBRFocusLost

    }//GEN-LAST:event_tableauListeBRFocusLost

    private void btEnregistrerBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnregistrerBRMouseClicked
        if (!tfRefDR.getText().isEmpty() && !tfNatureReparation.getText().isEmpty() && !tfDateEditionBR.getDateFormatString().isEmpty() && comboNomPrestataire.getSelectedIndex() != 0 && comboCategorie.getSelectedIndex() != 0 && comboMateriel.getSelectedIndex() != 0 && !travauxSignaleModel.isEmpty()) {
            String codMat = null,
                    requeteBR = "insert  into BonReparation values ( '" + tfNumeroBR.getText() + "', '" + tfDateEditionBR.getDateFormatString() + "', '" + tfRefDR.getText() + "', '" + tfNatureReparation.getText() + "' , " + this.numUtilisateur + " )";
            int numFrs = 0, numRepar = 0;
            try {
                ResultSet resultatcode = chargeur.executeQuery("select codMat from Materiel where libelle = '" + comboMateriel.getSelectedItem() + "' ");
                while (resultatcode.next()) {
                    codMat = resultatcode.getString("codMat");
                }
                resultatcode.close();
                ResultSet resultatnumFrs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs = '" + comboNomPrestataire.getSelectedItem() + "' ");
                while (resultatnumFrs.next()) {
                    numFrs = resultatnumFrs.getInt("numFrs");
                }
                resultatnumFrs.close();
                int re = chargeur.executeUpdate("insert  into Reparation values ( null, '" + tReparation.getValueAt(0, 0) + "', '" + tReparation.getValueAt(0, 2) + "', '" + tReparation.getValueAt(0, 4) + "', '" + tReparation.getValueAt(0, 5) + "', '" + codMat + "', " + numFrs + " )");
                try {
                    ResultSet resultatnumRepar = chargeur.executeQuery("select last_insert_id()");
                    while (resultatnumRepar.next()) {
                        numRepar = resultatnumRepar.getInt(1);
                    }
                    resultatnumRepar.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "FFFFF");
                }
                int re2 = chargeur.executeUpdate(requeteBR);

                int i = 0;
                int re3 = 0;
                while (i < travauxSignaleModel.getRowCount() - 1) {
                    String ligne = "insert  into LigneReparation values( " + numRepar + ",'" + tfNumeroBR.getText() + "', '" + travauxSignaleModel.getValueAt(i, 1) + "', " + travauxSignaleModel.getValueAt(i, 2) + ", " + travauxSignaleModel.getValueAt(i, 3) + " )";
                    re3 = chargeur.executeUpdate(ligne);
                    i++;
                }
                if ((re == 1) && (re2 == 1) && (re3 == 1)) {
                    JOptionPane.showMessageDialog(this, "Opération d'enregistrement reussie");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            nouveauBR();
        } else {
            JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
        }
    }//GEN-LAST:event_btEnregistrerBRMouseClicked

// Gestion des Bons de Commande

    private void btEnregistrerBCdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnregistrerBCdeMouseClicked
        if (btEnregistrerBCde.isEnabled()) {
            if (!tfDateLivraison.getDateFormatString().isEmpty() && !tfLieuLivraison.getText().isEmpty() && !tfDateEditionBCde.getDateFormatString().isEmpty() && comboFrs.getSelectedIndex() != 0 && !listeProduitCde.isEmpty()) 
            {
                int numFrs = 0, insertBCde = 0, insertLigneCde = 0, i = 0;
                try {
                    ResultSet requeteFrs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs = '" + comboFrs.getSelectedItem() + "' ");
                    while (requeteFrs.next()) {
                        numFrs = requeteFrs.getInt("numFrs");
                    }
                    String codMat = null, requete = "insert into BonCommande values( '" + tfRefBCde.getText() + "', '" + this.getSelectedDate(tfDateLivraison) + "', '" + tfLieuLivraison.getText() + "', '" + this.getSelectedDate(tfDateEditionBCde) + "'," + numFrs + ", " + this.numUtilisateur + " )";
                    insertBCde = chargeur.executeUpdate(requete);
                    while (i < listeProduitCde.getRowCount() - 1) {
                        ResultSet requeteMat = chargeur.executeQuery("select codMat from Materiel where libelle = '" + comboMaterielcommande.getSelectedItem() + "' ");
                        while (requeteMat.next()) {
                            codMat = requeteMat.getString("codMat");
                        }
                        String ligne = "insert  into LigneCommande values( '" + tfRefBCde.getText() + "','" + codMat + "', " + listeProduitCde.getValueAt(i, 2) + " )";
                        insertLigneCde = chargeur.executeUpdate(ligne);
                        i++;
                    }
                    if ((insertBCde == 1) && (insertLigneCde == 1)) {
                        JOptionPane.showMessageDialog(this, "Opération d'enregistrement reussie");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
                nouveauBCde();
            } else {
                JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
            }
        }
    }//GEN-LAST:event_btEnregistrerBCdeMouseClicked
    private void referenceBCde() {
        //incrementation du nombre par année
        int nombre = 0;
        String selectionRefBCde = "select refBCde from BonCommande where refBCde like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try {
           ResultSet resultatBCde = chargeur.executeQuery(selectionRefBCde);
            while (resultatBCde.next()) {
               if(resultatBCde.isLast()) nombre = Integer.parseInt(resultatBCde.getString("refBCde").substring(8));
            }
            resultatBCde.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème avec la numerotation du bon de commande");
        }
        nombre++;        
        tfRefBCde.setText(reference(nombre, "BCde"));
    }

    private void initialiserFournisseurs() {
        try {
            ResultSet rs = null;
            String ListeNomPrestataire = "select nomFrs from Fournisseur where type='Vendeur'";
            rs = chargeur.executeQuery(ListeNomPrestataire);
            while (rs.next()) {
                comboFrs.addItem(rs.getString("nomFrs").toString());
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème avec la liste des Vendeurs");
        }
    }

    private void initialiserCategorieMaterielCommande() {
        try {
            String libelleCategorie = " select libelle from Categorie ";
            ResultSet resultatlebelleCategorie = chargeur.executeQuery(libelleCategorie);
            while (resultatlebelleCategorie.next()) {
                comboCategorieMaterielCommande.addItem(resultatlebelleCategorie.getString("libelle").toString());
            }
            resultatlebelleCategorie.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Un problème concernant la liste des  catégories commandées");
        }
    }

    private void initialiserMaterielCommande() {
        try {
            String libelleMateriel = " select libelle from Materiel ";
            ResultSet resultatlebelleMatereil = chargeur.executeQuery(libelleMateriel);
            while (resultatlebelleMatereil.next()) {
                comboMaterielcommande.addItem(resultatlebelleMatereil.getString("libelle").toString());
            }
            resultatlebelleMatereil.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Un problème concernant la liste des matériels commandés");
        }
    }

    private void initialiserTableauBCde() {
        String listeBCde = " select refBCde, dateLivraison, lieuLivraison, nomFrs from BonCommande, Fournisseur "
                + "where BonCommande.numFrs = Fournisseur.numFrs and type = 'Vendeur' ";
        try {
            ResultSet resultatListe = chargeur.executeQuery(listeBCde);
            while (resultatListe.next()) {
                listeBCdeModel.addListeBCde(new JListeBCde(resultatListe.getString("refBCde"), resultatListe.getString("dateLivraison"),
                        resultatListe.getString("lieuLivraison"), resultatListe.getString("nomFrs")));
            }
            resultatListe.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de selection de Bon de Commande ");
        }
        this.tableauBCde.setModel(listeBCdeModel);
    }

    private void remplirProduitCommandes(String categorie, String materiel, double quantite, double prixUnitaire, double montant) {
        listeProduitCde.addProduitCommande(new JProduitCommande(categorie, materiel, "" + quantite + "", "" + prixUnitaire + "", montant));
    }
    private void tfRefBCdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRefBCdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRefBCdeActionPerformed

    private void tableauBCdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauBCdeMouseClicked
            int ligne = tableauBCde.getSelectedRow();
            if(ligne!=-1)
            {
            tfRefBCde.setText(tableauBCde.getValueAt(ligne, 0).toString());
            tfDateLivraison.setDateFormatString(getDate(tableauBCde.getValueAt(ligne, 1).toString()));
            tfLieuLivraison.setText(tableauBCde.getValueAt(ligne, 2).toString());
            comboFrs.setSelectedItem(tableauBCde.getValueAt(ligne, 3).toString());

            String res = "select dateEditionBCde"
                    + " from BonCommande"
                    + " where refBCde = '" + tableauBCde.getValueAt(ligne, 0) + "'";
            try {
                ResultSet resultat = chargeur.executeQuery(res);
                while (resultat.next()) {
                   tfDateEditionBCde.setDateFormatString(getDate(resultat.getString("dateEditionBCde")));
                }
                resultat.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erreur de choix");
            }
            String produitCommandes = "select  prixUnitaireFrs, qteCommandee,  m.libelle, c.libelle "
                    + " from LigneCommande l, Fournir f, BonCommande b, Fournisseur frs, Categorie c, Materiel m"
                    + " where f.numFrs = frs.numFrs and f.codMat = m.codMat and l.refBCde = b.refBCde "
                    + " and m.codCategorie = c.codCategorie and b.refBCde = '" + tableauBCde.getValueAt(ligne, 0) + "' and  "
                    + "  frs.numFrs = ( select numFrs from Fournisseur where nomFrs = '" + comboFrs.getSelectedItem().toString() + "') ";
            try {
                if (!listeProduitCde.isEmpty()) {
                    listeProduitCde.removeAll();
                }
                ResultSet resultatPCde = chargeur.executeQuery(produitCommandes);
           // if(resultatPCde.first())
                // {
                while (resultatPCde.next()) {
                    double qteb = resultatPCde.getDouble("qteCommandee"), prixU = resultatPCde.getDouble("prixUnitaireFrs");
                    listeProduitCde.addProduitCommande(new JProduitCommande(resultatPCde.getString("c.libelle"), resultatPCde.getString("m.libelle"), "" + qteb + "", "" + prixU + "", qteb * prixU));
                }
                listeProduitCde.addProduitCommande(new JProduitCommande("", "", "", "Total", listeProduitCde.getMontantTotal()));
           // }
                // else JOptionPane.showMessageDialog(this, "Liste vide");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            tableauProduitCommande.setModel(listeProduitCde);
            btEnregistrerBCde.setEnabled(false);
            btImprimerBCde.setEnabled(true);
            btModifierBCde.setEnabled(true);
            btSupprimerBCde.setEnabled(true);
            plNouveauBCde.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimer, Modifier ou Supprimer Bon Commande", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
            }
            
    }//GEN-LAST:event_tableauBCdeMouseClicked
// Autorisation dépense
    private void tableauAutorisationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauAutorisationMouseClicked
        
            int ligneSelectionnee = tableauAutorisation.getSelectedRow();
            if(ligneSelectionnee!=-1)
            {
            tfRefAD.setText(tableauAutorisation.getValueAt(ligneSelectionnee, 0).toString());
            tfObjetAutorisation.setText(tableauAutorisation.getValueAt(ligneSelectionnee, 1).toString());
            tfMontantDepense.setText(tableauAutorisation.getValueAt(ligneSelectionnee, 2).toString());
            tfDateEditionAD.setDateFormatString(getDate(tableauAutorisation.getValueAt(ligneSelectionnee, 3).toString()));
            btEnregistrerAD.setEnabled(false);
            btImprimerAD.setEnabled(true);
            btModifierAD.setEnabled(true);
            btSupprimerAD.setEnabled(true);
            plNouveauAD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimer, Modifier ou Supprimer une Autorisation de Depense", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(153, 153, 255)));
            } 
    }//GEN-LAST:event_tableauAutorisationMouseClicked

    private void referenceAutorisation() {
        int nombre = 0;
        String selectionRefAuto = "select refAutorisation from AutorisationDepense where refAutorisation like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try {
           ResultSet resultatAuto = chargeur.executeQuery(selectionRefAuto);
            while (resultatAuto.next()) {
               if(resultatAuto.isLast()) nombre = Integer.parseInt(resultatAuto.getString("refAutorisation").substring(6));
            }
            resultatAuto.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème avec la numerotation des Autorisation de Dépense");
        }
        nombre++;
        tfRefAD.setText(reference(nombre, "AD"));
    }

    private void initialiserTableauAutorisation() {
        String listeAuto = " select * from AutorisationDepense ";
        try {
            ResultSet resultatListeAuto = chargeur.executeQuery(listeAuto);
            while (resultatListeAuto.next()) {
                listeAutoModel.addAutorisation(new JListeAutorisation(resultatListeAuto.getString("refAutorisation"), resultatListeAuto.getString("objet"),
                        resultatListeAuto.getDouble("montantDepense"), resultatListeAuto.getDate("dateEditionAuto").toString()));
            }
            resultatListeAuto.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        this.tableauAutorisation.setModel(listeAutoModel);
    }
    private void btEnregistrerADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnregistrerADMouseClicked
        if (btEnregistrerAD.isEnabled()) {
            if (!tfObjetAutorisation.getText().isEmpty() && !tfMontantDepense.getText().isEmpty() && !tfDateEditionAD.getDateFormatString().isEmpty()) {

                int resultat = 0;
                double montant;
                montant = 0;
                try {
                    String montantD = tfMontantDepense.getText();
                    montant = Double.valueOf(montantD);
                    String insertAuto = " insert into AutorisationDepense values( '" + tfRefAD.getText() + "', '" +  this.getSelectedDate(tfDateEditionAD) + "', '" + tfObjetAutorisation.getText() + "', " + montant + ", " + this.numUtilisateur + " ) ";
                    resultat = chargeur.executeUpdate(insertAuto);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
                if (resultat == 1) {
                    JOptionPane.showMessageDialog(this, "Opération d'enregistrement reussie");
                }
                this.nouveauAD();
            } else {
                JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
            }

        }
    }//GEN-LAST:event_btEnregistrerADMouseClicked

    private void tableauBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauBCMouseClicked
        this.lignePassee = -1;
        int ligne = tableauBC.getSelectedRow();
        if(ligne!=-1)
        {
        String requete = "select dateEditionBC from BonCaisse where  refBC = '" + tableauBC.getValueAt(ligne, 0) + "' ";
        if (ligne != this.lignePassee) {
            tfRefBC.setText((String) tableauBC.getValueAt(ligne, 0));
            tfRefADBC.setText((String) tableauBC.getValueAt(ligne, 1));
            try {
                ResultSet res = chargeur.executeQuery(requete);
                while (res.next()) {
                    tfDateEditionBC.setDateFormatString(getDate(res.getString("dateEditionBC")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!lb2.isVisible() && !tfRefADBC.isVisible()) {
            lb1.setVisible(false);
            comboRefAD.setVisible(false);
            lb2.setVisible(true);
            tfRefADBC.setVisible(true);
        }
        btImprimerBC.setEnabled(true);
        btEnregistrerBC.setEnabled(false);
        btModifierBC.setEnabled(true);
        btSupprimerBC.setEnabled(true);
        plNouveauBC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imprimer, Modifier ou Supprimer un Bon de Caisse", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
    }
    }//GEN-LAST:event_tableauBCMouseClicked

    private void btEnregistrerBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnregistrerBCMouseClicked
        if (btEnregistrerBC.isEnabled()) {
            if (!comboRefAD.getSelectedItem().equals("Choisissez Autorisation de dépense") && !tfDateEditionBC.getDateFormatString().isEmpty()) {
                int resultat = 0;
                try {
                    String insertAuto;
                    insertAuto = " insert into BonCaisse values( '" + tfRefBC.getText() + "', '" +  this.getSelectedDate(tfDateEditionBC) + "', '" + comboRefAD.getSelectedItem().toString() + "',  " + this.numUtilisateur + " ) ";
                    resultat = chargeur.executeUpdate(insertAuto);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }

                if (resultat == 1) {
                    JOptionPane.showMessageDialog(this, "Opération d'enregistrement reussie");
                }
                nouveauBC();
            } else {
                JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
            }
        }
    }//GEN-LAST:event_btEnregistrerBCMouseClicked

    private void btImprimerBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerBRMouseClicked
        if (btImprimerBR.isEnabled()) {
            String  cod = null; 
            if (comboCategorie.getSelectedItem().toString().equalsIgnoreCase("Vehicule")) {
                cod = tfImmtriculation.getText();
            } else {
                try {
                    ResultSet re = chargeur.executeQuery("select codMat from Materiel where libelle = '" + comboMateriel.getSelectedItem().toString() + "'");
                    while (re.next()) {
                        cod = re.getString("codMat");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Impression I = new Impression(new JFicheImprimerBR(tfNumeroBR.getText(), tfRefDR.getText(), comboNomPrestataire.getSelectedItem().toString(), tfAdressePrestataire.getText(), comboCategorie.getSelectedItem().toString(), cod, travauxSignaleModel, tfDateEditionBR.getDateFormatString()).getPanel());
            I.setOrientation(1);
            I.print();
            nouveauBR();
        }
    }//GEN-LAST:event_btImprimerBRMouseClicked

    private void btImprimerBCdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerBCdeMouseClicked
        if (btImprimerBCde.isEnabled()) 
        {
            Impression I = new Impression(new JFicheImprimerBCde(this.tfRefBCde.getText(), this.tfDateLivraison.getDateFormatString(), this.tfLieuLivraison.getText(), this.comboFrs.getSelectedItem().toString(), tfDateEditionBCde.getDateFormatString(), listeProduitCde).getPanel());
            I.setOrientation(1);
            I.print();
            nouveauBC();
        }
    }//GEN-LAST:event_btImprimerBCdeMouseClicked

    private void btImprimerADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerADMouseClicked
        if (btImprimerAD.isEnabled()) {
             double m;
            m = Double.parseDouble(this.tfMontantDepense.getText());
            Impression I = new Impression(new JFicheImprimerAD(this.tfRefAD.getText(), this.tfObjetAutorisation.getText(), m, tfDateEditionAD.getDateFormatString()).getPanel());
            I.setOrientation(1);
            I.print();
            this.nouveauAD();
        }
    }//GEN-LAST:event_btImprimerADMouseClicked

    private void tfRefADBCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfRefADBCFocusGained
        this.lb1.setVisible(true);
        this.comboRefAD.setVisible(true);
        this.lb2.setVisible(false);
        this.tfRefADBC.setVisible(false);
        this.comboRefAD.addItem((String) this.tfRefADBC.getText());
    }//GEN-LAST:event_tfRefADBCFocusGained

    private void tableauBCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableauBCFocusLost

    }//GEN-LAST:event_tableauBCFocusLost

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        nouveauBC();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        nouveauBCde();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        nouveauBR();
    }//GEN-LAST:event_jButton4MouseClicked

    private void btEnregistrerFacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEnregistrerFacMouseClicked
        int i = comboTypeFacture.getSelectedIndex();
        String requete = null, requete2 = null; int numFrs = 0, numFac = 0, t=0, re1 =0, re2 = 0;
        ResultSet rs;
        if(comboFsrFacture.getSelectedIndex()!=0){
        try {
            rs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs ="+comboFsrFacture.getSelectedItem().toString()+"");
        while(rs.next()) numFrs = rs.getInt(1);    
           t = Integer.parseInt(tfMontant.getText());numFac = Integer.parseInt(tfNumeroFacture.getText());
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }}
        if(!tfDestination.getText().isEmpty()&& !tfMontant.getText().isEmpty() && !tfNumeroFacture.getText().isEmpty() && !tfService.getText().isEmpty() && !tfDateEditionFac.getDateFormatString().isEmpty() && !tfNumeroFacture.getText().isEmpty())
        requete = "insert into Facture values("+null+","+tfDestination.getText()+", "+t+", "+numFrs+", "+numUtilisateur+", "+tfService.getText()+" , "+this.getSelectedDate(tfDateEditionFac)+", "+numFac+")";
        else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
        switch(i)
        {
            case 1: if(!tfDateFacture.getDateFormatString().isEmpty()&& !tfTelephone.getText().isEmpty())
                requete2 ="insert into FactureTelephone values(LAST_INSERT_ID(), "+this.getSelectedDate(tfDateFacture)+", "+tfTelephone.getText()+")";
            else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
            break;
            case 2:
                if(!tfDateFacture.getDateFormatString().isEmpty()&&!tfCompteur.getText().isEmpty())
                requete2 ="insert into FactureReparation values(LAST_INSERT_ID(),"+this.getSelectedDate(tfDateFacture)+", "+tfCompteur.getText()+")";
                else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
                break;
            case 3:int n=0;
                try{
                 n = Integer.parseInt(tfPolice.getText());} catch(Exception e){JOptionPane.showMessageDialog(this, e.getMessage());}
                if(!tfDateFacture.getDateFormatString().isEmpty()&&!tfPolice.getText().isEmpty()&& !tfPeriode.getText().isEmpty())
                requete2 ="insert into FactureElectriciteEau values(LAST_INSERT_ID(),"+this.getSelectedDate(tfDateFacture)+", "+n+", "+tfPeriode.getText()+")";
                else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
                break;
        }
        try {
             re1 = chargeur.executeUpdate(requete);
             re2 = chargeur.executeUpdate(requete2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, " Erreur d'insertion: "+ex.getMessage());
        }
        if(re1==1 && re2== 1)JOptionPane.showMessageDialog(this, "Insertion réussie");
        else
        {
            if(re1==1 && re2== 0) try {
                chargeur.executeUpdate("delete from Facture where numFac = LAST_INSERT_ID()");
            } catch (SQLException ex) {
                Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }//GEN-LAST:event_btEnregistrerFacMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void tfRefADBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRefADBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRefADBCActionPerformed

    private void btModifierBCdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierBCdeMouseClicked
        if (btModifierBCde.isEnabled()) {
            if (!tfDateLivraison.getDateFormatString().isEmpty() && !tfLieuLivraison.getText().isEmpty() && !tfDateEditionBCde.getDateFormatString().isEmpty() && comboFrs.getSelectedIndex() != 0 && !listeProduitCde.isEmpty()) {
                int numFrs = 0, insertBCde = 0, insertLigneCde = 0, i = 0;
                try {
                    ResultSet requeteFrs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs = '" + comboFrs.getSelectedItem() + "' ");
                    while (requeteFrs.next()) {
                        numFrs = requeteFrs.getInt("numFrs");
                    }
                    String codMat = null, requete = "update BonCommande set dateLivraison='" +  this.getSelectedDate(tfDateLivraison) + "', lieuLivraison='" + tfLieuLivraison.getText() + "', dateEditionBcde='" +  this.getSelectedDate(tfDateEditionBCde) + "', numFrs=" + numFrs + ", numUtilisateur=" + this.numUtilisateur + "  where refBcde='" + tfRefBCde.getText() + "'";

                    insertBCde = chargeur.executeUpdate(requete);
                    chargeur.executeUpdate("delete from ligneCommande where refBcde='" + tfRefBCde.getText() + "' and codMat='" + codMat + "'");
                    while (i < listeProduitCde.getRowCount() - 1) {
                        ResultSet requeteMat = chargeur.executeQuery("select codMat from Materiel where libelle = '" + listeProduitCde.getValueAt(i, 1) + "' ");
                        while (requeteMat.next()) {
                            codMat = requeteMat.getString("codMat");
                        }
                        String ligne = "insert into ligneCommande values( '" + tfRefBCde.getText() + "', '" + codMat + "', " + listeProduitCde.getValueAt(i, 2) + " )";
                        insertLigneCde = chargeur.executeUpdate(ligne);
                        i++;
                    }
                    if ((insertBCde == 0) && (insertLigneCde == 0)) {
                        JOptionPane.showMessageDialog(this, "Modification reussie");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur de modification : ");
                }
                nouveauBCde();
            } else {
                JOptionPane.showMessageDialog(this, "Veillez renseigner tous les champs !");
            }
        }
    }//GEN-LAST:event_btModifierBCdeMouseClicked

    private void btAjouterProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAjouterProduitMouseClicked
        if (!comboCategorieMaterielCommande.getSelectedItem().equals("Choisir catégorie") && !comboMaterielcommande.getSelectedItem().equals("choisir matériel") && !tfQuantiteCommandee.getText().isEmpty()) {
            double PU = 0;
            int qte = 0;
            try {
                ResultSet pu = chargeur.executeQuery("select prixUnitaireFrs from Fournir f, Fournisseur frs, Materiel m where f.codMat = m.codMat and f.numFrs = frs.numFrs and libelle = '" + comboMaterielcommande.getSelectedItem().toString() + "'");
                while (pu.next()) {
                    PU = pu.getDouble("prixUnitaireFrs");
                }
                qte = Integer.parseInt(tfQuantiteCommandee.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            if (!listeProduitCde.isEmpty()) {
                listeProduitCde.removeProduitCommande(listeProduitCde.getRowCount() - 1);
            }
            this.listeProduitCde.addProduitCommande(new JProduitCommande(comboCategorieMaterielCommande.getSelectedItem().toString(), comboMaterielcommande.getSelectedItem().toString(), tfQuantiteCommandee.getText(), "" + PU + "", qte * PU));
            this.listeProduitCde.addProduitCommande(new JProduitCommande("", "", "", "  toal", listeProduitCde.getMontantTotal()));
        }
        this.tableauProduitCommande.setModel(listeProduitCde);
    }//GEN-LAST:event_btAjouterProduitMouseClicked

    private void btModifierBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierBRMouseClicked
        if (btModifierBR.isEnabled()) {
            if (!tfRefDR.getText().isEmpty() && !tfNatureReparation.getText().isEmpty() && !tfDateEditionBR.getDateFormatString().isEmpty() && comboNomPrestataire.getSelectedIndex() != 0 && comboCategorie.getSelectedIndex() != 0 && comboMateriel.getSelectedIndex() != 0 && !travauxSignaleModel.isEmpty()) {
                String codMat = null,
                        requeteBR = "update BonReparation set datEditionBR='" + tfDateEditionBR.getDateFormatString() + "', refDemandeReparation='" + tfRefDR.getText() + "', natureReparation='" + tfNatureReparation.getText() + "' , numUtilisateur=" + this.numUtilisateur + " where refBR='" + tfNumeroBR.getText() + "'";
                int numFrs = 0, numRepar = 0;
                try {
                    ResultSet resultatcode = chargeur.executeQuery("select codMat from Materiel where libelle = '" + comboMateriel.getSelectedItem() + "' ");
                    while (resultatcode.next()) {
                        codMat = resultatcode.getString("codMat");
                    }
                    resultatcode.close();
                    ResultSet resultatnumFrs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs = '" + comboNomPrestataire.getSelectedItem() + "' ");
                    while (resultatnumFrs.next()) {
                        numFrs = resultatnumFrs.getInt("numFrs");
                    }
                    resultatnumFrs.close();
                    String liste = " select distinct Reparation.numRepar from  LigneReparation, BonReparation, Reparation"
                            + " where  LigneReparation.numRepar = Reparation.numRepar and LigneReparation.refBR = BonReparation.refBR and "
                            + "BonReparation.refBR = '" + tableauListeBR.getValueAt(tableauListeBR.getSelectedRow(), 0) + "'";
                    ResultSet r = chargeur.executeQuery(liste);
                    while (r.next()) {
                        numRepar = r.getInt("numRepar");
                    }
                    r.close();

                    int re = chargeur.executeUpdate("update Reparation set dateEntreeRepar='" + tReparation.getValueAt(0, 0) + "', dateSortieRepar='" + tReparation.getValueAt(0, 2) + "', mainOeuvre='" + tReparation.getValueAt(0, 4) + "', coutpiece='" + tReparation.getValueAt(0, 5) + "', codMat='" + codMat + "', numFrs=" + numFrs + " where numRepar =" + numRepar + "");

                    int re2 = chargeur.executeUpdate(requeteBR);

                    int i = 0;
                    int re3 = 0;
                    chargeur.executeUpdate("delete from ligneReparation where numRepar=" + numRepar + " and refBR='" + tfNumeroBR.getText() + "'");
                    while (i < travauxSignaleModel.getRowCount() - 1) {
                        String ligne = "insert  into LigneReparation values( " + numRepar + ",'" + tfNumeroBR.getText() + "', '" + travauxSignaleModel.getValueAt(i, 1) + "', " + travauxSignaleModel.getValueAt(i, 2) + ", " + travauxSignaleModel.getValueAt(i, 3) + " )";
                        re3 = chargeur.executeUpdate(ligne);
                        i++;
                    }
                    if ((re == 1) && (re2 == 1) && (re3 == 1)) {
                        JOptionPane.showMessageDialog(this, "Modification reussie");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
                nouveauBR();
            } else {
                JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
            }
        }
    }//GEN-LAST:event_btModifierBRMouseClicked

    private void btModifierADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierADMouseClicked
        if (btModifierAD.isEnabled()) {
            if (!tfObjetAutorisation.getText().isEmpty() && !tfMontantDepense.getText().isEmpty() && !tfDateEditionAD.getDateFormatString().isEmpty()) {

                int resultat = 0;
                double montant;
                montant = 0;
                try {
                    String montantD = tfMontantDepense.getText();
                    montant = Double.valueOf(montantD);
                    String insertAuto = " replace into AutorisationDepense values( '" + tfRefAD.getText() + "', '" + this.getSelectedDate(tfDateEditionAD) + "', '" + tfObjetAutorisation.getText() + "', " + montant + ", " + this.numUtilisateur + " ) ";
                    resultat = chargeur.executeUpdate(insertAuto);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
                if (resultat == 1) {
                    JOptionPane.showMessageDialog(this, "Modification reussie");
                }
                this.nouveauAD();
            } else {
                JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
            }

        }
    }//GEN-LAST:event_btModifierADMouseClicked

    private void btModifierBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierBCMouseClicked
        if (btModifierBC.isEnabled()) {
            if (comboRefAD.isVisible()) {
                if (!comboRefAD.getSelectedItem().equals("Choisissez Autorisation de dépense") && !tfDateEditionBC.getDateFormatString().isEmpty()) {
                    int resultat = 0;
                    try {
                        String insertAuto;
                        insertAuto = " update BonCaisse set dateEditionBC='" + this.getSelectedDate(tfDateEditionBC) + "', refAutorisation='" + comboRefAD.getSelectedItem().toString() + "', numUtilisateur=" + this.numUtilisateur + " where refBC='" + tfRefBC.getText() + "'";
                        resultat = chargeur.executeUpdate(insertAuto);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }

                    if (resultat == 1) {
                        JOptionPane.showMessageDialog(this, "Modification reussie");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
                }
            } else if (tfRefADBC.isVisible()) {
                if (!tfRefADBC.getText().isEmpty() && !tfDateEditionBC.getDateFormatString().isEmpty()) 
                {
                    int resultat = 0;
                    try {
                        String insertAuto;
                        insertAuto = " update BonCaisse set dateEditionBC='" + this.getSelectedDate(tfDateEditionBC) + "', refAutorisation='" + tfRefADBC.getText() + "', numUtilisateur=" + this.numUtilisateur + " where refBC='" + tfRefBC.getText() + "'";
                        resultat = chargeur.executeUpdate(insertAuto);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }

                    if (resultat == 1) {
                        JOptionPane.showMessageDialog(this, "Modification reussie");
                    }
                    nouveauBC();
                } else {
                    JOptionPane.showMessageDialog(this, "Veille renseigner tous les champs !");
                }
            }

        }
    }//GEN-LAST:event_btModifierBCMouseClicked

    private void btSupprimerBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerBCMouseClicked
        if (btSupprimerBC.isEnabled()) {
            int option = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce bon de caisse ?", "Suppression de bon de caisse", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    int suppression = chargeur.executeUpdate("delete from BonCaisse where refBC='" + tfRefBC.getText() + "'");
                    if (suppression == 1) {
                        JOptionPane.showMessageDialog(this, "Bon de caisse a été supprimé !");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression !");
                }
            }
            nouveauBC();
        }
    }//GEN-LAST:event_btSupprimerBCMouseClicked

    private void btSupprimerADMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerADMouseClicked
        if (btSupprimerAD.isEnabled()) {
            int option = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette autorisation de dépense ?", "Suppression d'autorisation de dépense", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {

                try {
                    int suppression = chargeur.executeUpdate("delete from AutorisationDepense where refAutorisation='" + tfRefAD.getText() + "'");
                    if (suppression == 1) {
                        JOptionPane.showMessageDialog(this, "Autorisation de dépense a été supprimée !");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression !");
                }
            }
            nouveauAD();
        }
    }//GEN-LAST:event_btSupprimerADMouseClicked

    private void btSupprimerBRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerBRMouseClicked
        if (btSupprimerBR.isEnabled()) {
            int option = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce bon de réparation ?", "Suppression de bon de réparation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    int numRepar = 0;
                    String liste = " select distinct Reparation.numRepar from  LigneReparation, BonReparation, Reparation"
                            + " where  LigneReparation.numRepar = Reparation.numRepar and LigneReparation.refBR = BonReparation.refBR and "
                            + "BonReparation.refBR = '" + tableauListeBR.getValueAt(tableauListeBR.getSelectedRow(), 0) + "'";
                    ResultSet r = chargeur.executeQuery(liste);
                    while (r.next()) {
                        numRepar = r.getInt("numRepar");
                    }
                    int suppression0 = chargeur.executeUpdate("delete from ligneReparation where refBR='" + tfNumeroBR.getText() + "' and numRepar=" + numRepar + "");
                    int suppression = chargeur.executeUpdate("delete  from BonReparation where refBR='" + tfNumeroBR.getText() + "'");
                    int suppression1 = chargeur.executeUpdate("delete  from Reparation where numRepar=" + numRepar + "");
                    if (suppression0 == 1 && suppression == 1 && suppression1 == 1) {
                        JOptionPane.showMessageDialog(this, "Bon de réparation a été supprimé !");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
            nouveauBR();
        }
    }//GEN-LAST:event_btSupprimerBRMouseClicked

    private void btSupprimerBCdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerBCdeMouseClicked
        if (btSupprimerBCde.isEnabled()) {
            int option = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce bon de commande ?", "Suppression de bon de commande", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    int suppression0 = chargeur.executeUpdate("delete from LIGNECommande where refBCde='" + tfRefBCde.getText() + "'");
                    int suppression = chargeur.executeUpdate("delete from BonCommande where refBCde='" + tfRefBCde.getText() + "'");
                    if (suppression == 1 && suppression0 == 1) {
                        JOptionPane.showMessageDialog(this, "Bon commande a été supprimé !");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de la suppression !");
                }
            }
            nouveauBCde();
        }
    }//GEN-LAST:event_btSupprimerBCdeMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        nouveauAD();
    }//GEN-LAST:event_jButton2MouseClicked

    private void btFicheSuiviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFicheSuiviMouseClicked
        try {
            new JFicheDeSuivi(null).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btFicheSuiviMouseClicked

    private void comboTypeFactureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTypeFactureItemStateChanged
        int type = comboTypeFacture.getSelectedIndex();
        switch(type)
        {
            case 1: lbDate.setText("Date"); lbTelephone.setVisible(true);tfTelephone.setVisible(true);lbPolice.setVisible(false);tfPolice.setVisible(false); lbPeriode.setVisible(false);tfPeriode.setVisible(false);  
             lbCompteur.setVisible(false);tfCompteur.setVisible(false); break;
            case 2: lbDate.setText("Date"); lbCompteur.setText("N° réparation");lbTelephone.setVisible(false);tfTelephone.setVisible(false);lbPolice.setVisible(false);tfPolice.setVisible(false); lbPeriode.setVisible(false);tfPeriode.setVisible(false); 
             lbCompteur.setVisible(true);tfCompteur.setVisible(true); break;
            case 3: lbDate.setText("Date Depart"); lbCompteur.setText("N° réparation");lbTelephone.setVisible(false);tfTelephone.setVisible(false);lbPolice.setVisible(true);tfPolice.setVisible(true); lbPeriode.setVisible(true);tfPeriode.setVisible(true); 
             lbCompteur.setVisible(false);tfCompteur.setVisible(false);break;
            default :  
        }
    }//GEN-LAST:event_comboTypeFactureItemStateChanged

    private void btSupprimerFacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSupprimerFacMouseClicked
       int i = comboTypeFacture.getSelectedIndex(), numFac = 0;
       try {
            ResultSet rs = chargeur.executeQuery("select numFac from Facture where numFacture ="+tableauFacture.getValueAt(tableauFacture.getSelectedRow(), 2)+" ");
            while(rs.next()) numFac = rs.getInt(1);
       } catch (Exception ex) {
         
        }
       switch(i)
       {
           case 1:try {
               chargeur.executeUpdate("delete from FactureTelephone where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
               case 2:try {
               chargeur.executeUpdate("delete from FactureReparation where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
                   case 3:try {
               chargeur.executeUpdate("delete from FactureElectriciteEau where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
                       default:
       }  
    }//GEN-LAST:event_btSupprimerFacMouseClicked

    private void btModifierFacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModifierFacMouseClicked
             int i = comboTypeFacture.getSelectedIndex(), numFac = 0;
             //supression
             try {
            ResultSet rs = chargeur.executeQuery("select numFac from Facture where numFacture ="+tableauFacture.getValueAt(tableauFacture.getSelectedRow(), 2)+" ");
            while(rs.next()) numFac = rs.getInt(1);
       } catch (Exception ex) {
         
        }
       switch(i)
       {
           case 1:try {
               chargeur.executeUpdate("delete from FactureTelephone where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
               case 2:try {
               chargeur.executeUpdate("delete from FactureReparation where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
                   case 3:try {
               chargeur.executeUpdate("delete from FactureElectriciteEau where numFac = "+numFac+"");
               chargeur.executeUpdate("delete from Facture where numFac = "+numFac+"");
               JOptionPane.showMessageDialog(this, "Suppression réussie");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Erreur de suppression");
       }break;
                       default:
       }
       //réenregistrement
        String requete = null, requete2 = null; int numFrs = 0,  t=0, re1 =0, re2 = 0;
        ResultSet rs;
        if(comboFsrFacture.getSelectedIndex()!=0){
        try {
            rs = chargeur.executeQuery("select numFrs from Fournisseur where nomFrs ="+comboFsrFacture.getSelectedItem().toString()+"");
        while(rs.next()) numFrs = rs.getInt(1);    
           t = Integer.parseInt(tfMontant.getText());numFac = Integer.parseInt(tfNumeroFacture.getText());
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }}
        if(!tfDestination.getText().isEmpty()&& !tfMontant.getText().isEmpty() && !tfNumeroFacture.getText().isEmpty() && !tfService.getText().isEmpty() && !tfDateEditionFac.getDateFormatString().isEmpty() && !tfNumeroFacture.getText().isEmpty())
        requete = "insert into Facture values("+null+","+tfDestination.getText()+", "+t+", "+numFrs+", "+numUtilisateur+", "+tfService.getText()+" , "+this.getSelectedDate(tfDateEditionFac)+", "+numFac+")";
        else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
        switch(i)
        {
            case 1: if(!tfDateFacture.getDateFormatString().isEmpty()&& !tfTelephone.getText().isEmpty())
                requete2 ="insert into FactureTelephone values(LAST_INSERT_ID(), "+this.getSelectedDate(tfDateFacture)+", "+tfTelephone.getText()+")";
            else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
            break;
            case 2:
                if(!tfDateFacture.getDateFormatString().isEmpty()&&!tfCompteur.getText().isEmpty())
                requete2 ="insert into FactureReparation values(LAST_INSERT_ID(),"+this.getSelectedDate(tfDateFacture)+", "+tfCompteur.getText()+")";
                else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
                break;
            case 3:int n=0;
                try{
                 n = Integer.parseInt(tfPolice.getText());} catch(Exception e){JOptionPane.showMessageDialog(this, e.getMessage());}
                if(!tfDateFacture.getDateFormatString().isEmpty()&&!tfPolice.getText().isEmpty()&& !tfPeriode.getText().isEmpty())
                requete2 ="insert into FactureElectriciteEau values(LAST_INSERT_ID(),"+this.getSelectedDate(tfDateFacture)+", "+n+", "+tfPeriode.getText()+")";
                else JOptionPane.showMessageDialog(this, "Remplissez tous les champs");
                break;
        }
        try {
             re1 = chargeur.executeUpdate(requete);
             re2 = chargeur.executeUpdate(requete2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, " Erreur d'insertion: "+ex.getMessage());
        }
        if(re1==1 && re2== 1)JOptionPane.showMessageDialog(this, "Insertion réussie");
        else
        {
            if(re1==1 && re2== 0) try {
                chargeur.executeUpdate("delete from Facture where numFac = LAST_INSERT_ID()");
            } catch (SQLException ex) {
                Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
            }
         }        
    }//GEN-LAST:event_btModifierFacMouseClicked

    private void btImprimerBCMouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerBCMouseClicked1
JOptionPane.showMessageDialog(this, "Insertion réussie");
        // TODO add your handling code here:
    }//GEN-LAST:event_btImprimerBCMouseClicked1

    private void btImprimerBCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btImprimerBCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btImprimerBCMouseClicked

    private void tfQuantiteCommandeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantiteCommandeeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfQuantiteCommandeeKeyTyped

    private void tfMontantDepenseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMontantDepenseKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfMontantDepenseKeyTyped

    private void tfRefDRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRefDRKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfRefDRKeyTyped

    private void tfMOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMOKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfMOKeyTyped

    private void tfCoutPieceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCoutPieceKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfCoutPieceKeyTyped

    private void tfPoliceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPoliceKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfPoliceKeyTyped

    private void tfMontantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMontantKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfMontantKeyTyped

    private void tfNumeroFactureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroFactureKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || c ==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfNumeroFactureKeyTyped

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
         if (btImprimerAD.isEnabled()) {
             double m;
            m = Double.parseDouble(this.tfMontantDepense.getText());
            Impression I = new Impression(new JFicheImprimerAD(this.tfRefAD.getText(), this.tfObjetAutorisation.getText(), m, tfDateEditionAD.getDateFormatString()).getPanel());
            I.setOrientation(1);
            I.print();
            this.nouveauAD();
        }        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        new JChangerPassword(this, true, this.numUtilisateur, this.Host, this.User, this.Password).setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        new JPersonnalisation(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed
    
    private void referenceBC() {
        int nombre = 0;
        String selectionRefBC = "select refBC from BonCaisse where refBC like '" + Calendar.getInstance().get(Calendar.YEAR) + "%' ";
        try {
           ResultSet resultatBC = chargeur.executeQuery(selectionRefBC);
            while (resultatBC.next()) {
                if(resultatBC.isLast()) nombre = Integer.parseInt(resultatBC.getString("refBC").substring(6));
            }
            resultatBC.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "un problème avec la numerotation de bon caisse");
        }
        nombre++;
        tfRefBC.setText(reference(nombre, "BC"));
    }

    private void initialiserReferenceAD() {
        String liste = "select refAutorisation from AutorisationDepense "
                + "where refAutorisation not in (select AutorisationDepense.refAutorisation from BonCaisse, AutorisationDepense where  BonCaisse.refAutorisation = AutorisationDepense.refAutorisation )";
        while (comboRefAD.getItemCount() > 1) {
            comboRefAD.removeItemAt(comboRefAD.getItemCount() - 1);
        }
        try {
            ResultSet resultatListeRefAD = chargeur.executeQuery(liste);
            while (resultatListeRefAD.next()) {
                comboRefAD.addItem(resultatListeRefAD.getString("refAutorisation").toString());
            }
            resultatListeRefAD.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ereur dans le traitement des Autorisations de depense sans Bon de Caisse");
        }
    }

    private void initialiserTableauBC() {
        if (!listeBCModel.isEmpty()) {
            listeBCModel.removeAll();
        }
        String requete = "select refBC, a.refAutorisation, objet, montantDepense from BonCaisse b, AutorisationDepense a where b.refAutorisation = a.refAutorisation order by(refBC)";
        try {
            ResultSet res = chargeur.executeQuery(requete);
            while (res.next()) {
                listeBCModel.addBC(new JListeBC(res.getString("refBC"), res.getString("refAutorisation"), res.getString("objet"), res.getDouble("montantDepense")));
            }
            this.tableauBC.setModel(listeBCModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ereur dans le traitement des  Bons de Caisse");
        }
    }

    private void nouveauBR() {
        try {
            referenceBR();
        } catch (SQLException ex) {
            Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
        }
        initialiserPrestataire();
        initialiserCategorie();
        initialiserMateriel();
        adressePrestataire();
        if (!this.listeModel.isEmpty()) {
            listeModel.removeAll();
        }
        initialiserTableauBR();
        tfRefDR.setText("**************");
        tfNatureReparation.setText("*************");
        tfDateEditionBR.setDateFormatString(null);
        comboNomPrestataire.setSelectedIndex(0);
        tfAdressePrestataire.setText("Adresse du Prestataire");
        comboCategorie.setSelectedIndex(0);
        comboMateriel.setSelectedIndex(0);
        tfTravailSignale.setText("**************");
        tfMO.setText("**************");
        tfCoutPiece.setText("**************");
        if (!travauxSignaleModel.isEmpty()) {
            travauxSignaleModel.removeAll();
        }
        tReparation.setValueAt("*****", 0, 0);
        tReparation.setValueAt("*****", 0, 2);
        tReparation.setValueAt("++++++", 0, 4);
        tReparation.setValueAt("++++++", 0, 5);
        tReparation.setValueAt("++++++", 0, 6);
        tReparation.setValueAt("******", 0, 1);
        btImprimerBR.setEnabled(false);
        btEnregistrerBR.setEnabled(true);
        btModifierBR.setEnabled(false);
        btSupprimerBR.setEnabled(false);
        plNouveauBR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouveau Bon de Réparation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
    }

    private void nouveauBCde() {
        referenceBCde();
        initialiserFournisseurs();
        initialiserCategorieMaterielCommande();
        initialiserMaterielCommande();
        if (!listeBCdeModel.isEmpty()) {
            listeBCdeModel.removeAll();
        }
        initialiserTableauBCde();
        tfDateLivraison.setDateFormatString(null);
        tfLieuLivraison.setText("******************");
        tfDateEditionBCde.setDateFormatString(null);
        if (!listeProduitCde.isEmpty()) {
            this.listeProduitCde.removeAll();
        }
        btImprimerBCde.setEnabled(false);
        btEnregistrerBCde.setEnabled(true);
        btModifierBCde.setEnabled(false);
        btSupprimerBCde.setEnabled(false);
        plNouveauBCde.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouveau Bon de Commande", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
    }

    private void nouveauAD() {
        referenceAutorisation();
        if (!this.listeAutoModel.isEmpty()) {
            this.listeAutoModel.removeAll();
        }
        initialiserTableauAutorisation();
        tfObjetAutorisation.setText("******************");
        tfMontantDepense.setText("******************");
        tfDateEditionAD.setDateFormatString(null);
        btImprimerAD.setEnabled(false);
        btEnregistrerAD.setEnabled(true);
        btModifierAD.setEnabled(false);
        btSupprimerAD.setEnabled(false);
        plNouveauAD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouvelle Autorisation de Dépense", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
    }

    private void nouveauBC() {
        referenceBC();
        initialiserReferenceAD();
        initialiserTableauBC();
        this.tfDateEditionBC.setDateFormatString(null);
        btImprimerBC.setEnabled(false);
        btEnregistrerBC.setEnabled(true);
        btModifierBC.setEnabled(false);
        btSupprimerBC.setEnabled(false);
        plNouveauBC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouveau Bon de Caisse", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 204)));
        if (!lb1.isVisible() && !comboRefAD.isVisible()) {
            lb1.setVisible(true);
            comboRefAD.setVisible(true);
            lb2.setVisible(false);
            tfRefADBC.setVisible(false);
        }
    }

    public void tfRefDRTextValueChange(java.awt.event.TextListener e) {
    }

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
            java.util.logging.Logger.getLogger(JSectionCCME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSectionCCME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSectionCCME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSectionCCME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JSectionCCME(26,"localhost", "root","").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JSectionCCME.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjouter;
    private javax.swing.JButton btAjouterProduit;
    private javax.swing.JButton btEnregistrerAD;
    private javax.swing.JButton btEnregistrerBC;
    private javax.swing.JButton btEnregistrerBCde;
    private javax.swing.JButton btEnregistrerBR;
    private javax.swing.JButton btEnregistrerFac;
    private javax.swing.JButton btFicheSuivi;
    private javax.swing.JButton btImprimerAD;
    private javax.swing.JButton btImprimerBC;
    private javax.swing.JButton btImprimerBCde;
    private javax.swing.JButton btImprimerBR;
    private javax.swing.JButton btModifierAD;
    private javax.swing.JButton btModifierBC;
    private javax.swing.JButton btModifierBCde;
    private javax.swing.JButton btModifierBR;
    private javax.swing.JButton btModifierFac;
    private javax.swing.JButton btRechercherBCde;
    private javax.swing.JButton btSupprimerAD;
    private javax.swing.JButton btSupprimerBC;
    private javax.swing.JButton btSupprimerBCde;
    private javax.swing.JButton btSupprimerBR;
    private javax.swing.JButton btSupprimerFac;
    private javax.swing.JComboBox comboCategorie;
    private javax.swing.JComboBox comboCategorieMaterielCommande;
    private javax.swing.JComboBox comboFrs;
    private javax.swing.JComboBox comboFsrFacture;
    private javax.swing.JComboBox comboMateriel;
    private javax.swing.JComboBox comboMaterielcommande;
    private javax.swing.JComboBox comboNomPrestataire;
    private javax.swing.JComboBox comboRefAD;
    private javax.swing.JComboBox comboTypeFacture;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbCompteur;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbDestination;
    private javax.swing.JLabel lbMontant;
    private javax.swing.JLabel lbNumeroFacture;
    private javax.swing.JLabel lbPeriode;
    private javax.swing.JLabel lbPolice;
    private javax.swing.JLabel lbService;
    private javax.swing.JLabel lbTelephone;
    private javax.swing.JPanel panelGererAutorisationDepense;
    private javax.swing.JPanel panelGererBonCaisse;
    private javax.swing.JPanel panelGererBonCommande;
    private javax.swing.JPanel panelGererBonReparation;
    private javax.swing.JPanel panelGererFacture;
    private javax.swing.JPanel plNouveauAD;
    private javax.swing.JPanel plNouveauBC;
    public javax.swing.JPanel plNouveauBCde;
    private javax.swing.JPanel plNouveauBR;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tReparation;
    private javax.swing.JTabbedPane tabbedPaneGererBonCommande;
    private javax.swing.JTable tableauAutorisation;
    private javax.swing.JTable tableauBC;
    private javax.swing.JTable tableauBCde;
    private javax.swing.JTable tableauFacture;
    private javax.swing.JTable tableauListeBR;
    private javax.swing.JTable tableauProduitCommande;
    private javax.swing.JTable tableauTravauxSignales;
    private javax.swing.JTextField tfAdressePrestataire;
    private javax.swing.JFormattedTextField tfCompteur;
    private javax.swing.JTextField tfCoutPiece;
    private com.toedter.calendar.JDateChooser tfDateEditionAD;
    private com.toedter.calendar.JDateChooser tfDateEditionBC;
    private com.toedter.calendar.JDateChooser tfDateEditionBCde;
    private com.toedter.calendar.JDateChooser tfDateEditionBR;
    private com.toedter.calendar.JDateChooser tfDateEditionFac;
    private com.toedter.calendar.JDateChooser tfDateFacture;
    private com.toedter.calendar.JDateChooser tfDateLivraison;
    private javax.swing.JTextField tfDestination;
    private javax.swing.JTextField tfImmtriculation;
    private javax.swing.JTextField tfLieuLivraison;
    private javax.swing.JTextField tfMO;
    private javax.swing.JFormattedTextField tfMontant;
    private javax.swing.JTextField tfMontantDepense;
    private javax.swing.JTextField tfNatureReparation;
    private javax.swing.JTextField tfNumeroBR;
    private javax.swing.JTextField tfNumeroFacture;
    private javax.swing.JTextArea tfObjetAutorisation;
    private javax.swing.JFormattedTextField tfPeriode;
    private javax.swing.JTextField tfPolice;
    private javax.swing.JTextField tfQuantiteCommandee;
    private javax.swing.JTextField tfRecherche;
    private javax.swing.JTextField tfRecherche2;
    private javax.swing.JTextField tfRecherche3;
    private javax.swing.JTextField tfRecherche4;
    private javax.swing.JTextField tfRechercheBCde;
    private javax.swing.JTextField tfRefAD;
    private javax.swing.JTextField tfRefADBC;
    private javax.swing.JTextField tfRefBC;
    private javax.swing.JTextField tfRefBCde;
    private javax.swing.JTextField tfRefDR;
    private javax.swing.JTextField tfService;
    private javax.swing.JFormattedTextField tfTelephone;
    private javax.swing.JTextField tfTravailSignale;
    // End of variables declaration//GEN-END:variables

    private void initComponentFacture() 
    {
        tfPolice.setVisible(false);
        tfPeriode.setVisible(false);
        tfTelephone.setVisible(false);
        //tfObjet.setVisible(false);
        tfCompteur.setVisible(false);
        lbCompteur.setVisible(false);
        //lbObjet.setVisible(false);
        lbPeriode.setVisible(false);
        lbPolice.setVisible(false);
        lbTelephone.setVisible(false);
        
    }

}
