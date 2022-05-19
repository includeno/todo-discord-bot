package com.discordbot.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingListener extends ListenerAdapter implements ListenerInterface{
    public static final String name="ping";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event)
    {
        System.out.println(this.getName()+"command:"+event.getName());
        switch (event.getName()){
            case name:
                long time = System.currentTimeMillis();
                event.reply("Pong!").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat("Pong: %d ms", System.currentTimeMillis() - time) // then edit original
                        ).queue(); // Queue both reply and edit
                break;
            default:
                return;
        }
    }
}
