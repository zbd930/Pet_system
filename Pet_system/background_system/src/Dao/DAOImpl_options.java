package Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DAOImpl_options
{
    private static SessionFactory sessionFactory;
    /**
     * 通过hql语句得到数据库中记录总数
     */
    public int getAllRowCount(String hql,String start,String end)
    {
        sessionFactory = configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        int allRows = 0;
        try
        {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setString(1, start);
            query.setString(2, end);
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

    public List queryByPage(String hql, int offset, int pageSize,String start,String end)
    {
        sessionFactory =configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List list = null;
        try
        {
            tx = session.beginTransaction();

            Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
            query.setString("start", start);
            query.setString("end",end);
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
        }


        return list;
    }

    private static SessionFactory configureSessionFactory() {
        Configuration configuration =new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
        return sessionFactory;
    }

}
