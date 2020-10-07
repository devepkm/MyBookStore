package devepkm.service;


import devepkm.bean.User;

/**
 * @Auther: dev
 * @Date: 20/9/2020 21:32
 * @Description: UserService for sign up, login, checking username availability
 */
public interface UserService {

    public boolean signUp(User u);

    public boolean login(User u);

    public boolean isUsernameExits(String username);

}
