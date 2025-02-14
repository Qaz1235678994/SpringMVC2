//package app;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//
//import core.util.HibernateUtil;
//import web.member.entity.Member;
//
//// CriteriaExample  範例
//public class TestApp4 {
//	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//	//
//	public static void main(String[] args) {
//		
//		// select NICKNAME, ROLE_ID 
//		// from MEMBER 
//		// where USERNAME = ? and PASSWORD = ?
//		
//		
//		// 第一步 取得物件
//		Session session = sessionFactory.openSession();
//		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Member> cQuery = cBuilder.createQuery(Member.class);
//	
//		// from MEMBER
//		Root<Member> root = cQuery.from(Member.class);
//		
//		// where USERNAME = ? and PASSWORD = ?
//		cQuery.where(
//				cBuilder.and(
//						cBuilder.equal(root.get("username"), "admin"),
//						cBuilder.equal(root.get("password"), "P@ssw0rd")
//						)
//				);
//		
//		// select NICKNAME, ROLE_ID
//		cQuery.multiselect(root.get("nickname"), root.get("roleId"));
//	
//		Query<Member> query = session.createQuery(cQuery);
//		
//		Member member = query.uniqueResult();
//		System.out.println(member.getNickname());
//	}
//}
