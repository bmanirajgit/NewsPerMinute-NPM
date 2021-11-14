package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.util.Random;

import java.awt.*;


public class PChallenge implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent challenge) {

        //list Daily of challenges
        String a = "Type at 50 wpm!";
        String b = "Type at 60 wpm!";
        String c = "Type at 70 wpm!";
        String d = "Type at 80 wpm!";
        String e = "Type at 90 wpm!";
        String f = "Type at 100 wpm!";
        String h = "Type at 60% acc!";
        String j = "Type at 70% acc!";
        String k = "Type at 80% acc!";
        String l = "Type at 90% acc!";
        String m = "Type at 100% acc!";
        String o = "Type with your eyes closed :laughing:";
        String p = "Type with one hand :laughing:";
        String q = "Type with non-dominant hand :laughing:";
        String s = "Try to beat your PR (wpm)";
        String t = "Try to beat your PR (acc)";
        String u = "The avg. typing speed is 41 wpm, try and beat it!";
        String v = "The fastest recorded typing speed is 212 wpm by Stella Pajunas in 1946....I believe in you :)";
        String w = "Practice practice practice! Play at least 3 practice tests today!";
        String x = "The average typist has a 92% acc, try and beat it";

        String [] tips = {a, b, c, d, e, f, h, j, k, l, m, o, p, q, s, t, u, v, w, x};
        Random rand = new Random();
        int randomNum = rand.nextInt((20));
        if (challenge.getMessageContent().equalsIgnoreCase(Main.Prefix + "challenge")){

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("Challenge!")
                            .setDescription(tips[randomNum])
                            .setColor(Color.BLUE))
                    .send(challenge.getChannel());        }
    }
}
