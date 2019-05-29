package service;

import Bean_class.Contact;
import dbcp.dbcp;
import net.sf.json.JSONArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bathingservice {

    public JSONArray query(String wechat_name){
        JSONArray jsonArra=new JSONArray();
        jsonArra=dbcp.query_sql(wechat_name);
        return jsonArra;
    }


    public  void insert_historyorder(Contact contact) {
        dbcp dbcp =new dbcp();
        Date date=null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=format.parse(contact.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
          String price=contact.getPrice();
        if (price.equals("98")){
           int set_category=1;
            dbcp.insert_historyorder(contact.getUser_Name(),contact.getContact_name(),contact.getContact_addree(),contact.getContact_phone(),set_category,contact.getPick_time(), sqlDate);
        }
        else if(contact.getPrice().equals("138")){
            int set_category=2;
            dbcp.insert_historyorder(contact.getUser_Name(),contact.getContact_name(),contact.getContact_addree(),contact.getContact_phone(),set_category,contact.getPick_time(),sqlDate);
        }


    }
    public void insert_myorders(Contact contact){
        dbcp dbcp=new dbcp();
//        contact.getContact_addree();
        Date date=null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date=format.parse(contact.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dbcp.insert_myorders(contact.getUser_Name(),date);
    }

}
