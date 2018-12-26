package notebook.service.user.getuserbyid;

import notebook.entity.User;

public interface GetUserByIdService {
  User getUserById(long id);
}
