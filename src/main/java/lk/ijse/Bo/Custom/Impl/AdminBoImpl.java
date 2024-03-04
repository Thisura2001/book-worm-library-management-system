package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.Custom.AdminBo;
import lk.ijse.Dao.Custom.AdminDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Admin;

public class AdminBoImpl implements AdminBo {
    AdminDao adminDao = (AdminDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.ADMIN);
    @Override
    public boolean RegisterAdmin(String userName, String password) {
        return adminDao.save(new Admin(userName, password));
    }
}
