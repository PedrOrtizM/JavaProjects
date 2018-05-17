

package simulpro.vista.ventanas;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Observable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import simulpro.controlador.ActionAnimationListener;
import simulpro.controlador.SliderChangeListener;
import simulpro.modelo.logica.Animation;
import simulpro.modelo.logica.ControlModel;
import simulpro.modelo.logica.StateAnimation;
import simulpro.vista.componentes.beans.LabelThread;
import simulpro.vista.componentes.beans.Notifier;
import simulpro.vista.componentes.excel.CreateSheetExcel;
import simulpro.vista.dialogos.DialogChart;
import simulpro.vista.dialogos.DialogProbability;

/**
 *
 * @author Ariel Arnedo
 */
public class VentanaPrincipal extends RootFrame implements java.util.Observer{

    private final ControlModel CONTROL = ControlModel.getControlModel();
   
    
    public VentanaPrincipal() {
        super("SimulPro");
        CONTROL.setAnimation(new Animation());
        initNotifier();
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    private void initNotifier(){
        Notifier.getNotificador().añadirObsevador(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNort = new javax.swing.JPanel();
        buttonPlayAnimation = createButtonMenu();
        buttonStopAnimation = createButtonMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelCronometer = CONTROL.getAnimation().getLabelThread();
        buttonChart = createButtonMenu();
        buttonExcel = createButtonMenu();
        buttonProbability = createButtonMenu();
        panelCenter = new javax.swing.JPanel();
        panelSouth = new javax.swing.JPanel();
        labelProductosComprados = new javax.swing.JLabel();
        sliderSpeeds = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelNort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        buttonPlayAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulpro/vista/iconos/003-play-button.png"))); // NOI18N
        buttonPlayAnimation.setActionCommand("play");
        buttonPlayAnimation.addActionListener(new ActionAnimationListener());

        buttonStopAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulpro/vista/iconos/001-stop.png"))); // NOI18N
        buttonStopAnimation.setActionCommand("stop");
        buttonStopAnimation.setEnabled(false);
        buttonStopAnimation.addActionListener(new ActionAnimationListener());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulpro/vista/iconos/003-graphic.png"))); // NOI18N
        buttonChart.setEnabled(false);
        buttonChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChartActionPerformed(evt);
            }
        });

        buttonExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulpro/vista/iconos/002-excel.png"))); // NOI18N
        buttonExcel.setEnabled(false);
        buttonExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcelActionPerformed(evt);
            }
        });

        buttonProbability.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulpro/vista/iconos/probability-512-1.png"))); // NOI18N
        buttonProbability.setEnabled(false);
        buttonProbability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProbabilityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNortLayout = new javax.swing.GroupLayout(panelNort);
        panelNort.setLayout(panelNortLayout);
        panelNortLayout.setHorizontalGroup(
            panelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNortLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPlayAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStopAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonChart, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCronometer, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNortLayout.setVerticalGroup(
            panelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNortLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCronometer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(buttonStopAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPlayAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(buttonChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(panelNort, java.awt.BorderLayout.PAGE_START);

        panelCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        panelCenter.setLayout(new java.awt.BorderLayout());
        panelCenter.add(CONTROL.getAnimation().getPanelAnimation(),BorderLayout.CENTER);
        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        labelProductosComprados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CONTROL.getAnimation().setLabelProductosComprados(labelProductosComprados);

        sliderSpeeds.setMajorTickSpacing(1);
        sliderSpeeds.setMinimum(1);
        sliderSpeeds.setSnapToTicks(true);
        sliderSpeeds.setToolTipText("");
        sliderSpeeds.setValue(0);
        sliderSpeeds.addChangeListener(new SliderChangeListener());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acelerar Simulación");

        javax.swing.GroupLayout panelSouthLayout = new javax.swing.GroupLayout(panelSouth);
        panelSouth.setLayout(panelSouthLayout);
        panelSouthLayout.setHorizontalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSouthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProductosComprados, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addGroup(panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sliderSpeeds, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSouthLayout.setVerticalGroup(
            panelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSouthLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderSpeeds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelProductosComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelSouth, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChartActionPerformed
        DialogChart dialogChart = new DialogChart(this);
    }//GEN-LAST:event_buttonChartActionPerformed

    private void buttonProbabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProbabilityActionPerformed
        DialogProbability dialogProbability = new DialogProbability(this);
    }//GEN-LAST:event_buttonProbabilityActionPerformed

    private void buttonExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcelActionPerformed
        Runnable run;
        run = () -> {
            javax.swing.JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Formato Excel", "xls"));
            if(fileChooser.showSaveDialog(VentanaPrincipal.this) == javax.swing.JFileChooser.APPROVE_OPTION){
                System.out.println(new File(fileChooser.getCurrentDirectory(), fileChooser.getName(fileChooser.getSelectedFile()))+".xml");
                try{
                    CreateSheetExcel.createExcel(new File(fileChooser.getCurrentDirectory(), fileChooser.getName(fileChooser.getSelectedFile())+".xls"));
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Formato XML Generado");
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,ex.getMessage());
                }
            }
        };
        new Thread(run).start();
    }//GEN-LAST:event_buttonExcelActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Integer ){
            if(((Integer)(arg)).intValue() == 1){
                enableButttons(true);
                JOptionPane.showMessageDialog(rootPane, "Tiempo de la corrida finalizado","Tiempo finalizado",JOptionPane.INFORMATION_MESSAGE);
            }else if(((Integer)(arg)).intValue() == 2){
                enableButttons(false);
            }
            
        }
    }

    private void enableButtons(){
        buttonPlayAnimation.setEnabled(false);
        buttonExcel.setEnabled(false);
        buttonProbability.setEnabled(true);
        buttonChart.setEnabled(true);
        buttonStopAnimation.setEnabled(true);
    }
    
    private void enableButttons(boolean enable){
        buttonPlayAnimation.setEnabled(enable);
        buttonExcel.setEnabled(enable);
        buttonProbability.setEnabled(enable);
        buttonChart.setEnabled(enable);
        buttonStopAnimation.setEnabled(!enable);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChart;
    private javax.swing.JButton buttonExcel;
    private javax.swing.JButton buttonPlayAnimation;
    private javax.swing.JButton buttonProbability;
    private javax.swing.JButton buttonStopAnimation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCronometer;
    private javax.swing.JLabel labelProductosComprados;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelNort;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JSlider sliderSpeeds;
    // End of variables declaration//GEN-END:variables
}
