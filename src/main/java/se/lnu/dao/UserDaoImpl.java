package se.lnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lnu.entity.User;
import se.lnu.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
