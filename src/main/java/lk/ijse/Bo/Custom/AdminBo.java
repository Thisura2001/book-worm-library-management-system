package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;

public interface AdminBo extends SuperBo {
    boolean RegisterAdmin(String userName, String password);
}
