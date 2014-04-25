package br.com.gardenstation.core.manager;

import java.io.Serializable;

public interface Manager<T, I extends Serializable> {

	public T persist(T entity);

	public T save(T entity);

    public T merge(T entity);

    public void remove(T entity);

    public T findById(Integer id);
}
