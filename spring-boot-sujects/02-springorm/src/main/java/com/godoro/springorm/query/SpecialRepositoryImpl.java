package com.godoro.springorm.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

//JPA yontemleri ile yazdigimiz klasik Repository islemleri..
@Repository
public class SpecialRepositoryImpl implements SpecialRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin) {
		String jpql = "select s from Supplier s where s.totalDebit >= :totalDebitMin";
		TypedQuery<Supplier> typedQuery = entityManager.createQuery(jpql, Supplier.class);
		typedQuery.setParameter("totalDebitMin", totalDebitMin);
		return typedQuery.getResultList();
	}

}
