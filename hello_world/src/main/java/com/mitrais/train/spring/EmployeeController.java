package com.mitrais.train.spring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	private List<Employee> employees = Arrays.asList(new Employee("0001", "Jefri", "male"), new Employee("0002", "Susi", "female"));
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getEmployee(@RequestParam(value = "gender", defaultValue = "all")
    String gender) {
		List<Employee> listEmp = employees;
		if(gender.toLowerCase().equals("male")) {
			listEmp = listEmp.stream().filter(s -> s.getGender().equals("male")).collect(Collectors.toList());
		} else if(gender.toLowerCase().equals("female")) {
			listEmp = listEmp.stream().filter(s -> s.getGender().equals("female")).collect(Collectors.toList());
		}
    	return listEmp;
    }
	
	@PostMapping("/employees")
	@ResponseBody
    public Employee postHello(@RequestBody Employee message) {

		//employees.add(new Employee(id, name, gender));
    	return message;
    }
	
    @RequestMapping(value="/employees/{message}", method=RequestMethod.GET)
    @ResponseBody
    public  List<Employee> getSpecEmployee(@PathVariable String message) {
    	List<Employee> listEmp = employees;
		listEmp = listEmp.stream().filter(s -> s.getName().toLowerCase().equals(message.toLowerCase())).collect(Collectors.toList());
    	if(listEmp.isEmpty()){
    		throw new EmployeeNotFoundException();
    	}
		return listEmp;
    }
}
