package devepkm.dao;


import devepkm.bean.User;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:11
 * @Description: CRUD User Table
 */
public interface UserDao {


    /**
     * Checking availability of the username
     * @param username
     * @return User obj if exist, null if not exist
     */
    public User queryUserByUsername(String username);

    /**
     * verify username and password for login
     * @param username
     * @param password
     * @return @return User obj if exist, null if wrong infos
     */
    public User verifyUser(String username, String password);

    /**
     * Save user for Sign Up
     * @param u
     * @return true if success
     */
    public boolean saveUser(User u);
}
