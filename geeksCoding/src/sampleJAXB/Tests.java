package sampleJAXB;

import java.util.ArrayList;
import java.util.List;

public class Tests {
	
	private String general;
	private String generalBook;
	
	private List<TestData> testDatas = new ArrayList<>();

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public String getGeneralBook() {
		return generalBook;
	}

	public void setGeneralBook(String generalBook) {
		this.generalBook = generalBook;
	}
	
	public List<TestData> getTestDatas() {
		return testDatas;
	}

	public void setTestDatas(List<TestData> testDatas) {
		this.testDatas = testDatas;
	}
	
}