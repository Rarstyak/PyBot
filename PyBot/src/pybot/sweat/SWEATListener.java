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
        if (!ready){
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
                    + "\n{;;new[NAME][CLASS]} creates a new character, if you want you can create multiple characters, just make sure that the names and classes match up or no characters will be created!"
                    + "\n{;;delete[NAME]} deletes all the characters with those names"
                    + "\n{;;switch[NAME][STAT1][STAT2]} for a new character at lvl 0, switches the stats, works for multiple"
                    + "\n   1) Any combination of letters that begin with the first letter of the statistic works, including just the first letter..."
                    + "\n{;;trait[NAME][S][W][E][A][T]} for a new character at lvl 0, applies trait modifications of stats"
                    + "\n   1) Stat increases are capped at 20 and decreases are capped at -10"
                    + "\n   2) The stat change ratio must be +2:-1 or less"
                    + "\n   3) At least one stat must remain unchanged"
                    + "\n   4) This can only be done once at lvl 0, and is permenant"
                    + "\n   e) Yeah, this works for multiple as well"
                    + "\n..."
                    + "\n{;;all} pulls up a list of all the characters"
                    + "\n{;;all sheets} pulls up all of the character sheets"
                    + "\n{;;sheet [NAME]} pulls specified character sheets... you know the drill Steve"
                    + "\n{;;armor [NAME]} pulls specified character armor statments... you know the drill Steve"
                    + "\n{;;weapon [NAME]} pulls specified character weapon statements... you know the drill Steve"
                    + "\n{;;equiped [NAME]} pulls specified character armor and weapon statements... you know the drill Steve"
                    + "\n..."
                    + "\n...ADMINcmd {;;save ;;wipe}"
                    + "\n..."
                    + "\nAlso, you need to have fun. Yeah, I know you already know that Steve, no need to fuss.");
        }
        
        //======================================================================CREATE BASED
        
        //NEW , characters [Name]{Class}
        if (eRaw.startsWith(KEY+"new")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2 && param.length%2==0) {
                for (int i =0;i<param.length;i+=2) {
                    SWEATCharacter temp = new SWEATCharacter(param[i], param[i+1]);
                    boolean alreadyNamedThat = false;
                    for (SWEATCharacter hero : heros) {
                        if(hero.getCharName().equals(temp.getCharName())) {
                            alreadyNamedThat = true;
                        }
                    }
                    if (!alreadyNamedThat) {
                        heros.add(temp);
                        sendToSame(e,temp.getCharName()+" joined the roster!");
                    } else {
                        sendToSame(e,"Some hero already has the name "+temp.getCharName()+"!");
                    }
                }
            }
        }
        
        //DELETE , those with the names [NAME]
        if (eRaw.startsWith(KEY+"delete")){
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                Predicate<SWEATCharacter> predicate = (SWEATCharacter ch) -> ch.getCharName().equals(p);
                heros.removeIf(predicate);
            }
        }
        
        //SWITCH , initial stats [NAME][STAT][STAT]
        if (eRaw.startsWith(KEY+"switch")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=3 && param.length%3==0) {
                for (int i=0;i<param.length;i+=3) {
                    for (int j=0;j<heros.size();j++){
                        if(heros.get(j).getCharName().equals(param[i])) {
                            sendToSame(e,heros.get(j).switchStats(param[i+1].substring(0, 1).toLowerCase(), param[i+2].substring(0, 1).toLowerCase()));
                        }
                    }                                
                }
            }
        }
        
        //TRAIT , apply trait modifiers and become lvl 1 [Name][sMod][wMod][eMod][aMod][tMod]
        if (eRaw.startsWith(KEY+"trait")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=6 && param.length%6==0) {
                for (int i=0;i<param.length;i+=6) {
                    for (int j=0;j<heros.size();j++){
                        if(heros.get(j).getCharName().equals(param[i])) {
                            sendToSame(e,heros.get(j).applyTraits(Integer.parseInt(param[i+1]), Integer.parseInt(param[i+2]), Integer.parseInt(param[i+3]), Integer.parseInt(param[i+4]), Integer.parseInt(param[i+5])));
                        }
                    }                                
                }
            }
        }
        
        //======================================================================SHEET BASED
        
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
        if (eRaw.startsWith(KEY+"sheet")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equals(p)) {
                        results = results.concat("\n\n"+hero.getCharacterSheet());
                    }
                }                             
            }
            sendToSame(e,results.substring(2));
        }
        
        //ARMOR , get armor of those with [NAME]
        if (eRaw.startsWith(KEY+"armor")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equals(p)) {
                        results = results.concat("\n"+hero.getArmor());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
        
        //WEAPON , get weapon of those with [NAME]
        if (eRaw.startsWith(KEY+"weapon")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equals(p)) {
                        results = results.concat("\n"+hero.getWeapon());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
        
        
        //EQUIPED , get armor and weapon of those with [NAME]
        if (eRaw.startsWith(KEY+"equiped")){
            String results = "";
            String[] param = extractFlags(eRaw);
            for (String p : param) {
                for (SWEATCharacter hero : heros) {
                    if (hero.getCharName().equals(p)) {
                        results = results.concat("\n"+hero.getArmor()+"\n"+hero.getWeapon());
                    }
                }                             
            }
            sendToSame(e,results.substring(1));
        }
        
        //======================================================================I/O BASED
        
        if (eRaw.equalsIgnoreCase(KEY+"wipe")) {
            heros.clear();
        }
        
        if (eRaw.equalsIgnoreCase(KEY+"save")) {
            save();
        }
        
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
