package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        List<String> listIngredients = new ArrayList<>();
        List<String> listAlsoKnow = new ArrayList<>();
        if(jsonObject.getJSONArray("ingredients") != null){
            for (int i=0;i<jsonObject.getJSONArray("ingredients").length();i++){
                listIngredients.add(jsonObject.getJSONArray("ingredients") .getString(i));
            }
        }

        if(jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs") != null){
            for (int i=0;i<jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs") .length();i++){
                listAlsoKnow.add(jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs").getString(i));
            }
        }
        return new Sandwich(
                jsonObject.getJSONObject("name").getString("mainName"),
                listAlsoKnow,
                jsonObject.getString("placeOfOrigin"),
                jsonObject.getString("description"),
                jsonObject.getString("image"),
                listIngredients
        );
    }
}
