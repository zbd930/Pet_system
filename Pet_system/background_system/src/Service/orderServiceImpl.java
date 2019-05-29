package Service;

import Bean.PageBean;
import Bean.order;
import Dao.DAOImpl;

import java.util.List;

public class orderServiceImpl implements orderService{

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
        @Override

        public PageBean getPageBean(int pageSize, int page)
        {
            PageBean pageBean = new PageBean();

            String hql = "from order";

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
