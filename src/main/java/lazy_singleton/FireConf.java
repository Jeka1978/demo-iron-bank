package lazy_singleton;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@EnableScheduling
public class FireConf {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FireConf.class);
        Schwarzenegger schwarzenegger = context.getBean(Schwarzenegger.class);
        schwarzenegger.killEnemies();
        Thread.sleep(1000);
        schwarzenegger.killEnemies();
        Thread.sleep(1000);
        schwarzenegger.killEnemies();
    }
}
