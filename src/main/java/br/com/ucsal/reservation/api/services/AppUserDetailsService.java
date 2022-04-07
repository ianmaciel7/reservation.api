package br.com.ucsal.reservation.api.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.models.persistence.User;
import br.com.ucsal.reservation.api.repositories.UserRepository;
import br.com.ucsal.reservation.api.viewModels.UserViewModel;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        AppUserDetails appUserDetails = new AppUserDetails(user.getUserName(), user.getPassword(),
                authorities(user.getPermissions()));
        return appUserDetails;
    }

    private Collection<? extends GrantedAuthority> authorities(List<String> permissions) {
        Collection<GrantedAuthority> auths = new ArrayList<>();

        for (String p : permissions) {
            auths.add(new SimpleGrantedAuthority(p));
        }

        return auths;
    }
}
