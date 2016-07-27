package com.endava.jpa.service.impl;

import com.endava.jpa.criteria.EmployeeCriteria;
import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.model.Project;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	public void insertDepartment() {
		System.out.println("INSERT DEPARTMENT");
		System.out.println("Before change: " + departmentService.findAll());

		Department department = new Department();
		department.setName("HR");
		departmentService.save(department);
		System.out.println("After change: " + departmentService.findAll());
		System.out.println();
	}

	/**
	 * Find a random department
	 */
	public void findDepartment() {
		System.out.println("FIND DEPARTMENT");
		Department department = departmentService.find(1L);
		System.out.println(department);
		System.out.println();
	}

	/**
	 * Find a department by name
	 */
	public void findDepartmentByName() {
		System.out.println("FIND DEPARTMENT BY NAME");
		List<Department> departments = departmentService.find("dev");
		System.out.println(departments);
		System.out.println();
	}

	/**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment() {
		System.out.println("UPDATE DEPARTMENT");
		List<Department> departments = departmentService.find("TEST");

		if (departments.size() > 0) {
			Department department = departments.get(0);
			System.out.println("Before change: " + department);

			department.setName("QA");
			departmentService.update(department);
			System.out.println("After change: " + departmentService.find(department.getId()));
		} else {
			System.out.println("Nothing found");
		}
		System.out.println();
	}


		//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {
		System.out.println("INSERT EMPLOYEE");

		Department department = departmentService.find(1L);
		Employee newEmployee = new Employee();
		newEmployee.setName("Stevie Wonder");
		newEmployee.setBirthday(new Date());
		newEmployee.setDepartment(department);
		newEmployee.setSalary("5000");
		newEmployee.setCity("Cluj Napoca");
		employeeService.save(newEmployee);

		System.out.println("After change: ");
		print(employeeService.findAll());
		System.out.println();
	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){
		System.out.println("EMPLOYEES FROM BUCHAREST, DEV DEPT.");
		List<Department> departments = departmentService.findAll();
		EmployeeCriteria criteria = new EmployeeCriteria();
		criteria.setCity("Bucharest");
		criteria.setDepartment(departments.get(0));

		List<Employee> employees = employeeService.findAllForCriteria(criteria);
		print(employees);
		System.out.println();
	}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

	/**
	 * Method used to clean the database
	 */
	public void cleanUp() {
		System.out.println("CLEANING UP. . .");
		deleteAllProjects();
		deleteAllEmployees();
		deleteAllDepartments();
	}

	/**
	 * Method used to populate the database
	 */
	public void setUp() {
		System.out.println("SETTING UP. . .");

		//Departments
		Department devDepartment = new Department();
		devDepartment.setName("DEV");
		departmentService.save(devDepartment);

		Department amDepartment = new Department();
		amDepartment.setName("AM");
		departmentService.save(amDepartment);

		Department testDepartment = new Department();
		testDepartment.setName("TEST");
		departmentService.save(testDepartment);

		//Employees
		List<Department> departments = departmentService.findAll();

		Employee devEmployee1 = new Employee();
		devEmployee1.setName("John Wayne");
		devEmployee1.setCity("Bucharest");
		devEmployee1.setSalary("4500");
		devEmployee1.setBirthday(new Date());
		devEmployee1.setDepartment(departments.get(0));
		employeeService.save(devEmployee1);

		Employee devEmployee2 = new Employee();
		devEmployee2.setName("Frank Sinatra");
		devEmployee2.setCity("Bucharest");
		devEmployee2.setSalary("6200");
		devEmployee2.setBirthday(new Date());
		devEmployee2.setDepartment(departments.get(0));
		employeeService.save(devEmployee2);

		Employee testEmployee = new Employee();
		testEmployee.setName("Otis Redding");
		testEmployee.setCity("Bucharest");
		testEmployee.setSalary("3900");
		testEmployee.setBirthday(new Date());
		testEmployee.setDepartment(departments.get(1));
		employeeService.save(testEmployee);

		Employee amEmployee = new Employee();
		amEmployee.setName("Nina Simone");
		amEmployee.setCity("Bucharest");
		amEmployee.setSalary("4100");
		amEmployee.setBirthday(new Date());
		amEmployee.setDepartment(departments.get(2));
		employeeService.save(amEmployee);

		//Project
		List<Employee> employees = employeeService.findAll();

		Project project = new Project();
		project.setName("Endava Project");
		project.setDescription("Some Endava project people are working on");
		project.setManager(employees.get(0));
		projectService.save(project);
	}

	private void deleteAllDepartments() {
		List<Department> departments = departmentService.findAll();
		for(Department department : departments) {
			departmentService.delete(department);
		}
	}

	private void deleteAllProjects() {
		List<Project> Projects = projectService.findAll();
		for(Project project : Projects) {
			projectService.delete(project);
		}
	}

	private void deleteAllEmployees() {
		List<Employee> Employees = employeeService.findAll();
		for(Employee employee : Employees) {
			employeeService.delete(employee);
		}
	}

	private void print(Collection<?> collection) {
		for(Object o : collection) {
			System.out.println(o);
		}
	}
}
