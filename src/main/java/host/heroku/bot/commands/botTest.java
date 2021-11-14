package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;
import java.awt.Color;
import java.util.*;


public class botTest implements MessageCreateListener {


    @Override
    public void onMessageCreate(MessageCreateEvent check) {
        long id;
        long id2;
        if (check.getMessageContent().equalsIgnoreCase(Main.Prefix + "check")) {

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM React Test")
                            .setDescription("React with three :thumbsup: to begin")
                            .setColor(Color.BLUE))
                    .send(check.getChannel());
                    id = check.getMessageId();


            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM React Test")
                            .setDescription("id1 is " +  Long.toString(id))
                            .setColor(Color.BLUE))
                    .send(check.getChannel());




        }


        List<Reaction> List = new ArrayList<Reaction>();
        //having trouble getting reactions
        //List<Reaction> people = check.getReactions();

    }


}
