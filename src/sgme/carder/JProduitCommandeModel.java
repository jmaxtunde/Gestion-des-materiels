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
public class JProduitCommandeModel extends AbstractTableModel
{
    private final List<JProduitCommande> produitCommande = new ArrayList<JProduitCommande>();
    private final String entete[] = {"Catégorie","Matériel", "quantité ", "Prix Unitaire", "Montant"};

    public JProduitCommandeModel()
    {
       
    }

    @Override
    public int getRowCount() 
    {
        return this.produitCommande.size();
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
            case 0: return produitCommande.get(indiceLigne).getCategorie();
            case 1: return this.produitCommande.get(indiceLigne).getMateriel();
            case 2: return this.produitCommande.get(indiceLigne).getQuantite();
            case 3: return this.produitCommande.get(indiceLigne).getPrixUnitaire();
            case 4: return this.produitCommande.get(indiceLigne).getMontant();
            default: return null;
        }
    }
    @Override
    public String getColumnName( int indiceColonne)
    {
        return this.entete[indiceColonne].toString();
    }
    public void addProduitCommande(JProduitCommande ts)
    {
        this.produitCommande.add(ts);
        fireTableRowsInserted(this.produitCommande.size()-1, this.produitCommande.size()-1);
    }
    public void addProduitCommande(int indice, JProduitCommande ts)
    {
        this.produitCommande.add(indice, ts);
        fireTableRowsUpdated(indice, indice);
    }

    public void removeProduitCommande(int indice)
    {
        this.produitCommande.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    public void removeAll()
    {
        for(int i=produitCommande.size(); i>0; i--) this.removeProduitCommande(i-1);
    }
    public double getMontantTotal()
    {
        double total = 0;
        for(int i = 0; i < getRowCount();i++) total += produitCommande.get(i).getMontantReel();
        return total;
    }
   
    public boolean isEmpty()
    {
        return produitCommande.isEmpty();
    }

    
}
