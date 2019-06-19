package pe.com.presentacion.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfPKCS7;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSignatureAppearance;
import com.lowagie.text.pdf.PdfStamper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOGrupo;
import pe.com.util.ArchivoUtil;

public class FAlumno implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÑñ]+((\\s)+[a-zA-ZáéíóúÁÉÍÓÚÑñ]+)*$", message = "Nombre no es válido")
	private String nombre;

	private String apellido;
	private String direccion;
	private String telefono;
	private String celular;
	private Date fechaNacimiento;
	private Integer dni;
	private String correo;
	private List<SelectItem> listaSelectPrograma;
	private List<SelectItem> listaSelectModulo;
	private List<SelectItem> listaSelectCurso;
	private List<SelectItem> listaSelectGrupo;
	
	public void exportarPDF(List<Map<String,Object>> listaAlumnoNota,String nombreArchivo) throws JRException, KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, DocumentException {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		String fileName = "C:/Users/gusta/Dropbox/2019.Tesis/Desarrollo/PlantillaCertificación/plantillaCertificado.jasper";
		JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, parametros, new JRBeanCollectionDataSource(listaAlumnoNota));
		ArchivoUtil.prepararArchivo(jasperPrint, nombreArchivo, ".pdf");
		
		
        KeyStore ks = KeyStore.getInstance("pkcs12");
        ks.load(new FileInputStream("C:/Users/gusta/Dropbox/2019.Tesis/Desarrollo/Certificado/cert-key-20170613-231724.p12"), "123456".toCharArray());
        String alias = (String)ks.aliases().nextElement();
        PrivateKey key = (PrivateKey)ks.getKey(alias, "123456".toCharArray());
         java.security.cert.Certificate[] chain = ks.getCertificateChain(alias);
        // Recibimos como parámetro de entrada el nombre del archivo PDF a firmar
        PdfReader reader = new PdfReader("C:/Users/gusta/Desktop/"+nombreArchivo+".pdf"); 
        FileOutputStream fout = new FileOutputStream("C:/Users/gusta/Desktop/"+nombreArchivo+"Firmado"+".pdf");
        // Añadimos firma al documento PDF
        PdfStamper stp = PdfStamper.createSignature(reader, fout, '?');
        PdfSignatureAppearance sap = stp.getSignatureAppearance();
        sap.setCrypto(key, chain, null, PdfSignatureAppearance.WINCER_SIGNED);
        sap.setReason("Firma PKCS12");
        sap.setLocation("Imaginanet");
        // Añade la firma visible. Podemos comentarla para que no sea visible.
        sap.setVisibleSignature(new Rectangle(100,100,200,200),1,null);
        stp.close();
	}
	
	public void validarPDF() throws IOException{
		 Random rnd = new Random();
         KeyStore kall = PdfPKCS7.loadCacertsKeyStore();
         PdfReader reader = new PdfReader("C:/Users/gusta/Desktop/GUSTAVO_DE LA CRUZ_PRUEBAFirmado.pdf");
         AcroFields af = reader.getAcroFields();
         
          ArrayList names = af.getSignatureNames();
         for (int k = 0; k < names.size(); ++k) {
            String name = (String)names.get(k);
            int random = rnd.nextInt();
            FileOutputStream out = new FileOutputStream("C:/Users/gusta/Desktop/revision_" + random + "_" + af.getRevision(name) + ".pdf");

            byte bb[] = new byte[8192];
            InputStream ip = af.extractRevision(name);
            int n = 0;
            while ((n = ip.read(bb)) > 0)
            out.write(bb, 0, n);
            out.close();
            ip.close();

            PdfPKCS7 pk = af.verifySignature(name);
            Calendar cal = pk.getSignDate();
            Certificate pkc[] = pk.getCertificates();
            Object fails[] = PdfPKCS7.verifyCertificates(pkc, kall, null, cal);
            if (fails == null) {
            	System.out.println("Firma válida");
                System.out.println(pk.getSignName());
            }
            else {
                System.out.println("Firma no válida");
            }
            File f = new File("revision_" + random + "_" + af.getRevision(name) + ".pdf");
            f.delete();
         }
	}
	
	public FAlumno() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public List<SelectItem> getListaSelectPrograma() {
		return listaSelectPrograma;
	}

	public void setListaSelectPrograma(List<SelectItem> listaSelectPrograma) {
		this.listaSelectPrograma = listaSelectPrograma;
	}

	public List<SelectItem> getListaSelectModulo() {
		return listaSelectModulo;
	}

	public void setListaSelectModulo(List<SelectItem> listaSelectModulo) {
		this.listaSelectModulo = listaSelectModulo;
	}
	
	public List<SelectItem> getListaSelectGrupo() {
		return listaSelectGrupo;
	}

	public void setListaSelectGrupo(List<SelectItem> listaSelectGrupo) {
		this.listaSelectGrupo = listaSelectGrupo;
	}
	public List<SelectItem> getListaSelectCurso() {
		return listaSelectCurso;
	}

	public void setListaSelectCurso(List<SelectItem> listaSelectCurso) {
		this.listaSelectCurso = listaSelectCurso;
	}

	@Override
	public String toString() {
		return "FAlumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", celular=" + celular + ", fechaNacimiento=" + fechaNacimiento + ", dni="
				+ dni + ", correo=" + correo + "]";
	}

	public void obtenerSelectItemsPrograma(List<FPrograma> lista) {
		if (lista != null && lista.size() > 0) {
			listaSelectPrograma = new ArrayList<SelectItem>();
			for (FPrograma fPrograma : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fPrograma.getNombre());
				item.setValue(fPrograma.getId());
				listaSelectPrograma.add(item);
			}
		}
	}	
	
	public void obtenerSelectItemsModulo(List<FModulo> lista) {
		listaSelectModulo = new ArrayList<SelectItem>();
		if (lista != null && lista.size() > 0) {
			for (FModulo fModulo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fModulo.getNombre());
				item.setValue(fModulo.getId());
				listaSelectModulo.add(item);
			}
		}
	}	
	
	public void obtenerSelectItemsCurso(List<BOCurso> lista) {
		listaSelectCurso = new ArrayList<SelectItem>();
		if (lista != null && lista.size() > 0) {
			for (BOCurso fCurso : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fCurso.getNombre());
				item.setValue(fCurso.getId());
				listaSelectCurso.add(item);
			}
		}
	}

	public void obtenerSelectItemsGrupo(List<BOGrupo> lista) {
		listaSelectGrupo = new ArrayList<SelectItem>();
		if (lista != null && lista.size() > 0) {
			for (BOGrupo fGrupo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fGrupo.getNombre());
				item.setValue(fGrupo.getId());
				listaSelectGrupo.add(item);
			}
		}
		
	}	
	

}
