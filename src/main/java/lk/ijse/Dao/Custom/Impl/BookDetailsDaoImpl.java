package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Dao.Custom.BookDetailsDao;
import lk.ijse.Entity.BookDetails;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDetailsDaoImpl implements BookDetailsDao {
    @Override
    public boolean save(BookDetails entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(BookDetails book) {
        return false;
    }

    @Override
    public ArrayList<BookDetails> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query = session.createNativeQuery("SELECT * FROM BookDetails");
        query.addEntity(BookDetails.class);

        List<BookDetails> bookDetails = query.list();

        transaction.commit();
        session.close();
        return (ArrayList<BookDetails>) bookDetails;
    }

    @Override
    public String generateNewId() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM BookDetails ORDER BY id DESC");
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

        BookDetails bookDetails = new BookDetails();
        bookDetails.setId(id);

        session.remove(bookDetails);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean validateAdmin(BookDetails admin) {
        return false;
    }

    @Override
    public void markAsReturned(String id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        BookDetails bookDetails = session.get(BookDetails.class, id);

        bookDetails.setStatus("Returned");

        session.update(bookDetails);

        transaction.commit();
        session.close();
    }
}
