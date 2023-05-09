package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class AdministradorCategoriaDomain {
    private static final AdministradorCategoriaDomain DEFAULT_OBJECT = new AdministradorCategoriaDomain();
    private UUID identificador;
    private String nombre;
    private String correo;
    private TipoRelacionInstitucionDomain tipoRelacionInstitucion;
    private EstadoAdministradorCategoriaDomain estado;
    
    private AdministradorCategoriaDomain() {
        super();
        setIdentificador(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setCorreo(UtilText.getUtilText().getDefaultValue());
        setTipoRelacionInstitucion(TipoRelacionInstitucionDomain.getDefaultObject());
        setEstado(EstadoAdministradorCategoriaDomain.getDefaultObject());
    }
    
    public AdministradorCategoriaDomain(UUID identificador, String nombre, String correo, TipoRelacionInstitucionDomain tipoRelacionInstitucion, EstadoAdministradorCategoriaDomain estado) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setCorreo(correo);
        setTipoRelacionInstitucion(tipoRelacionInstitucion);
        setEstado(estado);
    }
    
    public static AdministradorCategoriaDomain getDefaultObject() {
        return DEFAULT_OBJECT;
    }
    
    public UUID getIdentificador() {
        return identificador;
    }
    
    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador); 
    }
    
    public String getNombre() {
        return nombre;
    }
    
    private void setNombre(final String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
    }
    
    public String getCorreo() {
        return correo;
    }
    
    private void setCorreo(final String correo) {
        this.correo = UtilText.getUtilText().applyTrim(correo);
    }
    
    public TipoRelacionInstitucionDomain getTipoRelacionInstitucion() {
        return tipoRelacionInstitucion;
    }
    
    private void setTipoRelacionInstitucion(final TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
        this.tipoRelacionInstitucion = UtilObject.getDefault(tipoRelacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
    }
    
    public EstadoAdministradorCategoriaDomain getEstado() {
        return estado;
    }
    
    private void setEstado(final EstadoAdministradorCategoriaDomain estado) {
        this.estado = estado;
    }


}
