import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class RoleAssignment extends ListenerAdapter{
    public RoleAssignment (JDA jda) {

    }
    // when a user reacts to a message in the roles channel, they are added to the associated role
    public void onMessageReactionAdd (MessageReactionAddEvent event, JDA jda){
        System.out.println(event.getUser().getName() + " just reacted to a message");
        MessageReaction.ReactionEmote reaction = event.getReactionEmote();
        System.out.println(reaction);
        if (reaction == '') { // baby witch
            event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(907370752519585823));
        } else if (reaction == '') { // guest
            event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(907383728668573777));

        }
        //event.getGuild().addRoleToMember(memberId, jda.getRoleById(yourRole));
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event, JDA jda) {

    }
}
