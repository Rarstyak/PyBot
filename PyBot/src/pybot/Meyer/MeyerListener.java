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
        /*OVERLOADS LIKE CRAZY
        if (eRaw.equalsIgnoreCase("py meyerterms")) {
            for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
                sendToSame(e, term.name());
            }
        }*/
        
        for (MeyerTerm term:MeyerTerm.class.getEnumConstants()) {
            if (eRaw.equalsIgnoreCase("py " + term.name())) {
                sendToSame(e, term.NameGerAndNameEngAndDesc());
            }
        }
                
        
    }
    
    public void sendToSame(MessageReceivedEvent e, String msg) {
        e.getChannel().sendMessage(msg).queue();        
    }
    
}