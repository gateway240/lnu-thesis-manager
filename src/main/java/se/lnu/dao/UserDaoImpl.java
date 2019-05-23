package se.lnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.entity.Role;
import se.lnu.entity.User;
import se.lnu.repository.DocumentRepository;
import se.lnu.repository.RoleRepository;
import se.lnu.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        documentRepository.saveAll(user.getDocuments());
        return userRepository.save(user);
    }


}
