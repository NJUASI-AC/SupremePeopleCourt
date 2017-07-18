package com.edu.nju.asi.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Byron Dong on 2017/7/18.
 *
 * 中文数字字符串转英文
 *
 */
public class NumberConvert {

    /**
     * 中文数字转阿拉伯数字的数字（包括字符串当中一部分为中文，一部分为数字的情况）
     * 若全为数字则不改变
     *
     * @param number 需要中文数字转阿拉伯数字的数字
     * @return String
     */
    public String convert(String number){

        if(number.contains("十")){
            String temp = standardStr(number);
            if(temp != null){
                number = temp;
            }
        }

        String result = "";
        for(int i =0;i<number.length();i++){
            String temp = numberConvert(number.substring(i,i+1));
            if(!temp.equals("null")){
                result = result + temp;
            } else{
                result = result + number.substring(i,i+1);
            }
        }
        return result;
    }

    /**
     * 中文数字转阿拉伯数字的数字
     *
     * @param index 需要中文数字转阿拉伯数字的数字
     * @return String
     */
    private String numberConvert(String index){
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("O",0);
            put("○",0);
            put("〇", 0);
            put("零", 0);
            put("一", 1);
            put("二", 2);
            put("三", 3);
            put("四", 4);
            put("五", 5);
            put("六", 6);
            put("七", 7);
            put("八", 8);
            put("九", 9);
        }};
        return String.valueOf(map.get(index));
    }

    private String standardStr(String str){
        if(str.length()==1){
            return "一零";
        } else if(str.length()==2){
            if(str.substring(0,1).equals("十")){
                return "一"+str.substring(str.length()-1,str.length());
            }else{
                return str.substring(0,1)+"零";
            }
        } else if(str.length() == 3){
            String result = str.replace("十","");
            return result;
        }
        return null;
    }
}
