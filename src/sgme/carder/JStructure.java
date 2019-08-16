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
public class JStructure 
{
 private   String colonne =null, type=null, nulle=null, defaultValue=null, extra=null, cle =null;
            int taille = 0, ordreDesColonnes =0;
    public JStructure(String colonne, String type, int taille, String nulle, String defaultValue,String cle, String extra, int ordreDesColonnes)  
    {
        this.colonne = colonne;
        this.type = type;
        this.taille = taille;
        this.defaultValue = defaultValue;
        this.nulle = nulle;
        this.cle = cle;
        this.extra = extra;
        this.ordreDesColonnes = ordreDesColonnes;
    }
    public String getColonne()
    {return this.colonne;}
    
    public String getType()
    {return this.type;}
    
    public String getDefaultValue()
    {return this.defaultValue;}
    
    public String getIsNullable()
    {return this.nulle;}
    
    public String getExtra()
    {return this.extra;}
            
    public int getTaille()
    {return this.taille;}
    
    public int getOrdre()
    {return this.ordreDesColonnes;}
    
    public String getCle()
    {return this.cle;}
}
