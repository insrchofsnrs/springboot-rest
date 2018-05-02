package by.insrch.sdrw.service;

import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @org.springframework.transaction.annotation.Transactional (readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        by.insrch.sdrw.pojo.User user = userRepository.findUserByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication (by.insrch.sdrw.pojo.User user, List<GrantedAuthority> authorities){
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (Role role : roles) {
            setAuths.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<>(setAuths);

        return result;
    }
}
