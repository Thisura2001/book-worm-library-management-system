package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.UserDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.User;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User entity) {
       Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
       Transaction transaction = session.beginTransaction();

       session.persist(entity);

       transaction.commit();
       session.close();
       return true;
    }

    @Override
    public boolean update(User book) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(book);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<User> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM User");
        nativeQuery.addEntity(User.class);
        List<User> users = nativeQuery.list();

        transaction.commit();
        session.close();
        return (ArrayList<User>) users;
    }

    @Override
    public String generateNewId() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM User ORDER BY id DESC");
        query.setMaxResults(1);
        List results = query.list();

        transaction.commit();
        session.close();

        return (results.size() == 0) ? null : (String) results.get(0);
    }

    @Override
    public boolean Delete(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class,id);

        session.remove(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean validateAdmin(User admin) {
        return false;
    }
}
