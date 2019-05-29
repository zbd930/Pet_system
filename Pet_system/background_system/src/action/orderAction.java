package action;

import Bean.PageBean;
import Service.orderServiceImpl;
import Service.orderServiceImpl_options;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class orderAction extends ActionSupport {
    private orderServiceImpl orderService ;
    private orderServiceImpl_options orderServiceImpl_options;
    private int page;
    private String start;
    private String end;

    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public orderServiceImpl getOrderService() {
        return orderService;
    }
    public void setOrderService(orderServiceImpl orderService) {
        this.orderService = orderService;
    }
    public Service.orderServiceImpl_options getOrderServiceImpl_options() {
        return orderServiceImpl_options;
    }
    public void setOrderServiceImpl_options(Service.orderServiceImpl_options orderServiceImpl_options) {
        this.orderServiceImpl_options = orderServiceImpl_options;
    }
    public int getPage()
    {
        return page;
    }
    public void setPage(int page)
    {
        this.page = page;
    }

    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
    public String search()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.print(start);
        System.out.print(end);
        PageBean pageBean=orderServiceImpl_options.getPageBean(5,page,start,end);
        request.setAttribute("pageBean", pageBean);
        return "search";
    }
    public String serach()throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        PageBean pageBean = orderService.getPageBean(5, page);
        request.setAttribute("pageBean", pageBean);
        return "serach";
    }

    public String file()throws Exception{
        return "file";
    }



}
