package core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import core.util.HibernateUtil;

public interface CoreService {
	// 因為這一段都一直重複所以把他提出來
//	private Session getSession( ) {
//		return HibernateUtil.getSessionFactory().getCurrentSession();
//	}
//	
//	// 因為這一段都一直重複所以把他提出來
//	private Transaction getTransaction() {
//		return getSession().getTransaction();
//	}
//
//	// 交易開始
//	default Transaction beginTransaction() {
//		return getSession().beginTransaction();
//	}
//
//	// 送出交易
//	default void commit() {
//		getTransaction().commit();
//	}
//
//	// 返回
//	default void rollback() {
//		getTransaction().rollback();
//	}
}
