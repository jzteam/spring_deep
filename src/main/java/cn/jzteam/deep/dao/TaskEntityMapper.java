package cn.jzteam.deep.dao;

import cn.jzteam.deep.dao.entity.TaskEntity;
import cn.jzteam.deep.dao.entity.TaskEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskEntityMapper {
    long countByExample(TaskEntityExample example);

    int deleteByExample(TaskEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskEntity record);

    int insertSelective(TaskEntity record);

    List<TaskEntity> selectByExample(TaskEntityExample example);

    TaskEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    int updateByExample(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    int updateByPrimaryKeySelective(TaskEntity record);

    int updateByPrimaryKey(TaskEntity record);
}