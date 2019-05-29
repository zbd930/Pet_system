package Service;

import Bean.PageBean;
import Bean.employee;
import Bean.order;
import Dao.DAOImpl;

import java.util.List;

public class employeeservice {
    private DAOImpl DAO ;

    public DAOImpl getDAO() {
        return DAO;
    }

    public void setDAO(DAOImpl DAO) {
        this.DAO = DAO;
    }

    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
    public void delte(int id){
        String hql="delete employee as e where e.id=?";
        DAO.delete_employee(hql,id);
    }
    public void add(employee employee){
        DAO.add_employee(employee);
    }
    public  void add_pic(String photo,int ID){
        DAO.add_pic(photo,ID);
    }
    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();

        String hql = "from employee";

        int allRows = DAO.getAllRowCount(hql);

        int totalPage = pageBean.getTotalPages(pageSize, allRows);

        int currentPage = pageBean.getCurPage(page);

        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

        List<order> list = DAO.queryByPage(hql, offset, pageSize);

        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

}
