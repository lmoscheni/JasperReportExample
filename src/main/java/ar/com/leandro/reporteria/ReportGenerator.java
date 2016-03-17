package ar.com.leandro.reporteria;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportGenerator {

	public static void generatePDF(List data, List data2) throws JRException {
		List elementos = new ArrayList<MasterReport>();
		elementos.add(new MasterReport(data, data2));
//		JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("reporteMaestro.jasper");
		JasperReport reporte = JasperCompileManager.compileReport("reporteMaestro.jrxml");

		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(elementos));
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Subreportes.pdf"));
		exporter.exportReport();
		System.out.println("Archivo genereado en el directorio principal del proyecto.");
	}
	
	public static List getPersons(){
		List persons = new ArrayList<Person>();
		persons.add(new Person("Pepe Argento","20/10/70","Masculino"));
		persons.add(new Person("Coky Argento","10/12/90","Masculino"));
		persons.add(new Person("Dardo Fuseneco","15/10/78","Masculino"));
		persons.add(new Person("Mony Argento","02/03/75","Femenino"));
		persons.add(new Person("Pepe Argento","15/06/94","Femenino"));
		persons.add(new Person("Maria Elena Fuseneco","20/10/80","Femenino"));
		
		return persons;
	}
	
	public static List getDogs() {
		List dogs = new ArrayList<Dog>();
		dogs.add(new Dog("Fatiga", "Pepe Argento", "Cualca"));
		dogs.add(new Dog("Poppy", "Maria Elena Fuseneco", "Labrador"));
		dogs.add(new Dog("Sol", "Maria Elena Fuseneco", "Labrador"));
		dogs.add(new Dog("Elena", "Dardo Fuseneco", "Labrador"));
		dogs.add(new Dog("Dalton", "Coky Argento", "Pastor Aleman"));
		dogs.add(new Dog("Tapito", "Mony Argento", "Cualca"));
		return dogs;
	}

	public static void main(String[] args) throws JRException {

		generatePDF(getPersons(),getDogs());
	}
}
