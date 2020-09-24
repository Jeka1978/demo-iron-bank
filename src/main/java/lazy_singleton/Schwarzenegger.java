package lazy_singleton;

import org.apache.commons.lang3.event.EventListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class Schwarzenegger  {

    private int power = 100;
    @Autowired
//    @Lazy
    private Launcher launcher;

    @Scheduled(fixedDelay = 100)
    public void makeOlder(){
        power-=10;
    }

    public void killEnemies(){
        if (power > 10) {
            killWithLog();
        }else {
            launcher.fire();
        }
    }

    private void killWithLog() {
        System.out.println("Log Log");
    }
}
