/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Senghor AKOMINON
 */
public class JListeBCdeModel extends AbstractTableModel
{
    private final List<JListeBCde> liste = new ArrayList<JListeBCde>();
    private final String[] entete = {" Reférence ", " Date Livraison ", " Lieu Livraison ", " Fourrnisseur "};
    
    public JListeBCdeModel()
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
            case 0: return this.liste.get(indiceLigne).getReferenceBCde();
            case 1: return this.liste.get(indiceLigne).getDateLivaison();
            case 2: return this.liste.get(indiceLigne).getLieuLivraison();
            case 3: return this.liste.get(indiceLigne).getFournisseur();
            default : return null;
        }
    }
    @Override
    public String getColumnName( int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addListeBCde(JListeBCde liste)
    {
        this.liste.add(liste);
        fireTableRowsInserted(this.liste.size()-1, this.liste.size()-1);
    }
    public void addListeBCde(int indice, JListeBCde l)
    {
        this.liste.add(indice, l);
        fireTableRowsUpdated(indice, indice);
    }
    public void removeBCde(int indice)
    {
        this.liste.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    public void removeAll()
    {
        for(int i=liste.size(); i>0; i--) this.removeBCde(i-1);
    }
    public boolean isEmpty()
    {
        return this.liste.isEmpty();
    }
    
}
