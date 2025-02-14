package web.member.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.config.TestConfig;
import web.member.entity.Member;

// 16-3
// 開頭 打SJUCR叫出SpringJUnit4ClassRunner
@RunWith(SpringJUnit4ClassRunner.class)
// 告訴他組態(我們使用的是JAVA組態)
@ContextConfiguration(classes = TestConfig.class)
// 交易控制
@Transactional
public class MemberServiceTest {
	// 注入
	@Autowired
	private MemberService service;
	
	// 先加上Test告訴這是測試
	@Test
	// 無回傳 開頭test帶回方法名
	public void testlogin( ) {
		Member member = new Member();
		member.setUsername("aaaaaaa");
		member.setPassword("1234567");
		member = service.login(member);
		String nickname = member.getNickname();
		// 判斷檢查是否為"值"
		assertThat(nickname, equalTo("bbbbbbb"));
	}
}
