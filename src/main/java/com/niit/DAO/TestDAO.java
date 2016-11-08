package com.niit.DAO;

import java.util.List;

import com.niit.model.Test;

public interface TestDAO {

	void saveOrUpdateTest(Test test);
	
	void delete(String testId);
	
	Test getTest(String testId);
	
	List<Test> listTest();
}
