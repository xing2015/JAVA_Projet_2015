/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
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
public class FormationFenetre extends JFrame {
    private FormationFenetre nf;
    private DefaultTableModel tableModel;
    private JTable moduleTable;
    private JPanel panelInfo, panelModule, panelAdd, panelSubmit;
    private JTextField moduleText, abbText, colorText, seanceText, nomText, dureeText, dureeFmText;
    private JScrollPane jScrollPane1;

    public FormationFenetre() {
        super();
        setTitle("Gestion de formation");
        setBounds(5, 5, 800, 450);
        //setMaximumSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        nomText = new JTextField("   ",10);
        dureeText = new JTextField("   ",10);
        dureeFmText = new JTextField("  ",10);
        
        panelInfo = new JPanel();
        panelSubmit = new JPanel();
        panelAdd = new JPanel();
        panelModule = new JPanel();
        jScrollPane1 = new JScrollPane();

        setLayout(new GridBagLayout());
        GridBagConstraints mainLayout = new GridBagConstraints();

        mainLayout.anchor = GridBagConstraints.CENTER;

        mainLayout.gridx = 0;
        mainLayout.gridy = 0;
        getContentPane().add(panelInfo);
        add(panelInfo, mainLayout);
        panelInfo.setPreferredSize(new Dimension(750, 110));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Formation"));

        mainLayout.gridx = 0;
        mainLayout.gridy = 1;
        getContentPane().add(panelModule);
        add(panelModule, mainLayout);
        panelModule.setPreferredSize(new Dimension(760, 200));

        mainLayout.gridx = 0;
        mainLayout.gridy = 2;
        getContentPane().add(panelAdd);
        add(panelAdd, mainLayout);
        panelAdd.setBorder(BorderFactory.createEtchedBorder());
        panelAdd.setPreferredSize(new Dimension(750, 50));

        mainLayout.gridx = 0;
        mainLayout.gridy = 3;
        getContentPane().add(panelSubmit);
        add(panelSubmit, mainLayout);
//PanelInfo************************************************************************************
        /**
         * PanelInfo :Définir les informations basic de cette formation.
         */

       
        panelInfo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.CENTER;

        c.gridx = 0;
        c.gridy = 0;
        panelInfo.add(new JLabel("Nom de formation: ", 10), c);

        c.gridx = 1;
        c.gridy = 0;
        panelInfo.add(nomText, c);
       //nomText.setPreferredSize(new Dimension(100,20));

        c.gridx = 0;
        c.gridy = 1;
        panelInfo.add(new JLabel("Durée de formation: ", 10), c);

        c.gridx = 1;
        c.gridy = 1;
        panelInfo.add(dureeFmText, c);
      //   nomText.setPreferredSize(new Dimension(100,20));
         
        c.gridx = 0;
        c.gridy = 2;
        panelInfo.add(new JLabel("   Duréé type d'une séance: ", 10), c);

        c.gridx = 1;
        c.gridy = 2;
        panelInfo.add(dureeText, c);
         //nomText.setPreferredSize(new Dimension(100,20));
        getContentPane().add(panelInfo);
        
//PanelModule************************************************************************************

        /**
         * PanelModule : liste des modules
         */
        Object[][] mRow = {{null, null, null, null}};
        Object[] mCol = {"Module", "abbreviation", "Couleur", "Nombre de séance"};
        tableModel = new DefaultTableModel(mRow, mCol);
        moduleTable = new JTable(tableModel);
        moduleTable.setBorder(BorderFactory.createEtchedBorder());
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
        panelModule.add(jScrollPane1);
        jScrollPane1.setPreferredSize(new Dimension(750, 150));

//PanelAdd************************************************************************************        
        /**
         * panelSubmit de "Ajouter/supprimer/modifier"
         */
        panelAdd.add(new JLabel("Module: "));
        moduleText = new JTextField("Java", 5);
        panelAdd.add(moduleText);

        panelAdd.add(new JLabel("Abb: "));
        abbText = new JTextField("java", 5);
        panelAdd.add(abbText);

        panelAdd.add(new JLabel("Color: "));
        colorText = new JTextField("red", 5);
        panelAdd.add(colorText);

        panelAdd.add(new JLabel("Seance: "));
        seanceText = new JTextField("50h", 5);
        panelAdd.add(seanceText);

        final JButton addButton = new JButton("Ajouter");//ajouter
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
        panelAdd.add(addButton);

        final JButton updateButton = new JButton("Modifier"); //modifier
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = moduleTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt(moduleText.getText(), selectedRow, 0);
                    tableModel.setValueAt(abbText.getText(), selectedRow, 1);
                    tableModel.setValueAt(colorText.getText(), selectedRow, 2);
                    tableModel.setValueAt(seanceText.getText(), selectedRow, 3);
                }
            }
        });
        panelAdd.add(updateButton);

        final JButton delButton = new JButton("Supprimer");// supprimer un ligne
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = moduleTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });
        panelAdd.add(delButton);

//PanelSubmit************************************************************************************
        /**
         * PanelSubmit: Enregistrer les opérations;
         */
       // panelSubmit.setPreferredSize(new Dimension(100, 40));
        final JButton submitButton = new JButton("Enregistrer");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panelSubmit.add(submitButton);
        //boutton reset
        //JButton submitButton =new JButton("Reset");
        //JButton annulerButton = new JButton("Annuler");
        //panelSubmit.add(annulerButton);

    }
    
    /* public FormationFenetre getNf() {
        if (nf == null) {
            nf = new FormationFenetre();
        }
        return nf;
    }
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FormationFenetre jTableDefaultTableModelTest = new FormationFenetre();
        jTableDefaultTableModelTest.setVisible(true);
    }
}
