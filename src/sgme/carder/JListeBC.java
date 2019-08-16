
package sgme.carder;

/**
 *
 * @author Senghor AKOMINON
 */
public class JListeBC 
{ 
    String refBC = null,
           refAD = null,
           objet = null;
    double montant = 0.0;
    public JListeBC(String refBC, String refAD, String objet, double montant)
    {
        this.refBC = refBC;
        this.refAD = refAD;
        this.objet = objet;
        this.montant = montant;
    }
    public String getRefBC()
    {
       return this.refBC;
    }
    public String getRefAD()
    {
       return this.refAD;
    }
    public String getObjet()
    {
        return this.objet;
    }
    public double getMontant()
    {
        return this.montant;
    }
}
