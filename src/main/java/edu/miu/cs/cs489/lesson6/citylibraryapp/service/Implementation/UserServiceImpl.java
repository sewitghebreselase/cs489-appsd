package edu.miu.cs.cs489.lesson6.citylibraryapp.service.Implementation;

import edu.miu.cs.cs489.lesson6.citylibraryapp.dao.UserRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.models.Users;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }
}
