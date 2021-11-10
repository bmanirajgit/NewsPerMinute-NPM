package host.heroku.bot.commands;

import host.heroku.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Ping implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent message) {

        if (message.getMessageContent().equalsIgnoreCase(Main.Prefix + "Ping")){
            ArticleScrape scrap = new ArticleScrape();
             try{
                      System.out.println("Processing...");
                }
                 catch (IOException ioe) {
                       System.out.println("Exception!!!");
                        ioe.printStackTrace();
                 }
            message.getChannel().sendMessage("Pong Hello2");
        }
    }
}
