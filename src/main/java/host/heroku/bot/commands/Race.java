package host.heroku.bot.commands;

import java.io.*;
import host.heroku.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import java.awt.*;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import host.heroku.bot.Main;
        import org.javacord.api.event.message.MessageCreateEvent;
        import org.javacord.api.listener.message.MessageCreateListener;

public class Race implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent race) {

        String statictest = "The only people for me are the mad ones, the ones who are mad to live, " +
                "mad to talk, mad to be saved, desirous of everything at the same time, " +
                "the ones who never yawn or say a commonplace thing, but burn, burn, burn " +
                "like fabulous yellow Roman candles exploding like spiders across the stars, " +
                "and in the middle, you see the blue center-light pop, and everybody goes ahh...";
        int staticlength = statictest.length();

        if (race.getMessageContent().equalsIgnoreCase(Main.Prefix + "Race")){

            new MessageBuilder()
                    //.append("React with a thumbs up to begin, 3 needed for a game!")
                    .setEmbed(new EmbedBuilder()
                            .setDescription("React with a thumbs up to begin, 3 needed for a game!")
                            .setColor(Color.RED))
                    .send(race.getChannel());

            new MessageBuilder()
                    .append("Go! Retype this paragraph: \n")
                    .setEmbed(new EmbedBuilder()
                            .setDescription(statictest)
                            .setColor(Color.GREEN))
                    .send(race.getChannel());




        }


        }
    }

