package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;


public class Ping implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message) throws IOException{

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "Ping")){
            ArticleScrape scrap = new ArticleScrape();
            message.getChannel().sendMessage("Pong Hello2");
        }
    }
}
