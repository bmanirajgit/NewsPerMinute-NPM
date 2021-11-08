package host.heroku.bot;

import host.heroku.bot.commands.Ping;
import host.heroku.bot.commands.Help;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static String Prefix = "tt ";
    public static void main(String[] args){

        DiscordApi Bot = new DiscordApiBuilder()
                .setToken(System.getenv().get("TOKEN"))
                .login().join();

        Bot.addListener(new Ping());

        System.out.println("We are hosted");

        Bot.addListener(new Help());
    }


}
