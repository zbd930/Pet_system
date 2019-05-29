package service;

import Bean_class.comments;
import dbcp.dbcp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class comentsservice {
    public Boolean insert_comments(comments comments,String ds){
        dbcp dbcp =new dbcp();
        JSONArray json=JSONArray.fromObject(ds);
        JSONObject jsonOne;
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<json.size();i++){
            jsonOne = json.getJSONObject(i);
            String s=(String) jsonOne.get("value")+',';
            stringBuffer.append(s);
        }
        dbcp.insert_comments(comments.getUser_Name(),comments.getOne_2(),comments.getService(),comments.getId(),stringBuffer.toString());
        return true;
    }
}
