package notebook.service.authentication;

import notebook.entity.User;
import notebook.factory.SecurityUserInterface;
import notebook.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {
  private final UserService userService;
  private final SecurityUserInterface securityUserInterface;

  @Autowired
  public CustomUserDetailService(UserService userService,
                                 SecurityUserInterface securityUserInterface) {
    this.userService = userService;
    this.securityUserInterface = securityUserInterface;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userService.findUserByEmail(email);

    if (user == null) {
      throw new UsernameNotFoundException(
        "No user found with username: "+ email);
    }

    return securityUserInterface.getConfiguredSecurityUser(user);
  }

}
