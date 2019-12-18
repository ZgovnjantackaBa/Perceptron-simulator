/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Aleksa
 */
public class Train extends javax.swing.JPanel {
    
    private Perceptron brain;
    private Point[] points;
    private boolean initOrSimulate = false;
    private int count = 0;
   
    
    public Train() {
        initComponents();
        
          brain = new Perceptron(3, (float)0.0000001);
    points = new Point[2000];
    
    for(int i = 0; i < points.length; i++){
        points[i] = new Point();
    }

       ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        repaint();            }
        };
    Timer timer = new Timer(1 ,taskPerformer);
    timer.setRepeats(true);
    timer.start();
    }
    
    
    
    @Override
    public void paint(Graphics gg){
    
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(1.5f));
        g.drawLine(0, (int)f(0f), 540, (int)f(540f));

        
    //    g.setStroke(new BasicStroke(3.00f));
        g.setColor(Color.ORANGE);
        // linija simulator po x osi radi
        g.drawLine((int)sim(0), 0, (int)sim(540), 540);
        
             //   Radi obucavanje - sve od jednoom
        
        if(!initOrSimulate){
            
            
            for(int i = 0; i < count; i++){
                float[] inputs = {points[i].getX(), points[i].getY(), points[i].getBias()};
            int label = points[i].getLabel();
            int calculated = brain.guess(inputs);
            
            if(calculated != label){
                g.setColor(Color.red);
                g.fillOval((int)inputs[0], (int)inputs[1], 8, 8);
            }
            else{
                if(inputs[1] > (inputs[0])){
                 g.setColor(Color.GREEN);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }else{
                     g.setColor(Color.BLUE);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }
                }
            }
            count++;
            if(count == points.length){
                count = 0;
            }
        }
   
        else{
          /*  for(int i = 0; i < count; i++){
                
                float[] inputs = {points[i].getX(), points[i].getY(), 1.000f};
            int label = points[i].getLabel();
            brain.train(inputs, label);
            int calculated = brain.guess(inputs);
            
            if(calculated != label){
                g.setColor(Color.red);
                g.fillOval((int)inputs[0], (int)inputs[1], 8, 8);
            }
            else{
                if(inputs[1] > f(inputs[0])){
                 g.setColor(Color.GREEN);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }else{
                     g.setColor(Color.BLUE);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }
                }
            }
            count++;
            if(count == points.length){
                count = 0;
            }*/
            
  for(int i = 0; i < points.length; i++){
            float[] inputs = {points[i].getX(), points[i].getY(), 1.000f};
            int label = points[i].getLabel();
            brain.train(inputs, label);
          
            
            if(brain.guess(inputs) != label){
                g.setColor(Color.red);
                g.fillOval((int)inputs[0], (int)inputs[1], 8, 8);
            }
            else{
                if(inputs[1] > f(inputs[0])){
                 g.setColor(Color.GREEN);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }else{
                     g.setColor(Color.BLUE);
                g.fillOval((int)inputs[0], (int)inputs[1], 4, 4);
                }
                
                }
    }           
            
            
}
    }

    public float f(float x){
    return 0.4f * x + 120f;
}
    public float sim(float x){
        float[] w = brain.getWeights();
        float m = w[1] / w[0];
        float b = w[2] / w[0];
        
        return  -m * x - b;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
        if(!initOrSimulate){
            initOrSimulate = true;
        }
        
        repaint();
    }//GEN-LAST:event_formMouseClicked

public static void main(String args[]){
      JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Perceptron");
            f.setResizable(false);
            f.setPreferredSize(new Dimension(540, 540));
            Train t = new Train();
            f.add(t, BorderLayout.CENTER);

            t.repaint();
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
/**/