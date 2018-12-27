package notebook.service.user.updateuserpassword;

import org.springframework.stereotype.Service;

import notebook.entity.User;
import notebook.service.common.BeanProvider;
import notebook.service.user.getuserbyid.GetUserByIdService;

@Service
public class UpdateUserPasswordServiceImpl implements UpdateUserPasswordService {

	@Override
	public void updateUserPassword(User user) {
		GetUserByIdService getUserByIdService = BeanProvider.getBean(GetUserByIdService.class);

    User userFromDb = getUserByIdService.getUserById(user.getId());

    user.setPassword(userFromDb.getPassword());
	}

}
