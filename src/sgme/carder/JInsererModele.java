/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class JInsererModele extends AbstractTableModel
{
   private MyTextField d1, d2 ,d3, d4, d5,d6,d7,d8;
    
    private final List<JInserer> data = new ArrayList<>();
String titre[]={"Colonnes", "Types", "Longueur","Valeur"};
                
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return titre.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
        switch(columnIndex)
        {
            case 0: return data.get(rowIndex).getNom();
            case 1: return data.get(rowIndex).getType();
            case 2: return data.get(rowIndex).getTaille();
            case 3: switch(rowIndex)
                    {
                        case 0: return d1; 
                            case 1: return d2;
                                case 2: return d3;
                                    case 3: return d4;
                                        case 4: return d5;
                                            case 5: return d6;
                                                case 6: return d7;
                                                    case 7:  return d8;
                                                        default: return null;
                    }
                default: return null ;
        }           
    }
    public String getValue(int ligne, int colonne)
    {
        switch(colonne)
        {
            case 0: return data.get(ligne).getNom();
            case 1: return data.get(ligne).getType();
            case 2: return ""+data.get(ligne).getTaille();
            case 3: switch(ligne)
                    {
                        case 0: return d1.getText();
                            case 1: return d2.getText();
                                case 2: return d3.getText();
                                    case 3: return d4.getText();
                                        case 4: return d5.getText();
                                            case 5: return d6.getText();
                                                case 6: return d7.getText();
                                                    case 7:  return d8.getText();
                                                        default: return null;
                    }
                default: return null ;
        }       
    }
   
    @Override
    public String getColumnName(int indiceColonne)
    {
        return this.titre[indiceColonne].toString();
    }
@Override
    public Class getColumnClass(int colonne)
    {
        switch(colonne)
        {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return MyTextField.class;
                default: return null ;
        }
    }
    public JInsererModele()      
    {
        d1= new MyTextField(); d2= new MyTextField() ;d3= new MyTextField(); d4= new MyTextField();
        d5= new MyTextField(); d6= new MyTextField(); d7= new MyTextField(); d8= new MyTextField();
                
    }
@Override
    public boolean isCellEditable(int ligne, int colonne)
    {
        if (getValueAt(ligne, colonne)instanceof MyTextField)
        {  d2.setText(null); return ligne != 0; 
        }
        else return false;
        
    }
    
    @Override
    public void setValueAt(Object value, int row, int colonne)
    {
        if(getValueAt(row, colonne)instanceof MyTextField)
        {
            switch(row)
            {
                case 0: d1.setText((String)value);break;
                case 1: d2.setText((String)value);break;
                case 2: d3.setText((String)value);break;
                case 3: d4.setText((String)value);break;
                case 4: d5.setText((String)value);break;
                case 5: d6.setText((String)value);break;
                case 6: d7.setText((String)value);break;
                case 7: d8.setText((String)value);break;
                    default: break;
                                
            }
        }
    }
    public void add(JInserer insertObject)
    {
        data.add(insertObject);
        fireTableRowsInserted(this.data.size()-1, this.data.size()-1);
    }
    public void removeAll()
    {this.data.removeAll(data);}
    
    public boolean isEmpty()
    {return this.data.isEmpty();}
}
