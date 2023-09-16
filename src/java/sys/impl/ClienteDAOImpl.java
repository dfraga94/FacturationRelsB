package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.ClienteDAO;
import sys.modelo.Cliente;
import sys.util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public List<Cliente> select() {
        List<Cliente> clientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        String hql = "FROM Cliente";
        try {
            clientes = session.createQuery(hql).list();
            trans.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
        return clientes;
    }

    @Override
    public void insert(Cliente cliente) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Cliente cliente) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Cliente cliente) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}
