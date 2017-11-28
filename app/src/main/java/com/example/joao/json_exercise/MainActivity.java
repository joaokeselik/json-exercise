package com.example.joao.json_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String content ="{\n" +
            "  \"colors\": [\n" +
            "    {\n" +
            "      \"color\": \"black\",\n" +
            "      \"category\": \"hue\",\n" +
            "      \"type\": \"primary\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [255,255,255,1],\n" +
            "        \"hex\": \"#000\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"color\": \"white\",\n" +
            "      \"category\": \"value\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [0,0,0,1],\n" +
            "        \"hex\": \"#FFF\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"color\": \"red\",\n" +
            "      \"category\": \"hue\",\n" +
            "      \"type\": \"primary\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [255,0,0,1],\n" +
            "        \"hex\": \"#FF0\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"color\": \"blue\",\n" +
            "      \"category\": \"hue\",\n" +
            "      \"type\": \"primary\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [0,0,255,1],\n" +
            "        \"hex\": \"#00F\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"color\": \"yellow\",\n" +
            "      \"category\": \"hue\",\n" +
            "      \"type\": \"primary\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [255,255,0,1],\n" +
            "        \"hex\": \"#FF0\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"color\": \"green\",\n" +
            "      \"category\": \"hue\",\n" +
            "      \"type\": \"secondary\",\n" +
            "      \"code\": {\n" +
            "        \"rgba\": [0,255,0,1],\n" +
            "        \"hex\": \"#0F0\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView_json);
    }

    void count(View view){
        Integer greenCount = 0;
        Map<String, Object> map;
        map = importJsonToMap(content);

        for(int i=0; i<6; i++){
            Double greenDouble;
            greenDouble = new Double((((List)((Map)((Map)((List)(map.get("colors"))).get(i)).get("code")).get("rgba")).get(1)).toString());
            if(greenDouble == 255){
                greenCount++;
            }
        }

        textView.setText(Integer.toString(greenCount));
    }

    void list(View view){
        String greenColors = "";
        Map<String, Object> map;
        map = importJsonToMap(content);

        for(int i=0; i<6; i++){
            Double greenDouble;
            greenDouble = new Double((((List)((Map)((Map)((List)(map.get("colors"))).get(i)).get("code")).get("rgba")).get(1)).toString());
            if(greenDouble == 255){
                greenColors += ((Map)((List)(map.get("colors"))).get(i)).get("color") + " ";
            }
        }

        textView.setText(greenColors);
    }

    void modify(View view) throws JSONException{
        String orange = "{\n" +
                "      \"color\": \"orange\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [255,165,0,1],\n" +
                "        \"hex\": \"#FA0\"\n" +
                "      }\n" +
                "    }\n";


        Map<String, Object> map;
        map = importJsonToMap(content);

        Map<String, Object> orangeToMap = importJsonToMap(orange);
        ((List)map.get("colors")).add(orangeToMap);

        JSONObject jsonObject = new JSONObject(map);

        //String mapStr = map.get("colors").toString();
        String jsonStr = jsonObject.toString(2);

        textView.setText(jsonStr);
    }

    public Map<String, Object> importJsonToMap(String content){

        Map<String, Object> jsonToMap = new Gson().fromJson(content, Map.class);
        return jsonToMap;

    }
}
