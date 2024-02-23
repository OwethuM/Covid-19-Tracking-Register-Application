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
public class frmUpdate extends javax.swing.JFrame {

    /**
     * Creates new form frmUpdate
     */
    public frmUpdate() {
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
    
    private void mClearVariables() 
    {
     strUserName="";
     strUserSurname="";
     intContact_Number=0;
     intAge=0;
     strAddress="";
     strEmailAddress="";
     intTemperature=0;
     intUserID=0;
    }  
    
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
            String strQuery = "Select UserID,UserName,UserSurname,Contact_Number,Age,Address,EmailAddress,Temperature from event_participants where UserName='"+cboUserName.getSelectedItem().toString()+"'";
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
    private void mUpdateUser()
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
            String strQuery = "Update event_participants SET UserName ='"+strUserName+"',UserSurname='"+strUserSurname+
                    "',Contact_Number='"+intContact_Number+"',Age='"+intAge+"',Address='"+strAddress+"',EmailAddress='"+strEmailAddress+"',Temperature='"+intTemperature+"'WHERE UserID="+intUserID;
            stStatement.executeUpdate(strQuery);
            rs=stStatement.getResultSet();
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
            JOptionPane.showMessageDialog(null,"Connection string not closed" + " "+ e);
        }    
        }    
    } 
    private void mGetValuesFromGUI()
    {
        strUserName=txtName.getText();
        strUserSurname=txtSurname.getText();
        intContact_Number=Integer.parseInt(txtContactNumber.getText());
        intAge=Integer.parseInt(txtAge.getText());
        strAddress=txtAddress.getText();
        strEmailAddress=txtEmailAddress.getText();
        intTemperature=Integer.parseInt(txtTemperature.getText());
        
    }
    private void mSetValuesToUpperCase()
    {
        strUserName=strUserName.toUpperCase();
        strUserSurname=strUserSurname.toUpperCase();
        strAddress=strAddress.toUpperCase();
        strEmailAddress=strEmailAddress.toUpperCase();
    }  
    private void mSetValuesInGUI()
    {
        txtName.setText(strUserName);
        txtSurname.setText(strUserSurname);
       
    }
    private void mClearTextFields()
    {
        txtName.setText("");
        txtSurname.setText("");
    }  
    private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboUserName.setModel(model);
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
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblContactNumber = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblEmailAddress = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        lblTemperature = new javax.swing.JLabel();
        txtTemperature = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUserNameActionPerformed(evt);
            }
        });

        lblName.setText("Name");

        lblSurname.setText("Surname");

        lblContactNumber.setText("Contact Number");

        lblAge.setText("Age");

        lblAddress.setText("Address");

        lblEmailAddress.setText("Email Address");

        lblTemperature.setText("Temperature");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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
                    .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSurname))
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(txtName)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblContactNumber)
                                .addComponent(lblAge)
                                .addComponent(lblAddress)
                                .addComponent(lblEmailAddress)
                                .addComponent(lblTemperature))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtContactNumber)
                                .addComponent(txtAddress)
                                .addComponent(txtEmailAddress)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 100, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(137, 137, 137)
                        .addComponent(btnReturn)))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cboUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactNumber)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmailAddress)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemperature)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnReturn))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        frmCRUD frmCRUD = new frmCRUD();
        frmCRUD.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void cboUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUserNameActionPerformed
        // TODO add your handling code here:
        mReadUserDetails();
        mSetValuesInGUI();
    }//GEN-LAST:event_cboUserNameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        mGetValuesFromGUI();
        mSetValuesToUpperCase();
        mUpdateUser();
        mClearComboBox();
        mClearTextFields();
        mClearVariables();
        mLoadUserName();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboUserName;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTemperature;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTemperature;
    // End of variables declaration//GEN-END:variables
}
