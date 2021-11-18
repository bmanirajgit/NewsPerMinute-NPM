package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;


public class Help implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent helpMenu) {
        if (helpMenu.getMessageContent().equalsIgnoreCase(Main.Prefix + "help")){

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM Help Page")
                            .setDescription("\n **npm help:** to open the help page" +
                                    "\n **npm info:** for information about the system " +
                                    "\n **npm test:** to run a typing test" +
                                    "\n **npm dare:** receive a personal challenge" +
                                    "\n **npm ping:** Get an article to read" +
                                    "\n **npm top:**  shows the leaderboard")
                            .setColor(Color.BLUE))
                    .send(helpMenu.getChannel());        }
    }
}
