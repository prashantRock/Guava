package com
/**
 * Created by prashant on 27/4/17.
 */
public class Database {

    public static String fetchData(String key){
        if(key.equals("Prashant")){
            return "Prashant"
        }else if(key.equals("Agarwal")){
            return "Agarwal"
        }else if(key.equals("Fintechlabs")){
            return "Fintechlabs"
        }
    }
}
