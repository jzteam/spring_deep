package cn.jzteam.deep.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import cn.jzteam.deep.dao.TaskRepository;
import cn.jzteam.deep.dao.entity.Task;
import cn.jzteam.deep.util.SpringTransactionUtil;

public class SpringTest {

    private ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private DataSourceTransactionManager transactionManager = ioc.getBean(DataSourceTransactionManager.class);

    public static void main(String[] args) {

        SpringTest spring = new SpringTest();
        TaskRepository mapper = spring.ioc.getBean(TaskRepository.class);
        spring.create(mapper);
        
//        spring.list(mapper);
//        spring.delete(mapper);
    }

    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaskRepository mapper = ioc.getBean(TaskRepository.class);

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // 进入方法表示开启事务
                try {
                    // 数据库操作
                } catch (Exception e) {
                    // 回滚
                    status.setRollbackOnly();
                }
                // 正常返回则自动提交
            }

        });
    }

    public void create(TaskRepository mapper) {
    	
    	SpringTransactionUtil.begin();
    	Task entity = new Task();
        try {
            // 操作数据库
            entity.setTask("first");
            entity.setTime("20171012");
            entity.setUserId(100);
            long insert2 = mapper.insert(entity);
            System.out.println("插入entity111,insert="+insert2+",id="+entity.getId());
            
            // 操作数据库
            entity.setTime("20171013");
            long insert = mapper.insert(entity);
            System.out.println("执行插入222,insert="+insert+",id="+entity.getId());
            
//            insert(mapper);
            
//            System.out.println(1/0);
            
            // 提交事务
            SpringTransactionUtil.commit();
            System.out.println("更新后commit");
        } catch (Exception e) {
            System.out.println("异常回滚");
            e.printStackTrace();
            // 回滚事务
            try {
            	SpringTransactionUtil.rollback();
            } catch (TransactionException e1) {
            }
        }
        
        System.out.println("entity.id="+entity.getId());
        return;
    }
    
    
    public void insert(TaskRepository mapper) {
//      TransactionDefinition def = new DefaultTransactionDefinition();
//    	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//    	def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        // 开启事务
//        TransactionStatus status = transactionManager.getTransaction(def);
    	SpringTransactionUtil.begin();
        try {
            // 操作数据库
            Task entity = new Task();
            entity.setTask("second");
            entity.setDate("20170912");
            entity.setUserId(100);
            System.out.println("准备entitybbbb");
            mapper.insert(entity);
            System.out.println("插入entitybbbb");
            
            // 操作数据库
            entity.setDate("201709111");
            System.out.println("准备entity2bbbb");
            mapper.insert(entity);
            System.out.println("执行插入2bbbb");
            
//            System.out.println(1/0);
            
            // 提交事务
            SpringTransactionUtil.commit();
            System.out.println("更新后commitbbbb");
        } catch (Exception e) {
            System.out.println("异常回滚bbbb");
            e.printStackTrace();
            // 回滚事务
            try {
            	SpringTransactionUtil.rollback();
            } catch (TransactionException e1) {
            }
        }
        return;
    }
    
    
    public void list(TaskRepository mapper){
    	List<Long> idList = new ArrayList<>();
    	idList.add(3L);
    	idList.add(4L);
    	idList.add(11L);
    	List<Task> selectByIds = mapper.selectByIds(idList);
    	selectByIds.forEach(x->{
    		System.err.println(x.getTask()+"=="+x.getTime());
    	});
    	
    }  
    
    public void delete(TaskRepository mapper){
    	long deleteById = mapper.deleteById(300);
    	System.out.println("删除："+deleteById);
    }

}
