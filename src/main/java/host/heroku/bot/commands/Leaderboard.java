package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.util.*;
import java.awt.Color;


public class Leaderboard implements MessageCreateListener {

    String[] users = {"bot", "bot", "bot", "bot", "bot"};
    int[] scores = {0, 0, 0, 0, 0};


    public void putInArr(String user, int score) {//insert new score, store old
        int tempInt = 0;
        int tempInt2 = 0;
        String tempStr = "";
        String tempStr2 = "";
        if(score > scores[4]) {
            int i = 0;
            for (i = 0; i < users.length; i++) {
                if (scores[i] >= score) { //score is greter
                    i = i + 1;
                } else { //score is less
                    tempInt = scores[i];
                    tempStr = users[i];
                    scores[i] = score;
                    users[i] = user;
                }
            }
            if (i != users.length - 1) { //shuffles
                while (i < users.length - 2) {
                    tempStr2 = users[i + 1];
                    tempInt2 = scores[i + 1];
                    users[i + 1] = tempStr;
                    scores[i + 1] = tempInt;
                    tempStr = tempStr2;
                    tempInt = tempInt2;
                    i++;
                }
            }
        }



    }

    @Override
    public void onMessageCreate(MessageCreateEvent top) {
        if (top.getMessageContent().equalsIgnoreCase(Main.Prefix + "top")) {
            String pos0 = users[0];
            String pos1 = users[1];
            String pos2 = users[2];
            String pos3 = users[3];
            String pos4 = users[4];

            int sco0 = scores[0];
            int sco1 = scores[1];
            int sco2 = scores[2];
            int sco3 = scores[3];
            int sco4 = scores[4];

            putInArr("Bharath", 1);
            //putInArr("Jacob", 100);

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("Leaderboard")
                            .setDescription("\n **1. **" + pos0 + ": " + sco0 +
                                    "\n **2. **" + pos1 + ": " + sco1 +
                                    "\n **3. **" + pos2 + ": " + sco2 +
                                    "\n **4. **" + pos3 + ": " + sco3 +
                                    "\n **5. **" + pos4 + ": " + sco4)
                            .setColor(Color.ORANGE))
                    .send(top.getChannel());
        }
    }

}

