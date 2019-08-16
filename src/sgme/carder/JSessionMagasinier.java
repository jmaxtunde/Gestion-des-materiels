
package sgme.carder;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/***
 * @author 
 */
public class JSessionMagasinier extends javax.swing.JFrame 
{    
    int numUtilisateur =0;String Host = null, User = null, Password =null;
    public JSessionMagasinier(int numUtilisateur, String Host, String User, String Password) 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.numUtilisateur =numUtilisateur; this.Host = Host;this.User = User; this.Password = Password;
        cx= new JDBConnection();
        try {   
            st= (Statement)cx.getJDBConnection(this.Host,this.User,this.Password).createStatement();
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, "Un problème s'est produit lors du chargement  !!! \n"+ex.getMessage());
             }
        int nbLignes =0;
        nbLignes=tableListeMateriel.getRowCount();
        if(nbLignes>0)
        {
           //btnImprimerMateriel.setEnabled(true);
        }
        Image img = null;
        try {
            img = ImageIO.read(new File("icon1.jpg"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.setIconImage(img);
        InitialiserTableListeMateriel();
        InitialiserMagasinMateriel();
        InitialisationCategorieMateriel();
        //bon entree
        InitialisationCategorieBE();
        InitialiserFournisseurBE();
        InitialiserReferenceBE();
        //bon sortie
        InitialiserRefBS();
        InitialiserNomMagasinierBS();
        InitialiserComboService();
        InitialisationCategorieBS();
        InitialiserTableBonSortie();
        //consultation
        InitialisationDesignationConsultation();
        InitialisationCategorieConsultation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        conteneurEnreg = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDesignationMateriel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMarqueMateriel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboCategorieMateriel = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboMagasinMateriel = new javax.swing.JComboBox();
        lbImmatriculation = new javax.swing.JLabel();
        txtQteDispoMateriel = new javax.swing.JTextField();
        txtCodMateriel = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtrechercheMateriel = new javax.swing.JTextField();
        btnRecherMateriel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListeMateriel = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnEnregistrerMateriel = new javax.swing.JButton();
        btnSupprimerMateriel = new javax.swing.JButton();
        btnModifierMateriel = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        conteneurAjoutBE = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comboCategorieBE = new javax.swing.JComboBox();
        comboDesignationBE = new javax.swing.JComboBox();
        txtQteStockBE = new javax.swing.JTextField();
        qteEntreBE = new javax.swing.JTextField();
        btnAjouterBE = new javax.swing.JButton();
        txtPUFrs = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbleListeMaterielEntreBE = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboFrsBE = new javax.swing.JComboBox();
        txtrefBE = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRefBonLivraisonBE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        txtrechercheBE = new javax.swing.JTextField();
        btnRechercherBE = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbleListeBonEntre = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnEnregistrerBE = new javax.swing.JButton();
        btnImprimerBE = new javax.swing.JButton();
        btnModifierBE = new javax.swing.JButton();
        btnSupprimerBE = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        txtrechercheBS = new javax.swing.JTextField();
        btnRechercherBS = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbleListeBonSortie = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        btnEnregistrerBS = new javax.swing.JButton();
        btnImprimerBS = new javax.swing.JButton();
        btnModifierBS = new javax.swing.JButton();
        btnSupprimerBS = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtRefBS = new javax.swing.JTextField();
        comboServiceBS = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtReceptionnaire = new javax.swing.JTextField();
        txtrefDemandeAchat = new javax.swing.JTextField();
        conteneurAjoutBE1 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        comboCategorieBS = new javax.swing.JComboBox();
        comboDesignationBS = new javax.swing.JComboBox();
        txtQteStockBS = new javax.swing.JTextField();
        qteSortieBS = new javax.swing.JTextField();
        btnAjouterBS = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbleListeMaterielSortieBS = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        btnVoirFicheStock2 = new javax.swing.JButton();
        comboCategorieConsultation = new javax.swing.JComboBox();
        btnInventaire = new javax.swing.JButton();
        btnFactureImpayeeConsultation = new javax.swing.JButton();
        btnListFact = new javax.swing.JButton();
        btnListBE = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        btnVoirFicheStock3 = new javax.swing.JButton();
        comboDesignationConsultation1 = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblConsultation = new javax.swing.JTable();
        btnImprimerConsultation = new javax.swing.JButton();
        labConsultation = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        jMenuItem10.setText("jMenuItem10");

        jMenuItem15.setText("jMenuItem15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(-1,true));

        jLabel1.setBackground(new java.awt.Color(-1966111,true));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel1.setForeground(new java.awt.Color(-16737844,true));
        jLabel1.setText("CARDER BORGOU/ALIBORI");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel2.setForeground(new java.awt.Color(-13395457,true));
        jLabel2.setText("********o*******");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel3.setForeground(new java.awt.Color(-65536,true));
        jLabel3.setText("Service du Matériel et de l'Entretien (SME)");

        conteneurEnreg.setBackground(new java.awt.Color(-1,true));
        conteneurEnreg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVEAU MATERIEL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N
        conteneurEnreg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Catégorie");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Code Matériel");

        txtDesignationMateriel.setMaximumSize(new java.awt.Dimension(60, 60));
        txtDesignationMateriel.setMinimumSize(new java.awt.Dimension(2, 20));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Désignation");

        txtMarqueMateriel.setMaximumSize(new java.awt.Dimension(30, 30));
        txtMarqueMateriel.setMinimumSize(new java.awt.Dimension(2, 4));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Marque");

        comboCategorieMateriel.setEditable(true);
        comboCategorieMateriel.setFont(new java.awt.Font("Serif", 1, 12));
        comboCategorieMateriel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choississez une Catégorie" }));
        comboCategorieMateriel.setFocusable(false);
        comboCategorieMateriel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategorieMaterielItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Libellé Magasin");

        comboMagasinMateriel.setEditable(true);
        comboMagasinMateriel.setFont(new java.awt.Font("Serif", 1, 12));
        comboMagasinMateriel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choississez un Magasin" }));
        comboMagasinMateriel.setFocusable(false);

        lbImmatriculation.setFont(new java.awt.Font("Dialog", 1, 14));
        lbImmatriculation.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbImmatriculation.setText("Stock");

        txtQteDispoMateriel.setMaximumSize(new java.awt.Dimension(6, 8));
        txtQteDispoMateriel.setMinimumSize(new java.awt.Dimension(1, 1));
        txtQteDispoMateriel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQteDispoMaterielKeyTyped(evt);
            }
        });

        txtCodMateriel.setEditable(false);

        javax.swing.GroupLayout conteneurEnregLayout = new javax.swing.GroupLayout(conteneurEnreg);
        conteneurEnreg.setLayout(conteneurEnregLayout);
        conteneurEnregLayout.setHorizontalGroup(
            conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurEnregLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurEnregLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(comboCategorieMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurEnregLayout.createSequentialGroup()
                        .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(conteneurEnregLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurEnregLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurEnregLayout.createSequentialGroup()
                                .addComponent(lbImmatriculation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMarqueMateriel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQteDispoMateriel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMagasinMateriel, 0, 243, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurEnregLayout.createSequentialGroup()
                        .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDesignationMateriel, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(txtCodMateriel))))
                .addGap(63, 63, 63))
        );
        conteneurEnregLayout.setVerticalGroup(
            conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurEnregLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategorieMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesignationMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarqueMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(comboMagasinMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conteneurEnregLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQteDispoMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbImmatriculation))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECHERCHER UN MATERIEL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        txtrechercheMateriel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrechercheMaterielActionPerformed(evt);
            }
        });

        btnRecherMateriel.setFont(new java.awt.Font("Serif", 1, 14));
        btnRecherMateriel.setForeground(new java.awt.Color(-65536,true));
        btnRecherMateriel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/searchfind.jpg"))); // NOI18N
        btnRecherMateriel.setText("Rechercher");
        btnRecherMateriel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 204)))); // NOI18N
        btnRecherMateriel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecherMaterielActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrechercheMateriel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecherMateriel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtrechercheMateriel)
                        .addGap(2, 2, 2))
                    .addComponent(btnRecherMateriel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableListeMateriel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code Mat", "Désignation", "QteEnStock", "Marque", "Magasin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableListeMateriel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListeMaterielMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableListeMateriel);

        jPanel9.setBackground(new java.awt.Color(-1,true));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(-16737844,true));

        btnEnregistrerMateriel.setFont(new java.awt.Font("Dialog", 1, 14));
        btnEnregistrerMateriel.setText("Enregistrer");
        btnEnregistrerMateriel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 204)))); // NOI18N
        btnEnregistrerMateriel.setEnabled(false);
        btnEnregistrerMateriel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnregistrerMaterielMouseClicked(evt);
            }
        });

        btnSupprimerMateriel.setFont(new java.awt.Font("Dialog", 1, 14));
        btnSupprimerMateriel.setText("Supprimer");
        btnSupprimerMateriel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 204)))); // NOI18N
        btnSupprimerMateriel.setEnabled(false);
        btnSupprimerMateriel.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnSupprimerMateriel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerMaterielActionPerformed(evt);
            }
        });

        btnModifierMateriel.setFont(new java.awt.Font("Dialog", 1, 14));
        btnModifierMateriel.setText("Modifier");
        btnModifierMateriel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 204)))); // NOI18N
        btnModifierMateriel.setEnabled(false);
        btnModifierMateriel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierMaterielActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnregistrerMateriel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupprimerMateriel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifierMateriel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnregistrerMateriel)
                    .addComponent(btnSupprimerMateriel)
                    .addComponent(btnModifierMateriel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 153, 255));
        jLabel48.setText("LISTE DES MATERIELS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(431, 431, 431))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(506, 506, 506))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conteneurEnreg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel48)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(conteneurEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1198, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Gérer Les Matériels", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVEAU BON D'ENTREE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        conteneurAjoutBE.setBackground(new java.awt.Color(255, 255, 255));
        conteneurAjoutBE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MATERIEL ENTRE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Categorie");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Matériel");

        jLabel22.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel22.setText("Quantité en Stock");

        jLabel23.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel23.setText("Quantité Entrée");

        comboCategorieBE.setEditable(true);
        comboCategorieBE.setFont(new java.awt.Font("Dialog", 1, 12));
        comboCategorieBE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Catégorie" }));
        comboCategorieBE.setFocusable(false);
        comboCategorieBE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategorieBEItemStateChanged(evt);
            }
        });

        comboDesignationBE.setEditable(true);
        comboDesignationBE.setFont(new java.awt.Font("Dialog", 1, 12));
        comboDesignationBE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matériel" }));
        comboDesignationBE.setFocusable(false);
        comboDesignationBE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDesignationBEItemStateChanged(evt);
            }
        });
        comboDesignationBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDesignationBEActionPerformed(evt);
            }
        });

        txtQteStockBE.setEnabled(false);
        txtQteStockBE.setFocusable(false);

        qteEntreBE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qteEntreBEKeyTyped(evt);
            }
        });

        btnAjouterBE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/plus.jpg"))); // NOI18N
        btnAjouterBE.setText("Ajouter");
        btnAjouterBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnAjouterBE.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnAjouterBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterBEActionPerformed(evt);
            }
        });

        txtPUFrs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPUFrsKeyTyped(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel35.setText("Prix Unitaire");

        tbleListeMaterielEntreBE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbleListeMaterielEntreBE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Catégorie", "Matériel", "Quantité Entrée", "Prix Unitaire"
            }
        ));
        jScrollPane2.setViewportView(tbleListeMaterielEntreBE);

        javax.swing.GroupLayout conteneurAjoutBELayout = new javax.swing.GroupLayout(conteneurAjoutBE);
        conteneurAjoutBE.setLayout(conteneurAjoutBELayout);
        conteneurAjoutBELayout.setHorizontalGroup(
            conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurAjoutBELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteneurAjoutBELayout.createSequentialGroup()
                .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(conteneurAjoutBELayout.createSequentialGroup()
                        .addComponent(comboCategorieBE, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDesignationBE, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQteStockBE, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qteEntreBE, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPUFrs, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAjouterBE, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );
        conteneurAjoutBELayout.setVerticalGroup(
            conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurAjoutBELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qteEntreBE, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(conteneurAjoutBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboDesignationBE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQteStockBE, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPUFrs)
                        .addComponent(btnAjouterBE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategorieBE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Référence Bon de Livraison");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Fournisseur");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Référence  Bon d'Entrée");

        comboFrsBE.setEditable(true);
        comboFrsBE.setFont(new java.awt.Font("Serif", 1, 12));
        comboFrsBE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choissisez un Fournisseur" }));
        comboFrsBE.setFocusable(false);

        txtrefBE.setEditable(false);
        txtrefBE.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Date d'Edition");

        txtRefBonLivraisonBE.setForeground(new java.awt.Color(204, 204, 204));
        txtRefBonLivraisonBE.setText("Saissisez référence bon livraison");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtrefBE, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRefBonLivraisonBE)
                            .addComponent(comboFrsBE, javax.swing.GroupLayout.Alignment.LEADING, 0, 189, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(conteneurAjoutBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrefBE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRefBonLivraisonBE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboFrsBE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(conteneurAjoutBE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setBackground(new java.awt.Color(-1966111,true));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel8.setForeground(new java.awt.Color(-16737844,true));
        jLabel8.setText("CARDER BORGOU/ALIBORI");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel10.setForeground(new java.awt.Color(-13395457,true));
        jLabel10.setText("********o*******");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel11.setForeground(new java.awt.Color(-65536,true));
        jLabel11.setText("Service du Matériel et de l'Entretien (SME)");

        jPanel16.setBackground(new java.awt.Color(-1,true));
        jPanel16.setPreferredSize(new java.awt.Dimension(160, 479));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECHERCHER UN BON D'ENTREE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        btnRechercherBE.setFont(new java.awt.Font("Serif", 1, 14));
        btnRechercherBE.setForeground(new java.awt.Color(-65536,true));
        btnRechercherBE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/searchfind.jpg"))); // NOI18N
        btnRechercherBE.setText("Rechercher");
        btnRechercherBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnRechercherBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherBEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrechercheBE, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRechercherBE, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(txtrechercheBE)
                        .addGap(5, 5, 5))
                    .addComponent(btnRechercherBE, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbleListeBonEntre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        tbleListeBonEntre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbleListeBonEntre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Référence Bon d'Entrée", "Date Edition", "Référence Bon de Livraison", "Fournisseur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbleListeBonEntre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleListeBonEntreMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbleListeBonEntre);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Serif", 1, 18));
        jLabel24.setForeground(new java.awt.Color(-16737844,true));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("LISTE BON D'ENTREE");

        jPanel15.setBackground(new java.awt.Color(-1,true));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N
        jPanel15.setForeground(new java.awt.Color(-16737844,true));

        btnEnregistrerBE.setFont(new java.awt.Font("Dialog", 1, 14));
        btnEnregistrerBE.setText("Enregistrer");
        btnEnregistrerBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnEnregistrerBE.setEnabled(false);
        btnEnregistrerBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerBEActionPerformed(evt);
            }
        });

        btnImprimerBE.setFont(new java.awt.Font("Dialog", 1, 14));
        btnImprimerBE.setText("Modifier");
        btnImprimerBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnImprimerBE.setEnabled(false);
        btnImprimerBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimerBEActionPerformed(evt);
            }
        });

        btnModifierBE.setFont(new java.awt.Font("Dialog", 1, 14));
        btnModifierBE.setText("Imprimer");
        btnModifierBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnModifierBE.setEnabled(false);
        btnModifierBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierBEActionPerformed(evt);
            }
        });

        btnSupprimerBE.setFont(new java.awt.Font("Dialog", 1, 14));
        btnSupprimerBE.setText("Supprimer");
        btnSupprimerBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        btnSupprimerBE.setEnabled(false);
        btnSupprimerBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerBEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModifierBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEnregistrerBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimerBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupprimerBE, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnregistrerBE)
                    .addComponent(btnImprimerBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifierBE)
                    .addComponent(btnSupprimerBE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(146, 146, 146))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gérer Les Bons d'Entrée", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(-1,true));

        jPanel23.setBackground(new java.awt.Color(-1,true));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECHERCHER UN BON DE SORTIE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        btnRechercherBS.setBackground(new java.awt.Color(255, 255, 255));
        btnRechercherBS.setFont(new java.awt.Font("Serif", 1, 14));
        btnRechercherBS.setForeground(new java.awt.Color(-65536,true));
        btnRechercherBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/searchfind.jpg"))); // NOI18N
        btnRechercherBS.setText("Rechercher");
        btnRechercherBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 51)))); // NOI18N
        btnRechercherBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherBSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrechercheBS, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRechercherBS)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtrechercheBS)
                    .addComponent(btnRechercherBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbleListeBonSortie.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbleListeBonSortie.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbleListeBonSortie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Référence Bon de Sortie", "Date Edition", "Référence Demande Achat", "Service Bénéficiaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbleListeBonSortie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleListeBonSortieMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbleListeBonSortie);

        jLabel13.setFont(new java.awt.Font("Serif", 1, 14));
        jLabel13.setForeground(new java.awt.Color(-16737844,true));
        jLabel13.setText("Liste des Bons de Sorties ");

        jPanel20.setBackground(new java.awt.Color(-1,true));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 36), new java.awt.Color(153, 153, 255))); // NOI18N

        btnEnregistrerBS.setFont(new java.awt.Font("Serif", 1, 14));
        btnEnregistrerBS.setText("Enregistrer ");
        btnEnregistrerBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0)))); // NOI18N
        btnEnregistrerBS.setEnabled(false);
        btnEnregistrerBS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnregistrerBSMouseClicked(evt);
            }
        });

        btnImprimerBS.setFont(new java.awt.Font("Serif", 1, 14));
        btnImprimerBS.setText("Imprimer ");
        btnImprimerBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0)))); // NOI18N
        btnImprimerBS.setEnabled(false);

        btnModifierBS.setFont(new java.awt.Font("Serif", 1, 14));
        btnModifierBS.setText("Modifier ");
        btnModifierBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0)))); // NOI18N
        btnModifierBS.setEnabled(false);
        btnModifierBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierBSActionPerformed(evt);
            }
        });

        btnSupprimerBS.setFont(new java.awt.Font("Serif", 1, 14));
        btnSupprimerBS.setText("Supprimer");
        btnSupprimerBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0)))); // NOI18N
        btnSupprimerBS.setEnabled(false);
        btnSupprimerBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerBSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnregistrerBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModifierBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnImprimerBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupprimerBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnregistrerBS)
                    .addComponent(btnImprimerBS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimerBS)
                    .addComponent(btnModifierBS))
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVEAU BON DE SORTIE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel58.setText("Référence  Bon de Sortie");

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel59.setText("Date d'Edition Bon de Sortie");

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel60.setText("Receptionnaire");

        txtRefBS.setEditable(false);

        comboServiceBS.setEditable(true);
        comboServiceBS.setFont(new java.awt.Font("Serif", 1, 12));
        comboServiceBS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choississez un Service" }));
        comboServiceBS.setFocusable(false);

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel61.setText("Référence Demande Achat");

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel62.setText("Service");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(comboServiceBS, javax.swing.GroupLayout.Alignment.LEADING, 0, 238, Short.MAX_VALUE)
                    .addComponent(txtRefBS, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrefDemandeAchat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtReceptionnaire))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtRefBS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(27, 27, 27)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrefDemandeAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReceptionnaire, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboServiceBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(23, 23, 23))
        );

        conteneurAjoutBE1.setBackground(new java.awt.Color(255, 255, 255));
        conteneurAjoutBE1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MATERIEL A SORTIR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel54.setText("Categorie");

        jLabel55.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel55.setText("Désignation");

        jLabel56.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel56.setText("QteEnStock");

        jLabel57.setFont(new java.awt.Font("Serif", 1, 12));
        jLabel57.setText("Qte Sortie");

        comboCategorieBS.setEditable(true);
        comboCategorieBS.setFont(new java.awt.Font("Serif", 1, 12));
        comboCategorieBS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir sa catégorie" }));
        comboCategorieBS.setFocusable(false);
        comboCategorieBS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategorieBSItemStateChanged(evt);
            }
        });

        comboDesignationBS.setEditable(true);
        comboDesignationBS.setFont(new java.awt.Font("Serif", 1, 12));
        comboDesignationBS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choissisez sa Désignation" }));
        comboDesignationBS.setFocusable(false);
        comboDesignationBS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDesignationBSItemStateChanged(evt);
            }
        });
        comboDesignationBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDesignationBSActionPerformed(evt);
            }
        });

        txtQteStockBS.setEditable(false);

        qteSortieBS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qteSortieBSKeyTyped(evt);
            }
        });

        btnAjouterBS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgme/carder/img/plus.jpg"))); // NOI18N
        btnAjouterBS.setText("Ajouter");
        btnAjouterBS.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0)))); // NOI18N
        btnAjouterBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterBSActionPerformed(evt);
            }
        });

        tbleListeMaterielSortieBS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Catégorie", "Matériel", "Quantité Sortie", "Service Bénéficiaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbleListeMaterielSortieBS);

        javax.swing.GroupLayout conteneurAjoutBE1Layout = new javax.swing.GroupLayout(conteneurAjoutBE1);
        conteneurAjoutBE1.setLayout(conteneurAjoutBE1Layout);
        conteneurAjoutBE1Layout.setHorizontalGroup(
            conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                .addGroup(conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel55)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel56))
                    .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                        .addComponent(comboCategorieBS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboDesignationBS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQteStockBS, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                        .addComponent(qteSortieBS, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAjouterBS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane3)
        );
        conteneurAjoutBE1Layout.setVerticalGroup(
            conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteneurAjoutBE1Layout.createSequentialGroup()
                .addGroup(conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteneurAjoutBE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQteStockBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qteSortieBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategorieBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDesignationBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjouterBS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conteneurAjoutBE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conteneurAjoutBE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel13))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabel49.setBackground(new java.awt.Color(-1966111,true));
        jLabel49.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel49.setForeground(new java.awt.Color(-16737844,true));
        jLabel49.setText("CARDER BORGOU/ALIBORI");

        jLabel51.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel51.setForeground(new java.awt.Color(-65536,true));
        jLabel51.setText("Service du Matériel et de l'Entretien (SME)");

        jLabel50.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel50.setForeground(new java.awt.Color(-13395457,true));
        jLabel50.setText("********o*******");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(415, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(137, 137, 137)))))
                .addGap(428, 428, 428))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1231, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 682, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Gérer les Bons de Sortie", jPanel3);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel64.setText("<html><u><b>FICHE DE STOCK</b></u></html>");

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Matériels par catégorie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(51, 153, 255))); // NOI18N

        btnVoirFicheStock2.setBackground(new java.awt.Color(255, 255, 255));
        btnVoirFicheStock2.setText("VOIR");
        btnVoirFicheStock2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnVoirFicheStock2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoirFicheStock2ActionPerformed(evt);
            }
        });

        comboCategorieConsultation.setEditable(true);
        comboCategorieConsultation.setFocusable(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoirFicheStock2)
                    .addComponent(comboCategorieConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCategorieConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoirFicheStock2))
        );

        btnInventaire.setBackground(new java.awt.Color(255, 255, 255));
        btnInventaire.setText("Inventaire");
        btnInventaire.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnInventaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventaireActionPerformed(evt);
            }
        });

        btnFactureImpayeeConsultation.setBackground(new java.awt.Color(255, 255, 255));
        btnFactureImpayeeConsultation.setText("Proposition d'achat");
        btnFactureImpayeeConsultation.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnFactureImpayeeConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactureImpayeeConsultationActionPerformed(evt);
            }
        });

        btnListFact.setBackground(new java.awt.Color(255, 255, 255));
        btnListFact.setText("Liste des Bons de Sortie");
        btnListFact.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnListFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListFactActionPerformed(evt);
            }
        });

        btnListBE.setBackground(new java.awt.Color(255, 255, 255));
        btnListBE.setText("Liste des Bons entrées");
        btnListBE.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnListBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListBEActionPerformed(evt);
            }
        });

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indiquez le nom de l'article", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 153, 255))); // NOI18N

        btnVoirFicheStock3.setBackground(new java.awt.Color(255, 255, 255));
        btnVoirFicheStock3.setText("VOIR");
        btnVoirFicheStock3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 0)))); // NOI18N
        btnVoirFicheStock3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoirFicheStock3ActionPerformed(evt);
            }
        });

        comboDesignationConsultation1.setEditable(true);
        comboDesignationConsultation1.setFocusable(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoirFicheStock3)
                    .addComponent(comboDesignationConsultation1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(comboDesignationConsultation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoirFicheStock3))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFactureImpayeeConsultation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListFact)
                            .addComponent(btnInventaire))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFactureImpayeeConsultation)
                .addGap(30, 30, 30)
                .addComponent(btnListBE)
                .addGap(26, 26, 26)
                .addComponent(btnListFact)
                .addGap(18, 18, 18)
                .addComponent(btnInventaire)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tblConsultation.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0)))); // NOI18N
        tblConsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " Ref Pièce", "Qte Entrée", "Qte Sortie", "P.U", "Remise", "Montant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblConsultation);

        btnImprimerConsultation.setText("IMPRIMER");
        btnImprimerConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimerConsultationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnImprimerConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(labConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimerConsultation)
                .addGap(34, 34, 34))
        );

        jLabel12.setBackground(new java.awt.Color(-1966111,true));
        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel12.setForeground(new java.awt.Color(-16737844,true));
        jLabel12.setText("CARDER BORGOU/ALIBORI");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel18.setForeground(new java.awt.Color(-13395457,true));
        jLabel18.setText("********o*******");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel21.setForeground(new java.awt.Color(-65536,true));
        jLabel21.setText("Service du Matériel et de l'Entretien (SME)");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(146, 146, 146))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultation", jPanel4);

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 204));

        jMenu1.setText("Fichier");

        jMenu3.setText("Nouveau");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem7.setText("Matériel");
        jMenu3.add(jMenuItem7);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Bon Entrée");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Bon Sortie");
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenu4.setText("Imprimer");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setText("Matériel");
        jMenu4.add(jMenuItem8);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setText("Bon Entrée");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Bon Sortie");
        jMenu4.add(jMenuItem4);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Afichage");

        jMenu5.setText("Liste");

        jMenuItem9.setText("Matériel");
        jMenu5.add(jMenuItem9);

        jMenuItem5.setText("Bon Entrée");
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Bon Sortie");
        jMenu5.add(jMenuItem6);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Paramètre");

        jMenuItem11.setText("Changer Mot de Passe");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem12.setText("Personnalisation");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Aide");

        jMenuItem14.setText("Documentation");
        jMenu7.add(jMenuItem14);

        jMenuItem16.setText("A propos du SGME");
        jMenu7.add(jMenuItem16);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void InitialisationCategorieMateriel()
    {
        try
    {
        String libelleCategorie =" select libelle from Categorie ";
        ResultSet resultat = st.executeQuery(libelleCategorie);
        while(resultat.next())
            comboCategorieMateriel.addItem(resultat.getString("libelle").toString());
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, " Echec d'initialisation de catégorie \n"+e.getMessage());
    }
}
    private void InitialiserMagasinMateriel()
    {
    try{
        ResultSet resultat = st.executeQuery(" select designation from Magasin ");
        while(resultat.next())
        {
            comboMagasinMateriel.addItem(resultat.getString("designation").toString());
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "Echec de récupération des magasins \n"+e.getMessage());
    }
}
    private void comboCategorieMaterielItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategorieMaterielItemStateChanged
        String codCategorie = null ; int nombre = 0;String codemateriel=null;
        try{
            ResultSet rs= st.executeQuery("select codCategorie from Categorie where libelle='"+comboCategorieMateriel.getSelectedItem()+"'");
            while (rs.next())
            {
                codCategorie= rs.getString(1).toString();
            }
            ResultSet r= st.executeQuery("select codMat from Materiel where codMat like '"+codCategorie+"%'");
            while(r.next())
            {
               codemateriel=r.getString("codMat").toString();
            }
            ResultSet rs1= st.executeQuery("select codMat from Materiel where codMat like '"+codCategorie+"%'");
            while(rs1.next())
            {
               nombre++;
            }
            nombre++;
            String codmat=""+codCategorie+nombre+"";
            if(codmat.equals(codemateriel))
            {
                nombre=nombre+1;
                txtCodMateriel.setText(codCategorie+ nombre);
            }
            else{
                txtCodMateriel.setText(codmat);
            }
            btnEnregistrerMateriel.setEnabled(true);
            btnModifierMateriel.setEnabled(false);
            btnSupprimerMateriel.setEnabled(false);
            //btnImprimerMateriel.setEnabled(false);
            txtQteDispoMateriel.setEnabled(false);
            txtQteDispoMateriel.setText("0");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Erreur d'initiation du code materiel "+e.getMessage());
        }
    }//GEN-LAST:event_comboCategorieMaterielItemStateChanged

    private void btnRecherMaterielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecherMaterielActionPerformed
        if(txtrechercheMateriel.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Veuillez renseigner le champs vide");
        } else
        {
            try{
                dt=new DefaultTableModel();
                dt.addColumn("CODMAT");
                dt.addColumn("DESIGNATION");
                dt.addColumn("QteEnSTOCK");
                dt.addColumn("MARQUE");
                dt.addColumn("MAGASIN");
                tableListeMateriel.setModel(dt);
                dt.setRowCount(0);
                String recherche; recherche= txtrechercheMateriel.getText().toString().toLowerCase();
                ResultSet rs=st.executeQuery("select codMat,Materiel.libelle,qteEnStock,marque,Categorie.libelle from Materiel,Categorie,Magasin where Materiel.codCategorie=Categorie.codCategorie and Materiel.numMagasin=Magasin.numMagasin and (Materiel.codMat='"+recherche+"'|| Materiel.libelle='"+recherche+"' || marque='"+recherche+"')");
                while(rs.next())
                {
                    String codmat=rs.getString(1);
                    String designation=rs.getString(2);
                    String qteEnstock=rs.getString(3);
                    String marque=rs.getString(4);
                    String magasin=rs.getString(5);
                    Object[] ob={codmat,designation,qteEnstock,marque,magasin};
                    dt.addRow(ob);
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Echec de recherche "+e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRecherMaterielActionPerformed

    private void tableListeMaterielMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListeMaterielMouseClicked
        int indiceLigne=tableListeMateriel.getSelectedRow();
        if(indiceLigne!=-1)
        {
            txtCodMateriel.setText(tableListeMateriel.getValueAt(indiceLigne, 0).toString());
            txtDesignationMateriel.setText(tableListeMateriel.getValueAt(indiceLigne, 1).toString());
            txtQteDispoMateriel.setText(dt.getValueAt(indiceLigne, 2).toString());
            txtMarqueMateriel.setText(tableListeMateriel.getValueAt(indiceLigne, 3).toString());
            comboMagasinMateriel.setSelectedItem(tableListeMateriel.getValueAt(indiceLigne, 4).toString());
            btnModifierMateriel.setEnabled(true);
            btnSupprimerMateriel.setEnabled(true);
            btnEnregistrerMateriel.setEnabled(false);

            txtQteDispoMateriel.setEnabled(true);
            txtQteDispoMateriel.setEditable(true);
            comboCategorieMateriel.setEnabled(false);
            conteneurEnreg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIFIER OU SUPPRIMER MATERIEL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(153, 153, 255)));
        }
    }//GEN-LAST:event_tableListeMaterielMouseClicked

    private void btnEnregistrerMaterielMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnregistrerMaterielMouseClicked
        if(txtDesignationMateriel.getText().isEmpty()||txtMarqueMateriel.getText().isEmpty()|| comboCategorieMateriel.getSelectedIndex()==0 ||comboMagasinMateriel.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        } else
        {
            int rep;
                rep=JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment enrégistrer ce materiel ?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(rep==JOptionPane.YES_OPTION)
                {
            try{
                String codCategorie = null,numMagasin = null;
                ResultSet rs= st.executeQuery("select codCategorie from Categorie where libelle='"+comboCategorieMateriel.getSelectedItem()+"'");
                while (rs.next())
                {
                    codCategorie= rs.getString(1).toString();
                }

                ResultSet rs1= st.executeQuery("select numMagasin from Magasin where designation='"+comboMagasinMateriel.getSelectedItem()+"'");
                while (rs1.next())
                {
                    numMagasin= rs1.getString(1).toString();
                }
                int t =st.executeUpdate("insert into Materiel values('"+txtCodMateriel.getText()+"','"+txtDesignationMateriel.getText()+"',"+0+",'"+txtMarqueMateriel.getText()+"','"+codCategorie+"','"+numMagasin+"')");
                if(t==1)JOptionPane.showMessageDialog(this,"Enregistrement fait avec succès");
                else JOptionPane.showMessageDialog(this,"Une erreur est survenue lors de l'enregistrement\n veillez reprendre !");
                txtCodMateriel.setText("");txtDesignationMateriel.setText("");txtMarqueMateriel.setText("");
                InitialiserTableListeMateriel();
                comboCategorieMateriel.setSelectedIndex(0);
                comboMagasinMateriel.setSelectedIndex(0);
                txtQteDispoMateriel.setEnabled(true);
                txtQteDispoMateriel.setText("");
                btnEnregistrerMateriel.setEnabled(false);
                btnModifierMateriel.setEnabled(false);
                btnSupprimerMateriel.setEnabled(false);
            }
                
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Enregistrement echoué"+e.getMessage());
            }
          }
        }
    }//GEN-LAST:event_btnEnregistrerMaterielMouseClicked

    private void btnModifierMaterielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierMaterielActionPerformed
        if(txtDesignationMateriel.getText().isEmpty()||txtMarqueMateriel.getText().isEmpty()||txtQteDispoMateriel.getText().isEmpty() ||comboMagasinMateriel.getSelectedIndex() ==0)
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        } else
        {
            try{
                int rep;
                rep=JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment modifier ce materiel ?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(rep==JOptionPane.YES_OPTION)
                {
                    String codMat,designation,qte,numMagasin = null,marque;int qteEnStock=0;
                    qte=txtQteDispoMateriel.getText().toString().toUpperCase();
                    qteEnStock = Integer.parseInt(qte);
                    try{
                        ResultSet rs1= st.executeQuery("select numMagasin from Magasin where designation='"+comboMagasinMateriel.getSelectedItem()+"'");
                        while (rs1.next())
                        {
                            numMagasin= rs1.getString(1).toString();
                        }
                        codMat= txtCodMateriel.getText().toString().toUpperCase();
                        designation= txtDesignationMateriel.getText().toString().toLowerCase();
                        marque= txtMarqueMateriel.getText().toString().toLowerCase();
                        int t= st.executeUpdate("update Materiel set libelle='"+designation+"',qteEnStock='"+qteEnStock+"', marque='"+marque+"', numMagasin='"+numMagasin+"' where codMat='"+codMat+"'");
                        if(t==1) JOptionPane.showMessageDialog(this," le matériel "+codMat+" a été bien modifié ");
                        else JOptionPane.showMessageDialog(this," Une erreur est survenue lors de l'exécution de le modification \n veillez reprendre l'opération !");
                        txtCodMateriel.setText("");txtDesignationMateriel.setText("");txtMarqueMateriel.setText(""); txtQteDispoMateriel.setText("");

                        InitialiserTableListeMateriel();
                        btnEnregistrerMateriel.setEnabled(false);
                        btnModifierMateriel.setEnabled(false);
                        btnSupprimerMateriel.setEnabled(false);
                        //btnImprimerMateriel.setEnabled(false);
                        //comboCategorieMateriel.setSelectedItem("Choississez une Catégorie");
                        comboCategorieMateriel.setEnabled(true);
                        comboMagasinMateriel.setSelectedItem("Choississez un Magasin");
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this, " Echec de modification "+e.getMessage());
                    }
                }
                else{
                    txtCodMateriel.setText("");txtDesignationMateriel.setText("");txtMarqueMateriel.setText(""); txtQteDispoMateriel.setText("");
                    InitialiserTableListeMateriel();
                    btnEnregistrerMateriel.setEnabled(false);
                    btnModifierMateriel.setEnabled(false);
                    btnSupprimerMateriel.setEnabled(false);
                    //btnImprimerMateriel.setEnabled(false);
                    comboCategorieMateriel.setEnabled(true);
                    comboCategorieMateriel.setSelectedItem("Choississez une Catégorie");
                    comboMagasinMateriel.setSelectedItem("Choississez un Magasin");
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this," la quantité doit être un entiers"+e.getMessage());

            }
        }
    }//GEN-LAST:event_btnModifierMaterielActionPerformed
private void InitialiserTableListeMateriel()
    {
          dt.addColumn("CODMAT");
          dt.addColumn("DESIGNATION");
          dt.addColumn("QteEnSTOCK");
          dt.addColumn("MARQUE");
          dt.addColumn("MAGASIN");
          tableListeMateriel.setModel(dt);
          dt.setRowCount(0);
              try{
                   ResultSet rs=st.executeQuery("select  distinct codMat,Materiel.libelle,qteEnStock,marque,Magasin.designation from Materiel,Magasin where Materiel.numMagasin=Magasin.numMagasin");
                    while(rs.next())
                      {
                         String codmat=rs.getString(1);
                         String designation=rs.getString(2);
                         String qteEnstock=rs.getString(3);
                         String marque=rs.getString(4);
                         String magasin=rs.getString(5);
                         Object[] ob={codmat,designation,qteEnstock,marque,magasin};
                         dt.addRow(ob);
                      }
                 }catch(Exception e)
                 {
                       JOptionPane.showMessageDialog(null,"Erreur d'initialisation de la liste des materiel "+" "+e.getMessage());
                 }
    }

    private void btnSupprimerMaterielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerMaterielActionPerformed
        if(txtCodMateriel.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Selectionner le materiel à supprimer puis cliquer sur 'Supprimer' ");
        } else
        {
            int rep;
            rep=JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer ce materiel ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(rep==JOptionPane.YES_OPTION)
            {
                try{
                    String codMat; codMat= txtCodMateriel.getText().toString().toUpperCase();
                    try{
                        st.executeUpdate("delete from  Materiel  where codMat='"+codMat+"'");
                        JOptionPane.showMessageDialog(this,"le matériel a été bien supprimé");
                        txtCodMateriel.setText("");txtDesignationMateriel.setText("");txtMarqueMateriel.setText(""); txtQteDispoMateriel.setText("");

                        InitialiserTableListeMateriel();
                        btnEnregistrerMateriel.setEnabled(false);
                        btnModifierMateriel.setEnabled(false);
                        btnSupprimerMateriel.setEnabled(false);
                        //btnImprimerMateriel.setEnabled(false);
                        comboCategorieMateriel.setSelectedItem("Choississez une Catégorie");
                        comboCategorieMateriel.setEnabled(true);
                        comboMagasinMateriel.setSelectedItem("Choississez un Magasin");
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this, "Suppression echoué"+e.getMessage());
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(this," la quantité doit être un entiers"+e.getMessage());
                    txtQteDispoMateriel.setText("");
                }
            }
            else{
                txtCodMateriel.setText("");txtDesignationMateriel.setText("");
                txtMarqueMateriel.setText(""); txtQteDispoMateriel.setText("");
                InitialiserTableListeMateriel();
                btnEnregistrerMateriel.setEnabled(false);
                btnModifierMateriel.setEnabled(false);
                btnSupprimerMateriel.setEnabled(false);
               // btnImprimerMateriel.setEnabled(false);
                comboCategorieMateriel.setSelectedItem("Choississez une Catégorie");
                comboCategorieMateriel.setEnabled(true);
                comboMagasinMateriel.setSelectedItem("Choississez un Magasin");
            }
        }
    }//GEN-LAST:event_btnSupprimerMaterielActionPerformed

    private void txtrechercheMaterielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrechercheMaterielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrechercheMaterielActionPerformed
private void InitialiserTableBE()
    {
          dtBE=new DefaultTableModel();
          dtBE.addColumn("REF BE");
          dtBE.addColumn("DATE EDITION");
          dtBE.addColumn("REF BON LIVRAISON");
          dtBE.addColumn("FOURNISSEUR");
          tbleListeBonEntre.setModel(dtBE);
          dtBE.setRowCount(0);
              try{
                   ResultSet rs=st.executeQuery("select refBE,datEditionBE,refBL, nomFrs from BonEntree,Fournisseur where BonEntree.numFrs=Fournisseur.numFrs ");  
                   while(rs.next())
                      {
                         Object[] ob={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                         dtBE.addRow(ob);
                      }
                 }catch(Exception e)
                 {
                       JOptionPane.showMessageDialog(null,"Erreur d'initialisation de la liste des Bons d'Entrées "+e.getMessage());
                 }
    }
    private void InitialisationCategorieBE()
    {
        try
    {
        String libelleCategorie =" select Categorie.libelle from Categorie ";
       ResultSet resultat = st.executeQuery(libelleCategorie);
        while(resultat.next())
            comboCategorieBE.addItem(resultat.getString("libelle").toString());

    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de catégorie échoué");
    }
}
    private void InitialisationCategorieConsultation()
    {
        try
    {
        String libelleCategorie =" select Categorie.libelle from Categorie ";
       ResultSet resultat = st.executeQuery(libelleCategorie);
        while(resultat.next())
            comboCategorieConsultation.addItem(resultat.getString("libelle").toString());
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de catégorie échoué");
    }
}
    private void InitialiserFournisseurBE()
    {
      try
    {
        ResultSet resultat = st.executeQuery(" select nomFrs from Fournisseur ");
        while(resultat.next())
            comboFrsBE.addItem(resultat.getString("nomFrs").toString());

    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de nom fournisseur échoué");
    }
}
    
 private void InitialiserReferenceBE()
    {
        //incrementation du nombre par année
        try
        {
          int nombre = 0; 
          ResultSet resu = st.executeQuery("select refBE from BonEntree where refBE like '"+Calendar.getInstance().get(Calendar.YEAR)+"%' ");
        while(resu.next())
        {
            if(resu.isLast())nombre = Integer.parseInt(resu.getString("refBE").substring(6));
        } 
        nombre++;
         txtrefBE.setText(reference(nombre, "BE"));
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(this, e);
      }
    }
    private void comboCategorieBEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategorieBEItemStateChanged
        try
        {  if(comboCategorieBE.getSelectedItem().equals("Catégorie")) comboDesignationBE.setSelectedIndex(0);
            else
            {  comboDesignationBE.removeAllItems();
                comboDesignationBE.addItem("Matériel");
                ResultSet rs= st.executeQuery("select Materiel.libelle from Materiel,Categorie where Materiel.CodCategorie=Categorie.codCategorie and Categorie.libelle='"+comboCategorieBE.getSelectedItem()+"'");
                while (rs.next())
                {
                    comboDesignationBE.addItem(rs.getString("libelle").toString());
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_comboCategorieBEItemStateChanged

    private void comboDesignationBEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDesignationBEItemStateChanged
        try{
            ResultSet rs= st.executeQuery("select qteEnStock from Materiel where libelle='"+comboDesignationBE.getSelectedItem()+"'");
            while (rs.next())
            {
                txtQteStockBE.setText(rs.getString(1));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_comboDesignationBEItemStateChanged

    private void comboDesignationBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDesignationBEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDesignationBEActionPerformed

    private void btnAjouterBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterBEActionPerformed
        if(qteEntreBE.getText().isEmpty()|| txtPUFrs.getText().isEmpty()|| comboCategorieBE.getSelectedItem().toString().equalsIgnoreCase("Catégorie") || comboDesignationBE.getSelectedItem().toString().equalsIgnoreCase("Désignation"))
        {
            JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs vides");
        }
        else
        {
            int rep;
            rep = JOptionPane.showConfirmDialog (this, "Voulez-vous vraiment continuer ?","Ajout d'une ligne d'entrée", JOptionPane.YES_NO_OPTION) ;
            if(rep==JOptionPane.YES_OPTION)
            {
                String q=qteEntreBE.getText().toString();
                int qt2=Integer.parseInt(q);
                if(qt2<=0)
                {
                    JOptionPane.showMessageDialog(this, " Quantité saissie non valide ! \n Veuillez saisir une quantité supérieur à zero (0).");
                    qteEntreBE.setText(null);
                }
                else
                {
                        String p=txtPUFrs.getText().toString();
                        int puf=Integer.parseInt(p);
                        if(puf<=0)
                        {
                            JOptionPane.showMessageDialog(this, " Prix saisi non valide! \n saissisez  un autre.");
                            txtPUFrs.setText("");
                        }
                        else
                        {
                            dtBE.addColumn("Categorie");
                            dtBE.addColumn("Matériel");
                            dtBE.addColumn("Quantité Entrée");
                            dtBE.addColumn("Prix Unitaire");
                            Object[] ob={comboCategorieBE.getSelectedItem().toString(),comboDesignationBE.getSelectedItem().toString(),qteEntreBE.getText(),txtPUFrs.getText()}; 
                            dtBE.addRow(ob);tbleListeMaterielEntreBE.setModel(dtBE);                        
                            txtPUFrs.setText("");
                            qteEntreBE.setText("");
                            comboCategorieBE.setSelectedIndex(0);
                            comboDesignationBE.setSelectedIndex(0);
                       }
                }
            }
            btnEnregistrerBE.setEnabled(true);
        }
    }//GEN-LAST:event_btnAjouterBEActionPerformed

    private void qteEntreBEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qteEntreBEKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
           getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_qteEntreBEKeyTyped

    private void txtPUFrsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPUFrsKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
           getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPUFrsKeyTyped

    private void txtQteDispoMaterielKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQteDispoMaterielKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
           getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtQteDispoMaterielKeyTyped
// Bon sorties
    private void InitialiserTableBonSortie()
    {
        dtBS=new DefaultTableModel();
          dtBS.addColumn("REFERENCE BS");
          dtBS.addColumn("DATE EDITION");
          dtBS.addColumn("REFERENCE DEMANDE D'ACHAT");
          dtBS.addColumn("RECEPTIONNAIRE");
          dtBS.addColumn("SERVICE BENEFICIAIRE");
          tbleListeBonSortie.setModel(dtBS);
          dtBS.setRowCount(0);
              try{
                   ResultSet rs=st.executeQuery("select refBS,datEditionBS,refDemandeAchat,receptionnaire, nomService from BonSortie,Service where BonSortie.codService=Service.codService");
                   while(rs.next())
                      {
                         String refbs=rs.getString(1);
                         String date=rs.getString(2);
                         String refdemandeAchat=rs.getString(3);
                         String receptionnaire=rs.getString(4);
                         String nomService=rs.getString(5);
                         Object[] ob={refbs,date,refdemandeAchat,receptionnaire,nomService};
                         dtBS.addRow(ob);

                      }
                 }catch(Exception e)
                 {
                       JOptionPane.showMessageDialog(null,"Erreur d'initialisation de la liste des Bons de sortie "+e.getMessage());
                 }
       
    }
   private void InitialisationCategorieBS()
    {
        try
    {
        String libelleCategorie =" select libelle from Categorie ";
        ResultSet resultat = st.executeQuery(libelleCategorie);
        while(resultat.next())
            comboCategorieBS.addItem(resultat.getString("libelle").toString());

    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de catégorie échoué");
    }
}
   private void InitialiserComboService()
    {
       try
    {
        ResultSet resultat = st.executeQuery(" select nomService from Service ");
        while(resultat.next())
            comboServiceBS.addItem(resultat.getString("nomService").toString());
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de nom Service échouée");
    }
   }
   private void InitialiserNomMagasinierBS()
    {
      try
    {
        ResultSet resultat = st.executeQuery(" select nomUtilisateur , prenomUtilisateur from Utilisateur where fonction='Magasinier'");
        while(resultat.next())
        {
            String nom = resultat.getString(1).toString();
            String prenom = resultat.getString(2).toString();
            String res=nom+" "+prenom;           
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de nom Magasinier échoué");
    }
   }
   private void InitialiserRefBS()
    {
      //incrementation du nombre par année
        int nombre = 0;
       try
        {
           ResultSet  resu = st.executeQuery("select refBS from BonSortie where refBS like '"+Calendar.getInstance().get(Calendar.YEAR)+"%' ");
          while(resu.next())
          {
           if(resu.isLast())nombre = Integer.parseInt(resu.getString("refBS").substring(6));
          } resu.close(); 
           nombre++;
           txtRefBS.setText(reference(nombre, "BS"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
   }
    private void btnRechercherBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherBSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRechercherBSActionPerformed

    private void tbleListeBonSortieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleListeBonSortieMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbleListeBonSortieMouseClicked

    private void btnEnregistrerBSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnregistrerBSMouseClicked

        if(txtDateeditionBS.getDateFormatString().isEmpty()||txtrefDemandeAchat.getText().isEmpty()||comboServiceBS.getSelectedItem().equals("Choississez un Service"))
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        }
        else
        {
            try{
                String refbs,datebs,refdemandeAchat,receptionnaire ;String service = null;
                ResultSet rs= st.executeQuery("select codService from Service where nomService='"+comboServiceBS.getSelectedItem()+"'");
                while (rs.next())
                {
                    service= rs.getString(1).toString();
                }
                
                refbs= txtRefBS.getText().toString().toUpperCase();
                datebs= this.getSelectedDate(txtDateeditionBS);
                receptionnaire=txtReceptionnaire.getText().toString().toLowerCase();
                refdemandeAchat= txtrefDemandeAchat.getText().toString().toLowerCase();
                st.executeUpdate("insert into BonSortie values('"+refbs+"','"+datebs+"','"+refdemandeAchat+"','"+receptionnaire+"','"+service+"','"+this.numUtilisateur+"')");
                JOptionPane.showMessageDialog(this,"Enregistrement fait avec succès");
                txtRefBS.setText("");txtDateeditionBS.setDateFormatString("");txtrefDemandeAchat.setText("");txtReceptionnaire.setText("");
                InitialiserRefBS();
                btnEnregistrerBS.setEnabled(false);
                btnModifierBS.setEnabled(false);
                btnSupprimerBS.setEnabled(false);
                btnImprimerBS.setEnabled(false);
                dtBS.setRowCount(0);
                comboCategorieBS.setSelectedItem("Choisir sa catégorie");
                comboDesignationBS.setSelectedItem(" choissisez sa Désignation");
                comboServiceBS.setSelectedItem("Choississez un Service");
                InitialiserTableBonSortie();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Enregistrement echoué"+e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEnregistrerBSMouseClicked

    private void btnModifierBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierBSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifierBSActionPerformed

    private void btnSupprimerBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerBSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupprimerBSActionPerformed
private void InitialisationDesignationConsultation()
    {
        try
    {
        String libelleCategorie ="select libelle from Materiel";
       ResultSet resultat = st.executeQuery(libelleCategorie);
        while(resultat.next())
            comboDesignationConsultation1.addItem(resultat.getString("libelle").toString());
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(this, "initialisation de catégorie échoué");
    }
}
    private void comboCategorieBSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategorieBSItemStateChanged
        // TODO add your handling code here:
        try{
            comboDesignationBS.removeAllItems();
            ResultSet rs= st.executeQuery("select Materiel.libelle from Materiel,Categorie where Materiel.CodCategorie=Categorie.codCategorie and Categorie.libelle='"+comboCategorieBS.getSelectedItem()+"'");
            while (rs.next())
            {
                comboDesignationBS.addItem(rs.getString("libelle").toString());
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_comboCategorieBSItemStateChanged

    private void comboDesignationBSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDesignationBSItemStateChanged
        // TODO add your handling code here:
        try{
            String qte=null;
            ResultSet rs= st.executeQuery("select qteEnStock from Materiel where libelle='"+comboDesignationBS.getSelectedItem()+"'");
            while (rs.next())
            {
                qte=rs.getString(1).toString();
            }
            txtQteStockBS.setText(qte);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_comboDesignationBSItemStateChanged

    private void comboDesignationBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDesignationBSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDesignationBSActionPerformed

    private void btnAjouterBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterBSActionPerformed
        if(qteSortieBS.getText().isEmpty()|| comboServiceBS.getSelectedItem().equals("Choississez un Service"))
        {
            JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs vides");
        }
        else
        {
            int rep;
            rep = JOptionPane.showConfirmDialog (this, "Voulez-vous vraiment ajouter cette ligne de Sortie ?","Ajout d'une ligne de sortie", JOptionPane.YES_NO_OPTION) ;
            if(rep==JOptionPane.YES_OPTION)
            {
                String q1=txtQteStockBS.getText().toString();
                String q2=qteSortieBS.getText().toString();
                int qt1=Integer.parseInt(q1);
                int qt2=Integer.parseInt(q2);
                if(qt1<qt2)
                {
                    JOptionPane.showMessageDialog(this, "Attention ! \n La quantité disponible est insuffisante pour satisfaire votre demande.");
                    qteSortieBS.setText("");
                }
                else if(qt2<=0)
                {
                    JOptionPane.showMessageDialog(this, "Inutile d'ajouter cette ligne ! \n Veuillez ajouter une quantité non nulle et positive.");
                    qteSortieBS.setText("");
                }
                else
                {

                    try{
                        String codmat = null,qteEnStock = null;
                        ResultSet resultat = st.executeQuery(" select codMat,qteEnstock from Materiel where libelLe='"+comboDesignationBS.getSelectedItem()+"' ");
                        while(resultat.next())
                        {
                            codmat = resultat.getString(1).toString();
                            qteEnStock=resultat.getString(2).toString();
                        }
                        String refBS=txtRefBS.getText().toString();
                        String qte=qteSortieBS.getText().toString();
                        st.executeUpdate("insert into LigneSortie values('"+refBS+"','"+codmat+"','"+qte+"')");
                        dtBS= new DefaultTableModel();
                        dtBS.addColumn("RefBS");
                        dtBS.addColumn("DESIGNATION");
                        dtBS.addColumn("QTE SORTIE");
                        dtBS.addColumn("SERVICE BENEFICIAIRE");
                        tbleListeMaterielSortieBS.setModel(dtBS);
                        qteSortieBS.setText("");
                        txtQteStockBS.setText("");
                        String service=comboServiceBS.getSelectedItem().toString();
                        ResultSet rs=st.executeQuery("select libelle,qteSortie from LigneSortie,Materiel where LigneSortie.codMat=Materiel.codMat and refBS='"+refBS+"'");
                        while(rs.next())
                        {
                            String designation=rs.getString(1);
                            String qteSortie=rs.getString(2);
                            Object[] ob={refBS,designation,qteSortie,service};
                            dtBS.addRow(ob);
                        }
                        int qteTotal;
                        int Qa=Integer.parseInt(qteEnStock);
                        int Qa1=Integer.parseInt(qte);
                        qteTotal=Qa-Qa1;
                        st.executeUpdate("update Materiel set qteEnStock='"+qteTotal+"' where codMat='"+codmat+"'");
                        InitialiserTableListeMateriel();
                        btnEnregistrerBS.setEnabled(true);
                        btnModifierBS.setEnabled(false);
                        btnSupprimerBS.setEnabled(false);
                        btnImprimerBS.setEnabled(false);
                    }catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this, "SSSSSSSSSSS");
                    }
                }
            }
            else
            {
                qteEntreBE.setText("");
                txtQteStockBE.setText("");
            }
        }
    }//GEN-LAST:event_btnAjouterBSActionPerformed

    private void qteSortieBSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qteSortieBSKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
           getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_qteSortieBSKeyTyped

    private void btnVoirFicheStock2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoirFicheStock2ActionPerformed
        // TODO add your handling code here:

        try{
            labConsultation.setText("Liste des matériels de la catégorie "+comboCategorieConsultation.getSelectedItem());
           dt=new DefaultTableModel();
                dt.addColumn("CODMAT");
                dt.addColumn("DESIGNATION");
                dt.addColumn("QteEnSTOCK");
                dt.addColumn("MARQUE");
                dt.addColumn("MAGASIN");
                tableListeMateriel.setModel(dt);
                dt.setRowCount(0);
                ResultSet rs=st.executeQuery("select codMat,Materiel.libelle,qteEnStock,marque,Magasin.designation from Materiel,Categorie,Magasin where Materiel.codCategorie=Categorie.codCategorie and Materiel.numMagasin=Magasin.numMagasin and Categorie.libelle='"+comboCategorieConsultation.getSelectedItem()+"'");
                while(rs.next())
                {
                    String codmat=rs.getString(1);
                    String designation=rs.getString(2);
                    String qteEnstock=rs.getString(3);
                    String marque=rs.getString(4);
                    String magasin=rs.getString(5);
                    Object[] ob={codmat,designation,qteEnstock,marque,magasin};
                    dt.addRow(ob);
                }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'initialisation de la liste des mteriels" +e.getMessage());
        }

    }//GEN-LAST:event_btnVoirFicheStock2ActionPerformed

    private void btnInventaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventaireActionPerformed
        // TODO add your handling code here:
        dt=new DefaultTableModel();
        dt.addColumn("PRODUIT");
        dt.addColumn("ENTREES");
        dt.addColumn("SORTIES");
        dt.addColumn("QTE EN STOCK");
        dt.addColumn("STOCK REEL");
        dt.addColumn("DIFFERENCE");
        dt.addColumn("OBSERVATION");
        tblConsultation.setModel(dt);
        dt.setRowCount(0);
        labConsultation.setText("INVENTAIRE DES ARTICLES DU CARDER BORGOU ALIBORI AU ......");
        try{
            ResultSet rs=st.executeQuery("select libelle,sum(qteEntree) as 'qteEntree',sum(qteSortie) as 'qteSortie',qteEnStock from ligneSortie,ligneentree,Materiel where Materiel.codMat=ligneentree.codMat and ligneSortie.codMat=Materiel.codMat group by libelle order by qteEntree asc");
            while(rs.next())
            {
                String lib=rs.getString(1);
                String qteEntree=rs.getString(2);
                String qteSortie=rs.getString(3);
                String qteEnStock=rs.getString(4);
                Object[] ob={lib,qteEntree,qteSortie,qteEnStock};
                dt.addRow(ob);
            }
            ResultSet rs1=st.executeQuery("select libelle,sum(qteEntree) as 'qteEntree',qteEnStock from ligneentree,Materiel where Materiel.codMat=ligneentree.codMat and libelle not in(select libelle from ligneSortie,ligneentree,Materiel where Materiel.codMat=ligneentree.codMat  and  ligneSortie.codMat=Materiel.codMat group by libelle order by qteEntree asc)  group by libelle order by qteEntree asc ");
            while(rs1.next())
            {
                String lib=rs1.getString(1);
                String qteEntree="-";
                String qteSortie="-";
                String qteEnStock=rs1.getString(2);
                Object[] ob={lib,qteEntree,qteSortie,qteEnStock};
                dt.addRow(ob);
            }
             ResultSet rs2=st.executeQuery("select libelle, qteEnStock from Materiel where libelle not in(select libelle from ligneentree,Materiel where Materiel.codMat=ligneentree.codMat )  group by libelle");
            while(rs2.next())
            {
                String lib=rs2.getString(1);
                String qteEntree="-";
                String qteSortie="-";
                String qteEnStock=rs2.getString(2);
                Object[] ob={lib,qteEntree,qteSortie,qteEnStock};
                dt.addRow(ob);
            }
            }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'initialisation du tableau d'inventaires"+e.getMessage());
        }
    }//GEN-LAST:event_btnInventaireActionPerformed

    private void btnFactureImpayeeConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactureImpayeeConsultationActionPerformed
        // TODO add your handling code here:
        dt=new DefaultTableModel();
        dt.addColumn("CODE MATERIEL");
        dt.addColumn("LIBELLE");
        dt.addColumn("QUANTITE EN STOCK");
        dt.addColumn("MARQUE");
        dt.addColumn("MAGASIN");
        tblConsultation.setModel(dt);
        dt.setRowCount(0);
        labConsultation.setText("PROPOSITION D'ACHAT");
        try{
            ResultSet rs=st.executeQuery("select codMat,libelle,qteEnStock,marque,designation from materiel,Magasin where materiel.nummagasin=magasin.nummagasin and qteEnstock<10");
            while(rs.next())
            {
                String codmat=rs.getString(1);
                String libelle=rs.getString(2);
                String qte=rs.getString(3);
                String marque=rs.getString(4);
                String desi=rs.getString(5);
                Object[] ob={codmat,libelle,qte,marque,desi};
                dt.addRow(ob);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'initialisation de proposition d'achat"+e.getMessage());
        }
    }//GEN-LAST:event_btnFactureImpayeeConsultationActionPerformed

    private void btnListFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListFactActionPerformed
        // TODO add your handling code here:
        dt=new DefaultTableModel();
        dt.addColumn("REF BS");
        dt.addColumn("DATE ");
        dt.addColumn("SERVICE");
        tblConsultation.setModel(dt);
        dt.setRowCount(0);
        labConsultation.setText("Liste des Bons de Sortie  ");
        Calendar cal;
        cal = Calendar.getInstance();
        int annee= cal.get(Calendar.YEAR);
        try{
            
            ResultSet rs=st.executeQuery("select refBS,dateditionBS,nomService from Service,BonSortie where Service.codService=BonSortie.codService  and refbS like '"+annee+"%' order by dateditionBS asc");
            while(rs.next())
            {
                String numfac=rs.getString(1);
                String datfac=rs.getString(2);
                String nomclient=rs.getString(3);
                Object[] ob={numfac,datfac,nomclient};
                dt.addRow(ob);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'initialisation de la facture impayée"+e.getMessage());
        }
    }//GEN-LAST:event_btnListFactActionPerformed

    private void btnListBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListBEActionPerformed
        // TODO add your handling code here:
        dt=new DefaultTableModel();
        dt.addColumn("REF BE");
        dt.addColumn("DATE BE");
        dt.addColumn("REF BL");
        dt.addColumn("NOM FRS");
        dt.addColumn("TELEPHONE");
        tblConsultation.setModel(dt);
        dt.setRowCount(0);
        labConsultation.setText("LISTE DES BORDEREAUX D'ENTREES");
        Calendar cal;
        cal = Calendar.getInstance();
        int annee= cal.get(Calendar.YEAR);
        try{
            ResultSet rs=st.executeQuery("select refBE,dateditionBE,refBL,nomFrs,telephone from Fournisseur,BonEntree where Fournisseur.numFrs=BonEntree.numFrs  and refbe like '"+annee+"%' order by dateditionBE asc");
            while(rs.next())
            {
                String refbe=rs.getString(1);
                String datbe=rs.getString(2);
                String refbl=rs.getString(3);
                String nomfrs=rs.getString(4);
                String telephone=rs.getString(5);
                Object[] ob={refbe,datbe,refbl,nomfrs,telephone};
                dt.addRow(ob);
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erreur d'initialisation du bordereau d'entrees"+e.getMessage());
        }
    }//GEN-LAST:event_btnListBEActionPerformed

    private void btnImprimerConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimerConsultationActionPerformed
        // TODO add your handling code here:
        MessageFormat header= new MessageFormat(" Fiche de stock ");
        MessageFormat footer= new MessageFormat(" 0,number,Integer ");
        try{
            tblConsultation.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e)
        {
            System.err.format("impossible d'imprimer", e.getMessage());
        }
    }//GEN-LAST:event_btnImprimerConsultationActionPerformed

    private void btnSupprimerBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerBEActionPerformed

        if(txtDateEditionBE.getDateFormatString().isEmpty()||txtRefBonLivraisonBE.getText().isEmpty()||comboFrsBE.getSelectedItem().equals("Choissisez un Fournisseur"))
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        } else
        {
            int rep;
            rep=JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment supprimer ce materiel ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(rep==JOptionPane.YES_OPTION)
            {
                try{
                    List listCodMat= new LinkedList();
                    List listQteEntree= new LinkedList();
                    String refbe; refbe= txtrefBE.getText().toString().toUpperCase();
                    ResultSet rs=st.executeQuery("select codMat,qteEntree from LigneEntree where refBE='"+refbe+"'");
                    while(rs.next())
                    {
                        listCodMat.add(rs.getString("codMat"));
                        listQteEntree.add(rs.getString("qteEntree"));
                    }
                    ListIterator l = listCodMat.listIterator();
                    ListIterator li = listQteEntree.listIterator();
                    while(l.hasNext())
                    {
                        String cod=l.next().toString();
                        String q=li.next().toString();
                        st.executeUpdate("update Materiel set qteEnStock=qteEnStock- '"+q+"'  where codMat='"+cod+"'");

                    }
                    st.executeUpdate("delete from  BonEntree  where refBE='"+refbe+"'");
                    st.executeUpdate("delete from  LigneEntree  where refBE='"+refbe+"'");

                    JOptionPane.showMessageDialog(this,"Suppression fait avec succès");
                    txtDateEditionBE.setDateFormatString("");
                    txtRefBonLivraisonBE.setText("");comboFrsBE.setSelectedItem("Choissisez un Fournisseur");
                    InitialiserTableBE();
                    InitialiserTableListeMateriel();
                    btnEnregistrerBE.setEnabled(false);
                    btnModifierBE.setEnabled(false);
                    btnSupprimerBE.setEnabled(false);
                    btnImprimerBE.setEnabled(false);
                    btnAjouterBE.setEnabled(true);
                    InitialiserReferenceBE();
                    dtBE.setRowCount(0);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, "Suppression echoué"+e.getMessage());
                }
            }
            else{
                txtDateEditionBE.setDateFormatString("");
                txtRefBonLivraisonBE.setText("");comboFrsBE.setSelectedItem("Choissisez un Fournisseur");
                InitialiserTableBE();
                btnEnregistrerBE.setEnabled(false);
                btnModifierBE.setEnabled(false);
                btnSupprimerBE.setEnabled(false);
                btnImprimerBE.setEnabled(false);
                btnAjouterBE.setEnabled(true);
                InitialiserReferenceBE();
                dtBE.setRowCount(0);
            }
        }
    }//GEN-LAST:event_btnSupprimerBEActionPerformed

    private void btnModifierBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierBEActionPerformed
        if(txtRefBonLivraisonBE.getText().isEmpty()||comboFrsBE.getSelectedItem().equals("Choissisez un Fournisseur"))
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        } else
        {
            int rep=JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment Modifier ce Bon d'Entrée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if(rep==JOptionPane.YES_OPTION)
            {
                String refbe,datebe = null,refbl,numfrs = null;
                try{
                    ResultSet rs1= st.executeQuery("select numFrs from Fournisseur where nomFrs='"+comboFrsBE.getSelectedItem()+"'");
                    while (rs1.next())
                    {
                        numfrs= rs1.getString(1).toString();
                    }
                    refbe= txtrefBE.getText().toString().toUpperCase();
                    datebe= txtDateEditionBE.getDateFormatString().toString().toLowerCase();
                    refbl= txtRefBonLivraisonBE.getText().toString().toLowerCase();
                    st.executeUpdate("update BonEntree set datEditionBE='"+datebe+"',refBL='"+refbl+"', numFrs='"+numfrs+"' where refBE='"+refbe+"'");
                    JOptionPane.showMessageDialog(null,"Modification fait avec succès");
                    txtDateEditionBE.setDateFormatString("");
                    txtRefBonLivraisonBE.setText("");comboFrsBE.setSelectedItem("Choissisez un Fournisseur");
                    InitialiserTableBE();
                    btnEnregistrerBE.setEnabled(false);
                    btnModifierBE.setEnabled(false);
                    btnSupprimerBE.setEnabled(false);
                    btnImprimerBE.setEnabled(false);
                    btnAjouterBE.setEnabled(true);
                    InitialiserReferenceBE();
                    dtBE.setRowCount(0);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, "Modification echouée"+e.getMessage());
                }
            }
            else{
                txtDateEditionBE.setDateFormatString("");
                txtRefBonLivraisonBE.setText("");comboFrsBE.setSelectedItem("Choissisez un Fournisseur");
                InitialiserTableBE();
                btnEnregistrerBE.setEnabled(false);
                btnModifierBE.setEnabled(false);
                btnSupprimerBE.setEnabled(false);
                btnImprimerBE.setEnabled(false);
                btnAjouterBE.setEnabled(true);
                InitialiserReferenceBE();
                dtBE.setRowCount(0);
            }
        }
    }//GEN-LAST:event_btnModifierBEActionPerformed

    private void btnImprimerBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimerBEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimerBEActionPerformed

    private void btnEnregistrerBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerBEActionPerformed
        if(txtRefBonLivraisonBE.getText().isEmpty()||comboFrsBE.getSelectedItem().equals("Choissisez un Fournisseur") || dtBE.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs vides");
        }
        else
        {   try
            {
                String refbe,datebe = null,refbl ;String frs = null;
                ResultSet rs= st.executeQuery("select numFrs from Fournisseur where nomFrs='"+comboFrsBE.getSelectedItem().toString()+"'");
                while (rs.next())
                {
                    frs= rs.getString(1).toString();
                }
                refbe= txtrefBE.getText().toString();
                datebe= this.getSelectedDate(txtDateEditionBE);
                refbl= txtRefBonLivraisonBE.getText().toString().toLowerCase();
                int s =0,r = st.executeUpdate("insert into BonEntree values('"+refbe+"','"+datebe+"','"+refbl+"','"+frs+"','"+this.numUtilisateur+"')");
                String codMat = null;int i = 0;
                while( i < tbleListeMaterielEntreBE.getRowCount() )
                {
                    ResultSet ss = st.executeQuery("select codMat from Materiel where libelle ='"+dtBE.getValueAt(i, 1)+"'");
                    while(ss.next())codMat = ss.getString(1);
                    s = st.executeUpdate("insert into ligneEntree values('"+refbe+"','"+codMat+"', "+dtBE.getValueAt(i, 2)+")");
                    ResultSet resultSetQte = st.executeQuery("select qteEnStock from Materiel where codMat = '"+codMat+"'");
                    int qteS=0;
                    while(resultSetQte.next())qteS = Integer.parseInt(resultSetQte.getString("qteEnStock"))+Integer.parseInt(tbleListeMaterielEntreBE.getValueAt(i, 2).toString());
                    st.executeUpdate("update Materiel set qteEnStock= "+qteS+" where codMat = '"+codMat+"'");
                    i++;
                }
                if(r==1 && s==1)JOptionPane.showMessageDialog(null,"Enregistrement fait avec succès");
                else
                { JOptionPane.showMessageDialog(null,"Une erreur est survenue lors de l'enregistrement ! \n Veillez reprendre l'enregistrement");
                    if(r==1) st.executeUpdate("delete from BonEntree where refBE ='"+refbe+"'");
                    else if(s==1)st.executeUpdate("delete from ligneEntree where refBE ='"+refbe+"'");
                }
                int rep=JOptionPane.showConfirmDialog(null,"Voulez-vous imprimer ce bon d'entrée ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(rep==JOptionPane.YES_OPTION)
                {
                    Impression I= new Impression(new EtatBE(refbe, refbl, frs,dtBE,datebe).getPanel());
                    I.setOrientation(1);I.print();
                }
                txtrefBE.setText("");
                txtDateEditionBE.setDateFormatString("");
                txtRefBonLivraisonBE.setText("");
                InitialiserReferenceBE();
                btnEnregistrerBE.setEnabled(false);
                btnModifierBE.setEnabled(false);
                btnSupprimerBE.setEnabled(false);
                btnImprimerBE.setEnabled(false);
                dtBE.setRowCount(0);
                comboCategorieBE.setSelectedItem("Catégorie");
                comboDesignationBE.setSelectedItem("Désignation");
                comboFrsBE.setSelectedItem("Choissisez un Fournisseur");
                InitialiserTableBE();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btnEnregistrerBEActionPerformed

    private void tbleListeBonEntreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleListeBonEntreMouseClicked
        int nbLigne=tbleListeBonEntre.getSelectedRow();
        if(nbLigne!=-1)
        {
            txtrefBE.setText(dtBE.getValueAt(nbLigne, 0).toString());
            txtDateEditionBE.setDateFormatString(dtBE.getValueAt(nbLigne, 1).toString());
            txtRefBonLivraisonBE.setText(dtBE.getValueAt(nbLigne, 2).toString());
            comboFrsBE. setSelectedItem(dtBE.getValueAt(nbLigne, 3).toString());
            try{
                dtBE= new DefaultTableModel();
                dtBE.addColumn("Catégorie");
                dtBE.addColumn("Matériel");
                dtBE.addColumn("Quantité entrée");
                tbleListeMaterielEntreBE.setModel(dtBE);
                ResultSet rs= st.executeQuery("select c.libelle, m.libelle, qteEntree from LigneEntree l, Materiel m, Categorie c where c.codCategorie=m.codCategorie and l.CodMat=m.CodMat and refBE='"+txtrefBE.getText()+"'");
                while (rs.next())
                {
                    Object[] ob={rs.getString(1), rs.getString(2), rs.getInt(3)};
                    dtBE.addRow(ob);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
            btnModifierBE.setEnabled(true);
            btnSupprimerBE.setEnabled(true);
            btnEnregistrerBE.setEnabled(false);
            btnAjouterBE.setEnabled(false);
        }
    }//GEN-LAST:event_tbleListeBonEntreMouseClicked

    private void btnRechercherBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherBEActionPerformed
        if(txtrechercheBE.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Veuillez renseigner le champs vide");
        } else
        {
            try{
                dtBE=new DefaultTableModel();
                dtBE.addColumn("Ref BE");
                dtBE.addColumn("Date Edition");
                dtBE.addColumn("Ref Bon Livraison");
                dtBE.addColumn("Fournisseur");
                tbleListeBonEntre.setModel(dtBE);
                dtBE.setRowCount(0);

                String recherche; recherche= txtrechercheBE.getText().toString().toUpperCase();
                ResultSet rs=st.executeQuery("select refBE, datEditionBE, refBL, nomFrs from BonEntree, Fournisseur where BonEntree.numFrs=Fournisseur.numFrs and (refBE='"+recherche+"' || refBL='"+recherche+"')");
                while(rs.next())
                {
                    Object[] ob={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                    dtBE.addRow(ob);
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Echec de recherche "+e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRechercherBEActionPerformed

    private void btnVoirFicheStock3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoirFicheStock3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoirFicheStock3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new JChangerPassword(this, true, this.numUtilisateur, this.Host, this.User, this.Password).setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new JPersonnalisation(this, true).setVisible(true); 
    }//GEN-LAST:event_jMenuItem12ActionPerformed

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
            java.util.logging.Logger.getLogger(JSessionMagasinier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSessionMagasinier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSessionMagasinier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSessionMagasinier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JSessionMagasinier(31,"localhost", "root","").setVisible(true);
            }
        });
    }
private Statement st;
private DefaultTableModel dt= new DefaultTableModel() ;
private DefaultTableModel dtBS= new DefaultTableModel() ;
private DefaultTableModel dtBE= new DefaultTableModel() ;
private final JDBConnection cx;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterBE;
    private javax.swing.JButton btnAjouterBS;
    private javax.swing.JButton btnEnregistrerBE;
    private javax.swing.JButton btnEnregistrerBS;
    private javax.swing.JButton btnEnregistrerMateriel;
    private javax.swing.JButton btnFactureImpayeeConsultation;
    private javax.swing.JButton btnImprimerBE;
    private javax.swing.JButton btnImprimerBS;
    private javax.swing.JButton btnImprimerConsultation;
    private javax.swing.JButton btnInventaire;
    private javax.swing.JButton btnListBE;
    private javax.swing.JButton btnListFact;
    private javax.swing.JButton btnModifierBE;
    private javax.swing.JButton btnModifierBS;
    private javax.swing.JButton btnModifierMateriel;
    private javax.swing.JButton btnRecherMateriel;
    private javax.swing.JButton btnRechercherBE;
    private javax.swing.JButton btnRechercherBS;
    private javax.swing.JButton btnSupprimerBE;
    private javax.swing.JButton btnSupprimerBS;
    private javax.swing.JButton btnSupprimerMateriel;
    private javax.swing.JButton btnVoirFicheStock2;
    private javax.swing.JButton btnVoirFicheStock3;
    private javax.swing.JComboBox comboCategorieBE;
    private javax.swing.JComboBox comboCategorieBS;
    private javax.swing.JComboBox comboCategorieConsultation;
    private javax.swing.JComboBox comboCategorieMateriel;
    private javax.swing.JComboBox comboDesignationBE;
    private javax.swing.JComboBox comboDesignationBS;
    private javax.swing.JComboBox comboDesignationConsultation1;
    private javax.swing.JComboBox comboFrsBE;
    private javax.swing.JComboBox comboMagasinMateriel;
    private javax.swing.JComboBox comboServiceBS;
    private javax.swing.JPanel conteneurAjoutBE;
    private javax.swing.JPanel conteneurAjoutBE1;
    private javax.swing.JPanel conteneurEnreg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labConsultation;
    private javax.swing.JLabel lbImmatriculation;
    private javax.swing.JTextField qteEntreBE;
    private javax.swing.JTextField qteSortieBS;
    private javax.swing.JTable tableListeMateriel;
    private javax.swing.JTable tblConsultation;
    private javax.swing.JTable tbleListeBonEntre;
    private javax.swing.JTable tbleListeBonSortie;
    private javax.swing.JTable tbleListeMaterielEntreBE;
    private javax.swing.JTable tbleListeMaterielSortieBS;
    private javax.swing.JTextField txtCodMateriel;
    private javax.swing.JTextField txtDesignationMateriel;
    private javax.swing.JTextField txtMarqueMateriel;
    private javax.swing.JTextField txtPUFrs;
    private javax.swing.JTextField txtQteDispoMateriel;
    private javax.swing.JTextField txtQteStockBE;
    private javax.swing.JTextField txtQteStockBS;
    private javax.swing.JTextField txtReceptionnaire;
    private javax.swing.JTextField txtRefBS;
    private javax.swing.JTextField txtRefBonLivraisonBE;
    private javax.swing.JTextField txtrechercheBE;
    private javax.swing.JTextField txtrechercheBS;
    private javax.swing.JTextField txtrechercheMateriel;
    private javax.swing.JTextField txtrefBE;
    private javax.swing.JTextField txtrefDemandeAchat;
    // End of variables declaration//GEN-END:variables
}
