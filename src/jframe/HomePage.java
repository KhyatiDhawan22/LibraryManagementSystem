/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author khyat
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    public HomePage() {
        initComponents();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToCards();
        showPieChart();
    }
    //Method 1 : Fetch from db and Display to table
    DefaultTableModel model;
    public void setStudentDetailsToTable(){
        try{
            Connection con=DBConnection.getConnection();
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from student_details");
            while(rs.next()){
                
                String studentId=rs.getString("student_id"); //orange one is db column name
                String studentName=rs.getString("name");
                String course=rs.getString("course");
                String branch=rs.getString("branch");
                
                //Same order as the table created in the frame
                Object[] obj={studentId,studentName,course,branch};
                
                //model will represent the table of the frame using which we will create the row in it
                model =(DefaultTableModel) rSTableMetro1.getModel();
                model.addRow(obj);
               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //Method 2 : Fetch from db and Display to table
    DefaultTableModel model2;
    public void setBookDetailsToTable(){
        try{
            Connection con=DBConnection.getConnection();
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from book_details");
            while(rs.next()){
                
                String bookId=rs.getString("book_id"); //orange one is db column name
                String bookName=rs.getString("book_name");
                String author=rs.getString("author");
                int quantity=rs.getInt("quantity");
                
                //Same order as the table created in the frame
                Object[] obj={bookId,bookName,author,quantity};
                
                //model will represent the table of the frame using which we will create the row in it
                model =(DefaultTableModel) rSTableMetro2.getModel();
                model.addRow(obj);
               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }   
    public void setDataToCards(){
        Statement st=null;
        ResultSet rs=null;
        long l=System.currentTimeMillis();
        Date todaysDate = new Date(l);
        try{
            Connection con=DBConnection.getConnection();
            st =con.createStatement();
            rs=st.executeQuery("select * from book_details");
            rs.last();//last
            rs.getRow();//row no.
            lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
            rs=st.executeQuery("select * from student_details");
            rs.last();
            rs.getRow();
            lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
            rs=st.executeQuery("select * from issue_book_details where status='"+"pending"+"'");
            rs.last();
            rs.getRow();
            lbl_issueBook.setText(Integer.toString(rs.getRow()));
            
            rs=st.executeQuery("select * from issue_book_details where due_date <'"+todaysDate+"' and status='"+"pending"+"'");
            rs.last();
            rs.getRow();
            lbl_defaulterList.setText(Integer.toString(rs.getRow()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
                
    }
    
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      try{
          Connection con=DBConnection.getConnection();
          String sql="select book_name,count(*) as issue_count from issue_book_details group by book_id";
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(sql);
          while(rs.next()){
              barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
          }
      }
      catch(Exception e){
          e.printStackTrace();
      }
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_issueBook = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome, Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("X");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1860, 10, 30, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel5.setText("  Logout");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 850, 340, 60));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("  Home Page");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 40));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 60));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Features");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 30));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("  LMS Dashboard");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel8.setText("  Manage Books");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 340, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel9.setText("  Manage Students");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 340, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel10.setText("  Issue Book");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 340, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel11.setText("  Return Book");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel12.setText("  View Records");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 40));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel13.setText("  View Issued books");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, 40));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 340, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel14.setText("  Defaulter List");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, 40));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 340, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 260, 140));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Student Details");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 260, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("No Of Students");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 260, -1));

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfStudents.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lbl_noOfStudents)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_noOfStudents)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Issued Books");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 260, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_issueBook.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_issueBook.setForeground(new java.awt.Color(102, 102, 102));
        lbl_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBook.setText("10");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lbl_issueBook)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_issueBook)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 260, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Defaulter List");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 60, 260, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_defaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lbl_defaulterList)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_defaulterList)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, 260, -1));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        rSTableMetro1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        rSTableMetro1.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        rSTableMetro1.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        rSTableMetro1.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 790, 260));

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("No Of Books");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 260, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book Details");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 260, -1));

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book id", "Name", "Author", "Quantity"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        rSTableMetro2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        rSTableMetro2.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        rSTableMetro2.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        rSTableMetro2.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        rSTableMetro2.setRowHeight(40);
        jScrollPane2.setViewportView(rSTableMetro2);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 790, 240));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel14.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 540, 450));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1570, 960));

        setSize(new java.awt.Dimension(1905, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        new ManageBooks().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
       jPanel6.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jPanel6.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
       jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
       jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
       jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jPanel12.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jPanel12.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new ManageStudents().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new IssueBook().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new ViewAllRecord().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new ReturnBook().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new IssueBookDetails().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issueBook;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JPanel panelPieChart;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    // End of variables declaration//GEN-END:variables
}
