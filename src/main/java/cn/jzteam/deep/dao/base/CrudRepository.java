package cn.jzteam.deep.dao.base;


import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * 数据库基本操作。
 */
public interface CrudRepository<T, Q, PK> {

    /**
     * 插入一条记录。
     *
     * @param entity
     * @return
     */
    long insert( T entity);

    /**
     * 根据ID删除记录。
     *
     * @param id
     * @return
     */
    long deleteById(@Param("id") PK id);

    /**
     * 根据ID更新所有不为空的字段。
     *
     * @param entity
     * @return
     */
    long updateById(@Param("entity") T entity);

    /**
     * 根据ID获取指定记录。
     *
     * @param id
     * @return
     */
    T selectById(@Param("id") PK id);
    
    /**
     * 根据ids获取记录列表
     * @param idList
     * @return
     */
    List<T> selectByIds(@Param("list") List<Long> idList);

    /**
     * 根据id锁定记录，用于兼容以前处理。
     *
     * @param id
     * @return
     */
    T selectById_notry(@Param("id") PK id);

    /**
     * 根据条件获取一条记录。
     *
     * @param query
     * @return
     */
    T selectFirstOne(@Param("query") Q query);

    /**
     * 根据条件获取列表。
     *
     * @param query
     * @return
     */
    List<T> selectList(@Param("query") Q query);

    /**
     * 获取满足条件的记录数。
     *
     * @param query
     * @return
     */
    long queryPageCount(@Param("query") Q query);

    /**
     * 获取指定页码的所有记录。
     *
     * @param query
     * @return
     */
    List<T> queryPageList(@Param("query") Q query);

}
