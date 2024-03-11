package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UserBo extends SuperBo {
    List<UserDto> getAll();

    String generateNewUserID();

    boolean AddUser(UserDto userDto);

    boolean updateUser(UserDto userDto);

    boolean deleteUser(String id);

    ArrayList<UserDto> getAllUnReturnedUsers();

    UserDto searchUser(String id);
}
