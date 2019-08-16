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
public class JReparationEffectueModel extends AbstractTableModel
{
    private final List<JReparationEffectuee> liste = new ArrayList<>();
    private final String[] entete = {"N° Ordre", "Nature Réparation", "Date entrée en réparation", "Date Sortie de réparation", "","Coût des pièces", "Main d'Oeuvre"}; 
    
    public JReparationEffectueModel(){}
    
    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }
    
    @Override
    public String getColumnName(int colonne)
    {
        return this.entete[colonne];
    }
    
    @Override
    public Class getColumnClass(int colonne)
    {
        return this.entete[colonne].getClass();
    }
   
    @Override
    public Object getValueAt(int row, int column) {
        switch(column)
        {
            case 0: return this.liste.size()+1;
            case 1: return this.liste.get(row).getNature();
            case 2: return this.liste.get(row).getDateEntree();
            case 3: return this.liste.get(row).getDateSortie();
            case 4: return this.liste.get(row).getCoutPiece();
            case 5: return this.liste.get(row).getMainOeuvre();
            default: return null  ;
        }
    }
    
    public void add(JReparationEffectuee reparationEffectuee)
    {
        this.liste.add(reparationEffectuee);
    }
    public boolean isEmpty()
    {
        return this.liste.isEmpty();
    }
}
