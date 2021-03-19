//package casestudy.module4.service.user.impl;
//
//import casestudy.module4.model.employee.User;
//import casestudy.module4.repository.employee.UserRepository;
//import casestudy.module4.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void save(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
