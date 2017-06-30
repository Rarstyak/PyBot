/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot;
import pybot.Meyer.MeyerListener;
import pybot.sweat.SWEATListener;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 *
 * @author BNC
 */
public class PyBot {

    public static JDA jda;
    
    public static final String BOT_TOKEN = "MzE4ODg5MjYxNDgxMDY2NTA2.DA5JHQ.tYjFz_YPRipDmM2LuRCuoGeolBc";
    
    public static void main(String[] args) {
        
        try{
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(BOT_TOKEN)
                    .buildBlocking();
            //jda.addEventListener(new BotListener());
            jda.addEventListener(new MeyerListener());
            jda.addEventListener(new SWEATListener());
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }
    }
    
}
