package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class Info implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent info) {
        if(info.getMessageContent().equalsIgnoreCase(Main.Prefix + "info")) {
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setDescription("Heyo! This is bot meant for both fun & learning, " +
                                    "as it will help with both your typing skills and allow you to keep up with current events. We give you your typing statistics " +
                                    "as well as a custom **NPM Score**. " +
                                    "If you wish to know about all of the commands please use the 'npm help' command.")
                            .setColor(Color.BLUE))
                    .send(info.getChannel());
        }

        if(info.getMessageContent().equalsIgnoreCase(Main.Prefix + "hello")) {
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setDescription("This wor ks.")
                            .setColor(Color.BLUE))
                    .send(info.getChannel());
        }
    }
}
