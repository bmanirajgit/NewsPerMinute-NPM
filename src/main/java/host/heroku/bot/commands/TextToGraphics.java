package host.heroku.bot.commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TextToGraphics implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent text) {
        if(text.getMessageContent().equalsIgnoreCase("text")) {
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setDescription("This is bot meant for both fun & learning, " +
                                    "as it will help with both your typing skills and allow you to keep up with current events. " +
                                    "If you wish to know about all of the commands please use the 'npm help' command.")
                            .setColor(Color.BLUE))
                    .send(text.getChannel());
        }
    }
}
