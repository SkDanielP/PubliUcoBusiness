package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class LectorDomain {
    private UUID identificador;
    private TipoIdentificacionDomain tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private TipoRelacionInstitucionDomain tipoRelacionInstitucion;

    public LectorDomain(UUID identificador, TipoIdentificacionDomain tipoIdentificacion, String numeroIdentificacion,
            String nombre, TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
    	super();
        setIdentificador(identificador);
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setNombre(nombre);
        setTipoRelacionInstitucion(tipoRelacionInstitucion);
    }
    
    private LectorDomain() {
    	super();
    	setIdentificador(UtilUUID.DEFAULT_UUID);
    	setTipoIdentificacion(TipoIdentificacionDomain.getDefaultObject());
    	setNumeroIdentificacion(UtilText.EMPTY);
    	setNombre(UtilText.EMPTY);
    	setTipoRelacionInstitucion(TipoRelacionInstitucionDomain.getDefaultObject());
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.DEFAULT_UUID;
    }

    public TipoIdentificacionDomain getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
        this.tipoIdentificacion = UtilObject.getDefault(tipoIdentificacion, TipoIdentificacionDomain.getDefaultObject());
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = UtilText.getUtilText().applyTrim(numeroIdentificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
    }

    public TipoRelacionInstitucionDomain getTipoRelacionInstitucion() {
        return tipoRelacionInstitucion;
    }

    public void setTipoRelacionInstitucion(TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
        this.tipoRelacionInstitucion = UtilObject.getDefault(tipoRelacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
    }
}
