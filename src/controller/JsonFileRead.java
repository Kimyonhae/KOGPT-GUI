package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.User;

public class JsonFileRead {

    public static void writeFile(JSONObject jsonObject, User user) {
        JSONObject userData = new JSONObject();
        userData.put("id", user.getId());
        userData.put("userId", user.getUserId());
        userData.put("password", user.getPassword());
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(user.getId(), userData);

        try {
            FileWriter file = new FileWriter("./src/database/user.json");
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject readFile() {
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            Reader reader = new FileReader("./src/database/user.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            json = jsonObject;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("현재 User Json file에 data가 없습니다!");
            e.printStackTrace();
        }
        return json;
    }
}
