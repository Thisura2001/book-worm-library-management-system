package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Dao.Custom.BookDetailsDao;
import lk.ijse.Entity.BookDetails;
import lk.ijse.Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class BookDetailsDaoImpl implements BookDetailsDao {
    @Override
    public List<BookDetails> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query = session.createNativeQuery("SELECT * FROM BookDetails");
        query.addEntity(BookDetails.class);

        List<BookDetails> bookDetails = query.list();

        transaction.commit();
        session.close();
        return bookDetails;
    }
}
