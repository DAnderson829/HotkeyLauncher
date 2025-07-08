package com.launcher.HotkeyLauncher;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//encodes file path to be able to send through postman
public class GetEncodedProcess {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String encoded = URLEncoder.encode(command, StandardCharsets.UTF_8);

        System.out.println(encoded);

        in.close();
    }
}
