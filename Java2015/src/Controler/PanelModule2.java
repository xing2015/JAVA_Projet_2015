/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xing
 */
public class PanelModule2 extends JPanel {

    private JTable moduleTable;
    private DefaultTableModel tableModel;
    private JScrollPane jScrollPane1;
    private JTextField moduleText;
    private JTextField abbText;
    private JTextField colorText;
    private JTextField seanceText;
    private JPanel panel;
    
    public PanelModule2() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();

        Object[][] mRow = {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };
        Object[] mCol = {"Module", "abbreviation", "Couleur", "Nombre de séance"};
        tableModel = new DefaultTableModel(mRow, mCol);
        moduleTable = new JTable(tableModel);
        jScrollPane1.setViewportView(moduleTable);

        moduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        moduleTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = moduleTable.getSelectedRow();
                Object oModule = tableModel.getValueAt(selectedRow, 0);
                Object oAbb = tableModel.getValueAt(selectedRow, 1);
                Object oColor = tableModel.getValueAt(selectedRow, 2);
                Object oSeance = tableModel.getValueAt(selectedRow, 3);

            }

        }
        );

         panel = new JPanel();
        // getContentPane().add(panel, BorderLayout.SOUTH);
        panel.add(new JLabel("Module: "));
        moduleText = new JTextField("A4", 10);
        panel.add(moduleText);

        panel.add(new JLabel("Abb: "));
        abbText = new JTextField("B4", 10);
        panel.add(abbText);

        panel.add(new JLabel("Color: "));
        colorText = new JTextField("B4", 10);
        panel.add(colorText);

        panel.add(new JLabel("Seance: "));
        seanceText = new JTextField("B4", 10);
        panel.add(seanceText);

        final JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] rowValues = {moduleText.getText(), abbText.getText(), colorText.getText(), seanceText.getText()};
                tableModel.addRow(rowValues); //ajouter un ligne
                int rowCount = moduleTable.getRowCount() + 1; //nb de ligne +1
                moduleText.setText("" + rowCount);
                abbText.setText("" + rowCount);
                colorText.setText("" + rowCount);
                seanceText.setText("" + rowCount);
            }

        });
        panel.add(addButton);

        final JButton updateButton = new JButton("Modifier"); //modifier
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = moduleTable.getSelectedRow();
                if (selectedRow != -1) 
                {
                    tableModel.setValueAt(moduleText.getText(), selectedRow, 0);
                    tableModel.setValueAt(abbText.getText(), selectedRow, 1);
                    tableModel.setValueAt(colorText.getText(), selectedRow, 0);
                    tableModel.setValueAt(seanceText.getText(), selectedRow, 1);
                }
            }
        });
        panel.add(updateButton);

        final JButton delButton = new JButton("Supprimer");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = moduleTable.getSelectedRow();
                if (selectedRow != -1) 
                {
                    tableModel.removeRow(selectedRow); 
                }
            }
        });
        panel.add(delButton);
    }


}
