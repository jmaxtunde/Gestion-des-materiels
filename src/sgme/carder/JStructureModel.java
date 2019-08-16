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
public class JStructureModel extends AbstractTableModel
{
     private final List<JStructure> data = new ArrayList<>();
String titre[]={"Colonnes", "Types", "Longueur","Valeur nulle", "Valeur par defaut", "Les clés" ,"Extra", "Ordre des colonnes"};

    @Override
    public int getRowCount()
    {
       return data.size();
    }
    
     @Override
    public String getColumnName(int colonne)
    {
       return this.titre[colonne]; 
    }
    @Override
    public int getColumnCount()
    {
        return titre.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        
        switch(columnIndex)
        {
            case 0: return data.get(rowIndex).getColonne();
            case 1: return data.get(rowIndex).getType();
            case 2: return data.get(rowIndex).getTaille();
            case 3: return data.get(rowIndex).getIsNullable();
            case 4: return data.get(rowIndex).getDefaultValue();
            case 5: return data.get(rowIndex).getCle();
            case 6: return data.get(rowIndex).getExtra();
            case 7: return data.get(rowIndex).getOrdre();
                default: return null;
        }
    }
    
    public void addStructure(JStructure structure)
    {
        data.add(structure);
        fireTableRowsInserted(this.data.size()-1, this.data.size()-1);
    }
}
