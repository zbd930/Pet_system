package servelet;

import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import Bean_class.Contact;
import service.bathingservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "bathingServlet",urlPatterns = "/selectdog")
public class bathingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "POST");

        synchronized (this){
            Map<String, String[]> parameterMap = request.getParameterMap();
            Contact contact=new Contact();
            try {
                BeanUtils.populate(contact,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            bathingservice bathingservice=new bathingservice();
            bathingservice.insert_historyorder(contact);
            bathingservice.insert_myorders(contact);
            //缺少提交JDBC的代码

            String string="上传成功";
            Writer out = response.getWriter();
            out.write(string);
            out.flush();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET");


        String wechat_name= request.getParameter("user_Name");
        JSONArray jsonObject= new JSONArray();
        bathingservice  bathingservice=new bathingservice();
        jsonObject=bathingservice.query(wechat_name);

       Writer out=response.getWriter();
       String string = jsonObject.toString();
       out.write(string);
    }
}