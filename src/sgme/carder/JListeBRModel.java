

package sgme.carder;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
  @author Senghor AKOMINON
 */
public class JListeBRModel extends AbstractTableModel 
{
    private final List<JListeBR> liste = new ArrayList<JListeBR>();
    private final String[] entete = {"Référence BR", "Ref demande réparation", " Materiel", "Nature Réparation"};
    public JListeBRModel()
    {
        
    }

    @Override
    public int getRowCount() 
    {
        return liste.size();
    }

    @Override
    public int getColumnCount() 
    {
        return entete.length;
    }

    @Override
    public Object getValueAt(int indiceLigne, int indiceColonne) 
    {
        switch(indiceColonne)
        {
            case 0: return this.liste.get(indiceLigne).getNumeroBR();
            case 1: return this.liste.get(indiceLigne).getRefDA();
            case 2: return this.liste.get(indiceLigne).getCategorieMateriel();
            case 3: return this.liste.get(indiceLigne).getNatureReparation();
            default : return null;
        }
    }
    @Override
    public String getColumnName( int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addListeBR(JListeBR liste)
    {
        this.liste.add(liste);
        fireTableRowsInserted(this.liste.size()-1, this.liste.size()-1);
    }
    public void addListeBR(int indice, JListeBR l)
    {
        this.liste.add(indice, l);
        fireTableRowsUpdated(indice, indice);
    }
    public void removeBR(int indice)
    {
        this.liste.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
     public void removeAll()
    {
        for(int i=liste.size(); i>0; i--) this.removeBR(i-1);
    }
    public boolean isEmpty()
    {
        return this.liste.isEmpty();
    }  
}
