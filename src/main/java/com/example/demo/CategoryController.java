package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryRepository cr;
	
	@GetMapping("/")
	public List<Category>getallCategory(){
		return cr.findAll();
	}
	@PostMapping("/api/category")
	public Category createcat(@RequestBody Category category) {
		return cr.save(category);
	}
	@GetMapping("/api/category/{id}")
	public Category getCatById(@PathVariable int id) {
		return cr.getById(id);
	}
	@PutMapping("/api/category/{id}")
	public Category updatecat(@PathVariable int id, @RequestBody Category catdetails) {
		Category category=cr.getById(id);
		category.setName(catdetails.getName());
		return cr.save(category);
	}
	@DeleteMapping("/api/category/{id}")
	public void deletecat(@PathVariable int id)

}
