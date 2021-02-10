package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import database.Database;

public class AddKhata {
     Connection con1;
     PreparedStatement insert;

     public AddKhata() {
          // designing add khata window frame
          JFrame frame = new JFrame("Add Khata");
          frame.setSize(800, 500);
          frame.setLocationRelativeTo(null);
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          JPanel insertPanel = new JPanel();
          frame.setLayout(new FlowLayout());
          insertPanel.setLayout(new GridLayout(0, 2));

          JLabel idLabel = new JLabel("Id: ");
          JLabel titleKhataLabel = new JLabel("Title: ");
          JLabel descKhataLabel = new JLabel("Description: ");
          JLabel dateLabel = new JLabel("Date: ");
          JLabel priceLabel = new JLabel("Price: ");
          JLabel remarksLabel = new JLabel("Remarks: ");
          JTextField idField = new JTextField(5);
          JTextField titleKhataField = new JTextField(10);
          JTextField descKhataField = new JTextField(10);
          JTextField dateField = new JTextField(10);
          JTextField priceField = new JTextField(10);
          JTextField remarksField = new JTextField(10);
          JButton saveBtn = new JButton("Save");
          JButton resetBtn = new JButton("Reset");
          JButton cancelBtn = new JButton("Cancel");
          insertPanel.add(idLabel);
          insertPanel.add(idField);
          insertPanel.add(titleKhataLabel);
          insertPanel.add(titleKhataField);
          insertPanel.add(descKhataLabel);
          insertPanel.add(descKhataField);
          insertPanel.add(dateLabel);
          insertPanel.add(dateField);
          insertPanel.add(priceLabel);
          insertPanel.add(priceField);
          insertPanel.add(remarksLabel);
          insertPanel.add(remarksField);
          insertPanel.add(resetBtn);
          insertPanel.add(saveBtn);
          insertPanel.add(cancelBtn);
          frame.add(insertPanel);
          // save button functionality starts here of Add Khata window frame
          saveBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    String id = idField.getText();
                    String title = titleKhataField.getText();
                    String description = descKhataField.getText();
                    String price = priceField.getText();
                    String date = dateField.getText();
                    String remarks = remarksField.getText();
                    if (e.getSource().equals(saveBtn)) {
                         try {
                              // connection to the database for adding khata
                              Database con1 = new Database();
                              con1.addKhata(id, title, description, price, date, remarks);
                              JOptionPane.showMessageDialog(null, "Details successfully inserted", "Inserting",
                                        JOptionPane.INFORMATION_MESSAGE);
                              frame.setVisible(false);
                              new HomePage();
                         } catch (Exception e1) {
                         }
                    }

               }
               // reset button functionality starts here of Add Khata window frame
          });
          resetBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    idField.setText("");
                    titleKhataField.setText("");
                    descKhataField.setText("");
                    dateField.setText("");
                    priceField.setText("");
                    remarksField.setText("");
               }
          });
          // cancel button functionality starts here of Add Khata window frame
          cancelBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    frame.dispose();
                    new HomePage();
               }

          });
          frame.setResizable(false);
          frame.setVisible(true);

     }

}
