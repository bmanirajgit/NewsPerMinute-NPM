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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

import java.awt.*;
public class ArticleScrape {
    private String article;
    private String link;
    private String articleText;
    public ArticleScrape() {
        this.article = "placeholder";
        this.link = "placeholder";
        this.articleText = "placeholder";
        System.out.println("This is hell");
    }
    public String getText(String link){
        /* This is just here to obtain all of the text from the article
         * using whatever scraping library, doesn't get the excerpt yet */
        /*should add another function for scrapper*/
        return "getText";
    }
    /* For each article or Scrapper should obtain the following:
     * 1. Title
     * 2. Summary
     * 3. Link to article
     **/
    public void readyArticle() {
        String url1 = "https://apnews.com/";
        String url2 = "https://www.nbcnews.com/?icid=nav_bar_logo";
        String url3 = "https://www.wsj.com/";
        String url4 = "https://www.reuters.com/";
        String url5 = "https://www.bbc.com/";
        int rand = new Random();
        int max = 5;
        int min = 4;
        int random = rand.nextInt((max-min)+1)+ min);
        System.out.println("This is hell");
        try {
        /*This chooses the article based on the random number generated*/
        switch (random){
            case 1: setArticle(url1);
                    break;
            case 2: setArticle(url2);
                    break;
            case 3: setArticle(url3);
                    break;
            case 4: setArticle(url4);
                    break;
            case 5: setArticle(url5);
                    break;
        }
        Document document = Jsoup.connect(getArticle()).get();
        Elements allLinks = document.select("a[href]"); //what does this part do??? DOES THIS GET ALL THE LINKS IN THE LANDING PAGE 
            //IF SO WE COULD LOOK AT THE TIME AND CHOOSE THE MOSt recent one :) THEN we can get set the link, find the summary 
            // set the summary and have our final thingy to present 
            
        for(Element link: allLinks) {
                String absoluteUrl = link.attr("abs:href"); //DOES THIS GET ALL THE LINKS ON THE LANDING PAGE 
                System.out.println("Absolute URL: " + absoluteUrl);
        }
            
         } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public String getArticle(){
        return this.article;
    }

    public void setArticle(String article){
        this.article = article;
    }

    public String getLink(){
        return this.link;
    }

    public void setLink(String link){
        this.link = link;
    }
}
