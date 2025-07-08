package com.launcher.HotkeyLauncher;


import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class KeybindListener implements NativeKeyListener {

    private final int button1;
    private final int button2;
    private final Integer button3;
    private final String command;
    private final Set<Integer> pressedKeys = new HashSet<>();

    public KeybindListener(Keybind keybind) {
        this.button1 = keybind.getButton1();
        this.button2 = keybind.getButton2();
        this.button3 = keybind.getButton3();
        this.command = keybind.getCommand();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        pressedKeys.add(e.getKeyCode());


        boolean threeKeyMatch =
                pressedKeys.contains(button1) &&
                pressedKeys.contains(button2) &&
                pressedKeys.contains(button3);

        if (threeKeyMatch) {
            System.out.println("Keybind matched, executing: " + command);
            try {
                String trimmedCommand = command.trim().replaceAll("^\"|\"$", "");

                if (trimmedCommand.startsWith("http")) {

                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + trimmedCommand);
                } else {
                    Process process = new ProcessBuilder(trimmedCommand).start();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            pressedKeys.clear();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }
}
