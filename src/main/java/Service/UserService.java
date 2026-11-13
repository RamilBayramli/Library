package Service;

import Entity.User;
import auth.RegisterRequest;
import enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final userRepository userRepository;

    public void register(PasswordEncoder passwordEncoder, RegisterRequest request) {
        String hashPass = passwordEncoder.encode(request.getPassword());

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(hashPass);
        user.setRole(Role.USER);

        userRepository.save(user);
    }
}