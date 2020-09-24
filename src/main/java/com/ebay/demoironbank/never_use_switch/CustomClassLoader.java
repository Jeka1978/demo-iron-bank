package com.ebay.demoironbank.never_use_switch;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Evgeny Borisov
 */
@Component
public class CustomClassLoader extends ClassLoader {
    @SneakyThrows
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String fileName = "target/classes" + className.replace('.', File.separatorChar) + ".class";
        byte[] bytes = Files.newInputStream(Path.of(fileName)).readAllBytes();
        return defineClass(className,bytes,0,bytes.length);
    }
}
