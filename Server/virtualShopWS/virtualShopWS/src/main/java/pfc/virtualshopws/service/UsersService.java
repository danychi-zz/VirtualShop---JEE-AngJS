package pfc.virtualshopws.service;

import java.util.List;

import pfc.virtualshopws.entity.Users;

public interface UsersService {

	public Users findById(Long id);

	public Users update(Users user);

	public Users create(Users user);

	public void delete(Users user);

	public Users findUserByUsername(String username);

	List<Users> findAll();

	public Users findUserByEmail(String email);

}
