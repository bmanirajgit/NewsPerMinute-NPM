package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;


public class Ping implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message){

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "Ping")){
            ArticleScrape scrap = new ArticleScrape();
            while (scrap.getText() == "placeholder"){
                scrap.readyArticle();
                message.getChannel().sendMessage(scrap.getTitle());
                message.getChannel().sendMessage(scrap.getLink());
                message.getChannel().sendMessage("Pong Hello4");
                message.getChannel().sendMessage(scrap.getText());
            }
           scrap = new ArticleScrape();
          
        }
    }
}
