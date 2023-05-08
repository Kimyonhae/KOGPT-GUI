package controller;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JsonFileRead {
    public static void readFile() {
        JSONObject obj = new JSONObject();
        obj.put("id", "1");
        obj.put("userId", "12341234");
        obj.put("password", "43214321");
        try {
            FileWriter file = new FileWriter("./src/database/user.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
