package pgfsd.services.login;

import pgfsd.dto.User;

public class LoginService {

    public boolean checkCredentials(User user) {
        return user.getEmail() != null
                && user.getPassword() != null
                && user.getEmail().equalsIgnoreCase("test@test.com")
                && user.getPassword().equals("test");
    }
}
