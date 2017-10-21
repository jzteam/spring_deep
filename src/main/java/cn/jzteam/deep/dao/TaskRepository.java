package cn.jzteam.deep.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.jzteam.deep.dao.base.CrudRepository;
import cn.jzteam.deep.dao.entity.Task;
import cn.jzteam.deep.dao.entity.TaskQuery;

@Repository
public interface TaskRepository extends CrudRepository<Task, TaskQuery, Integer>{
	
	long deleteTest(@Param("userId") int userId,@Param("deleteFlag")int deleteFlag);
	
	List<Task> selectTest(Map<String,Object> task);//@Param("list")List<Long> ids
	
	List<Task> testMapper(Map<String,Object> task);

}