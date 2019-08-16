
package sgme.carder;

/**
 @author Senghor AKOMINON
 */
public class JListeBR 
{
    private String numeroBR = null,
                   refDA = null,
                   categorieMateriel = null,
                   natureReparation = null;
    public JListeBR(String numeroBR, String refDA, String categorieMateriel, String natureReparation)
    {
        this.numeroBR = numeroBR;
        this.refDA = refDA;
        this.categorieMateriel = categorieMateriel;
        this.natureReparation = natureReparation;
    }
    public String getNumeroBR()
    {
        return this.numeroBR;
    }
    public String getNatureReparation()
    {
        return this.natureReparation;
    }
    public String getRefDA()
    {
        return this.refDA;
    }
    public String getCategorieMateriel()
    {
        return this.categorieMateriel;
    }
}
