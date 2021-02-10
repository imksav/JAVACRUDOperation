package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import database.Database;

public class UpdateKhata {
     // designing the update khata window frame
     public UpdateKhata() {
          JFrame frame = new JFrame("Update Khata");
          frame.setSize(400, 400);
          frame.setLocationRelativeTo(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLayout(new GridLayout(2, 0));
          JPanel insertPanel = new JPanel();
          frame.setLayout(new FlowLayout());
          insertPanel.setLayout(new GridLayout(0, 2));

          JLabel idLabel = new JLabel("Id: ");
          JLabel titleKhataLabel = new JLabel("Title: ");
          JLabel descKhataLabel = new JLabel("Description: ");
          JLabel dateLabel = new JLabel("Date: ");
          JLabel priceLabel = new JLabel("Price: ");
          JLabel remarksLabel = new JLabel("Remarks: ");
          JTextField idField = new JTextField(10);
          JTextField titleKhataField = new JTextField(10);
          JTextField descKhataField = new JTextField(10);
          JTextField dateField = new JTextField(10);
          JTextField priceField = new JTextField(10);
          JTextField remarksField = new JTextField(10);
          JButton loadBtn = new JButton("Load Data");
          JButton updateBtn = new JButton("Update");
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
          insertPanel.add(loadBtn);
          insertPanel.add(updateBtn);
          insertPanel.add(cancelBtn);
          frame.add(insertPanel);
          // load button functionality starts here of Update Khata window frame

          loadBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(loadBtn)) {
                         try {
                              // connection to update the database according to user's selection
                              Database con = new Database();
                              ResultSet rs2 = con.viewKhata(idField.getText());
                              int i = 0;
                              if (rs2.next()) {
                                   String id = rs2.getString(1);
                                   String title = rs2.getString(2);
                                   String description = rs2.getString(3);
                                   String price = rs2.getString(4);
                                   String date = rs2.getString(5);
                                   String remarks = rs2.getString(6);
                                   idField.setVisible(true);
                                   titleKhataField.setVisible(true);
                                   descKhataField.setVisible(true);
                                   priceField.setVisible(true);
                                   dateField.setVisible(true);
                                   remarksField.setVisible(true);
                                   i = 1;
                                   idField.setText(id);
                                   titleKhataField.setText(title);
                                   descKhataField.setText(description);
                                   priceField.setText(price);
                                   dateField.setText(date);
                                   remarksField.setText(remarks);
                              }
                              if (i == 0) {
                                   JOptionPane.showMessageDialog(null, "Sorry, no such Id is found in database. :(");
                              }
                         } catch (Exception e1) {
                         }
                    }
               }
          });
          // update button functionality starts here of Update Khata window frame

          updateBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(updateBtn)) {
                         try {
                              // connection to database to update data
                              Database con = new Database();
                              con.updateKhata(idField.getText(), titleKhataField.getText(), descKhataField.getText(),
                                        priceField.getText(), dateField.getText(), remarksField.getText());
                              JOptionPane.showMessageDialog(null, "Database Updated Successfully.");
                              frame.setVisible(true);
                         } catch (Exception e1) {
                         }
                    }
               }
          });
          // cancel button functionality starts here of Update Khata window frame

          cancelBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(cancelBtn)) {
                         frame.setVisible(false);
                         new HomePage();
                    }
               }
          });
          frame.setResizable(false);
          frame.setVisible(true);

     }
}
