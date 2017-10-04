/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.math;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author Brian Chau
 */
public class MathListener extends ListenerAdapter{
    
    public ArrayList<SetOfDoubles> sets = new ArrayList();
    public final String KEY = "::";
    private boolean ready = false;
    
    public MathListener(){
        try {
            load();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MathListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ready = true;
    }
    
    
    /*
    onMessageReceived override
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (!ready || e.getAuthor().isBot() || !e.getChannel().getName().toLowerCase().contains("") ){
            return;
        }
        String eRaw = e.getMessage().getRawContent();
        
        //NEW , characters [Name]{doubles...}
        if (eRaw.toLowerCase().startsWith(KEY+"new")) {
            String[] param = extractFlags(eRaw);
            if (param.length>=2) {
                String result = "";
                Double[] tempArray = new Double[param.length-1];
                for (int i=1;i<param.length;i++) {
                    tempArray[i-1] = Double.parseDouble(param[i]);
                }
                SetOfDoubles temp = new SetOfDoubles(param[0], tempArray);
                
                boolean alreadyNamedThat = false;
                if (-1!=getIndex(temp.getSetName())){
                    alreadyNamedThat = true;
                }
                if (!alreadyNamedThat) {
                    sets.add(temp);
                    result = result.concat("\n"+temp.getSetName()+" has been established!");
                } else {
                    result = result.concat("\nSome set already has the name "+temp.getSetName()+"!");
                }
            sendToSame(e,result.substring(1));
            }
        }
        
    }
        
    
    
    public int getIndex(String name) {
        for (int i=0;i<sets.size();i++){
            if (sets.get(i).getSetName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public void sendToSame(MessageReceivedEvent e, String msg) {
        e.getChannel().sendMessage(msg).queue();
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
    
    public void save(){
        ObjectOutputStream out = null;
        try {
            File temp = File.createTempFile("findpath", ".tmp");
            out = new ObjectOutputStream( new FileOutputStream(
                    temp.getAbsolutePath().substring(0, temp.getAbsolutePath().lastIndexOf(File.separator))+"sets.al")
            );  
            out.writeObject(sets);
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(MathListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(MathListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void load() throws IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        try {
            File temp = File.createTempFile("findpath", ".tmp");
            in = new ObjectInputStream(new FileInputStream(
                    temp.getAbsolutePath().substring(0, temp.getAbsolutePath().lastIndexOf(File.separator))+"sets.al")
            );
            sets = (ArrayList<SetOfDoubles>)in.readObject();
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MathListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MathListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
