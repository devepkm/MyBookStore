package devepkm.service.impl;


import devepkm.bean.User;
import devepkm.dao.UserDao;
import devepkm.dao.impl.UserDaoImpl;
import devepkm.service.UserService;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:36
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean signUp(User u) {
        return userDao.saveUser(u);
    }

    @Override
    public boolean login(User u) {
        User t = userDao.verifyUser(u.getUsername(), u.getPassword());
        return t != null;
    }

    @Override
    public boolean isUsernameExits(String username) {
        User t = userDao.queryUserByUsername(username);
        return t != null;
    }
}
