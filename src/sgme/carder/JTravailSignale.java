package sgme.carder;

/**
 *
 * @author Senghor AKOMINON
 */
public class JTravailSignale 
{
    private int ordre = 0;
    private String libelle = null;
    private String mainOuvre = null;double coutPiece =0, MO = 0;
    
    public JTravailSignale( String designation, String mainOuvre, double coutPiece)
    {
        
        this.libelle = designation;
        this.mainOuvre = mainOuvre;
        this.coutPiece = coutPiece;
        this.MO = Double.parseDouble(mainOuvre);
    }
    public void setLibelle(String designation)
    {
        libelle = designation;
    }
    public void setMainOuvre(double mainOuvre)
    {
        this.mainOuvre = ""+mainOuvre+"";
    }
    public void setCoutPiece(double coutPiece)
    {
        this.coutPiece = coutPiece;
    }
    public String getLibelle()
    {
        return this.libelle;
    }
    public String getMainOuvre()
    {
        return this.mainOuvre;
    }
    public double getMO()
    {
        return this.MO;
    }
    public double getCoutPiece()
    {
        return this.coutPiece;
    }
}
