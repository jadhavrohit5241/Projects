package com.te.pcmjwt.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class DepartmentsTest {
	private Departments departments = new Departments(12, "cc", new ArrayList<Products>(), new ArrayList<Categories>(),
			new ArrayList<Employee>());

	@Disabled   //TO SKIP THE TEST OR DISABLED THE TEST
	@BeforeEach
	public void beforeEachMethod() {
		System.out.println("before each test");

	}

	
	@Test
	void testGetDepartmentId() {
//		fail("Not yet implemented"); // TODO
		assertNotNull(departments);
		assertEquals(12,departments.getDepartmentId());
	}

	@Disabled
	@Test
	void testGetDepartmentTitle() {
//		fail("Not yet implemented"); // TODO
		
		assertNotNull(departments);
		assertEquals("cc",departments.getDepartmentTitle());
	}

	@Disabled
	@Test
	void testGetProductList() {
//		fail("Not yet implemented"); // TODO
	}

	@Disabled
	@Test
	void testGetCategoryList() {
	//	fail("Not yet implemented"); // TODO
	}

	@Disabled
	@Test
	void testGetEmployees() {
	//	fail("Not yet implemented"); // TODO
	}

	@Disabled
	@AfterEach
	public void afterEach() {
	System.out.println("done ");
	}

	
	@EnabledOnJre(value = JRE.JAVA_8)      //condiatioal annotation for perfroming test 
	@EnabledOnOs(value = OS.WINDOWS,disabledReason = "REASON IF U HAVE")
	@DisplayName("GROUP TESTNAME:-")     //PROVIDE NAME TO TEST
	@Test
	 void groupTest() {
		assertAll("USER PROPERTIES TEST",
				() -> assertEquals(12, departments.getDepartmentId()),
				() -> assertEquals("cc", departments.getDepartmentTitle()));
	}

}
