package org.miaguila.utilities;

public class Utilities {
    public Utilities() {}

    public String cadena(int count){
        String result = "";
        for(int i = 0; i < count; i++){
            result = "X" + result;
        }
        return result;
    }
}
