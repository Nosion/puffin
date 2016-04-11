package dk.security;

import dk.model.UserRole;
import dk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.stream.Collectors;

/**
 * Created by 52947 on 07-04-2016.
 */
@Service
public class LoginService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;


    /**
     * @see UserDetailsService#loadUserByUsername(String)
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        dk.model.User user = userRepository.findOne(username);
        logger.info("UserName " + user.getUsername());

        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());

        return buildUserForAuthentication(user, authorities);
    }


    private User buildUserForAuthentication(dk.model.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        setAuths.addAll(userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRoleName())).collect(Collectors.toList()));

        return new ArrayList<>(setAuths);
    }
}
