package co.edu.uco.business.domain;

import java.util.UUID;

public class PublicacionDomain {
    private UUID identificador;
    private CategoriaDomain categoria;
    private TipoAccesoDomain tipoAcceso;
    private EstadoPublicacionDomain estadoPublicacion;

    public PublicacionDomain(UUID identificador, CategoriaDomain categoria, TipoAccesoDomain tipoAcceso,
            EstadoPublicacionDomain estadoPublicacion) {
        this.identificador = identificador;
        this.categoria = categoria;
        this.tipoAcceso = tipoAcceso;
        this.estadoPublicacion = estadoPublicacion;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public CategoriaDomain getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDomain categoria) {
        this.categoria = categoria;
    }

    public TipoAccesoDomain getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(TipoAccesoDomain tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public EstadoPublicacionDomain getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacionDomain estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }
}
