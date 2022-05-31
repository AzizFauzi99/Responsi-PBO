/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AslabModel;
import View.AslabView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AslabController {
    AslabView AslabVieww;
    AslabModel AslabModell;
    public String dataterpilih;
    
    public AslabController(AslabView AslabVieww, AslabModel AslabModell) {
        this.AslabVieww = AslabVieww;
        this.AslabModell = AslabModell;
        
        if(AslabModell.getBanyakData()!=0){
            String dataKaryawan[][] = AslabModell.readContact();
            AslabVieww.tabel.setModel((new JTable(dataKaryawan, AslabVieww.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        AslabVieww.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nama = AslabVieww.getNama();
                String p = AslabVieww.getP();
                String m = AslabVieww.getM();
                String w = AslabVieww.getW();
                AslabModell.insertData(nama, p, m, w);
         
                String dataKaryawan[][] = AslabModell.readContact();
                AslabVieww.tabel.setModel((new JTable(dataKaryawan, AslabVieww.namaKolom)).getModel());
            }
        });
        
        AslabVieww.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AslabVieww.tNama.setText(null);
                AslabVieww.tP.setText(null);  
                AslabVieww.tM.setText(null);
                AslabVieww.tW.setText(null);
                
                String dataKaryawan[][] = AslabModell.readContact();
                AslabVieww.tabel.setModel((new JTable(dataKaryawan, AslabVieww.namaKolom)).getModel());
            }
        });
        
        AslabVieww.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = AslabVieww.getNama();
                String p = AslabVieww.getP();
                String m =AslabVieww.getM();
                String w =AslabVieww.getW();
                AslabModell.updateContact(nama,p, m, w);
                
                String dataKaryawan[][] = AslabModell.readContact();
                AslabVieww.tabel.setModel((new JTable(dataKaryawan, AslabVieww.namaKolom)).getModel());
            }
        });
        
        AslabVieww.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Aslab " + dataterpilih + "? ", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {      
                    String nama = AslabVieww.getNama();
                    AslabModell.deleteContact(nama);  
                    
                    String dataNilai[][] = AslabModell.readContact();
                    AslabVieww.tabel.setModel((new JTable(dataNilai, AslabVieww.namaKolom)).getModel());
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }        
               
                /*String nama = AslabVieww.getNama();
                AslabModell.deleteContact(nama);  
                
                String dataKaryawan[][] = AslabModell.readContact();
                AslabVieww.tabel.setModel((new JTable(dataKaryawan, AslabVieww.namaKolom)).getModel());*/
            }
        });
        
        AslabVieww.tabel.addMouseListener(new MouseAdapter(){    
        @Override
        public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = AslabVieww.tabel.getSelectedRow();
                
                String nama = AslabVieww.tabel.getValueAt(baris, 0).toString();
                String p = AslabVieww.tabel.getValueAt(baris, 1).toString();
                String m = AslabVieww.tabel.getValueAt(baris, 2).toString();
                String w = AslabVieww.tabel.getValueAt(baris, 3).toString();              
                
                AslabVieww.dispose();
                AslabView ed = new AslabView();
                ed.tNama.setText(nama);
                ed.tP.setText(p);
                ed.tM.setText(m);
                ed.tW.setText(w);              
               
                AslabModel am = new AslabModel();
                AslabController ct = new AslabController(ed, am);
                
                
            }
            
        });
        
    }
    
    
}
