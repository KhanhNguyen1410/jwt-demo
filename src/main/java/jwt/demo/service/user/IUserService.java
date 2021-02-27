package jwt.demo.service.user;

import jwt.demo.model.User;
import jwt.demo.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GeneralService<User>, UserDetailsService {
    Boolean checkUser(String username);
}
