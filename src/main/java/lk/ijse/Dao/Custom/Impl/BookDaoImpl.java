package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.BookDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Book;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean save(Book entity) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Book book) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(book);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Book> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM Book");
        nativeQuery.addEntity(Book.class);
        List<Book> books = nativeQuery.list();


        transaction.commit();
        session.close();

        return (ArrayList<Book>) books;
    }
}
