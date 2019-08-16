/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Senghor AKOMINON
 */
public class JListeAutorisationModel extends AbstractTableModel
{
    private final List<JListeAutorisation> listeAutorisation = new ArrayList<JListeAutorisation>();
    private final String entete[] = {"Reférence","Objet", "Montant ", "Date Edition"};
    
    public JListeAutorisationModel()
    {
    }
    @Override
    public int getRowCount() 
    {
        return this.listeAutorisation.size();
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
            case 0: return this.listeAutorisation.get(indiceLigne).getReference();
            case 1: return this.listeAutorisation.get(indiceLigne).getObjet();
            case 2: return this.listeAutorisation.get(indiceLigne).getMontant();
            case 3: return this.listeAutorisation.get(indiceLigne).getDate();
            default: return null;
        }
    }
    @Override
    public String getColumnName( int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addAutorisation(JListeAutorisation ts)
    {
        this.listeAutorisation.add(ts);
        fireTableRowsInserted(this.listeAutorisation.size()-1, this.listeAutorisation.size()-1);
    }
    public void addAutorisation(int indice, JListeAutorisation ts)
    {
        this.listeAutorisation.add(indice, ts);
        fireTableRowsUpdated(indice, indice);
    }

    public void removeAutorisation(int indice)
    {
        this.listeAutorisation.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    public void removeAll()
    {
        for(int i=listeAutorisation.size(); i>0; i--) this.removeAutorisation(i-1);
    }
    
   
    public boolean isEmpty()
    {
        return listeAutorisation.isEmpty();
    }

    
}
