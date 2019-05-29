package service;

import dbcp.dbcp;
import net.sf.json.JSONArray;


public class orderservice {

    public JSONArray query(String wechat_name){
         JSONArray jsonArray;
        jsonArray =dbcp.query_orders(wechat_name);
        return jsonArray;
    }

}
