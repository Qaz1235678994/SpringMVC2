package web.member.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.pojo.Core;
//import core.util.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "MEMBER")
public class Member extends Core {
	private static final long serialVersionUID = 1062017833925367218L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
//	@Column(name = "ID")
	private Integer id;
//	@Column(name = "USERNAME")
	private String username;
//	@Column(name = "PASSWORD")
	private String password;
//	@Column(name = "NICKNAME")
	private String nickname;
	@Column(insertable = false)
	private Boolean pass;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(insertable = false)
	private String creator;
	@Column(name = "CREATED_DATE", insertable = false)
	private Timestamp createdDate;
	@Column(insertable = false)
	private String updater;
	@Column(name = "LAST_UPDATED_DATE", insertable = false)
	private Timestamp lastUpdatedDate;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private Role role;
	
	// 配合TestApp4 CriteriaExample需要的建構子
	public Member(String nickname, Integer roleId) {
		super();
		this.nickname = nickname;
		this.roleId = roleId;
	}
	
	
//	public static void main(String[] args) {
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	Session session = sessionFactory.openSession();
//	Member members = session.get(Member.class, 4);
//	Role role = members.getRole();
//	System.out.println(role.getName());
//	HibernateUtil.shutdown();
//}
	
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Member member = session.get(Member.class, 4);
////		Gson gson = new Gson();
////		System.out.println(gson.toJson(member));
//		
//		
//		Role role = member.getRole();
//		List<Member> members = role.getMembers();
//		for (Member tmp : members) {
//			System.out.println(tmp.getNickname());
//		}
//		System.out.println(role.getName());
//		HibernateUtil.shutdown();
//	}
	
	

	// 因為引用了lomobk的外掛就不用建構子跟GET SET
//	public Member() {
//	}
//
//	public Member(Integer id, String username, String password, String nickname, Boolean pass, Integer roleId,
//			String creator, Timestamp createdDate, String updater, Timestamp lastUpdatedDate) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.nickname = nickname;
//		this.pass = pass;
//		this.roleId = roleId;
//		this.creator = creator;
//		this.createdDate = createdDate;
//		this.updater = updater;
//		this.lastUpdatedDate = lastUpdatedDate;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getNickname() {
//		return nickname;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//
//	public Boolean getPass() {
//		return pass;
//	}
//
//	public void setPass(Boolean pass) {
//		this.pass = pass;
//	}
//
//	public Integer getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}
//
//	public String getCreator() {
//		return creator;
//	}
//
//	public void setCreator(String creator) {
//		this.creator = creator;
//	}
//
//	public Timestamp getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Timestamp createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getUpdater() {
//		return updater;
//	}
//
//	public void setUpdater(String updater) {
//		this.updater = updater;
//	}
//
//	public Timestamp getLastUpdatedDate() {
//		return lastUpdatedDate;
//	}
//
//	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
//		this.lastUpdatedDate = lastUpdatedDate;
//	}
}
