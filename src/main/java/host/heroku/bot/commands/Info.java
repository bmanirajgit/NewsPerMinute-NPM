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
        if(info.getMessageContent().equalsIgnoreCase("npm info")) {
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setDescription("This is bot meant for both fun & learning, " +
                                    "as it will help with both your typing skills and allow you to keep up with current events. " +
                                    "If you wish to know about all of the commands please use the 'npm help' command.")
                            .setColor(Color.BLUE))
                    .send(info.getChannel());
        }
    }
}
