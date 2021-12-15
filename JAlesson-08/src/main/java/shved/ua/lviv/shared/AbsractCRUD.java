package shved.ua.lviv.shared;

import java.util.List;

public interface AbsractCRUD<T> {

	T create(T t);

	T read(Integer t);

	T update(T t);

	void delete(Integer t);

	List<T> readAll();
}
