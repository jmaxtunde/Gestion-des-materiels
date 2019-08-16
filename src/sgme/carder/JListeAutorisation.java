

package sgme.carder;

/**
 *
 * @author Senghor AKOMINON
 */
public class JListeAutorisation
{
    String reference = null,
            objet = null,
            date = null;
    double montant = 0;
    public JListeAutorisation(String reference, String objet, double montant, String date)
    {
        this.reference = reference;
        this.objet = objet;
        this.montant = montant;
        this.date= date;
    }
    public String getReference()
    {
        return this.reference;
    }
    public String getObjet()
    {
        return this.objet;
    }
    public double getMontant()
    {
        return this.montant;
    }
    public String getDate()
    {
        return this.date;
    }
}
