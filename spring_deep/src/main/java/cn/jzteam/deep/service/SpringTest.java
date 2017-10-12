package cn.jzteam.deep.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import cn.jzteam.deep.dao.TaskEntityMapper;
import cn.jzteam.deep.dao.entity.TaskEntity;
import cn.jzteam.deep.util.SpringTransactionUtil;

public class SpringTest {

    private ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private DataSourceTransactionManager transactionManager = ioc.getBean(DataSourceTransactionManager.class);

    public static void main(String[] args) {

        SpringTest spring = new SpringTest();
        TaskEntityMapper mapper = spring.ioc.getBean(TaskEntityMapper.class);
        spring.create(mapper);
    }

    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaskEntityMapper mapper = ioc.getBean(TaskEntityMapper.class);

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

    public void create(TaskEntityMapper mapper) {
//    	// 默认的TransactionDefinition接口实现：传播required，隔离数据库默认repeated_read。
//        TransactionDefinition def = new DefaultTransactionDefinition();
//        // 开启事务
//        TransactionStatus status = transactionManager.getTransaction(def);
    	
    	SpringTransactionUtil.begin();
        try {
            // 操作数据库
            TaskEntity entity = new TaskEntity();
            entity.setTask("first");
            entity.setTime("20171012");
            entity.setUserId(100);
            System.out.println("准备entityaaaa");
            mapper.insert(entity);
            System.out.println("插入entityaaaa");
            
            // 操作数据库
            entity.setDate("20171013");
            System.out.println("准备entity2aaaa");
            mapper.insert(entity);
            System.out.println("执行插入2aaaa");
            
//            insert(mapper);
            
//            System.out.println(1/0);
            
            // 提交事务
            SpringTransactionUtil.commit();
            System.out.println("更新后commitaaa");
        } catch (Exception e) {
            System.out.println("异常回滚aaa");
            e.printStackTrace();
            // 回滚事务
            try {
            	SpringTransactionUtil.rollback();
            } catch (TransactionException e1) {
            }
        }
        return;
    }
    
    
    public void insert(TaskEntityMapper mapper) {
//        TransactionDefinition def = new DefaultTransactionDefinition();
//    	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//    	def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        // 开启事务
//        TransactionStatus status = transactionManager.getTransaction(def);
    	SpringTransactionUtil.begin();
        try {
            // 操作数据库
            TaskEntity entity = new TaskEntity();
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
            
            System.out.println(1/0);
            
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
    

}
