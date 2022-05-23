package pgfsd.login;

import pgfsd.bean.User;

public class LoginService {

    public boolean checkCredentials(User user) {
        return user.getEmail() != null
                && user.getPassword() != null
                && user.getEmail().equalsIgnoreCase("test@test.com")
                && user.getPassword().equals("test");
    }
}
