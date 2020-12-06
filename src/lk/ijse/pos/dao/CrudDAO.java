package lk.ijse.pos.dao;

import lk.ijse.pos.entity.SuperEntity;

import java.util.ArrayList;

public interface CrudDAO<ID,T extends SuperEntity> extends SuperDAO{ // K
    public boolean save(T t) throws Exception;
    public boolean delete(ID id) throws Exception;
    public boolean update(T t) throws Exception;
    public T get(ID id) throws Exception;
    public ArrayList<T> getAll() throws Exception;
}
