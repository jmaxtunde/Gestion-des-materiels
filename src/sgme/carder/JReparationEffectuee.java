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
public class JReparationEffectuee
{
    String dateEntree = null, dateSortie = null, nautre = null;
    double coutPiece = 0, mainOeuvre = 0;
    
    public JReparationEffectuee(String natureReparation, String dateEntree, String dateSortie, double coutPiece, double mainOeuvre)
    {
        this.coutPiece = coutPiece;
        this.mainOeuvre = mainOeuvre;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.nautre = natureReparation;
    }
    public String getDateEntree()
    { return this.dateEntree;}
    
    public String getDateSortie()
    {return this.dateSortie;}
    
    public String getNature()
    {return this.nautre;}
    
    public double getCoutPiece()
    {return this.coutPiece;}
    
    public double getMainOeuvre()
    {return this.mainOeuvre;}
}
