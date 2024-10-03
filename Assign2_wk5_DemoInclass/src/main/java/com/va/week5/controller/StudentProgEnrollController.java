package com.va.week5.controller;

/*
 * Add comments.!-- each class must have.. author date description.. 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.va.week5.model.Student;
import com.va.week5.repo.StudentRepo;

@Controller
public class StudentProgEnrollController {
	

@Autowired
StudentRepo studentRepo;
// sets dependency injection--- for crud methods. 




@RequestMapping("/index")
public String home()
{
return "index";
}

@PostMapping("/studentRegiser")
public @ResponseBody String StudentRegister(
@RequestParam("studentId") int studentId,
@RequestParam("userName") String userName,
@RequestParam("password") String password,
@RequestParam("firstName") String firstName,
@RequestParam("lastName") String lastName,
@RequestParam("address ") String address,
@RequestParam("city") String city,
@RequestParam("postalCode") String postalCode
		)


{
Student student=new Student(studentId,userName,password,firstName,lastName,address,city,postalCode);
studentRepo.save(student);
return "student has been registered..!";
}



}
