package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePage {
     public HomePage() {

          // designing the homepage window frame
          JFrame frame = new JFrame();
          frame.setTitle("Home Page");
          frame.setSize(500, 500);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLocationRelativeTo(null);
          JPanel homepagePanel = new JPanel();
          homepagePanel.setBackground(Color.LIGHT_GRAY);
          JPanel buttonGroup = new JPanel();
          buttonGroup.setLayout(new BoxLayout(buttonGroup, 1));
          JButton addKhata = new JButton("Add Khata");
          JButton viewKhata = new JButton("View Khata");
          JButton deleteKhata = new JButton("Delete Khata");
          JButton updateKhata = new JButton("Update Khata");

          buttonGroup.add(addKhata);
          buttonGroup.add(viewKhata);
          buttonGroup.add(deleteKhata);
          buttonGroup.add(updateKhata);
          homepagePanel.add(buttonGroup);
          frame.add(homepagePanel);
          // add khata button functionality starts here of homepage window frame
          addKhata.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new AddKhata();
                    frame.dispose();
               }
          });
          // view khata button functionality starts here of homepage window frame
          viewKhata.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new ViewKhata();
                    frame.dispose();
               }
          });
          // delete khata button functionality starts here of homepage window frame
          deleteKhata.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    new DeleteKhata();
                    frame.dispose();
               }

          });
          // update khata button functionality starts here of update of homwpage window
          // frame
          updateKhata.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    new UpdateKhata();
                    frame.dispose();
               }

          });
          frame.setResizable(false);
          frame.setVisible(true);

     }
}
