import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class BotIn extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
        //Set message
        String message = event.getMessage().getContentRaw().toLowerCase();
        //Set textchannel
        TextChannel channel = event.getChannel();
        //if user type "join", bot join in channel
        if(message.equals("!join")) {
            //check if bot has permission
            if(!event.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
                channel.sendMessage("I do not have permissions to join a voice channel!").queue();
                return;
            }
            //Set voicechannel
            VoiceChannel voiceChannel = event.getMember().getVoiceState().getChannel();
            //check user in or not in channel
            if(voiceChannel == null) {
                channel.sendMessage("You are not connected to a voice channel!").queue();
                return;
            }
            //Set audiomanager
            AudioManager audioManager = event.getGuild().getAudioManager();
            //
            /**
            if(audioManager.isAttemptingToConnect()) {
                channel.sendMessage("The bot is already trying to connect! Enter the chill zone!").queue();
                return;
            }
             **/

            audioManager.openAudioConnection(voiceChannel);
            channel.sendMessage("Connected to the voice channel!").queue();
        } else if(message.equals("!leave")) {
            VoiceChannel connectedChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();

            if(connectedChannel == null) {
                channel.sendMessage("I am not connected to a voice channel!").queue();
                return;
            }

            event.getGuild().getAudioManager().closeAudioConnection();
            channel.sendMessage("Disconnected from the voice channel!").queue();
        }

    }
}