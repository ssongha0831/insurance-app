package com.dayone.insuranceapp.auth;

import com.dayone.insuranceapp.web.domain.User;
import com.dayone.insuranceapp.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException("Not found: " + email)));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getEmail())
                .password(user.get().getPasswordHash())
                .roles(user.get().getRole().name())
                .build();
    }
}
