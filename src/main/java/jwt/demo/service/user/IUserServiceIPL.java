package jwt.demo.service.user;

import jwt.demo.model.User;
import jwt.demo.model.UserPrinciple;
import jwt.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserServiceIPL implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iUserRepository.deleteById(id);
    }

    @Override
    public Boolean checkUser(String username) {
        return iUserRepository.findUserByUsername(username) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findUserByUsername(username);
        return UserPrinciple.build(user);
    }
}
