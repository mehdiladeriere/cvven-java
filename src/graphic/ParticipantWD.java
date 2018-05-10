/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import pojo.*;
import dao.*;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author p-lao
 */
public class ParticipantWD extends javax.swing.JFrame {
    
    private ArrayList <Evenement> evenements = new EvenementDAO().getAllAvailable();
    
    private ArrayList <JTextField> jTextField = new ArrayList <JTextField> ();
    private ArrayList <JTextArea> jTextArea = new ArrayList <JTextArea> ();
    private ArrayList <JComboBox> jComboBox = new ArrayList <JComboBox> ();
    private ArrayList <JList> jList = new ArrayList <JList> ();
    private ArrayList <JDateChooser> jDateChooser = new ArrayList <JDateChooser> ();

    /**
     * Creates new form Participant
     */
    public ParticipantWD() {
        
        initComponents();
        
        jListEvenement();
        
        listComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    // Init Component
    
    public void listComponents() {
        
        jTextField.add(jTextFieldNom);
        jTextField.add(jTextFieldPrenom);
        jTextField.add(jTextFieldEmail);
        jTextField.add(jTextFieldOrganisation);
        
        jTextArea.add(jTextAreaObservations);
        
        jList.add(jListEvenement);
        
        jDateChooser.add(jDateChooserDate);
    }

    public void jListEvenement() {
        
        DefaultListModel listModel = new DefaultListModel();
        
        for ( Evenement evenement : this.evenements )
            listModel.addElement( evenement.getIntitule() );
        
        this.jListEvenement.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
        this.jListEvenement.setLayoutOrientation( JList.VERTICAL );
        this.jListEvenement.setVisibleRowCount( -1 );
        this.jListEvenement.setModel( listModel );
    }
    
    // Get Component content
    
    public ArrayList <Evenement> getJListEvenement() {
        
        ArrayList <Evenement> list = new ArrayList <Evenement> ();
        
        for ( int indice : this.jListEvenement.getSelectedIndices() )
            list.add( this.evenements.get( indice ) );
        
        return list;
    }
    
    // Check Component content
    
    public boolean checkJTextField() {
        
        for ( JTextField field : this.jTextField ) {
            if ( field.getText().length() == 0 )
                return false;
        }
            
        return true;
    }
    
    public boolean checkJTextArea() {
        
        for ( JTextArea field : this.jTextArea ) {
            if ( field.getText().length() == 0 )
                return false;
        }
        
        return true;
    }
    
    public boolean checkJComboBox() {
        
        for ( JComboBox field : this.jComboBox ) {
            if ( field.getSelectedIndex() == -1 )
                return false;
        }
        
        return true;
    }
    
    public boolean checkJList() {
        
        for ( JList field : this.jList ) {
            if ( field.getSelectedIndices().length == 0 )
                return false;
        }
        
        return true;
    }
    
    public boolean checkJDateChooser() {
        
        for ( JDateChooser field : this.jDateChooser ) {
            if ( field.getDate() == null )
                return false;
        }
        
        return true;
    }
    
    // Check Form
    
    public boolean checkForm() {
        
        return checkJTextField() && checkJTextArea() && checkJComboBox() && checkJList() && checkJDateChooser();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAjouterUnParticipant = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelDateNaiss = new javax.swing.JLabel();
        jLabelOrganisation = new javax.swing.JLabel();
        jLabelObservations = new javax.swing.JLabel();
        jLabelEvenement = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldOrganisation = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservations = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEvenement = new javax.swing.JList<>();
        jButtonAjouter = new javax.swing.JButton();
        jDateChooserDate = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelAjouterUnParticipant.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabelAjouterUnParticipant.setText("Ajouter un participant");

        jLabelNom.setText("Nom");

        jLabelPrenom.setText("Prénom");

        jLabelEmail.setText("Email");

        jLabelDateNaiss.setText("Date de naissance");

        jLabelOrganisation.setText("Organisation");

        jLabelObservations.setText("Observations");

        jLabelEvenement.setText("Evenement");

        jTextAreaObservations.setColumns(20);
        jTextAreaObservations.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservations);

        jListEvenement.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListEvenement);

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jMenu1.setText("Nouveau");

        jMenuItem1.setText("Ajouter un événement");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ajouter un participant");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Ajouter des invités");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Voir");

        jMenuItem4.setText("Consulter les événements");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Action");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Revenir à l'accueil");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Se déconnecter");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAjouterUnParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNom)
                            .addComponent(jLabelPrenom)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelDateNaiss)
                            .addComponent(jLabelOrganisation)
                            .addComponent(jLabelObservations)
                            .addComponent(jLabelEvenement))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jButtonAjouter)
                            .addComponent(jTextFieldOrganisation)
                            .addComponent(jTextFieldPrenom)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldNom)
                            .addComponent(jScrollPane2)
                            .addComponent(jDateChooserDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelAjouterUnParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPrenom)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDateNaiss)
                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrganisation)
                    .addComponent(jTextFieldOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObservations)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEvenement)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButtonAjouter)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Submit
    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        
        JOptionPane d = new JOptionPane();
        
        if ( this.checkForm() ) {
            
            Participant participant = new Participant();
            participant.setNom( this.jTextFieldNom.getText() );
            participant.setPrenom( this.jTextFieldPrenom.getText() );
            participant.setEmail( this.jTextFieldEmail.getText() );
            participant.setDateNaiss( this.jDateChooserDate.getDate() );
            participant.setOrganisation( this.jTextFieldOrganisation.getText() );
            participant.setObservations( this.jTextAreaObservations.getText() );
            
            boolean isParticipant = new ParticipantDAO().isParticipant( participant );
            
            if ( isParticipant ) {
            
                d.showMessageDialog(this, "Ce participant existe déjà", "Message", JOptionPane.WARNING_MESSAGE);
                
            } else {
                
                new ParticipantDAO().create( participant );
                
                for ( Evenement evenement : this.getJListEvenement() )
                    new InvitationDAO().create( new Invitation( evenement, new ParticipantDAO().findByEmail( participant.getEmail() ) ) );
            
                d.showMessageDialog(this, "Votre participant a bien été ajouté !", "Message", JOptionPane.INFORMATION_MESSAGE);
                
                this.setVisible( false );

                new AccueilWD().setVisible( true );
            }
        
        } else {
            
            d.showMessageDialog(this, "Veuillez vérifier les informations", "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        this.setVisible( false );

        new EvenementWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        this.setVisible( false );

        new ParticipantWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        this.setVisible( false );

        new InvitationWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        this.setVisible( false );

        new ViewEvenementWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        this.setVisible( false );

        new AccueilWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        this.setVisible( false );

        new AuthentificationWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

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
            java.util.logging.Logger.getLogger(ParticipantWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipantWD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private com.toedter.calendar.JDateChooser jDateChooserDate;
    private javax.swing.JLabel jLabelAjouterUnParticipant;
    private javax.swing.JLabel jLabelDateNaiss;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEvenement;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelObservations;
    private javax.swing.JLabel jLabelOrganisation;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JList<String> jListEvenement;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaObservations;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldOrganisation;
    private javax.swing.JTextField jTextFieldPrenom;
    // End of variables declaration//GEN-END:variables
}
