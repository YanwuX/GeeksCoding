package sampleJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "tests" )
public class XmlReaderJAXB {
	
	@XmlType( propOrder = { "tittle", "book", "count" } )
	public static class TestDataJAXB {
		
		private String tittle;
		private String book;
		private int count;
		
		@XmlElement( name = "tittle" )
		public String getTittle() {
			return tittle;
		}
		public void setTittle(String tittle) {
			this.tittle = tittle;
		}
		@XmlElement( name = "book" )
		public String getBook() {
			return book;
		}
		public void setBook(String book) {
			this.book = book;
		}
		@XmlElement( name = "count" )
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
	}
	
	private String general;
	private String generalBook;
	
	@XmlElement( name = "general" )
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	@XmlElement( name = "general-book" )
	public String getGeneralBook() {
		return generalBook;
	}
	public void setGeneralBook(String generalBook) {
		this.generalBook = generalBook;
	}
	
	private List<TestDataJAXB> testDatas = new ArrayList<TestDataJAXB>();
	
	@XmlElement( name = "test-data" )
	public List<TestDataJAXB> getTestDatas() {
		return testDatas;
	}
	public void setTestDatas(List<TestDataJAXB> testDatas) {
		this.testDatas = testDatas;
	}
	
}
