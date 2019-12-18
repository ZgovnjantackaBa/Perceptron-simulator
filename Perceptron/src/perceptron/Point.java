/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Aleksa
 */
public class Point {
    
    private float x, y;
    private float inputs[];
    private int label;
    private final float bias;
    
    
    public Point() {
        Random r = new Random();
   
        this.x = r.nextFloat() * 540;
        this.y = r.nextFloat() * 540;
        this.label = calculateLabel(x);
         this.bias = 1.000f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        this.bias = 1.000f;
        this.label = calculateLabel(x);
    
    }
    
    
    
    private int calculateLabel(double x){
        
        if(y < f((float) x)){
            return 1;
        }else
            return -1;
             
             }
public float f(float x){
    return 0.4f * x + 120f;
}
    
    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getLabel() {
        return label;
    }

    public float getBias() {
        return bias;
    }

    
}


