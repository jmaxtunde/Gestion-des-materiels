/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

/**
 *
 * @author Senghor AKOMINON
 */
public class JListeBCde 
{
    String reference = null,
            dateLivraison = null,
            lieuLivraison =  null,
            fournisseur = null;
    public JListeBCde( String reference, String dateLivraison, String lieuLivraison, String fournisseur )
    {
        this.reference = reference;
        this.dateLivraison = dateLivraison;
        this.lieuLivraison = lieuLivraison;
        this.fournisseur = fournisseur;
    }
    public String getReferenceBCde()
    {
        return this.reference;
    }
    public String getDateLivaison()
    {
        return this.dateLivraison;
    }
    public String getLieuLivraison()
    {
        return this.lieuLivraison;
    }
    public String getFournisseur()
    {
        return this.fournisseur;
    }
}
