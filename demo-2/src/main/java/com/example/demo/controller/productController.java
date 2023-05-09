package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Category;
import com.example.demo.dto.Product;
import com.example.demo.repo.ProductRepository;

@RestController
public class productController {

	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
	 
        return repository.save(product);
    }
 
 
@GetMapping("/products/pid")
public Optional<Product> findById(@RequestParam int pid) {
	return repository.findById(pid);
}


@GetMapping("/products/page")
public List<Product> getAll(@RequestParam(value="page", defaultValue="0") 
int page,@RequestParam(value="pageSize") Integer pageSize )
{
	Page<Product>page2= repository.findAll(PageRequest.of(page, pageSize));
	List<Product> pages = page2.getContent();
	return pages;
}

@DeleteMapping("/products/pid")
public void deleteById(@RequestParam int pid) {
	repository.deleteById(pid);
	System.out.println("Record Deleted Sucessfully");
}

@PutMapping("/products")
public Product updaCategory(@RequestBody Product product) {
 return this.repository.save(product);
}
	
}
