package dbcp;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class dbcp {


    public  static JSONArray query_sql(String wechat_number){
        PreparedStatement pre =null;
        ResultSet rs = null;
        Connection conn = KCYDBCPUtil.getConnection();

        String sql = "select Nick_name from dog_file where Wechat_number = ? ";
        JSONArray json_array=new JSONArray();
        try {
            pre=conn.prepareStatement(sql);
            pre.setString(1,wechat_number);
            rs=pre.executeQuery();
            ResultSetMetaData data=rs.getMetaData();
            String columnName=null;
            String rst=null;
            while(rs.next()){
                //JSONObject json_object=new JSONObject();
                for(int i=1;i<=data.getColumnCount();++i){
                    //列名
                     //columnName=data.getColumnName(i);
                     rst=rs.getString(i);
                     if(!json_array.contains(rst)){
                         json_array.add(rst);
                     }
                }

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json_array;
    }
    public void insert_dogfile(String wechat_number,String nick_name,String picture,String category ){
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql = "insert into dog_file values( null,?,?,?,?);";
            //String sql = "insert into dog_file (Wechat_number,Nick_name,Picture,Category) values(?,?,?,?) ";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql);
            stat.setString(1,wechat_number);
            stat.setString(2,nick_name);
            stat.setString(3,picture);
            stat.setString(4,category);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("dog_file插入行数为"+row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert_filedetails(String wechat_number, int sex, BigDecimal weight, Date birthday){
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql = "insert into file_details (Wechat_number,Sex,Weight,Birthday) values ( ?,?,?,?); ";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql);
            stat.setString(1,wechat_number);
            stat.setInt(2,sex);
            stat.setBigDecimal(3,weight);
            stat.setDate(4, (java.sql.Date) birthday);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("file_details插入行数为"+row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert_historyorder(String wechat_number,String contractor,String Address,String Phone,int Set_category,String time,java.sql.Date date) {
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql = "insert into order_search (Wechat_number,Contractor,Address,Phone,Set_category,schedule,order_date) values (?,?,?,?,?,?,?); ";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql);
            stat.setString(1,wechat_number);
            stat.setString(2,contractor);
            stat.setString(3,Address);
            stat.setString(4, Phone);
            stat.setInt(5, Set_category);
            stat.setString(6, time);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            stat.setDate(7,date);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("order_search插入行数为"+row);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insert_myorders(String wechat_number,Date date) {
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql = "insert into my_order values ( null,?,?,?); ";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql);
            stat.setString(1,wechat_number);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate);
            stat.setDate(2, sqlDate);
            stat.setInt(3, 0);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("my_order插入行数为"+row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static JSONArray query_orders(String wechat_number)  {
        PreparedStatement pre =null;
        ResultSet rs = null;
        Connection conn = KCYDBCPUtil.getConnection();
        String sql = "select Status,Create_Date,ID from my_order where Wechat_number=? ;";
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, wechat_number);
            rs = pre.executeQuery();

            // 展开结果集数据库
            while (rs.next()) {
                //System.out.print(rs.getRow());
                //System.out.print(rs.getString("ID"));
                // 通过字段检索
                jsonobj.put("code",rs.getRow());
                jsonobj.put("date", rs.getString("Create_Date"));

                if (rs.getString("Status").equals("0")){
                    jsonobj.put("setvicing","服务中");
                    jsonobj.put("comments","");
                    jsonobj.put("finished","");
                    jsonobj.put("ID", rs.getString("ID"));
                    }else if(rs.getString("Status").equals("1")){
                    jsonobj.put("setvicing","");
                    jsonobj.put("comments","点击评价");
                    jsonobj.put("finished","");
                    jsonobj.put("ID", rs.getString("ID"));
                }else if(rs.getString("Status").equals("2")){
                    jsonobj.put("setvicing","");
                    jsonobj.put("comments","");
                    jsonobj.put("finished","已完成");
                    jsonobj.put("ID", rs.getString("ID"));
                }

                jsonarray.add(jsonobj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonarray;
    }
    public void insert_comments(String wechat_name,int star,String Service,int id,String service_value) {
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql = "insert into comments values( null,?,?,?,?,?);";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql);
            stat.setString(1,wechat_name);
            stat.setInt(2,star);
            stat.setString(3,Service);
            stat.setInt(4,id);
            stat.setString(5,service_value);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("comments插入行数为"+row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection conn = KCYDBCPUtil.getConnection();
            String sql1="update my_order set Status = 2 where ID = (?);";
            PreparedStatement stat= (PreparedStatement) conn.prepareStatement(sql1);
            stat.setInt(1, id);
            int row=stat.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("myorders插入行数为"+row);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
