import java.util.HashMap;
import java.util.List;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class RoleAssignment extends ListenerAdapter {
    private long rolesChannelID;
    private HashMap<String, Long> roleIdPairs = new HashMap<>();
    private JDA jda;

    public RoleAssignment(JDA jda) {
        this.jda = jda;
        //initializeRoleIds(roleIdPairs);
    }

    public HashMap<String, Long> createRolesMap() {
        HashMap<String, Long> map = new HashMap<>();
        List<Role> roles = jda.getRoles();

        for (Role role : roles) {
            map.put(role.getName(), role.getIdLong());
        }

        // for (HashMap.Entry<String, Long> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        // }

        return map;
    }

    public long getRoleId(HashMap<String, Long> map, String roleName) {
        //System.out.println("ENTERED GETROLEID FUNCTION");

        for (HashMap.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getKey().equals(roleName)) {
                //System.out.println("GETTINGROLEIDPROPERLY: " + roleName + ": " + entry.getValue());
                return entry.getValue();
            }
        }
        return 0;
    }

    public long getRolesChannelId() {
        return jda.getTextChannelsByName("roles", false).get(0).getIdLong();
    }

    // when a user reacts to a message in the roles channel, they are added to the associated role
    public void onMessageReactionAdd (MessageReactionAddEvent event){
        roleIdPairs = createRolesMap();
        rolesChannelID = getRolesChannelId();

        if (event.getChannel().getIdLong() == rolesChannelID) {
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");
            String reaction = event.getReactionEmote().toString();

            System.out.println("Adding role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
                System.out.println("Added user to baby witch role");
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
                System.out.println("Added user to guest role");
            }
        }
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event) {
        roleIdPairs = createRolesMap();
        rolesChannelID = getRolesChannelId();
        if (event.getChannel().getIdLong() == rolesChannelID) {
            String reaction = event.getReactionEmote().toString();
            System.out.println("Removing role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
            }
        }
    }
}
