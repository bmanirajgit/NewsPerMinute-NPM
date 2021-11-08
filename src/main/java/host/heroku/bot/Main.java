package host.heroku.bot;

import host.heroku.bot.commands.Ping;
import host.heroku.bot.commands.Help;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static String Prefix = "npm ";
    public static void main(String[] args){

        DiscordApi Bot = new DiscordApiBuilder()
                .setToken(System.getenv().get("TOKEN"))
                .login().join();

        Bot.addListener(new Ping());
        Bot.addListener(new Help());
        System.out.println("We are hosted");


    }


}
