package Dao;

import Bean.employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DAOImpl implements DAO
{
        private static SessionFactory sessionFactory;
        private static ServiceRegistry serviceRegistry;
    /**
     * 通过hql语句得到数据库中记录总数
     */
    @Override
    public int getAllRowCount(String hql)
    {
        sessionFactory = configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        int allRows = 0;
        try
        {
            tx = session.beginTransaction();

            Query query = session.createQuery(hql);

            allRows = query.list().size();

            tx.commit();

        }
        catch (Exception e)
        {
            if(tx != null)
            {
                tx.rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            session.close();
        }

        return allRows;
    }
    /**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
    @SuppressWarnings("unchecked")
    @Override
    public List queryByPage(String hql, int offset, int pageSize)
    {
        sessionFactory =configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List list = null;
        try
        {
            tx = session.beginTransaction();

            Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);

            list = query.list();

            tx.commit();

        }
        catch (Exception e)
        {
            if(tx != null)
            {
                tx.rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }


        return list;
    }

    public void delete_employee(String hql,int id){
        sessionFactory =configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try
        {
            Query query=session.createQuery(hql);

            query.setInteger(0,id);

            query.executeUpdate();

            session.beginTransaction().commit();

        }
        catch (Exception e)
        {
            if(tx != null)
            {
                tx.rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            session.close();
            sessionFactory.close();
        }
    };
    public void add_employee(employee employee){
        sessionFactory=configureSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            session.save(employee);
            tx.commit();
        }
        catch (Exception e)
        {
            if(tx != null)
            {
                tx.rollback();
            }

            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
    public  void add_pic(String myFileFileName, int ID){
        Configuration cf=new Configuration();
        SessionFactory sf=cf.configure().buildSessionFactory();
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();

        String hql="update employee as e set e.photo=? where e.ID=?";
        SQLQuery query = s.createSQLQuery(hql);
        query.setString(0,myFileFileName);
        query.setInteger(1,ID);
        int result = query.executeUpdate();
        t.commit();
        s.close();
        sf.close();
        System.out .print("影响了"+result);
    }
    private static SessionFactory configureSessionFactory() {
        Configuration configuration =new Configuration();
        configuration.configure();
        serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}