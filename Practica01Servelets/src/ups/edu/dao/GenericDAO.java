package ups.edu.dao;
import java.util.List;

public interface GenericDAO<T, ID> {

    public void createTable();

    public void create(T entity);

    public T findById(ID id);

    public void update(T entity);

    public void delete(T entity);

    public List<T> find();

	public T read(ID id);
}
