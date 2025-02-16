package web.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoImpl;
import web.member.entity.Member;
import web.member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao dao;
	
	// 已改用注入不需要自己實力化
//	public MemberServiceImpl() {
//		dao = new MemberDaoImpl();
//	}
	
	@Override
	public Member register(Member member) {
		if (member.getUsername() == null) {
			member.setMessage("使用者名稱未輸入");
			member.setSuccessful(false);
			return member;
		}
		
		if (member.getPassword() == null) {
			member.setMessage("密碼未輸入");
			member.setSuccessful(false);
			return member;
		}
		
		if (member.getNickname() == null) {
			member.setMessage("暱稱未輸入");
			member.setSuccessful(false);
			return member;
		}
		
		try {
//			beginTransaction();
			if (dao.selectByUsername(member.getUsername()) != null) {
				member.setMessage("使用者名稱重複");
				member.setSuccessful(false);
//				rollback();
				return member;
			}
			
			member.setRoleId(2);
			final int resultCount = dao.insert(member);
			if (resultCount < 1) {
				member.setMessage("註冊錯誤，請聯絡管理員!");
				member.setSuccessful(false);
//				rollback();
				return member;
			}
			
			member.setMessage("註冊成功");
			member.setSuccessful(true);
//			commit();
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			member.setMessage("註冊錯誤，請聯絡管理員!");
			member.setSuccessful(false);
//			rollback();
			return member;
		}
	}

	@Override
	public Member login(Member member) {
		final String username = member.getUsername();
		final String password = member.getPassword();
		
		if (username == null) {
			member.setMessage("使用者名稱未輸入");
			member.setSuccessful(false);
			return member;
		}
		
		if (password == null) {
			member.setMessage("密碼未輸入");
			member.setSuccessful(false);
			return member;
		}
		
		member = dao.selectForLogin(username, password);
		if (member == null) {
			member = new Member();
			member.setMessage("使用者名稱或密碼錯誤");
			member.setSuccessful(false);
			return member;
		}
		
		member.setMessage("登入成功");
		member.setSuccessful(true);
		return member;
	}

	@Override
	public Member edit(Member member) {
		final Member oMember = dao.selectByUsername(member.getUsername());
		member.setPass(oMember.getPass());
		member.setRoleId(oMember.getRoleId());
		member.setUpdater(member.getUsername());
		final int resultCount = dao.update(member);
		member.setSuccessful(resultCount > 0);
		member.setMessage(resultCount > 0 ? "修改成功" : "修改失敗");
		return member;
	}

	@Override
	public List<Member> findAll() {
		return dao.selectAll();
	}

	@Override
	public boolean remove(Integer id) {
		try {
//			beginTransaction();
			boolean result = dao.deleteById(id) > 0;
//			commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
//			rollback();
			return false;
		}
	}

	@Override
	public boolean save(Member member) {
		return dao.update(member) > 0;
	}
}
