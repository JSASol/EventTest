package com.jsa.sample.eventtest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsa.sample.eventtest.SamplePanel.SampleEvent;
import com.jsa.sample.eventtest.SamplePanel.SampleEventListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

  SampleEventListener sel = new SampleEventListener() {
    @Override public void buttonClicked(SampleEvent e) {
      System.out.println("Button clicked.");
    }
  };
  
  /////////////////////////////////////////////////////////////////////
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainFrame frame = new MainFrame();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public MainFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    SamplePanel panel = new SamplePanel();
    panel.addSampleEventListener(sel);
    
    contentPane.add(panel, BorderLayout.CENTER);
  }

}
