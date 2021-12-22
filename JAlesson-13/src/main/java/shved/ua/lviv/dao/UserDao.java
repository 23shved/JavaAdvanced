package shved.ua.lviv.dao;

import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.AbsractCRUD;

public interface UserDao extends AbsractCRUD<User>{
	User readByEmail(String email);

}
