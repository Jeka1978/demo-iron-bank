package com.ebay.demoironbank.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
public class BeanRegestratorController {

    @Autowired
    private CustomClassLoader classLoader;

    @Autowired
    private GenericApplicationContext context;

    @SneakyThrows
    @PostMapping("/regbean")
    public String registerBean(@RequestBody BeanMetaMD beanMetaMD) {
        Class<?> beanClass = classLoader.findClass(beanMetaMD.getClassName());
        var beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanFactory.registerBeanDefinition(beanMetaMD.getBeanName(),beanDefinition);
        context.getBean(beanMetaMD.getBeanName());
        return "registered";
    }
}
