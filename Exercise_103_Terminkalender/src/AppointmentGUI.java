
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class AppointmentGUI extends javax.swing.JFrame {
    
    private AppointmentModell model = new AppointmentModell();
    /**
     * Creates new form AppointmentGUI
     */
    public AppointmentGUI() {
        initComponents();
        
        this.setSize(400, 250);
        
        listAppointments.setModel(model);
        listAppointments.setComponentPopupMenu(jPopupMenu1);
        
        try{
            model.load();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "An error occured while loading saved entries.", "Error", JOptionPane.OK_OPTION);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();
        miUpdate = new javax.swing.JMenuItem();
        panelForm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAppointments = new javax.swing.JList<>();

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAdd);

        miRemove.setText("remove");
        miRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miRemove);

        miUpdate.setText("update");
        miUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miUpdate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        panelForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Termine"));
        panelForm.setLayout(new java.awt.BorderLayout());

        listAppointments.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAppointments);

        panelForm.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelForm);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        AppointmentDlg dialog = new AppointmentDlg(this, true, new Appointment(LocalDateTime.now(), "Text"));
        dialog.setVisible(true);
        if(dialog.isOk()){
            model.add(dialog.getAppointment());
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveActionPerformed
        model.remove(listAppointments.getSelectedIndex());
    }//GEN-LAST:event_miRemoveActionPerformed

    private void miUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateActionPerformed
        int idx = listAppointments.getSelectedIndex();
        
        AppointmentDlg dialog = new AppointmentDlg(this, true, (Appointment) model.getElementAt(idx));
        dialog.setVisible(true);
        if(dialog.isOk()){
            model.remove(idx);
            model.add(dialog.getAppointment(), idx);
        }
    }//GEN-LAST:event_miUpdateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
            model.save();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "An error occured while saving entries.", "Error", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listAppointments;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JMenuItem miUpdate;
    private javax.swing.JPanel panelForm;
    // End of variables declaration//GEN-END:variables
}
