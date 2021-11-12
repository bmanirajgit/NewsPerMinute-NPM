package host.heroku.bot;

import host.heroku.bot.commands.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    //prefix
    public static String Prefix = "npm ";
    public static void main(String[] args){

        //makes out top secret token an environment variable....shhhh
        DiscordApi Bot = new DiscordApiBuilder()
                .setToken(System.getenv().get("TOKEN"))
                .login().join();

        //class listeners
        Bot.addListener(new Ping());
        Bot.addListener(new Help());
        Bot.addListener(new Info());
        Bot.addListener(new Race());
        Bot.addListener(new TextToGraphics());



        System.out.println("We are hosted");


    }


}
