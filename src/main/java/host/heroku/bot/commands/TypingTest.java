package host.heroku.bot.commands;

import java.util.*;
import host.heroku.bot.commands.;
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

import java.awt.*;
import java.util.concurrent.CompletableFuture;


public class TypingTest implements MessageCreateListener {
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
            new MessageBuilder()
                    .append("Go! Retype this paragraph: \n")
                    .setEmbed(new EmbedBuilder()
                            .setDescription(statictest)
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
                    double accuracy = CalculateStats.calculateAccuracy(input2, statictest);
                    double wpm = CalculateStats.calculateWPM(staticLength, time);
                    String errors = CalculateStats.showErrors(statictest, input2);
                    new MessageBuilder()
                            .append("You sent: \n")
                            .append(input2 + "\n")
                            .setEmbed(new EmbedBuilder()
                                    .setDescription("The time you took was: " + time + " seconds\n" +
                                            "Your raw WPM score is: " + wpm + " words per minute.\n" +
                                            "Your paragraph was " + accuracy + "% accurate")
                                    .setColor(Color.green))

                            .send(input.getChannel());
                    new MessageBuilder()
                            .append("Errors: \n" + errors)
                            .send(input.getChannel());
                }
            });
        }
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
}
