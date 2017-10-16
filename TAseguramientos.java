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
public class TAseguramientos extends javax.swing.JInternalFrame {
//conexion para base de datos
  ConexionAse cnn=new ConexionAse();
    Connection  con=cnn.ConexionAsedb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public TAseguramientos() {
        initComponents();
        //seleccionar estado
        estado.addItem("Seleccione");
      estado.addItem("Vigente");
      estado.addItem("Vencido");
      //inciar carga de tabla
        tablaaseguramientos();
        //cargar combobox
        cargarcombo();
     
    }
 public void tablaaseguramientos(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo ");
      tabla.addColumn("Fecha de Inicio  ");
      tabla.addColumn("Fecha de Expiracion  ");
      tabla.addColumn("Valor Asegurado  ");
      tabla.addColumn("Estado ");
      tabla.addColumn("Costo ");
      tabla.addColumn("Placa  ");
       asegura.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT *FROM Aseguramientos");
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
            op=con.prepareStatement("INSERT INTO  Aseguramientos(Ase_codigo , Ase_fecha_inicio ,Ase_fecha_expiracion, Ase_valor_asegurado , Ase_estado , Ase_costo , Ase_placa ) values(?,?,?,?,?,?,?)");  
              op.setInt(1,Integer.parseInt(COD.getText()));
              op.setString(2,INI.getText());
              op.setString(3,EXPI.getText());
              op.setInt(4,Integer.parseInt(VALOR.getText()));
              op.setString(5,estado.getSelectedItem().toString());
              op.setInt(6,Integer.parseInt(COST.getText()));
               op.setString(7,PLACA.getSelectedItem().toString());
              op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
  public void filtrar(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo ");
      tabla.addColumn("Fecha de Inicio  ");
      tabla.addColumn("Fecha de Expiracion  ");
      tabla.addColumn("Valor Asegurado  ");
      tabla.addColumn("Estado ");
      tabla.addColumn("Costo ");
      tabla.addColumn("Placa  ");
       asegura.setModel(tabla);
      String datos[]=new String[7];
      tabla.addRow(datos);
      
       try {
        op=con.prepareStatement("SELECT *FROM Aseguramientos where Ase_codigo like '%"+FILTRO.getText()+"%' or Ase_fecha_inicio like '%"+FILTRO.getText()+"%' or Ase_fecha_expiracion like '%"+FILTRO.getText()+"%' or  Ase_valor_asegurado like '%"+FILTRO.getText()+"%' or Ase_estado like '%"+FILTRO.getText()+"%' or Ase_costo like '%"+FILTRO.getText()+"%' or Ase_placa like '%"+FILTRO.getText()+"%'");
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
 
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Aseguramientos where Ase_codigo ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
      public void modificar(String co ,String ini,String ex,String val,String es,String cos,String pla){
        
        try {
         op=con.prepareStatement("UPDATE Aseguramientos set Ase_fecha_inicio='"+ini+"',Ase_fecha_expiracion='"+ex+"', Ase_valor_asegurado='"+val+"' , Ase_estado='"+es+"' , Ase_costo='"+cos+"' , Ase_placa='"+pla+"' where Ase_codigo  ='"+co+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
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
         public void listardatos(){
     
      int lis=asegura.getSelectedRow();
     if(lis>=0){ 
     COD.setText(asegura.getValueAt(lis,0).toString());
    INI.setText(asegura.getValueAt(lis,1).toString());
     EXPI.setText(asegura.getValueAt(lis,2).toString());
     VALOR.setText(asegura.getValueAt(lis,3).toString());
       estado.setSelectedItem(asegura.getValueAt(lis,4).toString());
       COST.setText(asegura.getValueAt(lis,5).toString());
       PLACA.setSelectedItem(asegura.getValueAt(lis,6).toString());
     }
  }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        asegura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        COD = new javax.swing.JTextField();
        INI = new javax.swing.JTextField();
        EXPI = new javax.swing.JTextField();
        VALOR = new javax.swing.JTextField();
        COST = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        PLACA = new javax.swing.JComboBox<>();
        estado = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        FILTRO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ASEGURAMIENTOS");
        getContentPane().setLayout(null);

        asegura.setBackground(new java.awt.Color(255, 204, 255));
        asegura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        asegura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aseguraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(asegura);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 674, 129);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(44, 40, 120, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FECHA INICIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(44, 70, 120, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FECHA EXPIRACION");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(44, 100, 120, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VALOR ASEGURADO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(44, 130, 120, 15);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ESTADO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(44, 160, 120, 15);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("COSTO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(44, 190, 120, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PLACA");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(44, 220, 120, 15);

        COD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        COD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        COD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CODKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CODKeyTyped(evt);
            }
        });
        getContentPane().add(COD);
        COD.setBounds(230, 40, 150, 21);

        INI.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        INI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        INI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                INIKeyTyped(evt);
            }
        });
        getContentPane().add(INI);
        INI.setBounds(230, 70, 150, 21);

        EXPI.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EXPI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EXPI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EXPIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EXPIKeyTyped(evt);
            }
        });
        getContentPane().add(EXPI);
        EXPI.setBounds(230, 100, 150, 21);

        VALOR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        VALOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VALOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VALORKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VALORKeyTyped(evt);
            }
        });
        getContentPane().add(VALOR);
        VALOR.setBounds(230, 130, 150, 21);

        COST.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        COST.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        COST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                COSTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                COSTKeyTyped(evt);
            }
        });
        getContentPane().add(COST);
        COST.setBounds(230, 190, 150, 21);

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
        jButton2.setBounds(190, 0, 100, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 0, 100, 20);

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

        PLACA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PLACA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLACAActionPerformed(evt);
            }
        });
        getContentPane().add(PLACA);
        PLACA.setBounds(230, 220, 150, 30);

        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado);
        estado.setBounds(230, 160, 150, 20);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 0, 51));
        jButton5.setText("BUSCAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(390, 0, 80, 20);
        getContentPane().add(FILTRO);
        FILTRO.setBounds(470, 0, 290, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/aseg.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 770, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Registrar();
       tablaaseguramientos();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String dat=COD.getText();
        Eliminar(dat);
        tablaaseguramientos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       COD.setText(null);
       INI.setText(null);
       EXPI.setText(null);
       VALOR.setText(null);
       estado.removeAllItems();
       COST.setText(null);
       PLACA.removeAllItems();
        cargarcombo();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String cod,i,e,v,est,co,pl;
        cod=COD.getText();
        i=INI.getText();
        e=EXPI.getText();
        v=VALOR.getText();
        est=estado.getSelectedItem().toString();
        co=COST.getText();
        pl=PLACA.getSelectedItem().toString();
        modificar(cod, i, e, v, est, co, pl);
        tablaaseguramientos();
    }//GEN-LAST:event_jButton4ActionPerformed
   
    private void CODKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyTyped
     char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_CODKeyTyped

    private void INIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INIKeyTyped
        char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }     
    }//GEN-LAST:event_INIKeyTyped

    private void EXPIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EXPIKeyTyped
       char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }     
    }//GEN-LAST:event_EXPIKeyTyped

    private void VALORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORKeyTyped
     char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_VALORKeyTyped

    private void COSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_COSTKeyTyped
   char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }         
    }//GEN-LAST:event_COSTKeyTyped

    private void PLACAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLACAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PLACAActionPerformed

    private void CODKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
     INI.requestFocus();
    }//GEN-LAST:event_CODKeyPressed
    }
    private void INIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INIKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
     EXPI.requestFocus();
    }//GEN-LAST:event_INIKeyPressed
    }
    private void EXPIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EXPIKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
    VALOR.requestFocus();
    }//GEN-LAST:event_EXPIKeyPressed
    }
    private void VALORKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
      estado.requestFocus();
    }//GEN-LAST:event_VALORKeyPressed
    }    
    private void COSTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_COSTKeyPressed
     if(evt.getKeyCode()==evt.VK_ENTER){
      PLACA.requestFocus();
    }//GEN-LAST:event_COSTKeyPressed
    }
    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
      
    }//GEN-LAST:event_estadoActionPerformed

    private void aseguraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aseguraMouseClicked
       listardatos();
    }//GEN-LAST:event_aseguraMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       filtrar();
    }//GEN-LAST:event_jButton5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField COD;
    private javax.swing.JTextField COST;
    private javax.swing.JTextField EXPI;
    private javax.swing.JTextField FILTRO;
    private javax.swing.JTextField INI;
    private javax.swing.JComboBox<String> PLACA;
    private javax.swing.JTextField VALOR;
    private javax.swing.JTable asegura;
    private javax.swing.JComboBox<String> estado;
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
    // End of variables declaration//GEN-END:variables

}
