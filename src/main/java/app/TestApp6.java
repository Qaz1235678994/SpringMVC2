package app;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import web.member.dao.MemberDao;

// 測試GenericApplicationContext  範例
public class TestApp6 {

	public static void main(String[] args) {
		GenericApplicationContext container = new GenericApplicationContext();
		  new XmlBeanDefinitionReader(container).loadBeanDefinitions("applicationContext.xml");
		  container.refresh();

		  MemberDao memberDao = container.getBean(MemberDao.class);
		  memberDao.selectAll()
		  	.forEach(member -> System.out.println(member.getNickname()));
		  
		  ((ConfigurableApplicationContext) container).close();
	}
}
