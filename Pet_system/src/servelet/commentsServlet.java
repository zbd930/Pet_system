package servelet;

import Bean_class.comments;
import org.apache.commons.beanutils.BeanUtils;
import service.comentsservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "commentsServlet",urlPatterns = "/comments")
public class commentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "POST");

        synchronized (this){
            Writer out=null;
            Map<String, String[]> parameterMap = request.getParameterMap();
            comments comments=new comments();
            try {
                BeanUtils.populate(comments,request.getParameterMap());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            String value=request.getParameter("service_value");
            comentsservice comentsservice=new comentsservice();
            if (comentsservice.insert_comments(comments,value)){
                String string="上传成功";
                out = response.getWriter();
                out.write(string);
            }
            out.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
