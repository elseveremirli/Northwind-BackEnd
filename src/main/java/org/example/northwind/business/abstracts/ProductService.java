package org.example.northwind.business.abstracts;

import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;
import org.example.northwind.entities.concretes.Product;
import org.example.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	DataResult<List<Product>> getAllSorted();

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getProductsByProductNameAndCategory_CategoryId(String productName, int categoryId);

	DataResult<List<Product>> getProductsByProductNameOrCategory_CategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartingWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
