package core.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 14章測試 AOP

@Component
@Aspect
public class TestAspect {

	// 鎖定在 login 方法前 類別全名寫法
	@Before("execution(web.member.entity.Member web.member.service.impl.MemberServiceImpl.login(..))")
	public void testBefore() {
		System.out.println("---測試AOP---before---");
	}
	
	// 鎖定在 login 方法後 *寫法
		@Before("execution(* login(..))")
		public void testAfter() {
			System.out.println("---測試AOP---after---");
		}
}
