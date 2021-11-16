//class to moderate language used on server

//mute members who violate guidlines
/*
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class muteMember {
    @Override
    protected void execute(CommandEvent commandEvent) {
        Guild guild = commandEvent.getGuild();
        //if we're not in a guild we can't kick/mute anyone
        if(guild == null) {
            commandEvent.reply("You must run this command in a server");
            return;
        }
        GuildController controller = guild.getController();
        List&lt;Member&gt; mentionedMembers = commandEvent.getMessage().getMentionedMembers();
        if(mentionedMembers.isEmpty()) {
            commandEvent.reply("You must mention who you want to be muted");
            return;
        }
        Member toMute = mentionedMembers.get(0);
        Role muteRole = guild.getRoles().stream().filter(r-&gt;r.getName().equals("Muted")).findFirst().orElse(null);
        if(muteRole == null) {
            commandEvent.reply("No role named 'Muted' found");
            return;
        }
        controller.addSingleRoleToMember(toMute, muteRole).queue(success-&gt;{
            commandEvent.reply("Successfully muted " + toMute.getUser().getName());
            controller.removeSingleRoleFromMember(toMute, muteRole).queueAfter(1, TimeUnit.HOURS, success2-&gt;{
                commandEvent.reply("Successfully unmuted " + toMute.getUser().getName());
            }, error-&gt;{
                commandEvent.reply("Unable to unmute " + toMute.getUser().getName() + ": " + error);
            });
        }, error-&gt;{
            commandEvent.reply("Unable to mute " + toMute.getUser().getName() + ": " + error);
        });
    }
}
//left to do:
//need to figure out how to access and add members to mentionedmembers
//need to create muteRole named "Muted"
*/