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

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setAddress(user.getAddress());
            userDto.setContact(user.getContact());
            userDto.setGender(user.getGender());

            dtos.add(userDto);
        }
        return dtos;
    }

    @Override
    public String generateNewUserID() {
        return userDao.generateNewId();
    }

    @Override
    public boolean AddUser(UserDto userDto) {
        return userDao.save(new User(userDto.getId(), userDto.getName(), userDto.getAddress(), userDto.getContact(), userDto.getGender()));
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        return userDao.update(new User(userDto.getId(), userDto.getName(), userDto.getAddress(), userDto.getContact(), userDto.getGender()));
    }

    @Override
    public boolean deleteUser(String id) {
        return userDao.Delete(id);
    }

    @Override
    public ArrayList<UserDto> getAllUnReturnedUsers() {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.getAllUnReturnedUsers();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setAddress(user.getAddress());
            userDto.setContact(user.getContact());
        }
        return userDtos;
    }

    @Override
    public UserDto searchUser(String id) {
        User user = userDao.search(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAddress(user.getAddress());
        userDto.setContact(user.getContact());
        userDto.setGender(user.getGender());

        return userDto;
    }
}
