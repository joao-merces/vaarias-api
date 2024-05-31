package br.com.vaariasweb.vaarias;


import br.com.vaariasweb.vaarias.entities.User;
import br.com.vaariasweb.vaarias.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }
}