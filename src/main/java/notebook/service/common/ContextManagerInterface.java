package notebook.service.common;

import notebook.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public interface ContextManagerInterface {
 User getUserFromContext();

 default UserDetails getPrincipal() {
   return (UserDetails)SecurityContextHolder
     .getContext()
     .getAuthentication()
     .getPrincipal();
 }
}
