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
public class Excerpt {
    private ArticleScrape rawArticle;
    private String excerpt;
    private int wordCount;

    public String getExcerpt(ArticleScrape article){
        /*
        Loop that goes through the paragraphs from the parsed article and
        finds an excerpt that is 30-40 words long, chooses it, and separates it
        from the rest of the article by storing it as a String
         */
        return "getExcerpt";
    }
    public void setExcerpt(String s){
        this.excerpt = s;
    }
    public int getWordCount() {
        /* literally just return the word count of the excerpt */
        this.wordCount = 0;
        return this.wordCount;
    }
}
