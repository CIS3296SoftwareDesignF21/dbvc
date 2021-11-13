import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

/* role ids will depend on the server they are created in, so there will have to be some sort of environmental variable
to initialized the role values, or find a way for the user to set up the roles themselves within the server instead
of editing code
 */
// make sure the reactions only apply to messages in the roles channel
public class RoleAssignment extends ListenerAdapter {
    private static JDA jda;
    private long babyWitch = 907370752519585823L;
    private long guest = 907383728668573777L;
    private String rolesChannelID = "TC:roles(907008333557428295)";

    // when a user reacts to a message in the roles channel, they are added to the associated role
    public void onMessageReactionAdd (MessageReactionAddEvent event){
        jda = event.getJDA();
        if (event.getChannel().toString().equals(rolesChannelID)) {
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");
            String reaction = event.getReactionEmote().toString();

            System.out.println("Adding role based on reaction: " + reaction);
            event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(babyWitch));
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(babyWitch)).queue();
                System.out.println("Added user to baby witch role");
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().addRoleToMember(event.getUserId(), jda.getRoleById(guest)).queue();
                System.out.println("Added user to guest role");
            }
        }
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event) {
        event.getJDA();
        if (event.getChannel().toString().equals(rolesChannelID)) {
            String reaction = event.getReactionEmote().toString();
            System.out.println("Removing role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().removeRoleFromMember(event.getUserId(), jda.getRoleById(babyWitch)).queue();
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().removeRoleFromMember(event.getUserId(), jda.getRoleById(guest)).queue();
            }
        }
    }
}
