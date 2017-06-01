/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.Meyer;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author BNC
 */
public class MeyerListener extends ListenerAdapter{
    
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String eRaw = e.getMessage().getRawContent();
        
        //py Help
        if (eRaw.equalsIgnoreCase("py help")) {
            sendToSame(e, 
                    "PY! This bot knows some longsword terms! "
                    + "\n[py] is the key for this bot."
                    + "\n[py TERM] will get you the names and descriptions of a term."
                    + "\n[py search] INQUIRY will get you a list of terms containing the inquiry."
                    + "Pybot enjoys the consumption of blueberrypy.");
        }
        
        //py specific term
        for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
            if (eRaw.equalsIgnoreCase("py " + term.name())) {
                sendToSame(e, term.NameGerAndNameEngAndDesc());
            }
        }
        
        //py search terms
        if (eRaw.startsWith("py search ")) {
            String results = "";
            for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
                if (term.name().toLowerCase().contains(eRaw.substring(10).toLowerCase())) {
                    results = results.concat(", " + term.name());
                }
            }
            sendToSame(e, results.substring(2));
        }
        
        
        
    }
    
    public void sendToSame(MessageReceivedEvent e, String msg) {
        e.getChannel().sendMessage(msg).queue();        
    }
    
}