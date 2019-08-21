package vn.dvg.openfire.plugins.autoportal.data.dao;

import vn.dvg.openfire.plugins.autoportal.data.dto.BaseDto;
import vn.dvg.openfire.plugins.autoportal.data.dto.BaseEntity;

public interface BaseDao<T extends BaseEntity<TId>, TId> {
    T getById(TId id);
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
