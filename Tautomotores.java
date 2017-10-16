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
public class Tautomotores extends javax.swing.JInternalFrame {
  ConexionAse cnn=new ConexionAse();
    Connection  con=cnn.ConexionAsedb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Tautomotores() {
        initComponents();
        tablaautomotores();
    }

    public void tablaautomotores(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Placa  ");
      tabla.addColumn("Marca  ");
      tabla.addColumn("Tipo  ");
      tabla.addColumn("Modelo  ");
      tabla.addColumn("Nº Pasajeros   ");
      tabla.addColumn("Cilindraje   ");
      tabla.addColumn("Nº Chasis  ");
     automotores.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT * FROM automotores");
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
     public void filtrar(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Placa  ");
      tabla.addColumn("Marca  ");
      tabla.addColumn("Tipo  ");
      tabla.addColumn("Modelo  ");
      tabla.addColumn("Nº Pasajeros   ");
      tabla.addColumn("Cilindraje   ");
      tabla.addColumn("Nº Chasis  ");
     automotores.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT * FROM automotores where auto_placa like '%"+FILTRO.getText()+"%' or  Auto_marca like '%"+FILTRO.getText()+"%' or Auto_Tipo like '%"+FILTRO.getText()+"%' or Auto_modelo like '%"+FILTRO.getText()+"%' or Auto_num_pasajeros  like '%"+FILTRO.getText()+"%' or  Auto_cilindraje  like '%"+FILTRO.getText()+"%' or  Auto_numchasis  like '%"+FILTRO.getText()+"%'");
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
            op=con.prepareStatement("INSERT INTO  Automotores(auto_placa , Auto_marca , Auto_Tipo , Auto_modelo , Auto_num_pasajeros , Auto_cilindraje , Auto_numchasis ) values(?,?,?,?,?,?,?)");  
              op.setString(1,plac.getText());
              op.setString(2,marc.getText());
              op.setInt(3,Integer.parseInt(tipo.getText()));
              op.setString(4,mode.getText());
               op.setString(5,pasa.getText());
                op.setString(6,cilin.getText());
                op.setString(7,chasis.getText());
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from  Automotores where auto_placa ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
     public void modificar(String pla,String mar ,String ti,String mo,String pas,String cil,String cha){
        
        try {
         op=con.prepareStatement("UPDATE Automotores set  Auto_marca='"+mar+"', Auto_Tipo ='"+ti+"', Auto_modelo='"+mo+"', Auto_num_pasajeros='"+pas+"',Auto_cilindraje='"+cil+"',Auto_numchasis='"+cha+"' where auto_placa ='"+pla+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
     }
      public void listardatos(){
     
      int lis=automotores.getSelectedRow();
     if(lis>=0){ 
    plac.setText(automotores.getValueAt(lis,0).toString());
     marc.setText(automotores.getValueAt(lis,1).toString());
     tipo.setText(automotores.getValueAt(lis,2).toString());
      mode.setText(automotores.getValueAt(lis,3).toString());
       pasa.setText(automotores.getValueAt(lis,4).toString());
       cilin.setText(automotores.getValueAt(lis,5).toString());
       chasis.setText(automotores.getValueAt(lis,6).toString());
     }
  }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        automotores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        plac = new javax.swing.JTextField();
        marc = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        mode = new javax.swing.JTextField();
        pasa = new javax.swing.JTextField();
        cilin = new javax.swing.JTextField();
        chasis = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        FILTRO = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AUTOMOTORES");
        getContentPane().setLayout(null);

        automotores.setBackground(new java.awt.Color(255, 204, 255));
        automotores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        automotores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                automotoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(automotores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 237, 640, 140);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("PLACA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 30, 90, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("MARCA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 60, 90, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("TIPO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 90, 90, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("MODELO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 120, 90, 15);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Nº PASAJEROS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 150, 90, 15);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("CILINDRAJE");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 180, 90, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nº CHASIS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 210, 90, 15);

        plac.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        plac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        plac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                placKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                placKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                placKeyReleased(evt);
            }
        });
        getContentPane().add(plac);
        plac.setBounds(200, 30, 130, 21);

        marc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        marc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                marcKeyPressed(evt);
            }
        });
        getContentPane().add(marc);
        marc.setBounds(200, 60, 130, 21);

        tipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tipoKeyPressed(evt);
            }
        });
        getContentPane().add(tipo);
        tipo.setBounds(200, 90, 130, 21);

        mode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modeKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modeKeyPressed(evt);
            }
        });
        getContentPane().add(mode);
        mode.setBounds(200, 120, 130, 21);

        pasa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pasa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pasaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pasaKeyPressed(evt);
            }
        });
        getContentPane().add(pasa);
        pasa.setBounds(200, 150, 130, 21);

        cilin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cilin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cilin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cilinKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cilinKeyPressed(evt);
            }
        });
        getContentPane().add(cilin);
        cilin.setBounds(200, 180, 130, 21);

        chasis.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chasis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(chasis);
        chasis.setBounds(200, 210, 130, 21);

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
        jButton2.setBounds(190, 0, 90, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(280, 0, 100, 20);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 0, 100, 20);
        getContentPane().add(FILTRO);
        FILTRO.setBounds(460, 0, 190, 20);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 0, 51));
        jButton5.setText("BUSCAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton5KeyReleased(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(380, 0, 80, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/auto.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 660, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     Registrar();
     tablaautomotores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String dat=plac.getText();
        Eliminar(dat);
        tablaautomotores();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        plac.setText(null);
        marc.setText(null);
        tipo.setText(null);
        mode.setText(null);
        pasa.setText(null);
        cilin.setText(null);
        chasis.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String pl,m,t,mo,p,c,ch;
    pl=plac.getText();
    m=marc.getText();
    t=tipo.getText();
    mo=mode.getText();
    p=pasa.getText();
    c=cilin.getText();
    ch=chasis.getText();
        modificar(pl, m, t, mo, p, c, ch);
        tablaautomotores();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void placKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placKeyPressed
     
        if(evt.getKeyCode()==evt.VK_ENTER){
      marc.requestFocus();
    }//GEN-LAST:event_placKeyPressed
    }
    private void marcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
    tipo.requestFocus();
    }//GEN-LAST:event_marcKeyPressed
    }
    private void tipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
      mode.requestFocus();
    }//GEN-LAST:event_tipoKeyPressed
    }
    private void modeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
      pasa.requestFocus();
    }//GEN-LAST:event_modeKeyPressed
    }
    private void pasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasaKeyPressed
         if(evt.getKeyCode()==evt.VK_ENTER){
      cilin.requestFocus();
    }//GEN-LAST:event_pasaKeyPressed
    }
    private void cilinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cilinKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
       chasis.requestFocus();
    }//GEN-LAST:event_cilinKeyPressed
    }
    private void marcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcKeyTyped
    String texto= marc.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
      marc.setText(texto);
    
    }//GEN-LAST:event_marcKeyTyped
    char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }
    }
    private void modeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeKeyTyped
     char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_modeKeyTyped

    private void pasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pasaKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_pasaKeyTyped

    private void cilinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cilinKeyTyped
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_cilinKeyTyped

    private void tipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_tipoKeyTyped

    private void placKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placKeyTyped
      String text = (plac.getText()).toUpperCase();
        plac.setText(text);
        repaint();       
       
    }//GEN-LAST:event_placKeyTyped

    private void placKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placKeyReleased
   
    }//GEN-LAST:event_placKeyReleased

    private void automotoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_automotoresMouseClicked
    listardatos();
    }//GEN-LAST:event_automotoresMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
    filtrar();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyReleased
        filtrar();
    }//GEN-LAST:event_jButton5KeyReleased
  
  
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FILTRO;
    private javax.swing.JTable automotores;
    private javax.swing.JTextField chasis;
    private javax.swing.JTextField cilin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marc;
    private javax.swing.JTextField mode;
    private javax.swing.JTextField pasa;
    private javax.swing.JTextField plac;
    private javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables

}
