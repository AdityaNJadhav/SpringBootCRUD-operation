package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Category;
import com.example.demo.repo.CategoryRepository;

@RestController
public class categoryController {

	@Autowired
	private CategoryRepository repository;
	
	 @PostMapping("/categories")
	    public Category saveCategory(@RequestBody Category category) {
		 
	        return repository.save(category);
	    }
	 
	 
	@GetMapping("/categories/cid")
	public Optional<Category> findById(@RequestParam int cid) {
		return repository.findById(cid);
	}

	@GetMapping("/categories/page")
	public void getAll(@RequestParam int page) {
		if(page == 3) {
			List<Category> list = repository.findAll();
			
			for (Category category : list) {
				System.out.println(category);
			}
		}
		
	}
	
	@DeleteMapping("/categories/cid")
	public void deleteById(@RequestParam int cid) {
		repository.deleteById(cid);
		System.out.println("Record Deleted Sucessfully");
		
	}
	
	 @PutMapping("/categories")
	    public Category updaCategory(@RequestBody Category category) {
		 return this.repository.save(category);
	 }
}
