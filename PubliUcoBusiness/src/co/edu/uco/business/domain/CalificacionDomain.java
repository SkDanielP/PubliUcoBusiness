package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;

public class CalificacionDomain {
    private UUID identificador;
    private LectorDomain lector;
    private PublicacionDomain publicacion;

    public CalificacionDomain(UUID identificador, LectorDomain lector, PublicacionDomain publicacion) {
        this.identificador = identificador;
        this.lector = lector;
        this.publicacion = publicacion;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public void setLector(LectorDomain lector) {
        this.lector = lector;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(PublicacionDomain publicacion) {
        this.publicacion = publicacion;
    }
}
