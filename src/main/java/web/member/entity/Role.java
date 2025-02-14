package web.member.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import core.pojo.Core;
//import core.util.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
// 16-3 1對N 測試
public class Role extends Core{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String name;
		
		
		
		
		// 雙向 多對1
//		@OneToMany(mappedBy = "role")
//		private List<Member> members;
		
		
//		@OneToMany
//		@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
//		private List<Member> members;
//		
//		public static void main(String[] args) {
//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//			Session session = sessionFactory.openSession();
//			Role role = session.get(Role.class, 2);
//			List<Member> members = role.getMembers();
//			for (Member member : members) {
//				System.out.println(member.getNickname());
//			}
//			HibernateUtil.shutdown();
//		}
}
