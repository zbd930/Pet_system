package action;

import Bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sere
 * @date：2015年7月18日 上午9:04:18
 * 类说明
 */
public class LoginAction extends ActionSupport{

    private static final long serialVersionUID = 7922979648150320921L;

    private String username;
    private String password;

    /**
     * 处理客户端请求的method,对应struts.xml文件
     * @author  Sere
     * @date：2015年7月18日 上午9:06:22
     * */

    public String checkLogin(){
        String password=this.password;
        String username=this.username;
        if(username.endsWith("root")&&password.equals("Zbd7895123!@#")){
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("User",user);
            return SUCCESS;    //登陆成功返回SUCCESS
        }else{
            return LOGIN;    //登陆失败返回LOGIN
        }
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}