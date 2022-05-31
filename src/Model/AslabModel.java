/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DB.Aslab_DB;
import View.AslabView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AslabModel {

    Aslab_DB koneksi = new Aslab_DB();
    //AslabView AslabVieww = new AslabView();
    
    public String[][] readContact(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 5

            String query = "Select * from aslab";
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                //double hasil = (AslabVieww.getP() + AslabVieww.getM() + AslabVieww.getW())/3;
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertData(String Nama, String portofolio, String microteaching, String wawancara){
        int jmlData=0;
        double fportofolio = Float.parseFloat(portofolio);
        double fmicroteaching = Float.parseFloat(microteaching);
        double fwawancara = Float.parseFloat(wawancara);
        double nilai = (fportofolio + fmicroteaching +fwawancara)/3;
        try {
            String query = "Select * from aslab WHERE judul = '" + Nama + "'"; // cek apakah data sudah ada
            System.out.println(Nama);
            ResultSet resultSet = koneksi.statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { // jika data dengan tsb belum ada
                query = "INSERT INTO aslab VALUES('"+Nama+"','"+fportofolio+"','"+fmicroteaching+"','"+fwawancara+"','"+nilai+"')";

                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateContact(String Nama, String portofolio, String microteaching, String wawancara){
        int jmlData=0;
        double fportofolio = Float.parseFloat(portofolio);
        double fmicroteaching = Float.parseFloat(microteaching);
        double fwawancara = Float.parseFloat(wawancara);
        double nilai = (fportofolio + fmicroteaching +fwawancara)/3; 
        
        try {
            String query = "Select * from aslab WHERE judul = '"+ Nama + "'";
            ResultSet resultSet = koneksi.statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { 
                query = "UPDATE aslab SET judul ='" + Nama + "', portofolio ='" + fportofolio + "', microteaching='" + fmicroteaching +"', wawancara='" + fwawancara  + "', nilai = '" + nilai+ "' WHERE judul = '" + Nama +"'";
                koneksi.statement = (Statement) koneksi.koneksi.createStatement();
                koneksi.statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            koneksi.statement = koneksi.koneksi.createStatement();
            String query = "SELECT * FROM aslab";
            ResultSet resultSet = koneksi.statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteContact (String Nama) {
        try{
            String query = "DELETE FROM aslab WHERE judul = '"+Nama+"'";
            koneksi.statement = koneksi.koneksi.createStatement();
            koneksi.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
