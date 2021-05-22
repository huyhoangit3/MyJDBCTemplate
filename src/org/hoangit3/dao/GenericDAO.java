package org.hoangit3.dao;

import org.hoangit3.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    void update(String sqlQuery, Object... params);

    List<T> query(String sqlQuery, RowMapper<T> rowMapper, Object... params);

    int save(String sqlQuery, Object... params);
}
