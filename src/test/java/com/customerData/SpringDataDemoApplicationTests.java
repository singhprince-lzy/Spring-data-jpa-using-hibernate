package com.customerData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.customerData.model.Customer;
import com.customerData.model.Student;
import com.customerData.repository.CustomerRepository;
import com.customerData.repository.StudentRepository;


@SpringBootTest
public class SpringDataDemoApplicationTests {
	
	@Autowired
	CustomerRepository csr;
	
	@Autowired
	StudentRepository sr;
	
//	@Test
//	void createACustomer() {
//		Customer c=new Customer();
//		c.setId(4);
//		c.setEmail("Nikki@gmail.com");
//		c.setName("Bella Hadid Charls");
//		csr.save(c);
//	}
	
	
	@Test
	void testStudentCreate() {
		Student student=new Student();
		student.setFirstName("Loki");
		student.setLastName("Ferguson");
		student.setScore(876);
		
		Student student1=new Student();
		student1.setFirstName("Jaspreet");
		student1.setLastName("Bumrah");
		student1.setScore(776);
		
		Student student2=new Student();
		student2.setFirstName("Saheen");
		student2.setLastName("Afridi");
		student2.setScore(886);
		
		sr.save(student);
		sr.save(student1);
		sr.save(student2);
		
		
	}
	
	
	@Test
	void findByNameTest() {
		System.out.println("FindByName Test Called...");
		csr.findByName("Prince").stream().forEach(System.out::println);
	}
	
	@Test
	void findByNameAndIdTest() {
		System.out.println("FindByNameAndIdCalled....");
		Customer findByNameAndId = csr.findByNameAndId("Prince",0);
		System.out.println(findByNameAndId.getEmail());
	}
	
	@Test
	void findByNameLikeTest() {
		System.out.println("FindByName Like Test called....");
		Pageable pageable= PageRequest.of(0, 5,Sort.by(Order.asc("email")));
		csr.findByNameLike("Prince",pageable).stream().forEach(System.out::println);
	}
	
	@Test
	void findByIdBetweenTest() {
		System.out.println("FindByIdBetween called...");
		csr.findByIdBetween(0,4).stream().forEach(System.out::println);;
	}
	
	@Test
	void pagingFindAllTest() {
		System.out.println("Paging Test");
		Pageable pageable= PageRequest.of(0, 2);
		csr.findAll(pageable).forEach(System.out::println);
	}
	
	@Test
	void sortingFindAllTest() {
		System.out.println("Sorting test called");
		csr.findAll(Sort.by("name","id")).forEach(System.out::println);
	}
	
	@Test
	void pagingAndSorting() {
		System.out.println("Paging and Sorting Test.....");
		Pageable pageable= PageRequest.of(0, 2,Sort.by(Order.asc("name")));
		csr.findAll(pageable).forEach(System.out::println);;
	}
	
	@Test
	void testFindAllStudentJPQL() {
		sr.findAllStudents().stream().forEach(System.out::println);
	}
	
	@Test
	void testfindPartialDataJPQL() {
		sr.findStudentsPartialData().stream().forEach(p->System.out.println(p[0]+"--"+p[1]+"--"+p[2]));
	}
	
	@Test
	void testFindStudentByFNameJPQL() {
		sr.findStudentByFirstName("Loki").stream().forEach(System.out::println);
	}
	
	@Test
	void testFindStudentByScoreBetweenJPQL() {
		sr.findStudentByScoreBetween(876,886).stream().forEach(System.out::println);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void testdeleteByFirstNameJPQL() {
		sr.deleteByFirstName("Loki");
	}
	
	
	
	

}
