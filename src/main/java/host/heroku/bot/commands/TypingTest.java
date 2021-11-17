package host.heroku.bot.commands;

import java.util.*;
import host.heroku.bot.Main;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class TypingTest implements MessageCreateListener {
    //test array
    String[] users = {"bot", "bot", "bot", "bot", "bot"};
    int[] scores = {0, 0, 0, 0, 0};
    //test

    String statictest = "The only people for me are the mad ones, the ones who are mad to live, " +
            "mad to talk, mad to be saved, desirous of everything at the same time, " +
            "the ones who never yawn or say a commonplace thing, but burn, burn, burn " +
            "like fabulous yellow Roman candles exploding like spiders across the stars, " +
            "and in the middle, you see the blue center-light pop, and everybody goes ahh...";
    int staticLength = statictest.length();
    private DiscordApi api;
    public TypingTest(DiscordApi api){
        this.api = api;
    }
    public DiscordApi getTTApi(){
        return this.api;
    }
    @Override
    public void onMessageCreate(MessageCreateEvent test) {
        if (test.getMessageContent().equalsIgnoreCase(Main.Prefix + "test")){
            ArticleScrape scraper = new ArticleScrape();
            String summary = scraper.getText();
            String[] sumBySpace = summary.split(" ");
            int sumLength = sumBySpace.length;
            boolean done = false;
            while (!done){
                test.getChannel().sendMessage("Test started");
                new MessageBuilder()
                    .append("Go! Retype this paragraph: \n")
                    .setEmbed(new EmbedBuilder()
                            .setDescription(summary)
                            .setColor(Color.BLUE))
                    .send(test.getChannel());
                double start = System.currentTimeMillis();
                MessageAuthor ma = test.getMessageAuthor();
                System.out.println(ma);
                DiscordApi testApi = this.getTTApi();
                testApi.addMessageCreateListener(input -> {
                    if (input.getMessageAuthor().equals(ma)) {
                        String input2 = input.getMessageContent();
                        double stop = System.currentTimeMillis();
                    double time = (stop - start) / 1000;
                    double accuracy = CalculateStats.calculateAccuracy(input2, summary);
                    double wpm = CalculateStats.calculateWPM(sumLength, time);
                    double npm = CalculateStats.calculateNPM(sumLength, time, input2, summary);
                    String errors = CalculateStats.showErrors(summary, input2);
                    new MessageBuilder()
                            .append("You sent: \n")
                            .append(input2 + "\n")
                            .setEmbed(new EmbedBuilder()
                                    .setTitle("Results")
                                    .addField("Original Article", scraper.getTitle() +"\n"+ scraper.getLink())
                                    .addField("Time elapsed", time + " seconds")
                                    .addField("WPM Score", String.format("%.2f", wpm) + " words per minute")
                                    .addInlineField("NPM Score", String.format("%f", npm))
                                    .addField("Accuracy", String.format("%.2f", accuracy) + "%")
                                    .setColor(Color.PINK))
                            .send(input.getChannel());
                    new MessageBuilder()
                            .append("Errors: \n" + errors)
                            .send(input.getChannel());

                    npm = CalculateStats.calculateNPM(sumLength, time, input2, summary);
                    putInArr(test.getMessageAuthor().getName() , (int)npm);
           
                }
            }).removeAfter(20, TimeUnit.SECONDS);
            done = true;


          }


        }

        //test method------------------------------------------------------------------------------------------
        if (test.getMessageContent().equalsIgnoreCase(Main.Prefix + "top")) {
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

        /* test input
        putInArr("Bharath", 1);
        putInArr("Jacob", 100);
        */

            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle(":trophy: Leaderboard :trophy:")
                            .setDescription("\n **1. **" + pos0 + ": " + sco0 +
                                    "\n **2.  **" + pos1 + ": " + sco1 +
                                    "\n **3.  **" + pos2 + ": " + sco2 +
                                    "\n **4.  **" + pos3 + ": " + sco3 +
                                    "\n **5.  **" + pos4 + ": " + sco4)
                            .setColor(Color.ORANGE))
                    .send(test.getChannel());
        }
        //test------------------------------------------------------------------------------------------
    }


    private String input = "";
    private double timeElapsed = 0.0;
    private boolean isMuted = false;
    private boolean isFinished = false;
    private String channel = "";

    public void playerInput(){
    }

    public String getInput(){
        return this.input;
    }

    public void setInput(String input){
        this.input = input;
    }

    public double getTimeElapsed(){
        return this.timeElapsed;
    }

    public void setTimeElapsed(float time){
        this.timeElapsed = time;
    }

    public String getChannel(){
        /* Channel the typing test is in */
        return this.channel;
    }

    public void setChannel(String channel){
        this.channel = channel;
    }

    public void startTest(Excerpt excerpt){
        /* Starts the typing test */
    }

    public void printLink(Excerpt excerpt){
        /* Prints out the link of the article (separate command I guess)
          excerpt.rawArticle.getLink();
         */
    }

    public void showStats(String input){
        /* Use CalculateStats */
    }

    public void muteChat(String channel){
        /* Mutes the channel (Deletes messages during a race) */
    }

    public void userFinished() {
        /* idk */
        this.isFinished = true;
    }
    /*
    ##########################################################
    ##########################################################
    ##########################################################
    Leaderboard code below
     */



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
                    break;
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




}
