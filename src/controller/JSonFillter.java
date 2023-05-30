package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSonFillter {
    private static String result;

    public static String jsonToString(JSONObject response) {
        try {
            JSONArray generations = (JSONArray) response.get("generations");
            JSONObject textData = (JSONObject) generations.get(0);
            result = (String) textData.get("text").toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = "내용을 생성하지 못했습니다.";
        return result;
    }
}
