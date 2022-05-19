package com.discordbot;

import com.discordbot.listener.ListenerInterface;
import com.discordbot.utils.InterfaceImpls;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static JDA jda;

    public static void main(String[] args) {
        String token="OTY2MzQyNjkyMTYwMjg2ODAw.YmAWww.X4gafcNrXN7qNmlyzhcgBwpH1g8";
        try {
            jda=JDABuilder.createLight(token)
                    .setActivity(Activity.playing("Type /ping"))
                    .build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);//设置在线状态

            //设置指令slash command
            List<Class> slashCommandsClasses= InterfaceImpls.getSubclasses(ListenerInterface.class);
            for(Class<?> cl:slashCommandsClasses){
                ListenerInterface ins=(ListenerInterface)cl.getConstructor().newInstance();
                jda.addEventListener(ins);
                jda.upsertCommand(ins.getName(), "Calculate ping of the bot").queue(); // This can take up to 1 hour to show up in the client
            }

            jda.awaitReady();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}


