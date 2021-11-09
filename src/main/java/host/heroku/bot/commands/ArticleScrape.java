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

    public String getText(String link){
        /* This is just here to obtain all of the text from the article
         * using whatever scraping library, doesn't get the excerpt yet */
        return "getText";
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
