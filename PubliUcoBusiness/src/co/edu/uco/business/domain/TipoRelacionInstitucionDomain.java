package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;


public final class TipoRelacionInstitucionDomain {
    private static final TipoRelacionInstitucionDomain DEFAULT_OBJECT = new TipoRelacionInstitucionDomain();
	private UUID identificador;
	private String nombre;
	private String descripcion;
	private EstadoTipoRelacionInstitucionDomain estado;
	
	
	
	public TipoRelacionInstitucionDomain(final UUID identificador, final String nombre, final String descripcion, final EstadoTipoRelacionInstitucionDomain estado) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstado(estado);
		}
	
	private TipoRelacionInstitucionDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.EMPTY);
		setDescripcion(UtilText.EMPTY);
		setEstado(EstadoTipoRelacionInstitucionDomain.getDefaultObject());
	}
	
	 public static final TipoRelacionInstitucionDomain getDefaultObject() {
	        return DEFAULT_OBJECT;
	    }
	
	public final UUID getIdentificador() {
		return identificador;
	}
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador); 
		
	}
	public final String getNombre() {
		return nombre;
	}
	
	
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
				
	}
	
	public final String getDescripcion() {
		return descripcion;
	}
	
	
	private final void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}


	public final EstadoTipoRelacionInstitucionDomain getEstado() {
		return estado;
	}


	private final void setEstado(final EstadoTipoRelacionInstitucionDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoTipoRelacionInstitucionDomain.getDefaultObject());
		
	}
	
	
}