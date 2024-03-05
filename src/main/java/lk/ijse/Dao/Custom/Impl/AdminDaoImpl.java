package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.AdminDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean save(Admin entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Admin book) {
        return false;
    }

    @Override
    public ArrayList<Admin> getAll() {
        return null;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public boolean Delete(String id) {
        return false;
    }

    @Override
    public boolean validateAdmin(Admin admin) {
        return false;
    }
}
