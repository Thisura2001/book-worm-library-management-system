package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.LoginBo;
import lk.ijse.Dao.Custom.LoginDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.AdminDto;
import lk.ijse.Entity.Admin;

public class LoginBoImpl implements LoginBo {
    LoginDao loginDao = (LoginDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.LOGIN);

    @Override
    public boolean validUser(AdminDto adminDto) {
        return loginDao.validateAdmin(new Admin(adminDto.getUserName(), adminDto.getPassword()));
    }
}
