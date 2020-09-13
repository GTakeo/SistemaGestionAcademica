package pe.com.presentacion.controlador;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;

@Controller("fileBean")
public class FileBean {
     
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
  
    public void upload() {
    	System.out.println("Entro");
        if (file != null) {
        	InputStream input = null;
        	OutputStream output = null;
        	try {
        	String filename = FilenameUtils.getName(file.getFileName());
        	input = file.getInputstream();
            output = new FileOutputStream(new File("C:/ProyectoSGA/DocumentosCargados/", filename));

			IOUtils.copy(input, output);
			} catch (Exception e) {
				e.printStackTrace();
		    } finally {
		           IOUtils.closeQuietly(input);
		           IOUtils.closeQuietly(output);
		    }
        	
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
          
    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println(event.getFile().getFileName());
    	PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Archivo recibido");
    }
}