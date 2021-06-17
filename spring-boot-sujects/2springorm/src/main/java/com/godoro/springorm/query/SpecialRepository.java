package com.godoro.springorm.query;

import java.util.List;

public interface SpecialRepository {
	
	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin);

}
