package sounds.json;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JSONMaker {
    public static void main(String[] args) {
        JSONObject all = new JSONObject();

        for (int i = 21; i <= 108; i++) {


            JSONObject sound = new JSONObject();

            sound.put("category", "master");

            JSONArray soundInfo = new JSONArray();

            JSONObject sob = new JSONObject();

            if (i < 100)
                sob.put("name", "piano/piano0" + i);
            else
                sob.put("name", "piano/piano" + i);

            sob.put("stream", true);

            soundInfo.put(sob);
            sound.put("sounds", soundInfo);

            if (i < 100)
                all.put("piano.piano0" + i, sound);
            else
                all.put("piano.piano" + i, sound);
        }

        char[] chars = all.toString().toCharArray();
        String s = "";
        int tab = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ':') {
                s += chars[i] + " ";

            } else if (chars[i] == '{') {
                s += chars[i];
                s += "\n";
                tab++;
                for (int j = 0; j < tab; j++) {
                    s += "\t";
                }


            } else if (chars[i] == '}') {
                tab--;
                s += "\n";
                for (int j = 0; j < tab; j++) {
                    s += "\t";
                }
                s += chars[i];

            } else if (chars[i] == ',') {
                s += chars[i];
                s += "\n";
                for (int j = 0; j < tab; j++) {
                    s += "\t";
                }
            } else {
                s += chars[i];
            }


        }

        System.out.println(all);
        System.out.println(s);
        File f = new File("sounds.json");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
