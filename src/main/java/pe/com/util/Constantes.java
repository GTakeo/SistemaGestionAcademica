package pe.com.util;

public class Constantes {

	public static final int INFORMACION = 1;
	public static final int ADVERTENCIA = 2;
	public static final int ERROR = 3;

	public static final Integer ID_CAI_TODOS = 1;
	public static final Integer ID_CAI_ALGUNOS = 2;
	public static final String CAI_TODOS = "TODOS";
	public static final String CAI_ALGUNOS = "ALGUNOS";

	public static final Integer ID_CAA_TODOS = 1;
	public static final Integer ID_CAA_ALGUNOS = 2;
	public static final String CAA_TODOS = "TODOS";
	public static final String CAA_ALGUNOS = "ALGUNOS";

	public static final int ID_PEC_MENSUAL = 1;
	public static final int ID_PEC_TRIMESTRAL = 2;
	public static final int ID_PEC_SEMESTRAL = 3;
	public static final String PEC_MENSUAL = "MENSUAL";
	public static final String PEC_TRIMESTRAL = "TRIMESTRAL";
	public static final String PEC_SEMESTRAL = "SEMESTRAL";

	public static final int ID_MAM_CUOTA_CONSTANTE = 1;
	public static final int ID_MAM_CUOTA_CRECIENTE = 2;
	public static final int ID_MAM_CUOTA_DECRECIENTE = 3;
	public static final String MAM_CUOTA_CONSTANTE = "CUOTA CONSTANTE";
	public static final String MAM_CUOTA_CRECIENTE = "CUOTA CRECIENTE";
	public static final String MAM_CUOTA_DECRECIENTE = "CUOTA DECRECIENTE";

	public static final char CUOTA_CON_INTERES = '1';
	public static final char CUOTA_SIN_INTERES = '0';
	public static final String CON_INTERES = "CON INTERÉS";
	public static final String AMORTIZADO = "AMORTIZADO";
	public static final char CUOTA_CON_AMORTIZACION = '1';
	public static final char CUOTA_SIN_AMORTIZACION = '0';

	public static final int ID_ECU_SIN_PAGOS = 1;
	public static final int ID_ECU_PARCIALMENTE = 2;
	public static final int ID_ECU_PAGADO = 3;
	public static final String ECU_SIN_PAGOS = "SIN PAGOS";
	public static final String ECU_PARCIALMENTE = "PARCIALMENTE";
	public static final String ECU_PAGADO = "PAGADO";

	public static final Character ESTADO_INTERES_MORATORIO_APROBADO = '1';
	public static final String INTERES_MORATORIO_APROBADO = "APROBADO";
	public static final Character ESTADO_INTERES_MORATORIO_DESAPROBADO = '0';
	public static final String INTERES_MORATORIO_DESAPROBADO = "DESAPROBADO";
	public static final String INTERES_MORATORIO_NINGUNO = "NINGUNO";
	public static final char CUOTA_ES_VIGENTE = '0';

	public static final int AGREGAR_DESEMBOLSO = 1;
	public static final int ELIMINAR_DESEMBOLSO = 2;

	public static final int FORMATO_FECHA_HORA = 1;
	public static final int FORMATO_FECHA = 2;
	public static final int FORMATO_FECHA_BD = 3;

	public static final Integer ID_EOL_SIN_SOLICITAR = 1;
	public static final Integer ID_EOL_POR_EVALUAR = 2;
	public static final Integer ID_EOL_APTA = 3;
	public static final Integer ID_EOL_NO_APTA = 4;
	public static final Integer ID_EOL_APROBADA = 5;
	public static final Integer ID_EOL_DESAPROBADA = 6;

	public static final Integer ID_SLC_NINGUNA = 1;
	public static final Integer ID_SLC_DESAPROBADA = 2;
	public static final Integer ID_SLC_VIGENTE = 3;
	public static final Integer ID_SLC_FINALIZADA = 4;
	public static final Integer ID_SLC_RENOVADA = 5;

	public static final String EOL_SIN_SOLICITAR = "SIN SOLICITAR";
	public static final String EOL_POR_EVALUAR = "POR EVALUAR";
	public static final String EOL_APTA = "APTA";
	public static final String EOL_NO_APTA = "NO APTA";
	public static final String EOL_APROBADA = "APROBADA";
	public static final String EOL_DESAPROBADA = "DESAPROBADA";

	public static final String SLC_NINGUNA = "NINGUNA";
	public static final String SLC_DESAPROBADA = "DESAPROBADA";
	public static final String SLC_VIGENTE = "VIGENTE";
	public static final String SLC_FINALIZADA = "FINALIZADA";
	public static final String SLC_RENOVADA = "RENOVADA";

	public static final String DEPOSITO = "DEPÓSITO";
	public static final String CARTA_FIANZA = "CARTA FIANZA";
	public static final String HIPOTECA = "HIPOTECA";
	public static final String OTRA_GARANTIA = "OTRA GARANTÍA";

	public static final String SI = "SÍ";
	public static final String NO = "NO";
	public static final String OTROS = "OTROS";

	public static final String ACTIVO = "ACTIVO";
	public static final String INACTIVO = "INACTIVO";

	public static final Integer ID_ACTIVO = 1;
	public static final Integer ID_INACTIVO = 0;

	public static final char CHAR_ACTIVO = '1';
	public static final char CHAR_INACTIVO = '0';

	public static final String ERROR_ACCESO_DATOS_NO_CATEGORIZADO = "Error de acceso a datos no categorizado";
	public static final String ERROR_ACCESO_DATOS_OTRO = "Otro error de acceso a datos";
	public static final String ERROR_LOGICA_NEGOCIO_OTRO = "Otro error de lógica de negocio";

	public static final String TSV_SUPERVISADA_POR_SBS = "SUPERVISADA POR SBS";
	public static final String TSV_SUPERVISADA_POR_FENACREP = "SUPERVISADA POR FENACREP";
	public static final String TSV_NO_SUPERVISADA = "NO SUPERVISADA";

	public static final String SIN_NUMERO_LINEA_CREDITO = "...";

	public static final Integer ID_TIP_DOC_LC_CONTRATO_LC = 1;
	public static final String TIP_DOC_LC_CONTRATO_LC = "CONTRATO DE LÍNEA DE CRÉDITO";
	public static final Integer ID_TIP_DOC_LC_ADENDA = 2;
	public static final String TIP_DOC_LC_ADENDA = "ADENDA";

	public static final Integer ID_TIP_DOC_IFI_SOLIC_RENOV_FINAN_IFI = 1;
	public static final Integer ID_TIP_DOC_IFI_ACTA_COMITE_CREDITO = 2;
	public static final Integer ID_TIP_DOC_IFI_INFO_CREDITO = 3;
	public static final Integer ID_TIP_DOC_IFI_FICHA_RIESGO = 4;
	public static final Integer ID_TIP_DOC_IFI_ESTADO_FINAN = 5;
	public static final Integer ID_TIP_DOC_IFI_OTROS = 6;

	public static final String TIP_DOC_IFI_SOLIC_RENOV_FINAN_IFI = "SOLICITUD DE RENOVACIÓN O FINANCIAMIENTO DE LA IFI";
	public static final String TIP_DOC_IFI_ACTA_COMITE_CREDITO = "ACTA DE COMITÉ DE CRÉDITO";
	public static final String TIP_DOC_IFI_INFO_CREDITO = "INFORME DE CRÉDITO";
	public static final String TIP_DOC_IFI_FICHA_RIESGO = "FICHA DE RIESGO";
	public static final String TIP_DOC_IFI_ESTADO_FINAN = "ESTADO FINANCIERO";
	public static final String TIP_DOC_IFI_OTROS = "OTROS";
}
