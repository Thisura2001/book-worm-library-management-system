package lk.ijse.Dao.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.BookDetails;

import java.util.List;

public interface BookDetailsDao extends CrudDao<BookDetails> {
    void markAsReturned(String id);
}
