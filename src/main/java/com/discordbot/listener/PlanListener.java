package com.discordbot.listener;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PlanListener extends ListenerAdapter implements ListenerInterface{
    public final String name="plan";

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
                //获取消息发送者
                User user = event.getInteraction().getUser();
                System.out.println(user.getName());
                event.reply("Plan success!").setEphemeral(false) // reply or acknowledge
                        .flatMap(v ->
                                event.getHook().editOriginalFormat("Plan: %d ms", System.currentTimeMillis() - time) // then edit original
                        ).queue(); // Queue both reply and edit
                break;
            default:
                return;
        }
    }
}