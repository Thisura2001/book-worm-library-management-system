package lk.ijse.Bo;

import lk.ijse.Bo.Custom.Impl.BookBoImpl;
import lk.ijse.Bo.Custom.Impl.BranchBoImpl;
import lk.ijse.Bo.Custom.Impl.LoginBoImpl;
import lk.ijse.Bo.Custom.Impl.UserBoImpl;

public class BoFactory implements SuperBo{
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getInstance() {
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BOTypes {
       ADMIN,BOOK,BRANCH,USER

    }

    public SuperBo getBO(BOTypes boTypes) {

        switch (boTypes) {

            case ADMIN:
                return new LoginBoImpl();
            case BOOK:
                return new BookBoImpl();
            case BRANCH:
                return new BranchBoImpl();
            case USER:
                return new UserBoImpl();
            default:
                return null;
        }


    }
}
