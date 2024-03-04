package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.LoginDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean save(Admin entity) {
        return false;
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
    public boolean ValidAdmin(Admin admin) {
        return false;
    }

//    @Override
//    public boolean ValidAdmin(Admin admin) {
//        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        Admin current_user = session.get(Admin.class, admin.getUserName());
//        if (current_user.getPassword().equals(admin.getPassword())) {
//            return true;
//        }
//        transaction.commit();
//        session.close();
//        return false;
//    }
}
