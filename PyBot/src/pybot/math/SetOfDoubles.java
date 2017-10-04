/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.math;

import java.io.Serializable;

/**
 *
 * @author Brian Chau
 */
public class SetOfDoubles implements Serializable {
    
    private String setName = "";
    private Double[] set;
    
    public SetOfDoubles(String setName){
        this.setName = setName;
    }
    
    public SetOfDoubles(String setName, Double[] set){
        this.setName = setName;
        this.set = set;
    }
    
    
    
    
    
    public String getSetName(){
        return setName;
    }
    
}
