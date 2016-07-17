package pfc.virtualshopws.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pfc.virtualshopws.entity.Users;

@Repository
public class UsersDaoImpl extends GenericDaoImpl<Users>implements UsersDao {

	@Override
	public Users findUserByUsername(String login) {

		String sqlString = "SELECT u FROM Users u WHERE u.username = ?1";

		Query query = entityManager.createQuery(sqlString, Users.class);

		query.setParameter(1, login);

		return (Users) query.getSingleResult();

	}

	@Override
	public Users findUserByEmail(String login) {

		String sqlString = "SELECT u FROM Users u WHERE u.email = ?1";

		Query query = entityManager.createQuery(sqlString, Users.class);

		query.setParameter(1, login);

		return (Users) query.getSingleResult();

	}

}
