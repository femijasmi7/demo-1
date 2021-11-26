package com.cynnox.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.mdb.repository.BookRepository;
import com.cynnox.demo.model.Book;
import com.mongodb.client.result.UpdateResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookRepository bookrepo;
	
	@Autowired
	private MongoTemplate mt;
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	//get all books 
		@GetMapping("/books")
		public ResponseEntity<List<Book>> getAllBooks(){
			List<Book> books = new ArrayList<Book>();
			books = bookrepo.findAll();
			return new ResponseEntity<>(books,HttpStatus.OK);
		}
	
		//add books
	@PostMapping("/books")
	public ResponseEntity<?> addBooks(@RequestBody Book book){
		Book books = bookrepo.save(
				new Book(book.getId(), book.getName(), book.getPages(), book.getAuthor(), book.getCost()));
		return new ResponseEntity<>(books,HttpStatus.OK);
		
	}

	
	//get books by id
	@GetMapping("/books/id/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		Optional<Book> books = bookrepo.getBookById(id);
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	//get books by cost
	@GetMapping("/books/cost/{cost}")
	public ResponseEntity<?>  getBooksByCost(
			@PathVariable ("cost") Double cost) {
		List<Book> books = bookrepo.getBooksByCost(cost);
		if(!books.isEmpty()) {
			return new ResponseEntity<>(books,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null , HttpStatus.NO_CONTENT);
		}
	}
	
	//get books by page
	@GetMapping("/books/page/{page}")
	public ResponseEntity<List<Book>> getBooksByPages(@PathVariable ("page") int page) {
		List<Book> books = bookrepo.getBooksByPages(page);
		return new ResponseEntity<>(books,HttpStatus.OK);
	}

	
	//get books by author sort by name
	@GetMapping("/books/author/{author}")
	public ResponseEntity<List<Book>> getBooksByPages(@PathVariable ("author") String author) {
		List<Book> books = bookrepo.getBooksByAuthorSortByName(author);
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	

	//get count(books by author)
	@GetMapping("/books/author/count/{author}")
	public ResponseEntity<Integer> getBooksCountByAuthor(@PathVariable ("author") String author) {
		Integer books = bookrepo.getBooksCountByAuthor(author);
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	//display only name and author
		@GetMapping("/books/name/author/{page}")
		public ResponseEntity<List<Book>> getBooksByNameAndAuthor(@PathVariable ("page") int page) {
			List<Book> books = bookrepo.getBookNameAndAuthorByPages(page);
			if(!books.isEmpty()) {
			return new ResponseEntity<>(books,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}
		}
		
		//display all name like
				@GetMapping("/books/likename/{value}")
				public ResponseEntity<List<Book>> searchBooksLike(@PathVariable ("value") String value) {
					List<Book> books = bookrepo.getBooksByAuthorRegEx(value);
					if(!books.isEmpty()) {
					return new ResponseEntity<>(books,HttpStatus.OK);
					}else {
						return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
					}
				}
				
				
		//////////MONGOTEMPLATE///////////////
				
				//display all name like
				@GetMapping("mongotemplate/books")
				public ResponseEntity<List<Book>> searchBooks() {
					//////  List<Book> list = mt.findAll(Book.class);
					  List<Book> list = mt.findAll(Book.class,"Books");  //If collection name & the Entity Class Name are different (case-sensitive)
					  return new ResponseEntity<>(list,HttpStatus.OK);
				}		
				
				
			//update
			//	@PostMapping("mongotemplate/books/update/{id}")
				public ResponseEntity<Book>  updateBooks(@PathVariable ("id") int id) {
					Query query= new Query();
					query.addCriteria(Criteria.where("id").is(id));

					Update update = new Update();
					update.set("cost", 1060.25);
					update.set("name", "Core Java");

					Book list = mt.findAndModify(query, update, Book.class);
					System.out.println("Data Modified");
					
					return new ResponseEntity<>(list , HttpStatus.OK);
					
				}
					
				//update
			//	@PutMapping("mongotemplate/books/update/{id}")
				public ResponseEntity<Book>  updateMultipleBooks(@PathVariable ("id") int id) {
					Query query= new Query();
					query.addCriteria(Criteria.where("id").is(id));

					Update update = new Update();
					update.set("cost", 999.0);
					
					mt.updateMulti(query, update, Book.class);
					Book list = mt.findAndModify(query, update, Book.class);
					System.out.println("Data Modified");
					
					return new ResponseEntity<>(list , HttpStatus.OK);
				}
				
				//update using upsert
				@PutMapping("mongotemplate/books/update/{id}")
				public ResponseEntity<UpdateResult>  updateBooksUsingUpsert(@PathVariable ("id") int id) {
					Query query= new Query();
					query.addCriteria(Criteria.where("id").is(id));
					
					Update update = new Update();
					update.set("cost", 200);
					update.set("name", "one indian girl");
					
					
					UpdateResult list = mt.upsert(query, update, Book.class);
					System.out.println("Data Modified");
					
					return new ResponseEntity<>(list , HttpStatus.OK);
				}
				
				
				
					
				//delete
				@DeleteMapping("mongotemplate/books/delete/{name}")
				public ResponseEntity<	List<Book>>  deleteBooks(@PathVariable ("name") String value) {
					Query query= new Query();
					query.addCriteria(Criteria.where("name").is(value));
					
					List<Book> list =mt.findAllAndRemove(query, Book.class);
					System.out.println("Data Modified");
					
					return new ResponseEntity<>(list , HttpStatus.OK);
				}
				    
				    
}
