package cn.jzteam.deep.support.mybatisgen;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

/**
 * 代码自动生成工具。
 */
public class GeneratorMain {

    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade genFacade = new GeneratorFacade();
        
        // 打印数据库中的表名称
        // GeneratorFacade.printAllTableNames();

        // 删除生成器的输出目录
        //genFacade.deleteOutRootDir();

        // 设置模版文件所在的路径。
        genFacade.getGenerator().addTemplateRootDir("classpath:/template");

        //通过数据库表生成文件,template为模板的根目录
        genFacade.generateByTable("task");
//        genFacade.generateByTable("admin_bank_record","block_publish_coin");

        // 自动搜索数据库中的所有表并生成文件。
        // genFacade.generateByAllTable();

        // 根据指定的对象类生成文件。
        // genFacade.generateByClass(User.class);

        // 删除生成的文件
        // genFacade.deleteByTable("remit_transaction");

        //打开文件夹
        Runtime.getRuntime().exec("open " + GeneratorProperties.getRequiredProperty("outRoot"));
    }
    
}
