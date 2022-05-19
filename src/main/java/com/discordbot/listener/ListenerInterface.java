package com.discordbot.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface ListenerInterface {
    public String getName();
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event);
}
