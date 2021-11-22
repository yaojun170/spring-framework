package cn.yj.demo;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @Description
 * @Author yaojun
 * @Date 2020-10-30
 */
public class TestBeanDefinitionReader {
    public static void main(String[] args) {
        //创建一个简单注册器
        BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();
        //创建bean定义读取器
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(register);
        // 创建资源读取器
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        // 获取资源
        Resource xmlResource = resourceLoader.getResource("appContext-my.xml");
        // 装载Bean的定义
        reader.loadBeanDefinitions(xmlResource);
        // 打印构建的Bean 名称
        String[] beanDefinitionNames = register.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("-------------");
        System.out.println(register.getBeanDefinition("student").toString());


    }
}
