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
public class CalculateStats {
    private double wpm;
    private double accuracy;
    private String errors;

    public double calculateWPM(int wordCount, double time){
        return 0.0;
    }

    public double calculateAccuracy(String input, String excerpt){

        return 99.34;
    }

    public void showErrors(String excerpt, String input){

        System.out.println("XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
    }
}
