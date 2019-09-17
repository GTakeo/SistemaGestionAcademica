package pe.com.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ArchivoUtil {

	public static File obtenerArchivoDelProyecto(String rutaRealArchivo){
		File archivo = null;
		try{
			archivo = new File(obtenerRutaAbsolutaArchivo(rutaRealArchivo));
		}catch(Exception e){
			e.printStackTrace();
		}
		return archivo;
	}
	
	/**
	 * Obtiene la ruta absoluta a partir de una ruta relativa de archivo.
	 */
	public static String obtenerRutaAbsolutaArchivo(String rutaRelativa) {
		String rutaAbsoluta = null;
		try{
			rutaAbsoluta =  FacesContext.getCurrentInstance().getExternalContext().getRealPath(rutaRelativa);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rutaAbsoluta;
	}
	
	/**
	 * Obtiene solo el nombre del archivo de la ruta donde se ubica el archivo
	 * que se esta subiendo
	 * 
	 * @param rutaConNombre
	 * @return
	 */
	public static String obtenerNombreDeArchivo(String rutaConNombre) {
		String nombreArchivo = null;
		if (rutaConNombre != null) {
			int indiceDelUltimoSlash = rutaConNombre.lastIndexOf("\\");
			nombreArchivo = rutaConNombre.substring(indiceDelUltimoSlash + 1,
					rutaConNombre.length());
		}
		return nombreArchivo;
	}

	public static StreamedContent convertirAStreamed(byte[] archivo,
			String nombreArchivo) {
		StreamedContent streamedContent = null;
		if (archivo != null) {
			InputStream is = new ByteArrayInputStream(archivo);
			streamedContent = new DefaultStreamedContent(is, null,
					nombreArchivo);
		}
		return streamedContent;
	}
	
	public static void prepararArchivo(JasperPrint jasperPrint,JasperPrint jasperPrint2, String nombreArchivo, String extensionArchivo){ 
		String outFileName = "C:/ProyectoSGA/DocumentosGenerados/" + nombreArchivo + extensionArchivo;
        SimpleOutputStreamExporterOutput simpleOutputStreamExporterOutput = null;
        JRPdfExporter exporter = null;
        try {
        	
        	exporter = new JRPdfExporter();
            simpleOutputStreamExporterOutput = new SimpleOutputStreamExporterOutput(outFileName);
            
            List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
            
            jasperPrintList.add(jasperPrint);
            jasperPrintList.add(jasperPrint2);
            
            exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
            exporter.setExporterOutput(simpleOutputStreamExporterOutput);
            exporter.exportReport();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (simpleOutputStreamExporterOutput != null) {
                simpleOutputStreamExporterOutput.close();
            }
        }
	}
}
