package sampleJAXB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import sampleJAXB.XmlReaderJAXB.TestDataJAXB;

public class XmlReaderDAO {

	public static void readFromXML(Tests xr, XmlReaderJAXB xb) {
		
		List<TestData> tds = new ArrayList<TestData>();
		xr.setGeneral(xb.getGeneral());
		xr.setGeneralBook(xb.getGeneralBook());
		for(TestDataJAXB tdxb : xb.getTestDatas()) {
			TestData td = new TestData();
			td.setBook(tdxb.getBook());
			td.setTittle(tdxb.getTittle());
			td.setCount(tdxb.getCount());
			tds.add(td);
		}
		xr.setTestDatas(tds);
	}
	
	public static void main(String[] args) throws JAXBException {
		
		
		JAXBContext jc = JAXBContext.newInstance(XmlReaderJAXB.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/XmlReader.xml");
        XmlReaderJAXB tests = (XmlReaderJAXB) unmarshaller.unmarshal(xml);
        Tests xr = new Tests();
        readFromXML(xr,tests);
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tests, System.out);		
        
	}

}
