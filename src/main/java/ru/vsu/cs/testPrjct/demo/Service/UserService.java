package ru.vsu.cs.testPrjct.demo.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vsu.cs.testPrjct.demo.Entity.UserEntity;
import ru.vsu.cs.testPrjct.demo.Repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    public void save(UserEntity user) {
        user.setPassword(
                encoder.encode(user.getPassword())
        );
        userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<SimpleGrantedAuthority> roles = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );
        return new User(
                user.getUsername(),
                user.getPassword(),
                roles
        );
    }
}
