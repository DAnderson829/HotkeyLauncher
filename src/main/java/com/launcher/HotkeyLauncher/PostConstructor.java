package com.launcher.HotkeyLauncher;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstructor {

    @Autowired
    KeybindRepository keybindRepository;

    @PostConstruct
    public void init() {
        if(keybindRepository.count() == 0){
        //google: ctrl, alt, a
        Keybind google = new Keybind(29, 56, 30, "https://www.google.com/");
        keybindRepository.save(google);
    }
    }
}
