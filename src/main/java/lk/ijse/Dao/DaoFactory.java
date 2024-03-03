package lk.ijse.Dao;

import lk.ijse.Bo.Custom.Impl.BookBoImpl;
import lk.ijse.Bo.Custom.Impl.BranchBoImpl;
import lk.ijse.Bo.Custom.Impl.LoginBoImpl;
import lk.ijse.Bo.Custom.Impl.UserBoImpl;
import lk.ijse.Dao.Custom.Impl.BookDaoImpl;
import lk.ijse.Dao.Custom.Impl.BranchDaoImpl;
import lk.ijse.Dao.Custom.Impl.LoginDaoImpl;
import lk.ijse.Dao.Custom.Impl.UserDaoImpl;

public class DaoFactory implements SuperDao{
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOTypes {
        ADMIN,BOOK,BRANCH,USER
    }

    public SuperDao getDAO(DAOTypes daoTypes) {

        switch (daoTypes) {

            case ADMIN:
                return new LoginDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            case BRANCH:
                return new BranchDaoImpl();
            case USER:
                return new UserDaoImpl();
            default:
                return null;
        }
    }
}
