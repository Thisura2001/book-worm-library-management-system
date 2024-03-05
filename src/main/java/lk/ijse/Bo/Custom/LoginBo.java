package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dto.AdminDto;

public interface LoginBo extends SuperBo {

    boolean validUser(AdminDto adminDto);
}
