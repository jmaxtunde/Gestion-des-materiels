
package sgme.carder;


import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Senghor AKOMINON
 */
public class JTravailSignaleModel extends AbstractTableModel
{
    private final List<JTravailSignale> travailSignale = new ArrayList<JTravailSignale>();
    private final String entete[] = {"N° Ordre","Travaux Signalés", "Main d'ouvre", "Coût pièce"};

    public JTravailSignaleModel()
    {
       
    }

    @Override
    public int getRowCount() 
    {
        return this.travailSignale.size();
    }

    @Override
    public int getColumnCount() {
       return this.entete.length;
    }

    @Override
    public Object getValueAt(int indiceLigne, int indiceColonne) 
    {
        switch(indiceColonne)
        {
            case 0: if(travailSignale.size()-1 != indiceLigne) return indiceLigne+1;else return null;
            case 1: return this.travailSignale.get(indiceLigne).getLibelle();
            case 2: return this.travailSignale.get(indiceLigne).getMainOuvre();
            case 3: return this.travailSignale.get(indiceLigne).getCoutPiece();
            default: return null;
        }
    }
    @Override
    public String getColumnName( int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addTravailSignale(JTravailSignale ts)
    {
        this.travailSignale.add(ts);
        fireTableRowsInserted(this.travailSignale.size()-1, this.travailSignale.size()-1);
    }
    public void addTrauvailSignale(int indice, JTravailSignale ts)
    {
        this.travailSignale.add(indice, ts);
        fireTableRowsUpdated(indice, indice);
    }

    public void removeTravailSignale(int indice)
    {
        this.travailSignale.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    public void removeAll()
    {
        for(int i=travailSignale.size(); i>0; i--) this.removeTravailSignale(i-1);
    }
    public double getMainOuvreTotal()
    {
        double total = 0;
        for(int i = 0; i < getRowCount();i++) total += travailSignale.get(i).getMO();
        return total;
    }
    public double getCoutPieceTotal()
    {
        double total = 0;
        for(int i = 0; i < getRowCount();i++) total += travailSignale.get(i).getCoutPiece();
        return total;
    }
    public double total(){return getMainOuvreTotal()+getCoutPieceTotal();}
    public boolean isEmpty()
    {
        return travailSignale.isEmpty();
    }
}
