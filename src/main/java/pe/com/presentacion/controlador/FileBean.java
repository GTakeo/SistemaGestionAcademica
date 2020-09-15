package pe.com.presentacion.controlador;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import pe.com.presentacion.form.FAlumno;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;

@Controller("fileBean")
public class FileBean {
     
	FAlumno falumno;
	String resultado;
	String imagen;
	String mostrarResultado="none";
    private UploadedFile file;
 
    
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getMostrarResultado() {
		return mostrarResultado;
	}

	public void setMostrarResultado(String mostrarResultado) {
		this.mostrarResultado = mostrarResultado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
  
    public void upload() {
    	
    	
        if (file.getSize() != 0) {
        	InputStream input = null;
        	try {
            
        	input = file.getInputstream();
            
            falumno = new FAlumno();
            
            int indicador = falumno.validarPDF(input);
            
            if(indicador==0) {
            	resultado=" El certificado seleccionado es valido y cuenta con la firma digital del Jefe del CINFO.";
                imagen = "correcto";
            }else if(indicador == 1){
            	resultado=" El certificado seleccionado no es valido.";
                imagen = "error";
            }else {
            	resultado=" El certificado seleccionado no ha sido firmado digitalmente.";
                imagen = "alerta";
            }
                        
            mostrarResultado="block";
        	}catch(Exception e){
        		mostrarResultado="none";
        		PaginaUtil.mensajeJSF(Constantes.ADVERTENCIA, "El documento ingresado debe ser uno con la extensión PDF");
        	}
        }else {
        	mostrarResultado="none";
        	PaginaUtil.mensajeJSF(Constantes.ERROR, "Debe seleccionar un documento");
        }
    }
          
    public void handleFileUpload(FileUploadEvent event) {
    	System.out.println(event.getFile().getFileName());
    	PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Archivo recibido");
    }
}