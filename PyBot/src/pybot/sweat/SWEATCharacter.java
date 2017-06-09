/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.sweat;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author BNC
 */
public final class SWEATCharacter implements Serializable{
    
    private String charName = "";
    private String charClass = "";
    private byte level = 1;
    private int exp = 0;
    
    private byte sStat, wStat, eStat, aStat, tStat = 0;
    private int unassignedPoints = 0;
    
    private short healthPoints = 0;
    private short maxHealthPoints = (short) (aStat + tStat);//aspect + toughness
    
    private String armorName = "Almost Desperate Prayer";
    private byte armorBonus = 0;
    
    private String weaponName = "Fighting Limb of Terror";
    private byte weaponDie = 1;
    
    public SWEATCharacter(String charName, String charClass) {
        this.charName = charName;
        this.charClass = charClass;
        this.level = 0;
        this.exp = 0;
        
        this.sStat = (byte)nd10(3);
        this.wStat = (byte)nd10(3);
        this.eStat = (byte)nd10(3);
        this.aStat = (byte)nd10(3);
        this.tStat = (byte)nd10(3);
        update();
    }
    
    public String getCharacterSheet() {
        String unConscious = (healthPoints<=0)? " UNCONSCIOUS": "";
        return String.format(
                "%1$s LVL %6$d %2$s"+
                "\n%12$03d / %13$03d HP%5$s"+
                "\nS %7$3d    W %8$3d    E %9$3d    A %10$3d    T %11$3d"+
                "\n%3$s : %14$d Armor"+
                "\n%4$s : %15$d"+"d10"
                ,charName, charClass, armorName, weaponName, unConscious,
                level, sStat, wStat, eStat, aStat,
                tStat, healthPoints, maxHealthPoints, armorBonus, weaponDie);
    }
    
    public String switchStats(String stat1,String stat2){
        byte hold1 = "s".matches(stat1) ? sStat : "w".matches(stat1) ? wStat : "e".matches(stat1) ? eStat : "a".matches(stat1) ? aStat : "t".matches(stat1) ? tStat : 0;
        byte hold2 = "s".matches(stat2) ? sStat : "w".matches(stat2) ? wStat : "e".matches(stat2) ? eStat : "a".matches(stat2) ? aStat : "t".matches(stat2) ? tStat : 0;
        if (level==0 && hold1!=0 && hold2!=0) {
            sStat = "s".matches(stat1) ? hold2 : "s".matches(stat2) ? hold1 : sStat;
            wStat = "w".matches(stat1) ? hold2 : "w".matches(stat2) ? hold1 : wStat;
            eStat = "e".matches(stat1) ? hold2 : "e".matches(stat2) ? hold1 : eStat;
            aStat = "a".matches(stat1) ? hold2 : "a".matches(stat2) ? hold1 : aStat;
            tStat = "t".matches(stat1) ? hold2 : "t".matches(stat2) ? hold1 : tStat;
            update();
            return "Success! "+getCharName()+"'s "+stat1+" is now "+hold2+" and "+stat2+" is now "+hold1+".";
        } else {
            return "Failed to switch "+getCharName()+"'s "+stat1+" and "+stat2+".";
        }
    }
    
    public String applyTraits(int sMod, int wMod, int eMod, int aMod, int tMod) {
        int posMod = ((sMod>0) ? sMod : 0) + ((wMod>0) ? wMod : 0) + ((eMod>0) ? eMod : 0) + ((aMod>0) ? aMod : 0) + ((tMod>0) ? tMod : 0);
        int negMod = ((sMod<0) ? sMod : 0) + ((wMod<0) ? wMod : 0) + ((eMod<0) ? eMod : 0) + ((aMod<0) ? aMod : 0) + ((tMod<0) ? tMod : 0);
        
        if (level==0 && posMod<=20 && negMod>=-10 && posMod<=negMod*-2 && (sMod==0||wMod==0||eMod==0||aMod==0||tMod==0) && (sStat+sMod>0&&wStat+wMod>0&&eStat+eMod>0&&aStat+aMod>0&&tStat+tMod>0)){
        this.sStat += sMod;
        this.wStat += wMod;
        this.eStat += eMod;
        this.aStat += aMod;
        this.tStat += tMod;
        this.level = 1;
        update();
        return getCharName()+" is ready to adventure!";
        } else {
            return "Failed to prepare "+getCharName()+" for adventure.";
        }
        
    }
    
    public void spendPoints(int sMod, int wMod, int eMod, int aMod, int tMod) {
        int posMod = ((sMod>0) ? sMod : 0) + ((wMod>0) ? wMod : 0) + ((eMod>0) ? eMod : 0) + ((aMod>0) ? aMod : 0) + ((tMod>0) ? tMod : 0);
        int negMod = ((sMod<0) ? sMod : 0) + ((wMod<0) ? wMod : 0) + ((eMod<0) ? eMod : 0) + ((aMod<0) ? aMod : 0) + ((tMod<0) ? tMod : 0);
        
        if (level>0 && posMod<=unassignedPoints && negMod==0){
        this.sStat += sMod;
        this.wStat += wMod;
        this.eStat += eMod;
        this.aStat += aMod;
        this.tStat += tMod;
        unassignedPoints -=posMod;
        update();
        }
    }
    
    public String getCharName(){
        return charName;
    }
    
    public String getCharClass(){
        return charClass;
    }
    
    public String setArmor(String armorName, byte armorBonus) {
        String result = charName+" had a "+this.armorName+" with "+this.armorBonus+" armor, and has switched to a ";
        this.armorName = armorName;
        this.armorBonus = armorBonus;
        return result.concat(this.armorName+" with "+this.armorBonus+" armor!");
    }
    
    public String getArmor() {
        return charName+" has a "+this.armorName+" with "+this.armorBonus+" armor.";
    }
    
    public String setWeapon(String weaponName, byte weaponDie) {
        String result = charName+" had a "+this.weaponName+" with "+this.weaponDie+" rolls of attack, and has switched to a ";
        this.weaponName = weaponName;
        this.weaponDie = weaponDie;
        return result.concat(this.weaponName+" with "+this.weaponDie+" rolls of attack!");
    }
    
    public String getWeapon() {
        return charName+" has a "+this.weaponName+" with "+this.weaponDie+" rolls of attack!";
    }
    
    public String skillCheck(String stat){
        byte check = ("s".equals(stat)) ? sStat : ("w".equals(stat)) ? wStat : ("e".equals(stat)) ? eStat : ("a".equals(stat)) ? aStat : ("t".equals(stat)) ? tStat : 0;
        int result = pDie();
        return ((result<check) ? "Success" : "Failure") + "! "+getCharName()+" Rolled "+result+" against "+check;
    }
    
    public String skillCheck(String stat, int abilityMod){
        byte check = ("s".equals(stat)) ? sStat : ("w".equals(stat)) ? wStat : ("e".equals(stat)) ? eStat : ("a".equals(stat)) ? aStat : ("t".equals(stat)) ? tStat : 0;
        int result = pDie();
        return ((result<(check+abilityMod)) ? "Success" : "Failure") + "! "+getCharName()+" Rolled "+result+" against "+check+"+"+abilityMod+"="+(check+abilityMod);
    }
    
    public String addExp(int exp) {
        this.exp += exp;
        String result = charName+" has gained "+exp+" exp!";
        while (canLevelUp()) {
            result = result.concat("\n"+tryLevelUp());
        }
        return result;
    }
    
    public int expForNextLevel() {
        return 1000*2^(level-1);
    }
    
    public int expToNextLevel() {
        return expForNextLevel()-exp;
    }
    
    public boolean canLevelUp() {
        return (level!=0 && (exp>=expForNextLevel()));
    }
    
    public String tryLevelUp(){
        if (level==0){
            return "Please Set Your Character Traits";
        } else if (canLevelUp()) {
            exp -= 1000*2^(level-1);
            level += 1;
            byte roll1 = d10();
            byte roll2 = d10();
            unassignedPoints += 10 + roll1 + roll2;
            return charName+" is now level "+level+" with "+exp+" exp and haw gained 10+"+roll1+"+"+roll2+"="+(10+roll1+roll2)+" points, for a total of "+unassignedPoints+" unassigned points.";
        }
        return "Not Enough EXP For a Level Up";
    }
    
    public void update() {
        maxHealthPoints = (short) (aStat + tStat);
        if (healthPoints>maxHealthPoints){
            fullHeal();
        }
    }
    
    public void fullHeal() {
        healthPoints = maxHealthPoints;
    }
    
    //roll a d10
    public byte d10() {
        return (byte) randInt(1,10);
    }
    
    //sum of n d10s
    public int nd10(int n) {
        int number = 0;
        for (byte i=0; i<n; i++){
            number += d10();
        }
        return number;
    }
    
    //random 1-100
    public int pDie() {
        return randInt(1,100);
    }
    
    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max-min)+1)+min;
    }
    
}
