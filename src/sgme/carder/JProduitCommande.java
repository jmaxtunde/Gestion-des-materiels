package sgme.carder;
/**
  * @author Senghor AKOMINON
 */
public class JProduitCommande 
{
    private String categorie = null, materiel = null;
    private String  quantite = null, montant =null, prixUnitaire = null;
    private  double montantReel =0.0;
    public JProduitCommande( String categorie,String materiel, String quantite, String prixUnitaire, double montant)
    {
        
        this.categorie = categorie;
        this.materiel = materiel;
        this.prixUnitaire = ""+prixUnitaire+"";
        this.quantite = ""+quantite+"";
        this.montant = ""+montant+"";
        this.montantReel = montant;
    }
    public void setCategorie(String categorie)
    {
        this.categorie = categorie;
    }
    public void setMateriel(String materiel)
    {
        this.materiel = materiel;
    }
    public void setQuantite(double quantite)
    {
        this.quantite = ""+quantite+"";
    }
    public void setPrixUnitaire(double prixUnitaire)
    {
        this.prixUnitaire = ""+prixUnitaire+"";
    }
    public void setMontant(double montant)
    {
        this.montant = ""+montant+"";
    }
    public String getCategorie()
    {
        return this.categorie;
    }
    public String getMateriel()
    {
        return this.materiel; 
    }
    public String getQuantite()
    {
        return this.quantite;
    }
    public String getPrixUnitaire()
    {
        return this.prixUnitaire;
    }
    public String getMontant()
    {
        return this.montant;
    }
    public double getMontantReel()
    {
        return this.montantReel;
    }
}
