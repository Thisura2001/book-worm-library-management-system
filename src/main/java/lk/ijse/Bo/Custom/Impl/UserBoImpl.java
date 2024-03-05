package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.Custom.UserBo;
import lk.ijse.Dao.Custom.UserDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.UserDto;
import lk.ijse.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {
    UserDao userDao = (UserDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.USER);
    @Override
    public List<UserDto> getAll() {
        ArrayList<UserDto> dtos = new ArrayList<>();
        ArrayList<User> users = userDao.getAll();

        for (User user:users){
            dtos.add(new UserDto(user.getId(),user.getName(),user.getAddress(),user.getContact(),user.getGender()));
        }
        return dtos;
    }

    @Override
    public String generateNewUserID() {
        return userDao.generateNewId();
    }

    @Override
    public boolean AddUser(UserDto userDto) {
        return userDao.save(new User(userDto.getId(),userDto.getName(),userDto.getAddress(),userDto.getContact(),userDto.getGender()));
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        return userDao.update(new User(userDto.getId(),userDto.getName(),userDto.getAddress(),userDto.getContact(),userDto.getGender()));
    }

    @Override
    public boolean deleteUser(String id) {
        return userDao.Delete(id);
    }
}
