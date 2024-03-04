package lk.ijse.Bo;

import lk.ijse.Bo.Custom.Impl.*;

public class BoFactory implements SuperBo{
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getInstance() {
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BOTypes {
       ADMIN,BOOK,BRANCH,USER,LOGIN

    }

    public SuperBo getBO(BOTypes boTypes) {

        switch (boTypes) {

            case LOGIN:
                return new LoginBoImpl();
            case BOOK:
                return new BookBoImpl();
            case BRANCH:
                return new BranchBoImpl();
            case USER:
                return new UserBoImpl();
            case ADMIN:
                return new AdminBoImpl();
            default:
                return null;
        }


    }
}
