package pfc.virtualshopws.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext(unitName = "restPersistenceDialect")
	public EntityManager entityManager;

	private Class<T> type;

	public GenericDaoImpl() {// particulariza la clase que se va a manejar
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("SELECT t from " + type.getTypeName() + " t").getResultList();
	}

	@Override
	public T create(final T t) {
		this.entityManager.detach(t);
		this.entityManager.persist(t);
		this.entityManager.flush();
		return t;
	}

	@Override
	public void delete(final Object id) {
		this.entityManager.remove(this.entityManager.getReference(type, id));
	}

	@Override
	public T find(final Object id) {
		return (T) this.entityManager.find(type, id);
	}

	@Override
	public T update(final T t) {
		T out = this.entityManager.merge(t);
		this.entityManager.flush();
		return out;
	}

}
