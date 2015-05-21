/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/**
 *
 * @author IT
 */
import java.awt.BorderLayout;
import java.awt.PopupMenu;
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
//维护表格

public class JTableDefaultTableModelTest extends JFrame {

    private DefaultTableModel tableModel;  
    private JTable moduleTable;
    private JPanel panel;
    private JTextField moduleText;
    private JTextField abbText;
    private JTextField colorText;
    private JTextField seanceText;

    public JTableDefaultTableModelTest() {
        super();
        setTitle("Liste des modules");
        setBounds(10,10,700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();

        Object[][] mRow = {
            
        };
        Object[] mCol = {"Module", "abbreviation", "Couleur", "Nombre de séance"};
        tableModel = new DefaultTableModel(mRow, mCol);
        moduleTable = new JTable(tableModel);
        jScrollPane1.setViewportView(moduleTable);
        getContentPane().add(jScrollPane1,BorderLayout.CENTER);

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
         getContentPane().add(panel, BorderLayout.SOUTH);
        panel.add(new JLabel("Module: "));
        moduleText = new JTextField("Java", 5);
        panel.add(moduleText);

        panel.add(new JLabel("Abb: "));
        abbText = new JTextField("java", 5);
        panel.add(abbText);

        panel.add(new JLabel("Color: "));
        colorText = new JTextField("red", 5);
        panel.add(colorText);

        panel.add(new JLabel("Seance: "));
        seanceText = new JTextField("50h", 5);
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
                    tableModel.setValueAt(colorText.getText(), selectedRow, 2);
                    tableModel.setValueAt(seanceText.getText(), selectedRow, 3);
                }
            }
        });
        panel.add(updateButton);

        final JButton delButton = new JButton("Supprimer");// supprimer un ligne
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

    
  /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JTableDefaultTableModelTest jTableDefaultTableModelTest = new JTableDefaultTableModelTest();
        jTableDefaultTableModelTest.setVisible(true);
    }
}