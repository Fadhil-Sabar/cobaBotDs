package event;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        User user = event.getAuthor();
        String name = user.getName();

        if(messageSent.equalsIgnoreCase("d!hello")){
            event.getChannel().sendMessage("Haii " + name).queue();
        }
        String avatar;
        avatar = user.getEffectiveAvatarUrl();
        if (messageSent.equalsIgnoreCase("d!avatar")){
            event.getChannel().sendMessage(avatar).queue();
        }
        Message message = event.getMessage();
        String[] msg = message.getContentDisplay().split(" ");              //This returns a human readable version of the Message. Similar to//The message that was received.
        MessageChannel channel = event.getChannel();    //This is the MessageChannel that the message was sent to.



        if(msg[0].equals("d!ping") && msg[1].equals("me")){
            channel.sendMessage("i'm ponging you " + name).queue();
        }
        if (messageSent.equals("d!ping"))
        {
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
}
