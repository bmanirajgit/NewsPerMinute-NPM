package host.heroku.bot.commands;

import java.util.*;
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

public class TypingTest {
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
