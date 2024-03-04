package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Dao.SuperDao;
import lk.ijse.Entity.Admin;

public interface LoginDao extends CrudDao<Admin> {
    boolean ValidAdmin(Admin admin);
}
