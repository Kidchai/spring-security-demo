package kidchai.springsecuritydemo.services;

import kidchai.springsecuritydemo.models.User;
import kidchai.springsecuritydemo.security.UserWithDetails;
import kidchai.springsecuritydemo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserWithDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserWithDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new UserWithDetails(user.get());
    }
}
