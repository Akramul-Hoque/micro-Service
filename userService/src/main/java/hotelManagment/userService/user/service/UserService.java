package hotelManagment.userService.user.service;

import hotelManagment.userService.user.entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserByUsername(String username);
}
