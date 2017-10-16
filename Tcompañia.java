/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASEGURADORA;

import Controlador.ConexionAse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class Tcompañia extends javax.swing.JInternalFrame {

     ConexionAse cnn=new ConexionAse();
    Connection  con=cnn.ConexionAsedb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public Tcompañia() {
        initComponents();
        tablacompañia();
    }

    public void tablacompañia(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Nit Empresa ");
      tabla.addColumn("Nombre Empresa  ");
      tabla.addColumn("Año Fundacion  ");
      tabla.addColumn("Representante Legal ");
        tabla.addColumn("Usuario ");
          tabla.addColumn("Clave ");
      compa.setModel(tabla);
      String datos[]=new String[6];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT * FROM compania");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4); 
         datos[4]=rs.getString(5); 
         datos[5]=rs.getString(6); 
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
  }
     public void listardatos(){
     
      int lis=compa.getSelectedRow();
     if(lis>=0){ 
    NIT.setText(compa.getValueAt(lis,0).toString());
     NOMbre.setText(compa.getValueAt(lis,1).toString());
    FUN.setText(compa.getValueAt(lis,2).toString());
     LEGA.setText(compa.getValueAt(lis,3).toString());
      USU.setText(compa.getValueAt(lis,4).toString());
      CLAVE.setText(compa.getValueAt(lis,5).toString());
     }
     }
     public void Registrar(){
        try {
            op=con.prepareStatement("INSERT INTO Compania(Com_nit, Com_nombre,Com_anofun , Com_replegal,usuario,clave) values(?,?,?,?,?,?)");  
              op.setString(1,NIT.getText());
              op.setString(2,NOMbre.getText());
              op.setString(3,FUN.getText());
              op.setString(4,LEGA.getText());
              op.setString(5,USU.getText());
               op.setString(6,CLAVE.getText());
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Compania where Com_nit ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
     public void modificar(String ni,String no ,String fun,String le,String usu,String cla){
        
        try {
         op=con.prepareStatement("UPDATE Compania set  Com_nombre='"+no+"',Com_anofun ='"+fun+"',Com_replegal='"+le+"',usuario='"+usu+"',clave='"+cla+"' where Com_nit ='"+ni+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        compa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NIT = new javax.swing.JTextField();
        NOMbre = new javax.swing.JTextField();
        FUN = new javax.swing.JTextField();
        LEGA = new javax.swing.JTextField();
        USU = new javax.swing.JTextField();
        CLAVE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("COMPAÑIA");
        getContentPane().setLayout(null);

        compa.setBackground(new java.awt.Color(255, 204, 255));
        compa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        compa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(compa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 243, 620, 110);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NIT EMPRESA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 50, 130, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE EMPRESA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 90, 130, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AÑO DE FUNDACION");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 120, 130, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REPRESENTANTE LEGAL");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 150, 150, 15);

        NIT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NIT.setText("\n\n");
        NIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NITKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NITKeyPressed(evt);
            }
        });
        getContentPane().add(NIT);
        NIT.setBounds(240, 40, 180, 21);

        NOMbre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NOMbre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NOMbre.setText("\n\n");
        NOMbre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NOMbreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOMbreKeyPressed(evt);
            }
        });
        getContentPane().add(NOMbre);
        NOMbre.setBounds(240, 80, 180, 21);

        FUN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FUN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FUN.setText("\n\n");
        FUN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FUNKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FUNKeyPressed(evt);
            }
        });
        getContentPane().add(FUN);
        FUN.setBounds(240, 120, 180, 21);

        LEGA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LEGA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LEGA.setText("\n\n");
        LEGA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LEGAKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LEGAKeyPressed(evt);
            }
        });
        getContentPane().add(LEGA);
        LEGA.setBounds(240, 150, 180, 21);

        USU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        USU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        USU.setText("\n\n");
        USU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                USUKeyPressed(evt);
            }
        });
        getContentPane().add(USU);
        USU.setBounds(240, 180, 180, 21);

        CLAVE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CLAVE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CLAVE.setText("\n\n");
        getContentPane().add(CLAVE);
        CLAVE.setBounds(240, 210, 180, 21);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USUARIO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 180, 130, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CLAVE");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 210, 130, 15);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 90, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 0, 100, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 0, 90, 20);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 0, 0));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 0, 100, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/AUTOMOTORES.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 630, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     Registrar();
     tablacompañia();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         String dat=NIT.getText();
        Eliminar(dat);
        tablacompañia();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     NIT.setText(null);
     NOMbre.setText(null);
     FUN.setText(null);
     LEGA.setText(null);
     USU.setText(null);
     CLAVE.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void NITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NITKeyTyped
      char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }     
    }//GEN-LAST:event_NITKeyTyped

    private void NITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NITKeyPressed
     if(evt.getKeyCode()==evt.VK_ENTER){
        NOMbre.requestFocus();
    }             
    }//GEN-LAST:event_NITKeyPressed

    private void NOMbreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMbreKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
       FUN.requestFocus();
    }             
    }//GEN-LAST:event_NOMbreKeyPressed

    private void FUNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FUNKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
        LEGA.requestFocus();
    }             
    }//GEN-LAST:event_FUNKeyPressed

    private void LEGAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LEGAKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
        USU.requestFocus();
    }             
    }//GEN-LAST:event_LEGAKeyPressed

    private void USUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_USUKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
       CLAVE.requestFocus();
    }             
    }//GEN-LAST:event_USUKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String n,no, f,l, u, c;
    n=NIT.getText();
    no=NOMbre.getText();
    f=FUN.getText();
    l=LEGA.getText();
    u=USU.getText();
    c=CLAVE.getText();
        modificar(n,no, f, l, u, c);
    tablacompañia();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void NOMbreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMbreKeyTyped
      String texto= NOMbre.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length() );
    NOMbre.setText(texto);
    }
    char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
               
    }                             
    }//GEN-LAST:event_NOMbreKeyTyped

    private void LEGAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LEGAKeyTyped
     String texto= LEGA.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
      LEGA.setText(texto);
    
    }                             
    char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
   
    }                       
    }//GEN-LAST:event_LEGAKeyTyped

    private void FUNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FUNKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }      
    }//GEN-LAST:event_FUNKeyTyped

    private void compaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compaMouseClicked
       listardatos();
    }//GEN-LAST:event_compaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CLAVE;
    private javax.swing.JTextField FUN;
    private javax.swing.JTextField LEGA;
    private javax.swing.JTextField NIT;
    private javax.swing.JTextField NOMbre;
    private javax.swing.JTextField USU;
    private javax.swing.JTable compa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
