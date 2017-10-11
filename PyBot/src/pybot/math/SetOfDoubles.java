/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.math;

import java.io.Serializable;
import static java.lang.Math.*;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Brian Chau
 */
public class SetOfDoubles implements Serializable {
    
    private String setName = "";
    private Double[] set;
    
    private int length;
    private Double min, max, range, sum, average, variance, standardDeviation;
    
    public SetOfDoubles(String setName){
        this.setName = setName;
    }
    
    public SetOfDoubles(String setName, Double[] set){
        this.setName = setName;
        this.set = set;
    }
    
    public String addDoubles(Double[] add){
        this.set = ArrayUtils.addAll(set, add);
        return "Doubles added to "+setName+"\n";
    }
    
    public String refresh(){
        min = Double.MAX_VALUE;
        max = Double.MIN_VALUE;
        length = set.length;
        
        Double s = 0.0;
        for (Double d:set) {
            s+=d;
            if (d<min) {
                min = d;
            }
            if (d>max) {
                max = d;
            }
        } 
        sum = s;
        range = max - min;
        average = sum/length;
        
        Double var = 0.0;
        for (Double d:set) {
            var = (d-average)*(d-average);
        } 
        var /= (length-1);
        variance = var;
        
        standardDeviation = sqrt(variance);
        
        return setName+" has been refreshed!";
    }
    
    public String getSetName(){
        return setName;
    }
    
}
