import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Petunjuk extends JFrame{
   
    
    JButton btnHome = new JButton("Home");
    
    JTextArea teks = new JTextArea(" Klik tombol gaji untuk menghitung gaji anda \n\n Klik tombol data untuk melihat data sudah masuk atau belum");
   
    
    public Petunjuk(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(850,580);
        setLocation(225,75);
        
        add(btnHome);
        btnHome.setBounds(350,400,120,70);
        
        add(teks);
        teks.setBounds(150, 100, 600, 300);
        teks.setLineWrap(true);
        teks.setWrapStyleWord(true);
        teks.setFont(new Font("Arial", Font.BOLD, 18));
        
        btnHome.addActionListener((ActionEvent e) -> {
           Menu menu = new Menu();
        menu.menuu();
           dispose();
        });
        
    }
    
    
}
