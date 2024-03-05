package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.BranchDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Branch;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl implements BranchDao {

    @Override
    public boolean save(Branch entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Branch branch) {
       Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
       Transaction transaction = session.beginTransaction();

       session.update(branch);

       transaction.commit();
       session.close();
       return true;
    }

    @Override
    public ArrayList<Branch> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Branch");
        nativeQuery.addEntity(Branch.class);
        List<Branch> branches = nativeQuery.list();

        transaction.commit();
        session.close();
        return (ArrayList<Branch>) branches;
    }

    @Override
    public String generateNewId() {
       Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
       Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM Branch ORDER BY id DESC");
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

        Branch branch = session.get(Branch.class,id);
        session.remove(branch);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean validateAdmin(Branch admin) {
        return false;
    }
}
