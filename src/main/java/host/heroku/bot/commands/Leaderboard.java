package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.util.*;
import java.awt.Color;


public class Leaderboard implements MessageCreateListener {
    //get name and int
    HashMap<String, Integer> scores = new HashMap<>();

    public void putMap(String name, Integer score){

        scores.put(name, score);
    }

    @Override
    public void onMessageCreate(MessageCreateEvent top) {



        if (top.getMessageContent().equalsIgnoreCase(Main.Prefix + "top")){

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM Help Page")
                            .setDescription("\n **npm help:** to open the help page" +
                                    "\n **npm info:** for information about the system " +
                                    "\n **npm test:** to run a typing test" +
                                    "\n **npm challenge:** receive a personal challenge")
                            .setColor(Color.BLUE))
                    .send(top.getChannel());        }
    }
}
