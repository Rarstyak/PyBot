/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.sweat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author BNC
 */
public class SWEATListener extends ListenerAdapter{
    
    public ArrayList<SWEATCharacter> heros = new ArrayList();
    public final String KEY = ";;";
    private boolean ready = false;
    
    public SWEATListener(){
        try {
            load();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SWEATListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ready = true;
    }
    
     /*
    onMessageReceived override
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (!ready || e.getAuthor().isBot() || !e.getChannel().getName().toLowerCase().contains("sweat") ){
            return;
        }
        String eRaw = e.getMessage().getRawContent();
        
        //SWEAT Help
        if (eRaw.equalsIgnoreCase(KEY+"help")) {
            sendToSame(e, 
                    "Hey Steve! Welcome to SWEAT."
                    + "\n{;;} is the key for this bot"
                    + "\n{;;help} bring this message back up... but you already knew that Steve."
                    + "\n..."
                    + "\nWhat? Not Helpful? Fine."
                    + "\n{;;help create}"
                    + "\n{;;help sheet}"
                    + "\n{;;help checks}"
                    + "\n{;;help gm}"
                    + "\n{;;help admin}"
                    + "\n..."
                    + "\nAlso, you need to have fun. Yeah, I know you already know that Steve, no need to fuss."
            );
        }
        
        
        if (eRaw.equalsIgnoreCase(KEY+"help create")) {
            sendToSame(e, 
                    "Character Creation"
                    + "\n{;;new[NAME][CLASS]} creates a new character, if you want you can create multiple characters, just make sure that the names and classes match up or no characters will be created!"
                //  + "\n{;;summon[NAME][CLASS][LEVEL][EXP][S][W][E][A][T][uP][ARMOR][ARMORBONUS][WEAPON][WEAPONDIE]}Keep this one on the low Steve"
                    + "\n{;;delete[NAME]} deletes all the characters with those names"
                    + "\n{;;switch[NAME][STAT1][STAT2]} for a new character at lvl 0, switches the stats, works for multiple"
                    + "\n   1) Any combination of letters that begin with the first letter of the statistic works, including just the first letter..."
                    + "\n{;;trait[NAME][S][W][E][A][T]} for a new character at lvl 0, applies trait modifications of stats, while this works for multiple... it can get very confusing very fast."
                    + "\n   1) Stat increases are capped at 20 and decreases are capped at -10"
                    + "\n   2) The stat change ratio must be +2:-1 or less"
                    + "\n   3) At least one stat must remain unchanged"
                    + "\n   4) This can only be done once at lvl 0, and is permenant"
                    + "\n   e) Yeah, this works for multiple as well"
                    + "\n{;;assign[NAME][S][W][E][A][T]} when you level up, you get some points to spend on increasing you stats... but yeah, it can get confusing to do more than one at a time... the cap? Well, try to aim for 110% of your best?"
                    + "\n{;;new armor[NAME][ARMORNAME][ARMORBONUS]} will change the armor that [NAME] has... guess if this can be extended to multiple assignments... that's right Steve."
                    + "\n{;;new weapon[NAME][WEAPONNAME][ATTACKDIE]} will change the weapon that [NAME] has... Yes, Steve."
            );
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"help sheet")) {
            sendToSame(e, 
                    "Character Sheets"
                    + "\n{;;all} pulls up a list of all the characters"
                    + "\n{;;all sheets} pulls up all of the character sheets"
                    + "\n{;;sheet [NAME]} pulls specified character sheets... you know the drill Steve"
                    + "\n{;;armor [NAME]} pulls specified character armor statments... you know the-"
                    + "\n{;;weapon [NAME]} pulls specified character weapon statements... you know-"
                    + "\n{;;equiped [NAME]} pulls specified character armor and weapon statements... Steve. Stop cutting me off."
            );
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"help checks")) {
            sendToSame(e, 
                    "Character Skill Checks"
                   + "\n{;;check [NAME][STAT]} try to roll under! And- Yes."
                   + "\n{;;mod check [NAME][STAT][STATMOD]} andYouDon'tNeedToRollIfYouGetABonusOfOneHundred... haah. hah... You couldn't cut me off Steve!"
            );
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"help gm")) {
            sendToSame(e, 
                    "GM Commands"
                    + "\n{;;vs [ATTACKER][DEFENDER]}"
                    + "\n{;;change hp [NAME][AMOUNT]}"
                    + "\n{;;full heal [NAME]}"
                    + "\n{;;add exp [NAME][EXP]}"
            );
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"help admin")) {
            sendToSame(e, 
                    "ADMIN Commands"
                    + "\n...ADMINcmd {;;save ;;wipe}"
            );
        }
        
        //======================================================================SET BASED
        
        //NEW , characters [Name]{Class}
        if (eRaw.toLowerCase().startsWith(KEY+"new")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                String result = "";
                for (int i =0;i<param.length;i+=2) {
                    SWEATCharacter temp = new SWEATCharacter(param[i], param[i+1]);
                    boolean alreadyNamedThat = false;
                    if (-1!=getIndex(temp.getCharName())){
                        alreadyNamedThat = true;
                    }
                    if (!alreadyNamedThat) {
                        heros.add(temp);
                        result = result.concat("\n"+temp.getCharName()+" joined the roster!");
                    } else {
                        result = result.concat("\nSome hero already has the name "+temp.getCharName()+"!");
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //SUMMON , characters [Name]{Class}
        if (eRaw.toLowerCase().startsWith(KEY+"summon")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=14 && param.length%14==0) {
                String result = "";
                for (int i =0;i<param.length;i+=14) {
                    SWEATCharacter temp = new SWEATCharacter(
                            param[i], //name
                            param[i+1], //class
                            (byte) Integer.parseInt(param[i+2]), //lvl
                            Integer.parseInt(param[i+3]), //exp
                            (byte) Integer.parseInt(param[i+4]), //s
                            (byte) Integer.parseInt(param[i+5]), //w
                            (byte) Integer.parseInt(param[i+6]), //e
                            (byte) Integer.parseInt(param[i+7]), //a
                            (byte) Integer.parseInt(param[i+8]), //t
                            Integer.parseInt(param[i+9]), //uP
                            param[i+10], //a
                            (byte) Integer.parseInt(param[i+11]), //aBonus
                            param[i+12], //w
                            (byte) Integer.parseInt(param[i+13]));//wDie
                    boolean alreadyNamedThat = false;
                    if (-1!=getIndex(temp.getCharName())){
                        alreadyNamedThat = true;
                    }
                    if (!alreadyNamedThat) {
                        heros.add(temp);
                        result = result.concat("\n"+temp.getCharName()+" has been summoned!");
                    } else {
                        result = result.concat("\nSome hero already has the name "+temp.getCharName()+"!");
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //DELETE , those with the names [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"delete")){
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                Predicate<SWEATCharacter> predicate = (SWEATCharacter ch) -> ch.getCharName().equalsIgnoreCase(p);
                heros.removeIf(predicate);
            }
        }
        
        //SWITCH , initial stats [NAME][STAT][STAT]
        if (eRaw.toLowerCase().startsWith(KEY+"switch")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=3 && param.length%3==0) {
                String result = "";
                for (int i=0;i<param.length;i+=3) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).switchStats(param[i+1].substring(0, 1).toLowerCase(), param[i+2].substring(0, 1).toLowerCase()));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //TRAIT , apply trait modifiers and become lvl 1 [Name][sMod][wMod][eMod][aMod][tMod]
        if (eRaw.toLowerCase().startsWith(KEY+"trait")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=6 && param.length%6==0) {
                String result = "";
                for (int i=0;i<param.length;i+=6) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).applyTraits(Integer.parseInt(param[i+1]), Integer.parseInt(param[i+2]), Integer.parseInt(param[i+3]), Integer.parseInt(param[i+4]), Integer.parseInt(param[i+5])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //ASSIGN , [Name][sMod][wMod][eMod][aMod][tMod]
        if (eRaw.toLowerCase().startsWith(KEY+"assign")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=6 && param.length%6==0) {
                String result = "";
                for (int i=0;i<param.length;i+=6) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).spendPoints(Integer.parseInt(param[i+1]), Integer.parseInt(param[i+2]), Integer.parseInt(param[i+3]), Integer.parseInt(param[i+4]), Integer.parseInt(param[i+5])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //NEW ARMOR , initial stats [NAME][AROMOR][ARMORBONUS]
        if (eRaw.toLowerCase().startsWith(KEY+"new armor")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=3 && param.length%3==0) {
                String result = "";
                for (int i=0;i<param.length;i+=3) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).setArmor(param[i+1], (byte)Integer.parseInt(param[i+2])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //NEW WEAPON , initial stats [NAME][WEAPON][DIE]
        if (eRaw.toLowerCase().startsWith(KEY+"new weapon")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=3 && param.length%3==0) {
                String result = "";
                for (int i=0;i<param.length;i+=3) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).setWeapon(param[i+1], (byte)Integer.parseInt(param[i+2])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //======================================================================GET BASED
        
        //ALL , list of names
        if (eRaw.equalsIgnoreCase(KEY+"all")) {
            String results = "";
            for (SWEATCharacter hero : heros) {
                    results = results.concat("\n"+hero.getCharName());
            }
            sendToSame(e,results.substring(1));
        }
        
        //ALL SHEETS , list of sheets
        if (eRaw.equalsIgnoreCase(KEY+"all sheets")) {
            String results = "";
            for (SWEATCharacter hero : heros) {
                    results = results.concat("\n\n"+hero.getCharacterSheet());
            }
            sendToSame(e,results.substring(2));
        }
        
        //SHEET , get sheets of those with [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"sheet")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equalsIgnoreCase(p)) {
                        results = results.concat("\n\n"+hero.getCharacterSheet());
                    }
                }                             
            }
            sendToSame(e,results.substring(2));
        }
        
        //ARMOR , get armor of those with [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"armor")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equalsIgnoreCase(p)) {
                        results = results.concat("\n"+hero.getArmor());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
        
        //WEAPON , get weapon of those with [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"weapon")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equalsIgnoreCase(p)) {
                        results = results.concat("\n"+hero.getWeapon());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
                
        //EQUIPED , get armor and weapon of those with [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"equiped")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equalsIgnoreCase(p)) {
                        results = results.concat("\n"+hero.getArmor()+"\n"+hero.getWeapon());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
        
        //CHECK , [NAME][STAT]
        if (eRaw.toLowerCase().startsWith(KEY+"check")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                String result = "";
                for (int i=0;i<param.length;i+=2) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).skillCheck(param[i+1].substring(0, 1).toLowerCase()));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //MOD CHECK , [NAME][STAT][MOD]
        if (eRaw.toLowerCase().startsWith(KEY+"mod check")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=3 && param.length%3==0) {
                String result = "";
                for (int i=0;i<param.length;i+=3) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).skillCheck(param[i+1].substring(0, 1).toLowerCase(),Integer.parseInt(param[i+2])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //======================================================================GET and SET
        
        //VS , initial stats [ATTACKERNAME][DEFENDERNAME]==========================ARUAGGGGG
        if (eRaw.toLowerCase().startsWith(KEY+"vs")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                String result = "";
                for (int i=0;i<param.length;i+=2) {
                    int attackerIndex = getIndex(param[i]);
                    int defenderIndex = getIndex(param[i+1]);
                    if (attackerIndex!=defenderIndex && -1!=attackerIndex && -1!=defenderIndex) {
                        byte a = heros.get(attackerIndex).getA();
                        int d = heros.get(defenderIndex).totalDefense();
                        int roll = SWEATCharacter.pDie();
                        String atkName = heros.get(attackerIndex).getCharName();
                        String defName = heros.get(defenderIndex).getCharName();
                        if ((heros.get(attackerIndex).getA()+roll)>=heros.get(defenderIndex).totalDefense()){
                            int atkroll = heros.get(attackerIndex).rollAttack();
                            heros.get(defenderIndex).changeHP(-atkroll);
                            result = result.concat("\n\n"+atkName+" attacked "+defName+" for "+atkroll+" dmg with "+a+"+"+roll+"="+(a+roll)+" vs "+d+
                                    "\n"+heros.get(defenderIndex).getHP());
                        } else {
                            result = result.concat("\n\n"+atkName+" failed to hurt "+defName+" with "+a+"+"+roll+"="+(a+roll)+" vs "+d);
                        }
                    } else {
                        result = "X"+attackerIndex+" : "+defenderIndex;
                                //"XCombantants not found.";
                    }
                }
                sendToSame(e,result.substring(2));
            }
        }
        
        //CHANGE HP , [NAME][HPCHANGE]
        if (eRaw.toLowerCase().startsWith(KEY+"change hp")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                String result = "";
                for (int i=0;i<param.length;i+=2) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).changeHP(Integer.parseInt(param[i+1])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //FULL HEAL , [NAME]
        if (eRaw.toLowerCase().startsWith(KEY+"full heal")) {
            String[] param = extractFlags(eRaw);
            String result = "";
            for (String p : param) {
                int index = getIndex(p);
                if (-1!=index) {
                    result = result.concat("\n"+heros.get(index).fullHeal());
                }
            }
            sendToSame(e,result.substring(1));
        }
        
        //ADD EXP , [NAME][EXP]
        if (eRaw.toLowerCase().startsWith(KEY+"add exp")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                String result = "";
                for (int i=0;i<param.length;i+=2) {
                    int index = getIndex(param[i]);
                    if (-1!=index) {
                        result = result.concat("\n"+heros.get(index).addExp(Integer.parseInt(param[i+1])));
                    }
                }
                sendToSame(e,result.substring(1));
            }
        }
        
        //======================================================================I/O BASED
        
        if (eRaw.equalsIgnoreCase(KEY+"wipe")) {
            heros.clear();
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"save")) {
            save();
        }
        
        //======================================================================TESTING
        
        //sendToSame(e,Arrays.toString(extractFlags(eRaw)));
        //sendToSame(e, e.getAuthor().getAvatarId());
        //sendToSame(e, e.getAuthor().getAvatarUrl());
    }
    
    public int getIndex(String name) {
        for (int i=0;i<heros.size();i++){
            if (heros.get(i).getCharName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public int countFlags(String str){
        String crop = str;
        int count=0;
        while (true) {
            int index1 = crop.indexOf("[");
            int index2 = crop.indexOf("]",index1);
            if (index1<index2 && index1!=-1 && index2!=-1) {
                crop = crop.substring(index2);
                count++;
            } else {
                return count;
            }
        }
    }
    
    public String[] extractFlags(String str){
        String crop = str;
        int count = countFlags(str);
        String[] result = new String[count];
        for (int i=0;i<count;i++) {
            int index1 = crop.indexOf("[");
            int index2 = crop.indexOf("]",index1);
            if (index1<index2 && index1!=-1 && index2!=-1) {
                result[i] = crop.substring(index1+1,index2);
                crop = crop.substring(index2);
            }
        }
        return result;
    }
    
    public void sendToSame(MessageReceivedEvent e, String msg) {
        e.getChannel().sendMessage(msg).queue();
    }
    
    public void save(){
        ObjectOutputStream out = null;
        try {
            File temp = File.createTempFile("findpath", ".tmp");
            out = new ObjectOutputStream( new FileOutputStream(
                    temp.getAbsolutePath().substring(0, temp.getAbsolutePath().lastIndexOf(File.separator))+"heros.al")
            );  
            out.writeObject(heros);
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SWEATListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(SWEATListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void load() throws IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        try {
            File temp = File.createTempFile("findpath", ".tmp");
            in = new ObjectInputStream(new FileInputStream(
                    temp.getAbsolutePath().substring(0, temp.getAbsolutePath().lastIndexOf(File.separator))+"heros.al")
            );
            heros = (ArrayList<SWEATCharacter>)in.readObject();
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SWEATListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(SWEATListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
