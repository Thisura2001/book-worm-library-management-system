package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.UserDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.User;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User entity) {
        return false;
    }

    @Override
    public boolean update(User book) {
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
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
}
