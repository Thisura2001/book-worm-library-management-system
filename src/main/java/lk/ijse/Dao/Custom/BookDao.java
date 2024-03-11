package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.Book;

public interface BookDao extends CrudDao<Book> {
    Book search(String id);
}
