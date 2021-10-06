import event.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {
    public static void main(String[] args) throws Exception {
        {
            // Note: It is important to register your ReadyListener before building
            JDA jda = JDABuilder.createDefault("").build();
            // optionally block until JDA is ready
            jda.awaitReady();

            jda.addEventListener(new HelloEvent());
        }
    }
}
