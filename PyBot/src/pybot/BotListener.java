/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author BNC
 */
public class BotListener extends ListenerAdapter{
    
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        
        if (e.getMessage().getRawContent().equalsIgnoreCase("ping")) {
            e.getChannel().sendMessage(e.getAuthor().getAsMention() + " Pong!").queue();
        }
        
        simpleResponse(e, "hi", "Py!");
        simpleResponse(e, "bye", "Py!");
        simpleResponse(e, "hi pybot", "Hello to you too!");
        
        simpleResponse(e, "hilt", "Gefess");
        simpleResponse(e, "pommel", "Knopff");
        simpleResponse(e, "grip", "Bindt");
        simpleResponse(e, "cross", "Creutz");
    }
    
    public void simpleResponse(MessageReceivedEvent e, String input, String output) {
        if (e.getMessage().getRawContent().equalsIgnoreCase(input)) {
            e.getChannel().sendMessage(e.getAuthor().getAsMention() + " " + output).queue();
        }
    }
    
}
