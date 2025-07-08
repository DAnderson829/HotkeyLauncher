package com.launcher.HotkeyLauncher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Keybind implements NativeKeyListener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int button1;
    private int button2;
    private Integer button3;
    private String command;

    public Keybind(int button1, int button2, int button3, String command) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.command = command;
    }

    public Keybind(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getButton1() {
        return button1;
    }

    public void setButton1(int button1) {
        this.button1 = button1;
    }

    public int getButton2() {
        return button2;
    }

    public void setButton2(int button2) {
        this.button2 = button2;
    }

    public int getButton3() {
        return button3;
    }

    public void setButton3(Integer button3) {
        this.button3 = button3;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
