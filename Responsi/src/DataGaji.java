
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DataGaji extends JFrame  {
    
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/gaji";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
             //id	nama	posisi	alamat	no	gaji	jam	tunjangan	pajak	total
    Object namaKolom[] = {"id","nama","poisis","alamat","no","gaji","jam","tunjangan","pajak","total"};
    
    JLabel lTitle = new JLabel("Gaji Karyawan");
    JLabel lid = new JLabel("Id Pegawai ");
    JTextField tfid = new JTextField();
    JLabel lNama= new JLabel("Nama ");
    JTextField tfNama = new JTextField();    
    JLabel lposisi = new JLabel("Posisi ");
     String[] namaPosisi =
            {"Programmer", "Sekretaris", "Staff", "Administrasi"};
    JComboBox cmbPosisi = new JComboBox(namaPosisi);
    
    JLabel lAlamat = new JLabel("Alamat");
         JTextField tfAlamat = new JTextField(); 
         
    JLabel lno = new JLabel(" No.Hp ");
       JTextField tfno = new JTextField();
       
    JLabel lGaji = new JLabel("Gaji Pokok");
    JTextField tfGaji = new JTextField();
    
    JLabel lJam = new JLabel("Jam Lembur ");
    JTextField tfJam = new JTextField();
    
    JLabel lTunjangan= new JLabel("Tunjangan ");
    JTextField tftnj = new JTextField();
    
    JLabel lPajak= new JLabel("Pajak ");
    JTextField tfPajak = new JTextField();
    
    JLabel lTotal= new JLabel("Total Gaji ");
    JTextField tfTotal = new JTextField();
    
    JButton btnSimpanPanel = new JButton("Simpan");
    JButton btnHapusPanel = new JButton("Hitung");
    JButton btnHome = new JButton("Kembali");  
    
    public DataGaji(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
         setTitle("GAJI KARYAWAN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(860, 600);
        setLocation(520, 280);
        
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);        

        add(scrollPane);
        scrollPane.setBounds(20, 270, 800, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
             
        add(lTitle);
        lTitle.setBounds(330, 10, 300, 60);
        lTitle.setFont(new Font("Segoe Script",Font.BOLD, 30));
        lTitle.setForeground(Color.red);
        
        add(lid);
        add(tfid);
        add(lNama);
        add(tfNama);
        add(lposisi);
        add(cmbPosisi);
        add(lAlamat);
        add(tfAlamat);
        add(lno);
        add(tfno);
        add(lGaji);
        add(tfGaji);
        add(lTunjangan);
        add(tftnj);
        add(lPajak);
        add(tfPajak);
        add(lTotal);
        add(tfTotal);
        
         lid.setBounds(40, 80, 80, 20);
        tfid.setBounds(140, 80, 220, 20); 
        
        lNama.setBounds(40, 110, 80, 20);        
        tfNama.setBounds(140, 110, 220, 20);
        
        lposisi.setBounds(40, 140, 80, 20);        
        cmbPosisi.setBounds(140, 140, 220, 20); 
        
        lAlamat.setBounds(40,170, 80, 20);        
        tfAlamat.setBounds(140,170, 220, 20); 
        
        lno.setBounds(40, 200, 80, 20);        
        tfno.setBounds(140, 200, 220, 20);  
        
        lGaji.setBounds(480, 100, 120, 20);        
        tfGaji.setBounds(580, 100, 220, 20); 
        
        lTunjangan.setBounds(480, 130, 80, 20);        
        tftnj.setBounds(580, 130, 220, 20);
        
        lPajak.setBounds(480, 160, 80, 20);
        tfPajak.setBounds(580, 160, 220, 20);
        
        lTotal.setBounds(480, 190, 80, 20);
        tfTotal.setBounds(580,190, 220, 20);
        
        add(btnSimpanPanel);
        add(btnHapusPanel);
        add(btnHome);
        btnSimpanPanel.setBounds(160, 230, 80, 30);        
        btnHapusPanel.setBounds(260, 230, 80, 30);        
        btnHome.setBounds(360, 230, 80, 30);   
         //id	nama	posisi	alamat	no	gaji	jam	tunjangan	pajak	total
         btnSimpanPanel.addActionListener((ActionEvent e) -> {
            if (tfNama.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong!");
            } else {
                String id = tfid.getText();
                String nama = tfNama.getText();
                String posisi = (String) cmbPosisi.getSelectedItem();
                String alamat = tfAlamat.getText();
                String no = tfno.getText();
                String gaji = tfGaji.getText();
                String jam = tfJam.getText();
                String tunjangan = tftnj.getText();
                String pajak = tfPajak.getText();
                String total = tfTotal.getText();
                
                this.simpan(id,nama,posisi,alamat,no,gaji,jam,tunjangan,pajak,total);
  
                String dataAnggota[][] = this.readGaji();
                table.setModel(new JTable(dataAnggota,namaKolom).getModel());
            }
        });
        
        if (this.getBanyakData() != 0) {  
            String dataAnggota[][] = this.readGaji();  
            table.setModel((new JTable(dataAnggota, namaKolom)).getModel());
             
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
        }
        
        table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){ 
               int baris = table.getSelectedRow();
               int kolom = table.getSelectedColumn();  
               
               String dataterpilih = table.getValueAt(baris, 0).toString();
               btnHapusPanel.addActionListener((ActionEvent f) -> {
                  hapus(dataterpilih);
                  String dataAnggota[][] = readGaji();
                table.setModel(new JTable(dataAnggota,namaKolom).getModel());
                }); 
           }
        });

        btnHome.addActionListener((ActionEvent e) -> {
           Menu menu = new Menu();
        menu.menuu();
           dispose();
        });
    }
       //id	nama	posisi	alamat	no	gaji	jam	tunjangan	pajak	total
    
    public void simpan(String id, String nama, String posisi, String alamat, String no, String gaji, String jam, String tunjangan, String pajak,String total) {
        try{
            String query = "INSERT INTO `data_gaji`(`id`,`nama`,`posisi`,`alamat`,`no`,`gaji`,`jam`,`tunjangan`,`pajak`,`total`) VALUES ('"+id+"','"+nama+"','"+posisi+"', '"+alamat+"','"+no+"','"+gaji+"','"+jam+"','"+tunjangan+"','"+pajak+"','"+total+"')";
              statement =  koneksi.createStatement();
        statement.executeUpdate(query); 
            System.out.println("Berhasil Ditambahkan!");
            JOptionPane.showMessageDialog(null,"Berhasil menambahkan "+nama+"!");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }        
    }
    String[][] readGaji() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][8];
            String query = "Select * from `data_gaji`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("Nama");
                data[jmlData][2] = resultSet.getString("posisi");
                data[jmlData][3] = resultSet.getString("alamat");
                data[jmlData][4] = resultSet.getString("no");
                data[jmlData][5] = resultSet.getString("gaji");
                data[jmlData][6] = resultSet.getString("jam");
                data[jmlData][7] = resultSet.getString("tunjangan");
                 data[jmlData][8] = resultSet.getString("pajak");
                  data[jmlData][9] = resultSet.getString("total");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }

   
        int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * from `data_gaji`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }

    void hapus(String nama) {
        try{
            String query = "DELETE FROM `data_gaji` WHERE `nama` = '"+nama+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus "+nama+"!" );
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}



        
   