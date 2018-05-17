/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.componentes.beans;

import java.awt.Component;
import javax.swing.JList;
 
/**
 *
 * @author Klac
 */
public class FactoryCellListRenderer {
     
    public static javax.swing.DefaultListCellRenderer createListCellRenderer(){
        return new RowCellListRendererOne();
    }
     
    private static class RowCellListRendererOne extends javax.swing.DefaultListCellRenderer{
 
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
            setBackground(java.awt.Color.WHITE);
            setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            setPreferredSize(new java.awt.Dimension(40, 30));
            if(isSelected){
                setBackground(new java.awt.Color(204,210,255));
                setForeground(list.getSelectionForeground());
                setBorder(javax.swing.BorderFactory
                .createEtchedBorder(
                        javax.swing.border.EtchedBorder.RAISED,
                        new java.awt.Color(152, 204, 255),
                        new java.awt.Color(152, 204, 255)));
            }else{
                setForeground(new java.awt.Color(100, 200, 255));
                setBorder(javax.swing.BorderFactory.createEmptyBorder());
            }
            return this;
        }
    }
} 
