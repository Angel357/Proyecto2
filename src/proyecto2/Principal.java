/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Angeln
 */
public class Principal extends javax.swing.JFrame {

    String path;
    Simulacion s=new Simulacion();
    public static String[][] dat;
    
    public Principal() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);    
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
        txtArea = new javax.swing.JTextArea();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 630, 360));

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir archivo.png"))); // NOI18N
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 50, 50));

        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarComo.png"))); // NOI18N
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarComo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 50, 50));

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/play.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 50, 50));

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stop.png"))); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        getContentPane().add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 50, 50));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 50, 50));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        AbrirJason();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        GuardarComo();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        s.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        s.dispose();
    }//GEN-LAST:event_btnStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public void AbrirJason(){
        JFileChooser fl = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("csv files", "csv");
        fl.setFileFilter(filtro);
        int returnVal = fl.showOpenDialog(null);
        try{
            if(returnVal == JFileChooser.APPROVE_OPTION){
                Lectura(fl.getSelectedFile().getAbsolutePath());
            }
        }catch(Exception ex){
            System.out.println("Error al abrir");
        }
    }     
    public void Lectura(String path){
        this.path=path;
        File archivo = new File(path);
        String texto;
        try{
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            if(linea!=null){
                linea=linea.trim();
            }
                texto=linea+"\n";
            while(linea!=null){
                linea = leer.readLine();
                if(linea!=null){
                    linea=linea.trim();
                }
                texto+=linea+"\n";
            }
            txtArea.setText(texto);
            Llenar();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void Llenar(){
        String ptc = ";";
        String salto ="\n";
        String[] cdn = txtArea.getText().split(salto);
        dat =new String[cdn.length-1][17];
        int cont=0;
            for(int y =0;y<cdn.length-1;y++){
                String[] h=cdn[y].split(ptc);
                      for(int j=0;j<h.length-1;j++){
                          dat[cont][j]=h[j];
                      }
                cont++;
            }
            
            for(int i=0;i<cdn.length-1;i++ ){
                System.out.println("");
                for(int x=0;x<17;x++){
                    System.out.print("["+dat[i][x]+"]");
                }
            }
        
    }
    public void Guardar(){
        File archivo = new File(path);
        try{
            BufferedWriter salida=new BufferedWriter(new FileWriter (archivo));
            String uno=txtArea.getText();
            String[] linea=uno.split("\n");
            for(int x=0;x<linea.length-1;x++){
            salida.append(linea[x]);
            salida.newLine();
            }
            salida.close();
            JOptionPane.showMessageDialog(null, "Se a guardado correctamente el archivo");
        }catch(Exception e4){
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
        }
    
    }
    public void GuardarComo(){
        JFileChooser guardar=new JFileChooser();
        guardar.setApproveButtonText("Guardar");
        guardar.showSaveDialog(null);
        File archivo=new File(guardar.getSelectedFile()+".csv");
        try{
            BufferedWriter salida=new BufferedWriter(new FileWriter (archivo));
            String uno=txtArea.getText();
            //String[] linea=uno.split("\n");
            //for(int x=0;x<linea.length-1;x++){
            //salida.append(linea[x]);
            salida.append(uno);
            salida.newLine();
            //}
            salida.close();
            JOptionPane.showMessageDialog(null, "Se a guardado correctamente el archivo");
        }catch(Exception e4){
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo");
        }
    }
    
    public void LecturaJason(){
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
