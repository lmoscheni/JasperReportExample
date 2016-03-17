package ar.com.leandro.reporteria;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@SuppressWarnings("rawtypes")
public class MasterReport {
	private List persons;
	private List dogs;

	public MasterReport(List persons, List dogs) {
		this.persons = persons;
		this.dogs = dogs;
	}

	public JRDataSource getPersons() {
		return new JRBeanCollectionDataSource(this.persons);
	}

	public JRDataSource getDogs() {
		return new JRBeanCollectionDataSource(this.dogs);
	}
	
	public void setPersons(List persons) {
		this.persons = persons;
	}

	public void setDogs(List dogs) {
		this.dogs = dogs;
	}
}
