package Dao;

import Bean.employee;
import Bean.order;

import java.util.List;

public interface DAO
{
    public List<order> queryByPage(String hql, int offset, int pageSize);

    public int getAllRowCount(String hql);
    public void delete_employee(String hql,int id);
    public void add_employee(employee employee);
    public  void add_pic(String myFileFileName, int ID);

}