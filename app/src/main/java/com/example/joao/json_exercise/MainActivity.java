package com.example.joao.json_exercise;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
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

        /*
        Map<String, Object> map = new HashMap<String, Object>();
        map = importJsonToMap(content);
        String green;
        green = (((List)((Map)((Map)((List)(map.get("colors"))).get(1)).get("code")).get("rgba")).get(1)).toString();

        Integer green;
        green = new Integer((((List)((Map)((Map)((List)(map.get("colors"))).get(1)).get("code")).get("rgba")).get(1)).toString());
        */








    }

    public void count(View view){
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

    public void list(View view){
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

    public void modify(View view){
        String orange = "{\n" +
                "      \"color\": \"orange\",\n" +
                "      \"category\": \"hue\",\n" +
                "      \"code\": {\n" +
                "        \"rgba\": [255,165,0,1],\n" +
                "        \"hex\": \"#FA0\"\n" +
                "      }\n" +
                "    }";
        Map<String, Object> map;
        map = importJsonToMap(content);

    }





    public Map<String, Object> importJsonToMap(String content){

        /*
        //InputStream in = this.getClass().getResourceAsStream(content);
        InputStream in = new ByteArrayInputStream(content.getBytes());

        Reader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        Type listType = new TypeToken<ArrayList<Color>>(){}.getType();
        Gson gson = new Gson();
        List<Color> colors = gson.fromJson(br, listType);
        return colors;*/


        Map<String, Object> jsonToMap = new Gson().fromJson(content, Map.class);
        return jsonToMap;
    }
}
