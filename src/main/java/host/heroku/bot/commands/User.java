package host.heroku.bot.commands;

import java.util.*;
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
public class NPMUser {
    private String id;
    private Challenge challenge;
    private double averageWPM;
    private double averageAccuracy;
    private ArrayList<String> newsFeed;

    public String getID(){
        return this.id;
    }

    public String getChallenge(){
        return this.challenge.getExcerpt(); //?????
    }

    public void setChallenge(Challenge c){
        this.challenge = c;
    }

    public double getAvgWPM(){
        return this.averageWPM;
    }

    public void setAvgWPM(double avg){
        this.averageWPM = avg;
    }

    public double getAvgAcc(){
        return this.averageAccuracy;
    }

    public void setAvgAcc(double acc){
        this.averageAccuracy = acc;
    }

    public void addNewsFeed(ArticleScrape article){

        this.newsFeed.add(article.getLink()); //idk
    }

    public void removeNewsFeed(ArticleScrape article){

        this.newsFeed.remove(article.getLink()); //idk
    }

    public void viewProfile(){

    }
}
