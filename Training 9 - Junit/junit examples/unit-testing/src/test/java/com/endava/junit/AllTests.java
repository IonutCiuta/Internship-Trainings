package com.endava.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.endava.junit.process.EmployeeProcessorTestCase;
import com.endava.junit.read.EmployeeReaderTestCase;
import com.endava.junit.services.EmployeeServiceTestCase;
import com.endava.junit.write.EmployeeWriterTestCase;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeProcessorTestCase.class, EmployeeReaderTestCase.class,
		EmployeeServiceTestCase.class, EmployeeWriterTestCase.class })
public class AllTests {

}
