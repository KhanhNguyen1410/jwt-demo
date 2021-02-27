package jwt.demo.service.role;

import jwt.demo.model.Role;
import jwt.demo.service.GeneralService;

public interface IRoleService extends GeneralService<Role> {
    public Role findRoleByName(String name);
}
