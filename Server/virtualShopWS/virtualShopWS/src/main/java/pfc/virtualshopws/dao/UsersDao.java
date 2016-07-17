package pfc.virtualshopws.dao;

import pfc.virtualshopws.entity.Users;

public interface UsersDao extends GenericDao<Users> {

	public Users findUserByUsername(String login);

	public Users findUserByEmail(String login);

}
