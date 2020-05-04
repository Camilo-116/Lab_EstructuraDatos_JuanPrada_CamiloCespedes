/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2_lab_juanpabloprada_camilocespedes;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JPPM
 */
public class Proyecto_Multilista extends javax.swing.JFrame {
 DefaultListModel modeloE;
 DefaultListModel modeloB;
 DefaultListModel modeloR;
    
    public Proyecto_Multilista() {
        initComponents();
        modeloE=new DefaultListModel();
        listaEscenarios.setModel(modeloE);
        modeloB=new DefaultListModel();
        listaBandas.setModel(modeloB);
        modeloR = new DefaultListModel();
        listaReporte.setModel(modeloR);
        ptr = null;
    }
    
    NodoEsc ptr = null;
    int escenarios = 0;
    class NodoEsc{
        int numeroEscenario;
        String patrocinador;
        float presupuesto;
        float costoEs = 0;
        int contB = 0;
        NodoEsc linkE;
        NodoBan linkB;
    }
    
    class NodoBan{
        String nombreBanda;
        int cantidadFans;
        int cantidadC;
        float costo;
        NodoBan linkB;
    }
    
    public NodoEsc AddEscenario (NodoEsc ptr, int num, String patro, float presu){
        NodoEsc escenario = new NodoEsc ();
        escenario.numeroEscenario = num;
        escenario.patrocinador = patro;
        escenario.presupuesto = presu;
        NodoEsc p = ptr;
        if (ptr == null){
            ptr = escenario;
        }else{
            while ( p.linkE != null){
                p = p.linkE;
            }
            p.linkE = escenario;
            escenarios++;
        }
        return ptr;
    }
    
    
    void showList(NodoEsc ptr){
        DefaultListModel model = (DefaultListModel) listaEscenarios.getModel();
        model.clear();
        NodoEsc p = ptr;
        while(p != null){
            model.addElement(p.numeroEscenario+" | "+p.patrocinador+" | "+p.presupuesto+" | Número de Bandas:"+p.contB);
            model.addElement("");
            p = p.linkE;
        }
    }
    void showList(NodoBan ptr){
        DefaultListModel model = (DefaultListModel) listaBandas.getModel();
        model.clear();
        NodoBan p = ptr;
        while(p != null){
            model.addElement(p.nombreBanda+" | "+p.cantidadFans+" | "+p.cantidadC+" | "+p.costo);
            p = p.linkB;
        }
    }
     void showList_Reporte(NodoEsc ptr){
        DefaultListModel model = (DefaultListModel) listaReporte.getModel();
        model.clear();
        NodoEsc p = ptr;
        model.addElement("#Escenario | Costo generado");
        while(p != null){
            
            model.addElement(p.numeroEscenario+"               | "+p.costoEs);
            model.addElement(" ");
            p = p.linkE;
        }
        float total = dinerogastado (ptr);
        DineroG.setText(String.valueOf(total));
    }
     float dinerogastado(NodoEsc ptr){
         float sum=0;
         NodoEsc p = ptr;
         while(p != null){
            sum+=p.costoEs;
            p = p.linkE;
        }
         return sum;
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        escenarioNum = new javax.swing.JTextField();
        patrocinadorNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        presuPat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bandaNom = new javax.swing.JTextField();
        cantidadFans = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Banda = new javax.swing.JButton();
        Escenario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBandas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEscenarios = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bandaCosto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cantidadC = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaReporte = new javax.swing.JList<>();
        Reporte = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        DineroG = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 509, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Festival");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 13, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Escenario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 62, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Numero del escenario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 105, -1, -1));

        escenarioNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenarioNumActionPerformed(evt);
            }
        });
        getContentPane().add(escenarioNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 102, 72, -1));

        patrocinadorNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patrocinadorNomActionPerformed(evt);
            }
        });
        getContentPane().add(patrocinadorNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 142, 72, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Nombre patrocinador:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 145, -1, -1));

        presuPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presuPatActionPerformed(evt);
            }
        });
        getContentPane().add(presuPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 187, 72, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 661, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Presupuesto Patrocinador");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 190, -1, -1));

        bandaNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bandaNomActionPerformed(evt);
            }
        });
        getContentPane().add(bandaNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 394, 72, -1));

        cantidadFans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadFansActionPerformed(evt);
            }
        });
        getContentPane().add(cantidadFans, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 434, 72, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad de fans:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 437, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Banda");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 333, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Costo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 510, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre de la banda:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 397, -1, -1));

        Banda.setText("Agregar Banda");
        Banda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BandaActionPerformed(evt);
            }
        });
        getContentPane().add(Banda, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 547, -1, -1));

        Escenario.setText("Agregar Escenario");
        Escenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscenarioActionPerformed(evt);
            }
        });
        getContentPane().add(Escenario, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 237, -1, -1));

        listaBandas.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        listaBandas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaBandas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 403, 432, 200));

        listaEscenarios.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        listaEscenarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaEscenarios);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 97, 427, 200));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel13.setText("Lista Bandas");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel14.setText("Lista Escenarios");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));
        getContentPane().add(bandaCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 507, 72, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cantidad de canciones");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 473, -1, -1));
        getContentPane().add(cantidadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 467, 75, -1));

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 547, -1, -1));

        listaReporte.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        listaReporte.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaReporte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 258, 299, 171));

        Reporte.setText("Generar Reporte de Costos de Festival");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });
        getContentPane().add(Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 204, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 611, -1, -1));

        DineroG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DineroG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DineroG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroGActionPerformed(evt);
            }
        });
        getContentPane().add(DineroG, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 493, 168, 49));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Costo total del festival");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Concert.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escenarioNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escenarioNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escenarioNumActionPerformed

    private void patrocinadorNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patrocinadorNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patrocinadorNomActionPerformed

    private void presuPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presuPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presuPatActionPerformed

    private void bandaNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bandaNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bandaNomActionPerformed

    private void cantidadFansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadFansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadFansActionPerformed

    private void BandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BandaActionPerformed
        if ( !bandaNom.getText().isEmpty() && !cantidadFans.getText().isEmpty() && !cantidadC.getText().isEmpty() && !bandaCosto.getText().isEmpty()){
            int n = Integer.parseInt(cantidadFans.getText());
            int nC = Integer.parseInt(cantidadC.getText());
            String nom = bandaNom.getText();
            float cos = Float.parseFloat(bandaCosto.getText());
            NodoEsc p = ptr;
            NodoBan banda = new NodoBan();
            banda.nombreBanda = nom;
            banda.cantidadC = nC;
            banda.cantidadFans = n;
            banda.costo = cos;
            do{
                if( p== null ){
                    JOptionPane.showMessageDialog(null, "No hay escenarios", "ERROR", 0);
                    break;
                }
                if ( (p.presupuesto - p.costoEs) >= banda.costo ){
                    NodoBan q = p.linkB;
                    NodoBan antq = q;
                    if ( q == null ){
                        p.linkB = banda;
                    }else{
                        while ( (q.cantidadFans > banda.cantidadFans) && (p.contB<10) && (q.linkB != null)){
                            antq = q;
                            q = q.linkB;
                        }
                        if ( (p.contB<10) ){
                            if (q == p.linkB){
                                if( q.cantidadFans < banda.cantidadFans){
                                    banda.linkB = q;
                                    p.linkB = banda;
                                }else{
                                    q.linkB = banda;
                                }
                            }else{
                                banda.linkB = q;
                                antq.linkB = banda;
                            }
                        }else{
                            p = p.linkE;
                        }
                    }
                    p.contB++;
                    p.costoEs += banda.costo;
                    showList(p.linkB);
                    showList(ptr);
                    break;
                }else{
                    p = p.linkE;
                }
            }while(p != null);
            if ( p == null ){
                JOptionPane.showMessageDialog(null,"No fue posible agregar la banda a ningún escenario", "ERROR", 0);
            }
        }else{
            JOptionPane.showMessageDialog (null, "No debe dejar campos en blanco", "ERROR", 0);
        }
        bandaNom.setText("");
        cantidadFans.setText("");
        cantidadC.setText("");
        bandaCosto.setText("");
        
    }//GEN-LAST:event_BandaActionPerformed

    private void EscenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscenarioActionPerformed
        if ( !escenarioNum.getText().isEmpty() && !patrocinadorNom.getText().isEmpty() && !presuPat.getText().isEmpty()){
            int n = Integer.parseInt(escenarioNum.getText());
            String nom = patrocinadorNom.getText();
            float pres = Float.parseFloat(presuPat.getText());
            ptr = AddEscenario (ptr, n, nom, pres);
            showList (ptr);
        }else{
            JOptionPane.showMessageDialog (null, "No debe dejar campos en blanco", "ERROR", 0);
        }
        escenarioNum.setText("");
        patrocinadorNom.setText("");
        presuPat.setText("");
    }//GEN-LAST:event_EscenarioActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        if ( !bandaNom.getText().isEmpty() ){
            if ( !cantidadFans.getText().isEmpty() || !cantidadC.getText().isEmpty() || !bandaCosto.getText().isEmpty() ){
                JOptionPane.showMessageDialog(null, "No es necesario llenar campos además del nombrede la banda");
            }
           
            //String nom = bandaNom.getText();
            NodoEsc p = ptr;
            NodoBan q;
            while ( p != null){
                q = p.linkB;
                int cont = 1;
                while ( !(q.nombreBanda.equals(bandaNom.getText())) && (q.linkB != null)){
                    q = q.linkB;
                    cont++;
                }
                if (q.nombreBanda.equals(bandaNom.getText())){
                    showList (p.linkB);
                    JOptionPane.showMessageDialog(null, "La banda "+bandaNom.getText()+" se encuentra en el escenario: "+p.numeroEscenario+" en la posicion "+cont);
                    break;
                }
                p = p.linkE;
            }
            if ( p == null ){
                JOptionPane.showMessageDialog(null, "No se encontró la banda en ningún escenario", "ERROR", 0);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La casilla de nombre no puede estar en blanco", "ERROR", 0);
        }
        bandaNom.setText("");
        cantidadFans.setText("");
        cantidadC.setText("");
        bandaCosto.setText("");
    }//GEN-LAST:event_BuscarActionPerformed

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        showList_Reporte(ptr);
    }//GEN-LAST:event_ReporteActionPerformed

    private void DineroGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DineroGActionPerformed
        
    }//GEN-LAST:event_DineroGActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Banda;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField DineroG;
    private javax.swing.JButton Escenario;
    private javax.swing.JButton Reporte;
    private javax.swing.JTextField bandaCosto;
    private javax.swing.JTextField bandaNom;
    private javax.swing.JTextField cantidadC;
    private javax.swing.JTextField cantidadFans;
    private javax.swing.JTextField escenarioNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaBandas;
    private javax.swing.JList<String> listaEscenarios;
    private javax.swing.JList<String> listaReporte;
    private javax.swing.JTextField patrocinadorNom;
    private javax.swing.JTextField presuPat;
    // End of variables declaration//GEN-END:variables

}
