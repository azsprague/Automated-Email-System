package email;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.*;

/**
 * Deals with sending the message.
 * 
 * @author Aidan Sprague
 * @version 2020.12.20
 */
public class Sender {

    public static void send(Data data) {
        
        // Signs in to the email service
        EmailScript script = new EmailScript(data);
        script.signIn();
        
        // Access desired time of delivery
        String time = data.getTime();
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6));
        
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime nextRun = now.withHour(hour).withMinute(minute).withSecond(second);
        if (now.compareTo(nextRun) > 0) {
            nextRun = nextRun.plusDays(1);
        }
            
        Duration duration = Duration.between(now, nextRun);
        long initalDelay = duration.getSeconds();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {script.send();}
        },  initalDelay,
            TimeUnit.SECONDS);
    }

}
