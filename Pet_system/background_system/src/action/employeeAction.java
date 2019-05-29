package action;

import Bean.PageBean;
import Bean.employee;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class employeeAction extends ActionSupport {
    private Service.employeeservice employeeservice;
    private employee employee;
    private int page;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service.employeeservice getEmployeeservice() {
        return employeeservice;
    }

    public void setEmployeeservice(Service.employeeservice employeeservice) {
        this.employeeservice = employeeservice;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Bean.employee getEmployee() {
        return employee;
    }

    public void setEmployee(Bean.employee employee) {
        this.employee = employee;
    }


    public String execute() throws Exception {
        return SUCCESS;
    }
    public String search()throws Exception{
        PageBean pageBean = employeeservice.getPageBean(5, page);

        HttpServletRequest request = ServletActionContext.getRequest();

        request.setAttribute("pageBean", pageBean);
        return "search";
    }
    public String delete() throws Exception {

        employeeservice.delte(id);
        return "delete";
    }

    /*
     * 添加商品方法
     */
    public String add() {
        employeeservice.add(employee);
        return "add";
    }

    }

