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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class Tincidentes extends javax.swing.JInternalFrame {

    ConexionAse cnn=new ConexionAse();
    Connection  con=cnn.ConexionAsedb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Tincidentes() {
        initComponents();
        tablaincidentes();
        cargarcombo();
    }

     public void tablaincidentes(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo ");
      tabla.addColumn("Fecha ");
      tabla.addColumn("Placa  ");
      tabla.addColumn("Lugar  ");
      tabla.addColumn("Cant. Heridos  ");
      tabla.addColumn("Cant. Fatalidades   ");
      tabla.addColumn("Cant. Aut. Involucrados  ");
     incidentes.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT *FROM incidentes");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);
         datos[4]=rs.getString(5);
         datos[5]=rs.getString(6);
         datos[6]=rs.getString(7);
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
    }
     public void Registrar(){
        try {
            op=con.prepareStatement("INSERT INTO Incidentes(Inci_codigo , Inci_fecha , Inci_placa , Inci_lugar , Inci_cant_heridos , Inci_cant_fatalidades , Inci_cant_autos_involucrados)values(?,?,?,?,?,?,?)");  
              op.setInt(1,Integer.parseInt(COD.getText()));
              op.setString(2,FECHA.getText());
              op.setString(3,PLACA.getSelectedItem().toString());
              op.setString(4,LUGAR.getText());
              op.setInt (5,Integer.parseInt(HERI.getText()));
              op.setInt(6,Integer.parseInt(FATA.getText()));
              op.setInt(7,Integer.parseInt(AUTOS.getText()));  
              op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Incidentes where Inci_codigo ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
     public void listardatos(){
     
      int lis=incidentes.getSelectedRow();
     if(lis>=0){ 
    COD.setText(incidentes.getValueAt(lis,0).toString());
     FECHA.setText(incidentes.getValueAt(lis,1).toString());
    PLACA.setSelectedItem(incidentes.getValueAt(lis,2).toString());
     LUGAR.setText(incidentes.getValueAt(lis,3).toString());
     HERI.setText(incidentes.getValueAt(lis,4).toString());
      FATA.setText(incidentes.getValueAt(lis,5).toString());
      AUTOS.setText(incidentes.getValueAt(lis,6).toString());
     }
     }
     public void cargarcombo(){
        try {
           PLACA.removeAll();
           PLACA.addItem("SELECCIONE PLACA");
          op=con.prepareStatement("Select auto_placa from Automotores ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("auto_placa");
             this.PLACA.addItem(aux);
         }
        } catch (Exception e) {
        }
       }
       public void modificar(String co ,String in,String pla,String lu,String her,String fata,String can){
        
        try {
         op=con.prepareStatement("UPDATE incidentes set Inci_fecha='"+in+"' , Inci_placa='"+pla+"' , Inci_lugar='"+lu+"' , Inci_cant_heridos='"+her+"' , Inci_cant_fatalidades='"+fata+"' , Inci_cant_autos_involucrados='"+can+"' where Inci_codigo  ='"+co+"'");
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
        incidentes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        COD = new javax.swing.JTextField();
        FECHA = new javax.swing.JTextField();
        LUGAR = new javax.swing.JTextField();
        HERI = new javax.swing.JTextField();
        FATA = new javax.swing.JTextField();
        AUTOS = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        PLACA = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INCIDENTES");
        getContentPane().setLayout(null);

        incidentes.setBackground(new java.awt.Color(255, 204, 255));
        incidentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        incidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                incidentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(incidentes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 270, 610, 140);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 50, 130, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FECHA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 80, 130, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PLACA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 130, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LUGAR");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 140, 130, 15);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CANT. HERIDOS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 170, 130, 15);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CANT. FATALIDADES");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 200, 130, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CANT. AUTOS INVOLUCRADOS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 230, 190, 20);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 90, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 0, 100, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 51));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 0, 100, 20);

        COD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        COD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        COD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CODKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CODKeyPressed(evt);
            }
        });
        getContentPane().add(COD);
        COD.setBounds(200, 50, 160, 21);

        FECHA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FECHA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FECHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FECHAKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHAKeyPressed(evt);
            }
        });
        getContentPane().add(FECHA);
        FECHA.setBounds(200, 80, 160, 21);

        LUGAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LUGAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LUGAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LUGARKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LUGARKeyPressed(evt);
            }
        });
        getContentPane().add(LUGAR);
        LUGAR.setBounds(200, 140, 160, 21);

        HERI.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        HERI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HERI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HERIKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HERIKeyPressed(evt);
            }
        });
        getContentPane().add(HERI);
        HERI.setBounds(200, 170, 160, 21);

        FATA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        FATA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FATA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FATAKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FATAKeyPressed(evt);
            }
        });
        getContentPane().add(FATA);
        FATA.setBounds(200, 200, 160, 20);

        AUTOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AUTOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AUTOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AUTOSKeyTyped(evt);
            }
        });
        getContentPane().add(AUTOS);
        AUTOS.setBounds(200, 230, 160, 21);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 0, 100, 20);

        PLACA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PLACA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLACAActionPerformed(evt);
            }
        });
        PLACA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PLACAKeyPressed(evt);
            }
        });
        getContentPane().add(PLACA);
        PLACA.setBounds(200, 110, 160, 20);

        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/acci.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 630, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Registrar();
      tablaincidentes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String dat=COD.getText();
        Eliminar(dat);
        tablaincidentes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      COD.setText(null);
      FECHA.setText(null);
      PLACA.removeAllItems();
      LUGAR.setText(null);
      HERI.setText(null);
      FATA.setText(null);
      AUTOS.setText(null);
      cargarcombo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PLACAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLACAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLACAActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     String c,i,pl,lu,h,fa,ca;
     c=COD.getText();
     i=FECHA.getText();
     pl=PLACA.getSelectedItem().toString();
     lu=LUGAR.getText();
     h=HERI.getText();
     fa=FATA.getText();
     ca=AUTOS.getText();
        modificar(c, i, pl, lu, h, fa, ca);
        tablaincidentes();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CODKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_CODKeyTyped

    private void HERIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HERIKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_HERIKeyTyped

    private void FATAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATAKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_FATAKeyTyped

    private void AUTOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AUTOSKeyTyped
    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_AUTOSKeyTyped

    private void LUGARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LUGARKeyTyped
        String texto= LUGAR.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
      LUGAR.setText(texto);
    
    }                             
    char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }
    }//GEN-LAST:event_LUGARKeyTyped

    private void FECHAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHAKeyTyped
      char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }     
    }//GEN-LAST:event_FECHAKeyTyped

    private void CODKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
        FECHA.requestFocus();
    }                            
    }//GEN-LAST:event_CODKeyPressed

    private void FECHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHAKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
      PLACA.requestFocus();
    }                            
    }//GEN-LAST:event_FECHAKeyPressed

    private void PLACAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PLACAKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
        LUGAR.requestFocus();
    }                            
    }//GEN-LAST:event_PLACAKeyPressed

    private void LUGARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LUGARKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
       HERI.requestFocus();
    }                            
    }//GEN-LAST:event_LUGARKeyPressed

    private void HERIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HERIKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
       FATA.requestFocus();
    }                            
    }//GEN-LAST:event_HERIKeyPressed

    private void FATAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATAKeyPressed
     if(evt.getKeyCode()==evt.VK_ENTER){
        AUTOS.requestFocus();
    }                            
    }//GEN-LAST:event_FATAKeyPressed

    private void incidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_incidentesMouseClicked
    listardatos();
    }//GEN-LAST:event_incidentesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AUTOS;
    private javax.swing.JTextField COD;
    private javax.swing.JTextField FATA;
    private javax.swing.JTextField FECHA;
    private javax.swing.JTextField HERI;
    private javax.swing.JTextField LUGAR;
    private javax.swing.JComboBox<String> PLACA;
    private javax.swing.JTable incidentes;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
