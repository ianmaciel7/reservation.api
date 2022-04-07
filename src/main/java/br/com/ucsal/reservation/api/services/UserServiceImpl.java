package br.com.ucsal.reservation.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.reservation.api.models.persistence.User;
import br.com.ucsal.reservation.api.repositories.UserRepository;
import br.com.ucsal.reservation.api.viewModels.UserViewModel;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserViewModel add(UserViewModel userViewModel) throws Exception {

        this.throwIfNull(userViewModel);

        User user = User.parser(userViewModel);
        User addedUser = userRepository.add(user);
        UserViewModel addedUserViewModel = UserViewModel.parser(addedUser);

        return addedUserViewModel;
    }

    @Override
    public UserViewModel update(UserViewModel newUserViewModel) throws Exception {

        User oldUser = this.tryGetUserById(newUserViewModel.getId());

        User newUser = User.parser(newUserViewModel);

        User user = userRepository.update(oldUser, newUser);
        UserViewModel userViewModel = UserViewModel.parser(user);

        return userViewModel;
    }

    @Override
    public void removeById(int userId) throws Exception {
        User user = this.tryGetUserById(userId);
        userRepository.remove(user);
    }

    @Override
    public UserViewModel findById(int userId) throws Exception {
        User user = this.tryGetUserById(userId);

        UserViewModel userViewModel = UserViewModel.parser(user);
        return userViewModel;
    }

    @Override
    public UserViewModel findByUsername(String username) throws Exception {
        User user = this.tryGetUserByUsername(username);

        UserViewModel userViewModel = UserViewModel.parser(user);
        return userViewModel;
    }

    private User tryGetUserById(int userId) throws Exception {
        User user = userRepository.findById(userId);
        this.throwIfNull(user);
        return user;
    }

    private User tryGetUserByUsername(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        this.throwIfNull(user);
        return user;
    }

}
