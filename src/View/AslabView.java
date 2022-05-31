/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.AslabModel;
import Controller.AslabController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Aziz
 */
public class AslabView extends JFrame {
    
    JLabel lNama = new JLabel("Nama");
    JLabel lP = new JLabel("Nilai Portfolio");
    JLabel lM = new JLabel("Nilai Microteaching");
    JLabel lW = new JLabel("Wawancara");
    
    public JTextField tNama = new JTextField();
    public JTextField tP = new JTextField();
    public JTextField tM = new JTextField();
    public JTextField tW = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Refresh");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama", "Portfolio", "Microteaching", "Wawancara", "Nilai Akhr"};

    public AslabView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        setTitle("");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,450);
        
        add(scrollPane);
        scrollPane.setBounds(0, 0, 400, 500);

        add(lNama);
        lNama.setBounds(510, 20, 120, 20);
        add(tNama);
        tNama.setBounds(510, 40, 120, 20);
        
        add(lP);
        lP.setBounds(510, 80, 120, 20);
        add(tP);
        tP.setBounds(510, 100, 120, 20);
        
        add(lM);
        lM.setBounds(510, 140, 120, 20);
        add(tM);
        tM.setBounds(510, 160, 120, 20);
        
        add(lW);
        lW.setBounds(510, 200, 120, 20);
        add(tW);
        tW.setBounds(510, 220, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 260, 120, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 290, 120, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 320, 120, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 350, 120, 20);
        
        
        
    }
    
    public String getNama(){
        return tNama.getText();
    }
    public String getM(){
        return tM.getText();
    }
    public String getP(){
        return tP.getText();
    }
    public String getW(){
        return tW.getText();
    }
    
}
