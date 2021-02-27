package jwt.demo.service.role;

import jwt.demo.model.Role;
import jwt.demo.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IRoleServiceIPL implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Iterable<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return iRoleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return iRoleRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iRoleRepository.deleteById(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return iRoleRepository.findRoleByName(name);
    }
}
