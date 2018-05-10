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
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author p-lao
 */
public class EvenementWD extends javax.swing.JFrame {
    
    private ArrayList <TypeEvenement> types = new TypeEvenementDAO().findAll();
    private ArrayList <Salle> salles = new ArrayList <Salle> ();

    private ArrayList <JTextField> jTextField = new ArrayList <JTextField> ();
    private ArrayList <JTextArea> jTextArea = new ArrayList <JTextArea> ();
    private ArrayList <JComboBox> jComboBox = new ArrayList <JComboBox> ();
    private ArrayList <JList> jList = new ArrayList <JList> ();
    private ArrayList <JDateChooser> jDateChooser = new ArrayList <JDateChooser> ();
    
    /**
     * Creates new form Evenement
     */
    public EvenementWD() {
        
        initComponents();
        
        jComboBoxDuree();
        jComboBoxPartMax();
        jComboBoxTypeEvenement();
        jComboBoxSalle();
        
        listComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    // Init Components
    
    public void listComponents() {
        
        jTextField.add(jTextFieldIntitule);
        jTextField.add(jTextFieldTheme);
        jTextField.add(jTextFieldOrganisateur);
        
        jTextArea.add(jTextAreaDescription);
        
        jComboBox.add(jComboBoxDuree);
        jComboBox.add(jComboBoxPartMax);
        jComboBox.add(jComboBoxSalle);
        jComboBox.add(jComboBoxTypeEvenement);
        
        jDateChooser.add(jDateChooserDate);
    }
    
    public void jComboBoxDuree() {
        
        this.jComboBoxDuree.removeAllItems();
        
        for ( int i = 1; i <= 24; i++ )
            this.jComboBoxDuree.addItem( i + " H" );
    }
    
    public void jComboBoxPartMax() {
        
        this.jComboBoxPartMax.removeAllItems();
        
        for ( int i = 1; i <= new SalleDAO().getCapaciteMax(); i++ ) 
            this.jComboBoxPartMax.addItem( i + " participants" );
    }
    
    public void jComboBoxTypeEvenement() {
        
        this.jComboBoxTypeEvenement.removeAllItems();
        
        for ( TypeEvenement type : this.types )
            this.jComboBoxTypeEvenement.addItem( type.getNom() );
    }
    
    public void jComboBoxSalle() {
        
        this.jComboBoxSalle.removeAllItems();
        
        for ( Salle salle : this.salles ) 
            this.jComboBoxSalle.addItem( salle.getNom() );
    }
    
    // Get Component content
    
    public int getJComboBoxDuree() {
        
        String[] split = this.jComboBoxDuree.getSelectedItem().toString().split(" ");
            
        return Integer.parseInt( split[0] );
    }
    
    public int getJComboBoxPartMax() {
            
        String[] split = this.jComboBoxPartMax.getSelectedItem().toString().split(" ");
            
        return Integer.parseInt( split[0] );
    }
    
    public TypeEvenement getJComboBoxTypeEvenement() {
        
        if ( this.jComboBoxTypeEvenement.getSelectedIndex() != -1 )
            return this.types.get( this.jComboBoxTypeEvenement.getSelectedIndex() );
        
        return null;
    }
    
    public Salle getJComboBoxSalle() {
        
        if ( this.jComboBoxSalle.getSelectedIndex() != -1 )
            return this.salles.get( this.jComboBoxSalle.getSelectedIndex() );
        
        return null;
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

        jLabel1 = new javax.swing.JLabel();
        jLabelIntitule = new javax.swing.JLabel();
        jLabelTheme = new javax.swing.JLabel();
        jLabelDateArrivee = new javax.swing.JLabel();
        jLabelDuree = new javax.swing.JLabel();
        jLabelPartMax = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jLabelOrganisateur = new javax.swing.JLabel();
        jLabelTypeEvenement = new javax.swing.JLabel();
        jLabelSalle = new javax.swing.JLabel();
        jTextFieldIntitule = new javax.swing.JTextField();
        jTextFieldTheme = new javax.swing.JTextField();
        jComboBoxDuree = new javax.swing.JComboBox<>();
        jComboBoxPartMax = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jTextFieldOrganisateur = new javax.swing.JTextField();
        jComboBoxTypeEvenement = new javax.swing.JComboBox<>();
        jComboBoxSalle = new javax.swing.JComboBox<>();
        jButtonAjouter = new javax.swing.JButton();
        jDateChooserDate = new com.toedter.calendar.JDateChooser();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel1.setText("Ajouter un événement");

        jLabelIntitule.setText("Intitulé");

        jLabelTheme.setText("Thème");

        jLabelDateArrivee.setText("Date d'arrivée");

        jLabelDuree.setText("Durée");

        jLabelPartMax.setText("Participant maximum");

        jLabelDescription.setText("Description");

        jLabelOrganisateur.setText("Organisateur");

        jLabelTypeEvenement.setText("Type d'événement");

        jLabelSalle.setText("Salle");

        jComboBoxDuree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxPartMax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPartMax.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPartMaxItemStateChanged(evt);
            }
        });

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jComboBoxTypeEvenement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxSalle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jMenu5.setText("Nouveau");

        jMenuItem6.setText("Ajouter un événement");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem2.setText("Ajouter un participant");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Ajouter des invités");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar3.add(jMenu5);

        jMenu2.setText("Voir");

        jMenuItem4.setText("Consulter les événements");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar3.add(jMenu2);

        jMenu3.setText("Action");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Revenir à l'accueil");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Se déconnecter");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar3.add(jMenu3);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIntitule)
                            .addComponent(jLabelTheme)
                            .addComponent(jLabelDuree)
                            .addComponent(jLabelPartMax)
                            .addComponent(jLabelDescription)
                            .addComponent(jLabelOrganisateur)
                            .addComponent(jLabelTypeEvenement)
                            .addComponent(jLabelSalle)
                            .addComponent(jLabelDateArrivee))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButtonAjouter))
                            .addComponent(jComboBoxPartMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOrganisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldTheme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jTextFieldIntitule, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIntitule)
                    .addComponent(jTextFieldIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTheme)
                    .addComponent(jTextFieldTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDateArrivee)
                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuree)
                    .addComponent(jComboBoxDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPartMax)
                    .addComponent(jComboBoxPartMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelDescription)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrganisateur)
                    .addComponent(jTextFieldOrganisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTypeEvenement)
                    .addComponent(jComboBoxTypeEvenement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalle)
                    .addComponent(jComboBoxSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButtonAjouter)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // jComboBox on change
    private void jComboBoxPartMaxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPartMaxItemStateChanged
        
        if ( evt.getStateChange() == ItemEvent.SELECTED && this.jDateChooserDate.getDate() != null ) {
        
            this.salles = new SalleDAO().getAllAvailable( this.getJComboBoxPartMax() , this.jDateChooserDate.getDate() );
            
            this.jComboBoxSalle.removeAllItems();
        
            for ( Salle salle : this.salles ) 
                this.jComboBoxSalle.addItem( salle.getNom() );
        }
    }//GEN-LAST:event_jComboBoxPartMaxItemStateChanged

    // Submit
    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        
        JOptionPane d = new JOptionPane();
        
        if ( this.checkForm() ) {
            
            Evenement evenement = new Evenement();
            evenement.setIntitule( this.jTextFieldIntitule.getText() );
            evenement.setTheme( this.jTextFieldTheme.getText() );
            evenement.setDateDebut( this.jDateChooserDate.getDate() );
            evenement.setDuree( this.getJComboBoxDuree() );
            evenement.setNbPartMax( this.getJComboBoxPartMax() );
            evenement.setDescription( this.jTextAreaDescription.getText() );
            evenement.setOrganisateur( this.jTextFieldOrganisateur.getText() );
            evenement.setTypeEvenement( this.getJComboBoxTypeEvenement() );
            evenement.setSalle( this.getJComboBoxSalle() );
            
            new EvenementDAO().create( evenement );
            
            d.showMessageDialog(this, "Votre événement a bien été ajouté !", "Message", JOptionPane.INFORMATION_MESSAGE);
            
            this.setVisible( false );

            new AccueilWD().setVisible( true );
        
        } else {
            
            d.showMessageDialog(this, "Veuillez vérifier les informations", "Message", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    // jDateChooser on change
    private void jDateChooserDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserDatePropertyChange
        
        if ( evt.getPropertyName().equals( "date" ) && this.jComboBoxPartMax.getSelectedIndex() != -1 ) {
            
            this.salles = new SalleDAO().getAllAvailable( this.getJComboBoxPartMax() , this.jDateChooserDate.getDate() );
            
            this.jComboBoxSalle.removeAllItems();
        
            for ( Salle salle : this.salles ) 
                this.jComboBoxSalle.addItem( salle.getNom() );
        }
    }//GEN-LAST:event_jDateChooserDatePropertyChange

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        this.setVisible( false );

        new EvenementWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        this.setVisible( false );

        new AccueilWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        this.setVisible( false );

        new AuthentificationWD().setVisible( true );
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(EvenementWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvenementWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvenementWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvenementWD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EvenementWD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JComboBox<String> jComboBoxDuree;
    private javax.swing.JComboBox<String> jComboBoxPartMax;
    private javax.swing.JComboBox<String> jComboBoxSalle;
    private javax.swing.JComboBox<String> jComboBoxTypeEvenement;
    private com.toedter.calendar.JDateChooser jDateChooserDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDateArrivee;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelDuree;
    private javax.swing.JLabel jLabelIntitule;
    private javax.swing.JLabel jLabelOrganisateur;
    private javax.swing.JLabel jLabelPartMax;
    private javax.swing.JLabel jLabelSalle;
    private javax.swing.JLabel jLabelTheme;
    private javax.swing.JLabel jLabelTypeEvenement;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldIntitule;
    private javax.swing.JTextField jTextFieldOrganisateur;
    private javax.swing.JTextField jTextFieldTheme;
    // End of variables declaration//GEN-END:variables

}
