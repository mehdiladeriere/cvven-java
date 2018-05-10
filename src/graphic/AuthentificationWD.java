/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import dao.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author p-lao
 */
public class AuthentificationWD extends javax.swing.JFrame {
    
    private ArrayList <JTextField> jTextField = new ArrayList <JTextField> ();
    private ArrayList <JPasswordField> jPasswordField = new ArrayList <JPasswordField> ();

    /**
     * Creates new form Authentification
     */
    public AuthentificationWD() {
        
        initComponents();
        
        listComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    // Init Component
    
    public void listComponents() {
        
        jTextField.add(jTextFieldNomUtilisateur);
        
        jPasswordField.add(jPasswordFieldMdp);
    }
    
    // Check Component content
    
    public boolean checkJTextField() {
        
        for ( JTextField field : this.jTextField ) {
            if ( field.getText().length() == 0 )
                return false;
        }
            
        return true;
    }
    
    public boolean checkJPasswordField() {
        
        for ( JPasswordField field : this.jPasswordField ) {
            if ( field.getText().length() == 0 )
                return false;
        }
            
        return true;
    }
    
    // Check Form
    
    public boolean checkForm() {
        
        return checkJTextField() && checkJPasswordField();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNomUtilisateur = new javax.swing.JLabel();
        jLabelMdp = new javax.swing.JLabel();
        jTextFieldNomUtilisateur = new javax.swing.JTextField();
        jPasswordFieldMdp = new javax.swing.JPasswordField();
        jButtonConnexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("CVVEN");

        jLabelNomUtilisateur.setText("Nom d'utilisateur");

        jLabelMdp.setText("Mot de passe");

        jButtonConnexion.setText("Se connecter");
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomUtilisateur)
                            .addComponent(jLabelMdp))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordFieldMdp, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomUtilisateur)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButtonConnexion)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomUtilisateur)
                    .addComponent(jTextFieldNomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMdp))
                .addGap(18, 18, 18)
                .addComponent(jButtonConnexion)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed
        
        JOptionPane d = new JOptionPane();
        
        if ( this.checkForm() ) {
            
            boolean isAuthenticate = new UtilisateurDAO().authenticate( this.jTextFieldNomUtilisateur.getText() , this.jPasswordFieldMdp.getText() );
            
            if ( isAuthenticate ) {
                
                this.setVisible( false );
        
                new AccueilWD().setVisible( true );
        
            } else {
                
                d.showMessageDialog(this, "Nom d'utilisateur ou mot de passe incorrect", "Message", JOptionPane.WARNING_MESSAGE);
            }
        
        } else {
            
            d.showMessageDialog(this, "Veuillez saisir un nom d'utilisateur et un mot de passe", "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConnexionActionPerformed

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
            java.util.logging.Logger.getLogger(AuthentificationWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthentificationWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthentificationWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthentificationWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthentificationWD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMdp;
    private javax.swing.JLabel jLabelNomUtilisateur;
    private javax.swing.JPasswordField jPasswordFieldMdp;
    private javax.swing.JTextField jTextFieldNomUtilisateur;
    // End of variables declaration//GEN-END:variables
}
