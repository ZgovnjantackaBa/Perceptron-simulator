/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author Aleksa
 */
public class Map {
    
    public static double map(double x, double negativeAxis, double positiveAxis, double from, double to){
        
        double zero = (to - from) / 2.000;
        
        if(x < negativeAxis){
            x = negativeAxis;}
        else if(x > positiveAxis){
            x = positiveAxis;
        }
        
        if(x > 0){
            double scale = x / positiveAxis;
            if(from > to){
                return zero + scale * zero + from;
            }
            return zero + scale * zero;
        }
        else if(x == 0){
            return zero;
        }else{
            double scale = x / negativeAxis;
            if(from > to){
                return zero - scale * zero + from;
            }
            return zero - scale * zero;
        }
    }
    
    public static double scaleMap(double value, double minA, double maxA, double minB, double maxB) {
    return (1 - ((value - minA) / (maxA - minA))) * minB + ((value - minA) / (maxA - minA)) * maxB;
}
    
    
}
