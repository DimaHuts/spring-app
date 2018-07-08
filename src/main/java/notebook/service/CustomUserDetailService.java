package notebook.service;

import notebook.entity.Role;
import notebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {
  private final UserService userService;

  @Autowired
  public CustomUserDetailService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userService.findUserByEmail(email);
    System.out.println(email);

    if (user == null) {
      throw new UsernameNotFoundException(
        "No user found with username: "+ email);
    }

    return new org.springframework.security.core.userdetails.User(
      user.getEmail(), user.getPassword(), getAuthorities(user));
  }

  private Set<GrantedAuthority> getAuthorities(User user){
    Set<GrantedAuthority> authorities = new HashSet<>();

//    for(Role role : user.getRoles()) {
//      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
//      authorities.add(grantedAuthority);
//    }

    return authorities;
  }
}
