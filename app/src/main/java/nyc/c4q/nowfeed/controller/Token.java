package nyc.c4q.nowfeed.controller;

import android.content.res.Resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by MarckemX on 12/17/17.
 */

public class Token {

    public static String getApiKey() {
        String apiKey = "";
        File file = new File("api_key.txt");
        try {
            Scanner scanner = new Scanner(file);
            apiKey = scanner.next();
            scanner.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return apiKey;
    }

}
