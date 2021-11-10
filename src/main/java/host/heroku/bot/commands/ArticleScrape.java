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
import java.awt.*;
public class ArticleScrape {
    private String article;
    private String link;
    private String articleText;
    public ArticleScrape() {
        this.article = "";
        this.link = "":
        this.articleText = "";
    }
    public String getText(String link){
        /* This is just here to obtain all of the text from the article
         * using whatever scraping library, doesn't get the excerpt yet */
        /*should add another function for scrapper*/
        return "getText";
    }
    public String getArticle(){
        String url1 = "https://apnews.com/";
        String url2 = "https://www.nbcnews.com/?icid=nav_bar_logo";
        System.out.println("This is hell");
        try {
        Document document = Jsoup.connect(url1).get();
        Elements allLinks = document.select("a[href]");
          
        for(Element link: allLinks) {
                
                String absoluteUrl = link.attr("abs:href");
                
                
                System.out.println("Absolute URL: " + absoluteUrl);
        }
            
         } catch (IOException e) {
            e.printStackTrace();
        }
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
