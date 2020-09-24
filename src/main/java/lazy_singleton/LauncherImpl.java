package lazy_singleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Component
@Lazy
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LauncherImpl implements Launcher {

    @PostConstruct
    public void payForLauncher(){
        System.out.println("launcher was created, you payed 100500");
    }

    @Override
    public void fire() {
        System.out.println("BAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahhhhhhhh");
    }
}
