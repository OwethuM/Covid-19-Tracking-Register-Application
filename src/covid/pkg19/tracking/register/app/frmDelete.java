/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19.tracking.register.app;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author HP 250
 */
public class frmDelete extends javax.swing.JFrame {

    /**
     * Creates new form frmDelete
     */
    public frmDelete() {
        initComponents();
        mLoadUserName();
    }
    
    String strUserName;
    String strUserSurname;
    int intContact_Number;
    int intAge;
    String strAddress;
    String strEmailAddress;
    int intTemperature;
    int intUserID;
    String strCovid_Symptons;
    String strExposed_to_anyone_with_covid;
    
    private void mLoadUserName()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tracking_register";
        String strDBUser="root";
        String strDBPassword="Password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery ="Select UserName from event_participants";
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
        while(rs.next()) 
        {
            cboUserName.addItem(rs.getString(1));
        }    
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        } 
        finally
        {
            try
            {
                stStatement.close();
            } 
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed"+" "+ e);
            }    
        }    
    }
     private void mDeleteUser()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tracking_register";
        String strDBUser="root";
        String strDBPassword="Password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            String strQuery = "Delete from event_participants where UserName  ='"+strUserName+"'and UserSurname ='"+strUserSurname+"'and Contact_number='"+intContact_Number+
                    "'and Age='"+intAge+"'and Address ='"+strAddress+"'and EmailAddress ='"+strEmailAddress+"'and Temperature='"+ intTemperature+"'and Covid_Symptons='"+strCovid_Symptons+"'and Exposed_to_anyone_with_covid='"+strExposed_to_anyone_with_covid+"'and UserID ="+intUserID;
            stStatement = conMySQLConnectionString.prepareStatement(strQuery);
            stStatement.execute(strQuery);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
        try
        {
            stStatement.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Connection String not closed"+" "+e);
        }    
        }    
    }
    private void mReadUserDetails()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tracking_register";
        String strDBUser="root";
        String strDBPassword="Password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select UserID,UserName,UserSurname,Contact_Number,Age,Address,EmailAddress,Temperature,Covid_Symptons,Exposed_to_anyone_with_covid from event_participants where UserName='"+cboUserName.getSelectedItem().toString()+"'";
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
        while(rs.next()) 
        {  
            intUserID=rs.getInt(1);
            strUserName=rs.getString(2);
            strUserSurname=rs.getString(3);
            intContact_Number=rs.getInt(4);
            intAge=rs.getInt(5);
            strAddress=rs.getString(6);
            strEmailAddress=rs.getString(7);
            intTemperature=rs.getInt(8);
            strCovid_Symptons=rs.getString(9);
            strExposed_to_anyone_with_covid=rs.getString(10);
        } 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }        
        finally
        {
            try
            {
                stStatement.close();
            }  
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection string not closed" + " "+ e);
            }    
        }    
    } 
     private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboUserName.setModel(model);
    } 
    private void mClearVaribles() 
    {
     strUserName="";
     strUserSurname="";
     intContact_Number=0;
     intAge=0;
     strAddress="";
     strEmailAddress="";
     intTemperature=0;
     strCovid_Symptons="";
     strExposed_to_anyone_with_covid="";
     intUserID=0;
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboUserName = new javax.swing.JComboBox();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(btnReturn))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(btnReturn)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        frmCRUD frmCRUD = new frmCRUD();
        frmCRUD.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        mReadUserDetails();
        mDeleteUser();
        mClearComboBox();
        mClearVaribles();
        mLoadUserName();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(frmDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox cboUserName;
    // End of variables declaration//GEN-END:variables
}
