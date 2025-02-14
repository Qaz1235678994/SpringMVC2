//package app;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import core.util.HibernateUtil;
//import web.member.entity.Member;
//
//// HQLExample SELECT敘述範例
//public class TestApp3 {
//	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//	// 多筆
////	public static void main(String[] args) {
////		Session session = sessionFactory.openSession();
////		Query<Member> query = session.createQuery("FROM Member", Member.class);
////		List<Member> list = query.getResultList();
////		list.forEach(member -> {
////			System.out.println(member.getNickname());
////		});
////	}
//	
//	// 單欄
////	public static void main(String[] args) {
////		Session session = sessionFactory.openSession();
////		// 要注意 SELECT 的屬性名要跟Member的一樣所以要注意大小寫
////		Query<String> query = session.createQuery("SELECT nickname FROM Member", String.class);
////		List<String> list = query.getResultList();
////		list.forEach(nickname -> {
////			System.out.println(nickname);
////		});
////	}
//	
//	// 多屬性多筆
////	public static void main(String[] args) {
////		Session session = sessionFactory.openSession();
////		// 要注意 SELECT 的屬性名要跟Member的一樣所以要注意大小寫
////		Query<Object[]> query = session.createQuery("SELECT username, password FROM Member", Object[].class);
////		List<Object[]> list = query.getResultList();
////		list.forEach(row -> {
////			System.out.println(row[0] + "\t" + row[1]);
////		});
////	}
//	
//	// 單筆
//	public static void main(String[] args) {
//		Session session = sessionFactory.openSession();
//		// 要注意 SELECT 的屬性名要跟Member的一樣所以要注意大小寫
//		Member member = session
//				.createQuery("FROM Member WHERE id = 1", Member.class)
//				.uniqueResult();
//		
//		System.out.println(member.getNickname());
//	}
//	
//	// 單筆測試unidqueResult
////		public static void main(String[] args) {
////			Session session = sessionFactory.openSession();
////			// 要注意 SELECT 的屬性名要跟Member的一樣所以要注意大小寫
////			Member member = session
////					.createQuery("FROM Member WHERE id = 11", Member.class)
////					.uniqueResult();
////			
////			System.out.println(member.getNickname());
////		}
//}
