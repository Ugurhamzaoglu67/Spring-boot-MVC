package com.ugurhmz.springorm.query;

import java.util.List;

public interface SpecialRepository {

	public List<Supplier> findSupplierTotalDebitMin(double totalDebitMin);
}
