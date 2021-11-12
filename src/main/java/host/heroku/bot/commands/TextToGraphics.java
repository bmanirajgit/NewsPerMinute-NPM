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

    public void onMessageCreate(MessageCreateEvent txtGraph) {

        if(txtGraph.getMessageContent().equalsIgnoreCase("textG")) {
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setImage("Text.png" +
                                    "as it will help with both your typing skills and allow you to keep up with current events. " +
                                    "If you wish to know about all of the commands please use the 'npm help' command.")
                            .setColor(Color.GREEN))
                    .send(txtGraph.getChannel());
        }
    }

}
