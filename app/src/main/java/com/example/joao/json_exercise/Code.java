package com.example.joao.json_exercise;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmp-sda-1110 on 11/28/17.
 */

class Code {
    private List<Integer> rgba;
    private String hex;

    public Code(){
        rgba = new ArrayList<>(4);
        hex = "";
    }

    public List<Integer> getRgba(){
        return rgba;
    }

    public Integer getGreen(){
        return rgba.get(1);
    }

}
