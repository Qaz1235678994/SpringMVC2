package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.member.dao.MemberDao;

// 測試是否可以從容器拿出來使用  範例
public class TestApp5 {

	public static void main(String[] args) {
		ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberDao memberDao = iocContainer.getBean(MemberDao.class);
		memberDao.selectAll()
			.forEach(member -> System.out.println(member.getNickname()));
		// 用完要關閉 但是要先轉型成ConfigurableApplicationContext 然後再呼叫close關閉
		((ConfigurableApplicationContext) iocContainer).close();
	}
}
