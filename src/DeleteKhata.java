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

public class DeleteKhata {
     // designing the delete khata window frame
     public DeleteKhata() {
          JFrame frame = new JFrame("Delete Khata");
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
          JLabel idField = new JLabel();
          JLabel titleKhataField = new JLabel();
          JLabel descKhataField = new JLabel();
          JLabel dateField = new JLabel();
          JLabel priceField = new JLabel();
          JLabel remarksField = new JLabel();
          JLabel viewId = new JLabel("ID: ");
          JTextField viewIdField = new JTextField(10);
          insertPanel.add(viewId);
          insertPanel.add(viewIdField);
          JButton loadBtn = new JButton("Load Data");
          JButton deleteBtn = new JButton("Delete");
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
          insertPanel.add(viewId);
          insertPanel.add(viewIdField);
          insertPanel.add(loadBtn);
          insertPanel.add(deleteBtn);
          insertPanel.add(cancelBtn);
          frame.add(insertPanel);
          // load button functionality starts here of Delete Khata window frame
          loadBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(loadBtn)) {
                         try {
                              Database con = new Database();
                              ResultSet rs2 = con.viewKhata(viewIdField.getText());
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
          // delete button functionality starts here of Delete Khata window frame

          deleteBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(deleteBtn)) {
                         try {
                              // connection to database to delete the selected data
                              Database con = new Database();
                              con.deleteKhata(viewIdField.getText());
                              JOptionPane.showMessageDialog(null, "Khata Delete Successfull");
                              idField.setVisible(false);
                              titleKhataField.setVisible(false);
                              descKhataField.setVisible(false);
                              priceField.setVisible(false);
                              dateField.setVisible(false);
                              remarksField.setVisible(false);
                         } catch (Exception e1) {
                         }
                    }
               }
          });
          // cancel button functionality starts here of Delete Khata window frame

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
