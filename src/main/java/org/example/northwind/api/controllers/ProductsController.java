package org.example.northwind.api.controllers;

import java.util.List;

import org.example.northwind.business.abstracts.ProductService;
import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;
import org.example.northwind.core.utilities.results.SuccessDataResult;
import org.example.northwind.entities.concretes.Category;
import org.example.northwind.entities.concretes.Product;
import org.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return new SuccessDataResult<Product>(productService.getByProductName(productName));
	}

	@GetMapping("/getProductsByProductNameAndCategory_CategoryId")
	public SuccessDataResult<Product> getProductsByProductNameAndCategory_CategoryId(@RequestParam String productName,@RequestParam int categegoryId){
		return new SuccessDataResult<Product>(productService.getProductsByProductNameAndCategory_CategoryId(productName,categegoryId));
	}

	@GetMapping("/getProductsByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getProductsByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId) {
		return new SuccessDataResult<List<Product>>(productService.getProductsByProductNameOrCategory_CategoryId(productName,categoryId));
	}

	@GetMapping("/getByCategory_CategoryIdIn")
	public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(productService.getByCategory_CategoryIdIn(categories));
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return new SuccessDataResult<List<Category>>(productService.getByProductNameContains(productName));
	}

	@GetMapping("/getByProductNameStartingWith")
	public DataResult<List<Product>> getByProductNameStartingWith(@RequestParam String productName) {
		return new SuccessDataResult<List<Product>>(productService.getByProductNameStartingWith(productName));
	}

	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId) {
		return new SuccessDataResult<List<Product>>(productService.getByNameAndCategory(productName,categoryId));
	}



	@GetMapping("/getAllByPage")
	public 	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return new SuccessDataResult(productService.getAll(pageNo,pageSize));
	};

	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return new SuccessDataResult<List<Product>>(productService.getAllSorted());
	}

	@GetMapping("/etProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> etProductWithCategoryDetails(){
		return productService.getProductWithCategoryDetails();
	}
}
