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
public class JListeBCModel extends AbstractTableModel
{
    private final List<JListeBC> listeBC = new ArrayList<>();
    private final String entete[] = {"Reférence Bon Caisse", "Reférence Autorisation", "Objet", "Montant"};

    @Override
    public int getRowCount() 
    {
       return this.listeBC.size();
    }
    
    @Override
    public int getColumnCount() 
    {
        return this.entete.length;
    }

    @Override
    public Object getValueAt(int indiceLigne, int indiceColonne) 
    {
        switch(indiceColonne)
        {
            case 0: return this.listeBC.get(indiceLigne).getRefBC();
            case 1: return this.listeBC.get(indiceLigne).getRefAD();
            case 2: return this.listeBC.get(indiceLigne).getObjet();
            case 3: return this.listeBC.get(indiceLigne).getMontant();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addBC(JListeBC bc)
    {
        this.listeBC.add(bc);
        fireTableRowsInserted(this.listeBC.size()-1, this.listeBC.size()-1);
    }
    public void addBC(int position, JListeBC bc)
    {
        this.listeBC.add(position, bc);
        fireTableRowsUpdated(position, position);
    }
    public void removeBC(int position)
    {
        this.listeBC.remove(position);
        fireTableRowsDeleted(position, position);
    }
    public void removeAll()
    {
        for(int i=listeBC.size(); i>0; i--) this.removeBC(i-1);
    }
    public boolean isEmpty()
    {
        return this.listeBC.isEmpty();
    }
}
