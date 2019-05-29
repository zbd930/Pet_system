package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter extends HttpServlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
                         FilterChain filterChain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) sRequest;
        HttpServletResponse response = (HttpServletResponse) sResponse;
        HttpSession session = request.getSession();
        String url=request.getServletPath();
        String contextPath=request.getContextPath();
        System.out.print(contextPath);
        String a=request.getRequestURI();
        if(url.equals("")) url+="/";
        if((url.startsWith("/")&&!url.startsWith("/log"))){//若访问后台资源 过滤到login
            String user= (String) session.getAttribute("User");
            if(user==null){//转入管理员登陆页面
                System.out.print("user是空");
                System.out.print(contextPath);
                response.sendRedirect(contextPath+"/log.jsp");
                return;
            }
        }
        filterChain.doFilter(sRequest, sResponse);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}