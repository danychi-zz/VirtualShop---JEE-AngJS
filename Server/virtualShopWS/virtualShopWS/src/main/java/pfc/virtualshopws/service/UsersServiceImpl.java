package pfc.virtualshopws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfc.virtualshopws.dao.UsersDao;
import pfc.virtualshopws.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public Users findById(Long id) {
		return usersDao.find(id);
	}

	@Override
	public List<Users> findAll() {
		return usersDao.findAll();
	}

	@Override
	public Users update(Users user) {
		return usersDao.update(user);
	}

	@Override
	public Users create(Users user) {
		return usersDao.create(user);
	}

	@Override
	public void delete(Users user) {
		usersDao.delete(user.getUserId());

	}

	@Override
	public Users findUserByUsername(String username) {
		return usersDao.findUserByUsername(username);
	}

	@Override
	public Users findUserByEmail(String email) {
		return usersDao.findUserByEmail(email);
	}

}
