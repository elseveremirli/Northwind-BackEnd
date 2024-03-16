package org.example.northwind.business.concretes;

import java.util.List;

import org.example.northwind.business.abstracts.ProductService;
import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;
import org.example.northwind.core.utilities.results.SuccessDataResult;
import org.example.northwind.core.utilities.results.SuccessResult;
import org.example.northwind.dataAccess.abstracts.ProductDao;
import org.example.northwind.entities.concretes.Category;
import org.example.northwind.entities.concretes.Product;
import org.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

		Pageable pageable =  PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());

	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>(productDao.findAll(sort));
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(productDao.getByProductName(productName));
	}

	@Override
	public DataResult<Product> getProductsByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(productDao.getProductsByProductNameAndCategory_CategoryId(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getProductsByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getProductsByProductNameOrCategory_CategoryId(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(productDao.getByCategory_CategoryIdIn(categories));
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Category>>(productDao.getByProductNameContains(productName));
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartingWith(String productName) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartingWith(productName));
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName,categoryId));
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails());
	}


}
