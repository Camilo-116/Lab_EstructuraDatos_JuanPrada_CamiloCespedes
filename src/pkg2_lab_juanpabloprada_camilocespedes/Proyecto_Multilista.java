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
            model.addElement(p.nombreBanda+" | "+p.cantidadC+" | "+p.cantidadFans+" | "+p.costo);
            p = p.linkB;
        }
    }
     void showList_Reporte(NodoEsc ptr){
        DefaultListModel model = (DefaultListModel) listaReporte.getModel();
        model.clear();
        NodoEsc p = ptr;
        model.addElement("#Escenario | Costo generado");
        while(p != null){
            
            model.addElement(p.numeroEscenario+"              | "+p.costoEs);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Festival");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Escenario");

        jLabel4.setText("Numero del escenario:");

        escenarioNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escenarioNumActionPerformed(evt);
            }
        });

        patrocinadorNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patrocinadorNomActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre patrocinador:");

        presuPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presuPatActionPerformed(evt);
            }
        });

        jLabel7.setText("Presupuesto Patrocinador");

        bandaNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bandaNomActionPerformed(evt);
            }
        });

        cantidadFans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadFansActionPerformed(evt);
            }
        });

        jLabel8.setText("Cantidad de fans:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setText("Banda");

        jLabel10.setText("Costo:");

        jLabel11.setText("Nombre de la banda:");

        Banda.setText("Agregar Banda");
        Banda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BandaActionPerformed(evt);
            }
        });

        Escenario.setText("Agregar Escenario");
        Escenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscenarioActionPerformed(evt);
            }
        });

        listaBandas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaBandas);

        listaEscenarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaEscenarios);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Lista Bandas");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Lista Escenarios");

        jLabel15.setText("Cantidad de canciones");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        listaReporte.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaReporte);

        Reporte.setText("Generar Reporte de Costos de Festival");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        DineroG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DineroG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DineroG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DineroGActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Costo total del festival");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(bandaCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(cantidadFans, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(bandaNom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(presuPat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(patrocinadorNom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(escenarioNum, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(Escenario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadC, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Banda)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(Buscar)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Reporte)
                                        .addGap(30, 30, 30))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(DineroG, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel16)))
                        .addContainerGap(27, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(escenarioNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(patrocinadorNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(presuPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(Escenario)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel9)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(bandaNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cantidadFans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidadC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(bandaCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Banda)
                            .addComponent(Buscar))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(212, 212, 212)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(Reporte)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DineroG, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(50, 50, 50)))))
                .addComponent(jLabel6)
                .addContainerGap())
        );

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
