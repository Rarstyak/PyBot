/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author BNC
 */
public class BotListener extends ListenerAdapter{
    
    /*
    onMessageReceived override
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        
        arrayResponse(e, new String[][] {
            {"Py!", "hi pybot", "bye pybot"},
            {"1 py", "one py", "uno py", "ei py", "moay py"},
            {"2 py", "two py", "duo py", "er py", "bei py"},
            {"...py?", "..."},
{"Primary Guard : [Day;High]","Tag"},
{"Primary Guard : [Ox]","Ochs"},
{"Primary Guard : [Plow]","Pflug"},
{"Primary Guard : [Fool]","Olber"},

{"Secondary Guard : [Change]","Wechsel"},
{"Secondary Guard : [Side Guard]","Nebenhut"},
{"Secondary Guard : [Crossed Guard]","Schrankhut"},
{"Secondary Guard : [Iron Door]","Eisenport"},
{"Secondary Guard : [Middle Guard]","Mittelhut"},
{"Secondary Guard : [Key]","Schlüßel"},
{"Secondary Guard : [Long Point]","Langnort"},
{"Secondary Guard : [Speaking Window]","ßprechfenster"},
{"Secondary Guard : [Hanging Point]","Hangetort"},
{"Secondary Guard : [Wrath Guard]","Zornhut"},
{"Secondary Guard : [Crown]","Kron"},
{"Secondary Guard : [One Horn; Unicorn]","Einhorn"},

{"Basic Cut : [Over Cut]","Oberhauw"},
{"Basic Cut : [Middle Cut]","Mittelhauw"},
{"Basic Cut : [Under Cut]","Underhauw"},
{"Primary(Master) Cut : [Wrath Cut]","Zornhauw"},
{"Primary(Master) Cut : [Crooked Cut]","Krumphauw"},
{"Primary(Master) Cut : [Thwert Cut]","Zwerchhauw"},
{"Primary(Master) Cut : [Squinting Cut]","Schielhauw"},
{"Primary(Master) Cut : [Scalp Cut]","Scheidelhauw"},
{"Secondary Cut : [Short Cut]","Kurtzhauw"},
{"Secondary Cut : [Clashing Cut]","Glützhauw"},
{"Secondary Cut : [Rebound Cut]","Prellhauw"},
{"Secondary Cut : [Winding Cut]","Windthauw"},
{"Secondary Cut : [Blind Cut]","Blendthauw"},
{"Secondary Cut : [Wing Cut]","Pflugelhauw"},
{"Secondary Cut : [Change Cut]","Wechselhauw"},
{"Secondary Cut : [Plunge Cut]","Sturtzhauw"},
{"Secondary Cut : [Wrist Cut]","Kniechelhauw"},
{"Secondary Cut : [Crown Cut]","Kronhauw"},
{"Secondary Cut : [Flick/Tag Hit]","Schneller/Zeckrur"},

{"Parts : [Approch]","Zufechten"},
{"Parts : [War]","Krieg"},
{"Parts : [Withdraw]","Abzug"},

{"Times : [Before]","Vor"},
{"Times : [After]","Nach"},
{"Times : [Simultaneously]","Gleich"},
{"Times : [Instantaneous]","Indeß"},

{"Handworks : [Parrying]","Versetzen"},
{"Handworks : [Handwork]","Handtarbeit"},
{"Handworks : [Binding/Remaining/Feeling]","Anbinden/Bleiben/Fülen"},
{"Handworks : [Chasing]","Nachreisen"},
{"Handworks : [Slicing]","Schneiden"},
{"Handworks : [Striking Around]","Umbschlagen"},
{"Handworks : [Running Off]","Ablauffen"},
{"Handworks : [Deceiving]","Verführen"},
{"Handworks : [Flitting]","Verfliegen"},
{"Handworks : [Setting Off]","Absetzen"},
{"Handworks : [Slinging]","Schlaudern"},
{"Handworks : [Pulling]","Zucken"},

{"Handworks : [Doubling]","Doplieren"},
{"Handworks : [Reversing]","Verkehren"},
{"Handworks : [Snapping Around]","Umbschnappen"},
{"Handworks : [Failing]","Fehlen"},
{"Handworks : [Circle]","Zirckel"},
{"Handworks : [Looping]","Rinde"},
{"Handworks : [Winding]","Winden"},
{"Handworks : [Winding Through]","Durchwinden"},
{"Handworks : [Changing]","Wechslen"},
{"Handworks : [Slicing Off]","Abschneiden"},
{"Handworks : [Pressing Hands]","Hendtrucken"},
{"Handworks : [Sliding]","Verschieben"},
{"Handworks : [Hanging]","Hengen"},
{"Handworks : [Wrenching]","Absreißen"},
{"Handworks : [Barring]","Sperren"},
{"Handworks : [Blocking]","Verstüllen"},
{"Handworks : [Over Gripping]","Übergreiffen"},
{"Handworks : [Running In]","Einlauffen"}
        });
        
        if (e.getMessage().getRawContent().contains("py")) {
            e.getChannel().sendMessage("!").queue();
        }
                
    }
    
    /*
    With exact ignore case content input send author mention and output
    */
    public void simpleResponse(MessageReceivedEvent e, String input, String output) {
        if (e.getMessage().getRawContent().equalsIgnoreCase(input)) {
            e.getChannel().sendMessage(e.getAuthor().getAsMention() + " " + output).queue();
        }
    }
    
    /*
    Array of with any exact ignore case content input after first item return first item as author mention and first item output
    */
    public void arrayResponse(MessageReceivedEvent e, String[][] array) {
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++) {
                if (e.getMessage().getRawContent().equalsIgnoreCase(array[i][j])) {
                    e.getChannel().sendMessage(e.getAuthor().getAsMention() + " " + array[i][0]).queue();
                }
            }
        }
    }
    
    
}
