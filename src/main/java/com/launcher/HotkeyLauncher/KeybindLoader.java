package com.launcher.HotkeyLauncher;

import com.github.kwhat.jnativehook.GlobalScreen;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class KeybindLoader {

    private final KeybindRepository keybindRepository;

    @Autowired
    public KeybindLoader(KeybindRepository keybindRepository) {
        this.keybindRepository = keybindRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void registerKeybinds() {
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            logger.setUseParentHandlers(false);

            GlobalScreen.registerNativeHook();

            List<Keybind> keybinds = keybindRepository.findAll();
            System.out.println("Loaded keybinds: " + keybinds.size());

            for (Keybind keybind : keybinds) {
                System.out.println("Registering keybind: " + keybind.getCommand());
                GlobalScreen.addNativeKeyListener(new KeybindListener(keybind));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}