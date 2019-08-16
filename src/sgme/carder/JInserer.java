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
public class JInserer 
{
    String Nom = null,
           type = null;
      int  taille = 0;
    double montant = 0.0;
    public JInserer(String nom, String type, int taille)
    {
        this.Nom = nom;
        this.type = type;
        this.taille = taille;        
    }
    public String getNom()
    {
       return this.Nom;
    }
    public String getType()
    {
       return this.type;
    }
    public int getTaille()
    {
        return this.taille;
    }    
}
