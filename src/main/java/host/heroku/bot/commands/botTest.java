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

    long id;
    @Override
    public void onMessageCreate(MessageCreateEvent check) {

        long id2;
        if (check.getMessageContent().equalsIgnoreCase(Main.Prefix + "check")) {

            new MessageBuilder ()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM Reaction Test")
                            .setDescription("React with one :thumbsup: in initial comomand to begin")
                            .setColor(Color.BLUE))
                    .send(check.getChannel());
                    id = check.getMessageId();


            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("NPM React Test")
                            .setDescription("id1 is " +  Long.toString(id))
                            .setColor(Color.BLUE))
                    .send(check.getChannel())
                    .thenAccept(message -> message.getReactions().size());





        }



        //this code bricks the entire bot
        // List<Reaction> yuh = check.getMessage().getReactions(); is used to get list of reactions
        //here we check if the reaction list is = 1 for testing purposes
        //runs until "someone" reacts to it
        /*
        while(check.getMessage().getReactions().size() != 1) {

            if (check.getMessage().getReactions().size() == 1) {
                //set equal to num of players we want

                List<Reaction> yuh = check.getMessage().getReactions();
                for (Reaction reaction : yuh){
                    //for loop that I haven't imiplemented yet
                }
                //this shows -1 for some reason when I ran it
                int value = yuh.indexOf(":thumbsup:");

                //this actually worked, but -1 was index and it broke the bot
                new MessageBuilder()
                        .setEmbed(new EmbedBuilder()
                                .setTitle("Who reacted")
                                .setDescription("at index " + value)
                                .setColor(Color.BLUE))
                        .send(check.getChannel());

            }



        }

        */
        //check.getMessage().get;



        //List<Reaction> List = new ArrayList<Reaction>();
        //having trouble getting reaction s


    }


}
