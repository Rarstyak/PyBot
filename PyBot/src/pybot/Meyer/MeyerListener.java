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
    
    public final String KEY = "py ";
    
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String eRaw = e.getMessage().getRawContent();
        
        //py Help
        if (eRaw.equalsIgnoreCase(KEY+"help")) {
            sendToSame(e, 
                    "PY! This bot knows some longsword terms! "
                    + "\n{py} is the key for this bot."
                    + "\n{py TERM} will get you the names and descriptions of a term."
                    + "\n{py search INQUIRY} will get you a list of terms containing the inquiry."
                    + "\n{py tags list} will get you a list tags."
                    + "\n{py tags INQUIRY} will get you a list of terms with the tag."
                    + "\nDisclaimer: This bot is only as accurate as the author's knowledge"
                    + "\nPybot enjoys the consumption of blueberrypy.");
        }
        
        //py specific term
        for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
            if (eRaw.equalsIgnoreCase("py " + term.name())) {
                sendToSame(e, term.NameGerAndNameEngAndDesc());
            }
        }
        
        //py search terms
        if (eRaw.startsWith(KEY+"search ")) {
            String results = "";
            String inquiry = eRaw.substring(10);
            for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
                if (term.name().toLowerCase().contains(inquiry.toLowerCase())) {
                    results = results.concat(",\n" + term.name());
                } else if (term.nameEng().toLowerCase().contains(inquiry.toLowerCase())) {
                    results = results.concat(",\n" + term.name() + " [" + term.nameEng() + "]");
                }
            }
            if (results.length()>2) {
                sendToSame(e, results.substring(2));
            }
        }
        
        //py seach tags
        if (eRaw.startsWith(KEY+"tags ")) {
            String results = "";
            String inquiry = eRaw.substring(8);
            if (inquiry.equalsIgnoreCase("list")) {
                for (MeyerTermTag tag:MeyerTermTag.class.getEnumConstants()) {
                    results = results.concat(",\n" + tag.name());
                }
            } else for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
                for (MeyerTermTag termtag:term.tags()) {
                    if (inquiry.equalsIgnoreCase(termtag.toString())) {
                        results = results.concat(",\n" + term.name());
                    }
                }
            }
            if (results.length()>2) {
                sendToSame(e, results.substring(2));
            }
        }
        
        
    }
    
    public void sendToSame(MessageReceivedEvent e, String msg) {
        e.getChannel().sendMessage(msg).queue();        
    }
    
}