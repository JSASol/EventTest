package com.jsa.sample.eventtest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.EventListenerList;

@SuppressWarnings("serial")
public class SamplePanel extends JPanel implements ActionListener {

  // UI
  JButton btnPush;
  
  // Event
  EventListenerList lstEvents = new EventListenerList();
  SampleEvent evt = new SampleEvent();
  
  ///////////////////////////////////////////////////////////////
  /**
   * Create the panel.
   */
  public SamplePanel() {
    
    btnPush = new JButton("Push");
    add(btnPush);
    btnPush.addActionListener(this);
  }

  @Override public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(btnPush)){
      for (SampleEventListener listener : lstEvents.getListeners(SampleEventListener.class)) {
        listener.buttonClicked(evt);
      }
    }
  }
  
  ////////////////////////////////////////////////////////////////////////////
  // Events
  public void addSampleEventListener(SampleEventListener listener){
    lstEvents.add(SampleEventListener.class, listener);
  }
 
  public interface SampleEventListener extends EventListener{
    public void buttonClicked(SampleEvent e);
  }
 
  public class SampleEvent {

  }

}
