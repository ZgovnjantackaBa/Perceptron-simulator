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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 *
 * @author Aleksa
 */
public class Perceptron {
    
    private float weights[];
    private float learnRate;
    private static final float APROVED_LEARN_TATE = 0.0000001f;
    private static final float APROVED_NUM_OF_LEARNING_POINTS = 2000;

    public Perceptron(int n, float learnRate) {
        this.learnRate = learnRate;
    
        Random r = new Random();
        
        weights = new float[n];
        
        for(int i = 0; i < n; i++){
            weights[i] = r.nextFloat() * 2 - 1;
        }
        
    }
    
    public int guess(float[] inputs){
        
        float summ = 0;
        
        for(int i = 0; i < weights.length; i++){
            
            summ += weights[i] * inputs[i];
        }
        
        if(summ >= 0)
            return 1;
        
        else 
            return -1;
    }
    
    public void train(float[] inputs, int label){
        
        int guess = guess(inputs);
        int error = label - guess;

        for(int i = 0; i < weights.length; i++)
            weights[i] += error * inputs[i] * learnRate;
        
        
        
    }

    public float[] getWeights() {
        return weights;
    }
    

    
}
