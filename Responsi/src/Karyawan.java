/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo;


import DataKaryawan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.*;
import java.io.IOException;
import java.io.*;
import javax.imageio.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author ADAM ARDI
 */
public class Karyawan extends JFrame{
   
    
    JButton btnHome = new JButton("Home");
    JButton btnGaji = new JButton("Gaji");
    JButton btnData = new JButton("Data");
    JButton btnPetunjuk= new JButton("Petunjuk");
    JButton btnAdmin = new JButton("Admin");
    JTextArea teks = new JTextArea(" Selamat Datang di,\n Silahkan masuk ke menu gaji untuk melakukan perhitungan gaji.\n Jika mengalami kesulitan klik menu petunjuk");
    JLabel Footer = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VETERAN JAYA");
    
    public Karyawan(){
        
    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(850,580);
        setLocation(225,75);
        
         
        
        add(btnHome);
        btnHome.setBounds(10,20,120,70);
        add(btnGaji);
        btnGaji.setBounds(10,100,120,70);
        add(btnData);
        btnData.setBounds(10,180,120,70);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10,260,120,70);
        add(btnAdmin);
        btnAdmin.setBounds(700,20,120,70);
        add(teks);
        teks.setBounds(150, 100, 600, 300);
        teks.setLineWrap(true);
        teks.setWrapStyleWord(true);
        teks.setFont(new Font("Arial", Font.BOLD, 18));
        add(Footer);
        Footer.setBounds(250, 500, 600, 50);
        Footer.setFont(new Font("Arial",Font.CENTER_BASELINE, 15));
        
        
        btnHome.addActionListener((ActionEvent e) -> {
          Karyawan a = new Karyawan();
           dispose();
        });
        btnGaji.addActionListener((ActionEvent e) -> {
          KaryawanGaji b = new KaryawanGaji();
           dispose();
        });
        btnData.addActionListener((ActionEvent e) -> {
          DataK c = new DataK();
           dispose();
        });
        btnPetunjuk.addActionListener((ActionEvent e) -> {
          ptjkK p = new ptjkK();
           dispose();
        });
       
        
    }
    
    
}
