import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RoleAssignment extends ListenerAdapter{
    public void onMessageReactionAdd (MessageReactionAddEvent event, JDA jda){
        System.out.println(event.getUser().getName() + " just reacted to a message");
        MessageReaction.ReactionEmote reaction = event.getReactionEmote();
        System.out.println(reaction);
     //   if (reaction == '')
     //       event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(ROLE HERE));
        //event.getGuild().addRoleToMember(memberId, jda.getRoleById(yourRole));
    }
}
