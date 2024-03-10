package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {
    List<User> getAllUnReturnedUsers();
}
