package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
public class botTest implements MessageCreateListener {


    @Override
    public void onMessageCreate(MessageCreateEvent check) {
        if (check.getMessageContent().equalsIgnoreCase(Main.Prefix + "check")) {

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM commands list")
                            .setDescription("\n 'npm help' to open the help page" + "\n 'npm info' for information about the system "
                                    + "\n 'npm run' to run the typing game")
                            .setColor(Color.BLUE))
                    .send(check.getChannel());
        }
    }

}
