package com.craftmend.openaudiomc.modules.commands.subcommands;

import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.modules.commands.interfaces.SubCommand;
import com.craftmend.openaudiomc.modules.commands.objects.Argument;
import com.craftmend.openaudiomc.modules.players.objects.Client;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class StateSubCommand extends SubCommand {

    public StateSubCommand() {
        super("state");
        registerArguments(new Argument("", "Obtain and display state information"));
    }

    @Override
    public void onExecute(CommandSender sender, String[] args) {
        message(sender, ChatColor.YELLOW + "State: " + ChatColor.AQUA + OpenAudioMc.getInstance().getStateService().getCurrentState().getClass().getSimpleName());
        message(sender, ChatColor.YELLOW + "State Info: " + ChatColor.AQUA + OpenAudioMc.getInstance().getStateService().getCurrentState().getDescription());

        int clients = 0;
        for (Client client : OpenAudioMc.getInstance().getPlayerModule().getClients()) {
            if (client.isConnected()) clients++;
        }

        message(sender, ChatColor.YELLOW + "Connected Clients: " + ChatColor.AQUA + "" + clients);
        if (OpenAudioMc.getInstance().getRegionModule() == null) {
            message(sender, ChatColor.YELLOW + "Loaded Audio Regions: " + ChatColor.RED + "Feature Disabled");
        } else {
            message(sender, ChatColor.YELLOW + "Loaded Audio Regions: " + ChatColor.AQUA + "" + OpenAudioMc.getInstance().getRegionModule().getRegionPropertiesMap().size());
        }
        message(sender, ChatColor.YELLOW + "Loaded Speakers: " + ChatColor.AQUA + "" + OpenAudioMc.getInstance().getSpeakerModule().getSpeakerMap().size());
        message(sender, ChatColor.YELLOW + "Detected Version: " + ChatColor.AQUA + "" + OpenAudioMc.getInstance().getServerService().getVersion());
        message(sender, ChatColor.YELLOW + "Time Offset: " + ChatColor.AQUA + "" + OpenAudioMc.getInstance().getTimeService().getOffset());
    }
}
