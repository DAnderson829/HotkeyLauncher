package com.launcher.HotkeyLauncher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class KeybindController {


    @Autowired
    private KeybindRepository keybindRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createKeybind(@RequestParam int button1, @RequestParam int button2, @RequestParam Integer button3, @RequestParam String command){
        var k = new Keybind(button1, button2, button3, command);
        keybindRepository.save(k);
        return ResponseEntity.ok("Command created");
    }

    @GetMapping("/getAll")
    public List<Keybind> getAllKeybinds(){
        return keybindRepository.findAll();
    }
    //29,56,34 ctrl alt g
    //29,56,35 ctrl alt h

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKeybind(@PathVariable Long id){
        if(keybindRepository.findById(id).isPresent()){
            keybindRepository.deleteById(id);
            return ResponseEntity.ok("Command deleted");
        }
        return ResponseEntity.ok("Command not found");
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllKeybinds(){
        keybindRepository.deleteAll();
        return ResponseEntity.ok("All keybinds deleted");
    }



}
