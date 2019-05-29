package servelet;

import Bean_class.Dog;
import org.apache.commons.beanutils.BeanUtils;
import service.dogfileservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "dogfileServlet",urlPatterns = "/dogfile")
public class dogfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //System.out.print(request.getParameter("dogbirthday"));
        synchronized (this){
            Map<String, String[]> parameterMap = request.getParameterMap();
            Dog dog=new Dog();
            try {
                BeanUtils.populate(dog,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            dogfileservice dogfileservice=new dogfileservice();
            dogfileservice.insert_t1(dog);
            dogfileservice.insert_t2(dog);
            String string="上传成功";
            Writer out = response.getWriter();
            out.write(string);
            out.flush();
        }
    }
}
