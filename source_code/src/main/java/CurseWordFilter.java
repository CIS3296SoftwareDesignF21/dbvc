import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CurseWordFilter extends ListenerAdapter {
    //NOTE: curse words should be listed in lower case
    private static final List&lt;String&gt; CURSE_WORDS = Arrays.asList(
            "evil", "mudblood", "never", "jinx", "juju", "devil", "hate"
    );
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //get what the user typed) and convert to lower case
        String message = event.getMessage().getContentRaw().toLowerCase();
        //for each curse word in the curse words list
        for(String curseWord : CURSE_WORDS) {
            //check if the message contains it
            if(message.contains(curseWord)) {
                //the message contains a curse word
                //let's see if we can delete it
                //if we don't have permission to delete messages we'll just warn and return
                if(!event.getGuild().getSelfMember().hasPermission(event.getChannel(), Permission.MESSAGE_MANAGE)) {
                    System.out.println("No permission to delete messages in #" + event.getChannel().getName());
                    return;
                }
                //try deleting it
                event.getMessage().delete().queue(ddone-&gt;{
                    //if it was deleted, warn the user
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", you cannot say that!").queue();
                }, error-&gt;{
                    //if we got an error deleting it print it
                    System.out.println("Error deleting message with curse word");
                    error.printStackTrace();
                });
                return;
            }
        }
    }
}
