//package app;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import core.util.HibernateUtil;
//import web.member.entity.Member;
//
//public class TestApp2 {
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//	public static void main(String[] args) {
//		TestApp2 obj = new TestApp2();
////
//		// 新增
////		Member member = new Member();
////		member.setUsername("U");
////		member.setPassword("P");
////		member.setNickname("N");
////		member.setCreatedDate(new Timestamp(System.currentTimeMillis()));
////		member.setCreator("C");
////		member.setPass(false);
////		member.setRoleId(2);
////
////		Integer id = obj.insert(member);
////		System.out.println(obj);
////		System.out.println(id);
//
//		// 刪除
////		boolean result = obj.deleteById(3);
////		System.out.println(result);
//
//		// 修改
////		Member member = new Member();
////		member.setId(4);
////		member.setPassword("P");
////		member.setNickname("N");
////		System.out.println(obj.updateById(member));
//		
//		// 查詢
//		Member member = obj.selectById(4);
//		System.out.println(member.getId());
//		System.out.println(member.getUsername());
//		System.out.println(member.getNickname());
//		HibernateUtil.shutdown();
//	}
//
//	// 新增方法
//	public Integer insert(Member member) {
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			session.persist(member);
//			transaction.commit();
//			return member.getId();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//	}
//
//	// 刪除方法
//	public boolean deleteById(Integer id) {
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member member = session.get(Member.class, id);
//			session.remove(member);
//			transaction.commit();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return false;
//		}
//	}
//
//	// 修改方法
//	public boolean updateById(Member newMember) {
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member oldMember = session.get(Member.class, newMember.getId());
//
//			final String password = newMember.getPassword();
//			if (password != null && !password.isEmpty()) {
//				oldMember.setPassword(password);
//			}
//
//			final String nickname = newMember.getNickname();
//			if (nickname != null && !nickname.isEmpty()) {
//				oldMember.setNickname(nickname);
//			}
//
//			transaction.commit();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return false;
//		}
//	}
//
//	// 查詢方法
//	public Member selectById(Integer id) {
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member member = session.get(Member.class, id);
//			transaction.commit();
//			return member;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//	}
//}
