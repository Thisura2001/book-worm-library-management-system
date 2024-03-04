package lk.ijse.Dao;

import lk.ijse.Dto.AdminDto;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Book;

import java.util.ArrayList;

public interface CrudDao <T> extends SuperDao{
    boolean save(T entity);

    boolean update(T book);

    ArrayList<T> getAll();
}
