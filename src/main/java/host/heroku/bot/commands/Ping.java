package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;


public class Ping implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message){

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "Ping")){
            ArticleScrape scrap = new ArticleScrape();
             message.getChannel().sendMessage(scrap.getLink());
            scrap.readyArticle();
            message.getChannel().sendMessage(scrap.getLink());
            message.getChannel().sendMessage("Pong Hello3");
            message.getChannel().sendMessage(scrap.getArticleText());
            scrap = new ArticleScrape();
            scrap.readyArticle();
        }
    }
}
