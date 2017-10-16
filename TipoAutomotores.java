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
public class TipoAutomotores extends javax.swing.JInternalFrame {
ConexionAse cnn=new ConexionAse();
    Connection  con=cnn.ConexionAsedb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public TipoAutomotores() {
        initComponents();
        tablatipoautomotores();
     
    }
 public void tablatipoautomotores(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Tipo Auto ");
      tabla.addColumn("Nombre ");
      tipoa.setModel(tabla);
      String datos[]=new String[2];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT *FROM tiposautomotores");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
    }
  public void listardatos(){
     
      int lis=tipoa.getSelectedRow();
     if(lis>=0){ 
     TIPO.setText(tipoa.getValueAt(lis,0).toString());
     NOM.setText(tipoa.getValueAt(lis,1).toString());
     }
     }
   public void Registrar(){
        try {
            op=con.prepareStatement("INSERT INTO TiposAutomotores(Tipo_Aut,Tipo_Autnombre)values(?,?)");  
              op.setString(1,TIPO.getText());
              op.setString(2,NOM.getText());
              op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from TiposAutomotores where Tipo_Aut ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
       public void modificar(String doc,String no){
        
        try {
         op=con.prepareStatement("UPDATE   TiposAutomotores set Tipo_Autnombre='"+no+"' where Tipo_Aut='"+doc+"'");
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
        tipoa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NOM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        TIPO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TIPO AUTOMOTORES");
        getContentPane().setLayout(null);

        tipoa.setBackground(new java.awt.Color(255, 204, 255));
        tipoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tipoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tipoa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 380, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TIPO AUTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(63, 44, 66, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(77, 89, 52, 15);

        NOM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NOM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NOM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NOMKeyTyped(evt);
            }
        });
        getContentPane().add(NOM);
        NOM.setBounds(139, 86, 119, 21);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 90, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 0, 110, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(310, 0, 110, 20);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 0, 110, 20);

        TIPO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIPO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TIPOKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TIPOKeyTyped(evt);
            }
        });
        getContentPane().add(TIPO);
        TIPO.setBounds(140, 40, 120, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/auto.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 420, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Registrar();
        tablatipoautomotores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String dat=TIPO.getText();
        Eliminar(dat);
        tablatipoautomotores();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TIPO.setText(null);
        NOM.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     String t,n;
     t=TIPO.getText();
     n=NOM.getText();
     modificar(t, n);
     tablatipoautomotores();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void NOMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyTyped
    String texto=NOM.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        NOM.setText(texto);
      
}
        char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }      
    }//GEN-LAST:event_NOMKeyTyped

    private void TIPOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TIPOKeyTyped
               
    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }
                     
    }//GEN-LAST:event_TIPOKeyTyped

    private void TIPOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TIPOKeyPressed
         if(evt.getKeyCode()==evt.VK_ENTER){
        NOM.requestFocus();
    }                      
    }//GEN-LAST:event_TIPOKeyPressed

    private void tipoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoaMouseClicked
      listardatos();
    }//GEN-LAST:event_tipoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NOM;
    private javax.swing.JTextField TIPO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tipoa;
    // End of variables declaration//GEN-END:variables
}
