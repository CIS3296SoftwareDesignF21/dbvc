import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

/* role ids will depend on the server they are created in, so there will have to be some sort of environmental variable
to initialized the role values, or find a way for the user to set up the roles themselves within the server instead
of editing code
 */
// make sure the reactions only apply to messages in the roles channel and the welcome channel
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

    // when a user reacts to a message in the roles channel, they are added to the associated role
    /**
    public void onMessageReactionAdd (MessageReactionAddEvent event){
        Guild g = event.getGuild();
        String channel = event.getChannel().toString();
        String welcomeID = g.getTextChannelsByName("welcome", true).get(0).getId();
        String rolesID = g.getTextChannelsByName("roles", true).get(0).getId();
        String reaction = event.getReactionEmote().toString();

        if(channel.equals(welcomeID)){
            if(reaction.equals("RE:U+270d")){
                System.out.println("Removing role based on reaction: " + reaction);
                g.removeRoleFromMember(event.getUserId(), g.getRolesByName("unauth", true).get(0)).queue();
            }
        } else if(channel.equals(rolesID)){
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");

            switch (reaction) {
                case "RE:U+1f98b":  // baby witch
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("baby witch", true).get(0)).queue();
                    System.out.println("Added user to baby witch role");
                    break;
                case "RE:U+1f337":  // guest
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("guest", true).get(0)).queue();
                    System.out.println("Added user to guest role");
                    break;
                case "RE:U+1f52e":  // sage witch
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("sage witch", true).get(0)).queue();
                    System.out.println("Added user to sage witch role");
                    break;
                case "RE:U+1f7e9":  // she/her
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("she/her", true).get(0)).queue();
                    System.out.println("Added user to she/her role");
                    break;
                case "RE:U+1f7e6":  // he/him
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("he/him", true).get(0)).queue();
                    System.out.println("Added user to he/him role");
                    break;
                case "RE:U+1f7ea":  // they/them
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("they/them", true).get(0)).queue();
                    System.out.println("Added user to they/them role");
                    break;
                case "RE:U+2648":  // aries
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("aries", true).get(0)).queue();
                    System.out.println("Added user to aries role");
                    break;
                case "RE:U+2649":  // taurus
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("taurus", true).get(0)).queue();
                    System.out.println("Added user to taurus role");
                    break;
                case "RE:U+264A":  // gemini
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("gemini", true).get(0)).queue();
                    System.out.println("Added user to gemini role");
                    break;
                case "RE:U+264B":  // cancer
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("cancer", true).get(0)).queue();
                    System.out.println("Added user to cancer role");
                    break;
                case "RE:U+264C":  // leo
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("leo", true).get(0)).queue();
                    System.out.println("Added user to leo role");
                    break;
                case "RE:U+264D":  // virgo
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("virgo", true).get(0)).queue();
                    System.out.println("Added user to virgo role");
                    break;
                case "RE:U+264E":  // libra
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("libra", true).get(0)).queue();
                    System.out.println("Added user to libra role");
                    break;
                case "RE:U+264F":  // scorpio
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("scorpio", true).get(0)).queue();
                    System.out.println("Added user to scorpio role");
                    break;
                case "RE:U+2650":  // sagittarius
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("sagittarius", true).get(0)).queue();
                    System.out.println("Added user to sagittarius role");
                    break;
                case "RE:U+2651":  // capricorn
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("capricorn", true).get(0)).queue();
                    System.out.println("Added user to capricorn role");
                    break;
                case "RE:U+2652":  // aquarius
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("aquarius", true).get(0)).queue();
                    System.out.println("Added user to aquarius role");
                    break;
                case "RE:U+2653":  // pisces
                    g.addRoleToMember(event.getUserId(), g.getRolesByName("pisces", true).get(0)).queue();
                    System.out.println("Added user to pisces role");
                    break;
                default:
                    break;
            }
            System.out.println("Added role based on reaction: " + reaction);
        }
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event) {
        Guild g = event.getGuild();
        String channel = event.getChannel().toString();
        String welcomeID = g.getTextChannelsByName("welcome", true).get(0).getId();
        String rolesID = g.getTextChannelsByName("roles", true).get(0).getId();
        String reaction = event.getReactionEmote().toString();

        if(channel.equals(welcomeID)){
            if(reaction.equals("RE:U+270d")){
                System.out.println("Adding role based on reaction: " + reaction);
                g.addRoleToMember(event.getUserId(), g.getRolesByName("unauth", true).get(0)).queue();

                event.getMember().getUser().openPrivateChannel().flatMap(privateMessage ->
                        privateMessage.sendMessage("You have removed acknowledgement to server rules, and are no longer authorized. "+
                                "Please react once more to gain access back to the server.")).queue();
            }
        } else if(channel.equals(rolesID)){
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");

            switch (reaction) {
                case "RE:U+1f98b":  // baby witch
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("baby witch", true).get(0)).queue();
                    System.out.println("Removed user to baby witch role");
                    break;
                case "RE:U+1f337":  // guest
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("guest", true).get(0)).queue();
                    System.out.println("Removed user to guest role");
                    break;
                case "RE:U+1f52e":  // sage witch
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("sage witch", true).get(0)).queue();
                    System.out.println("Removed user to sage witch role");
                    break;
                case "RE:U+1f7e9":  // she/her
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("she/her", true).get(0)).queue();
                    System.out.println("Removed user to she/her role");
                    break;
                case "RE:U+1f7e6":  // he/him
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("he/him", true).get(0)).queue();
                    System.out.println("Removed user to he/him role");
                    break;
                case "RE:U+1f7ea":  // they/them
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("they/them", true).get(0)).queue();
                    System.out.println("Removed user to they/them role");
                    break;
                case "RE:U+2648":  // aries
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("aries", true).get(0)).queue();
                    System.out.println("Removed user to aries role");
                    break;
                case "RE:U+2649":  // taurus
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("taurus", true).get(0)).queue();
                    System.out.println("Removed user to taurus role");
                    break;
                case "RE:U+264A":  // gemini
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("gemini", true).get(0)).queue();
                    System.out.println("Removed user to gemini role");
                    break;
                case "RE:U+264B":  // cancer
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("cancer", true).get(0)).queue();
                    System.out.println("Removed user to cancer role");
                    break;
                case "RE:U+264C":  // leo
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("leo", true).get(0)).queue();
                    System.out.println("Removed user to leo role");
                    break;
                case "RE:U+264D":  // virgo
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("virgo", true).get(0)).queue();
                    System.out.println("Removed user to virgo role");
                    break;
                case "RE:U+264E":  // libra
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("libra", true).get(0)).queue();
                    System.out.println("Removed user to libra role");
                    break;
                case "RE:U+264F":  // scorpio
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("scorpio", true).get(0)).queue();
                    System.out.println("Removed user to scorpio role");
                    break;
                case "RE:U+2650":  // sagittarius
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("sagittarius", true).get(0)).queue();
                    System.out.println("Removed user to sagittarius role");
                    break;
                case "RE:U+2651":  // capricorn
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("capricorn", true).get(0)).queue();
                    System.out.println("Removed user to capricorn role");
                    break;
                case "RE:U+2652":  // aquarius
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("aquarius", true).get(0)).queue();
                    System.out.println("Removed user to aquarius role");
                    break;
                case "RE:U+2653":  // pisces
                    g.removeRoleFromMember(event.getUserId(), g.getRolesByName("pisces", true).get(0)).queue();
                    System.out.println("Removed user to pisces role");
                    break;
                default:
                    break;
            }
            System.out.println("Added role based on reaction: " + reaction);
        }
    }
     **/
}
