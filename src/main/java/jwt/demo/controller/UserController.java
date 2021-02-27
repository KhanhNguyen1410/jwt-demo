package jwt.demo.controller;

import jwt.demo.model.Role;
import jwt.demo.model.User;
import jwt.demo.service.role.IRoleService;
import jwt.demo.service.user.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Log logger = LogFactory.getLog(getClass());

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (!bindingResult.hasFieldErrors()) {
            Role role = iRoleService.findRoleByName("ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (iUserService.checkUser(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                iUserService.save(user);
                return new ResponseEntity<>("new user create successful",HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }
}
