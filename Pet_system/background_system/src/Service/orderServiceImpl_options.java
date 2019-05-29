package Service;

import Bean.PageBean;
import Bean.order;
import Dao.DAOImpl_options;

import java.util.List;

public class orderServiceImpl_options {

    private DAOImpl_options DAOImpl_options;

    public Dao.DAOImpl_options getDAOImpl_options() {
        return DAOImpl_options;
    }

    public void setDAOImpl_options(Dao.DAOImpl_options DAOImpl_options) {
        this.DAOImpl_options = DAOImpl_options;
    }

    /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */

    public PageBean getPageBean(int pageSize, int page,String start,String end)
    {
        PageBean pageBean = new PageBean();

        String hql = "from order where order_date>:start and order_date<:end";

        int allRows = DAOImpl_options.getAllRowCount(hql,start,end);

        int totalPage = pageBean.getTotalPages(pageSize, allRows);

        int currentPage = pageBean.getCurPage(page);

        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);

        List<order> list = DAOImpl_options.queryByPage(hql, offset, pageSize,start,end);

        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
