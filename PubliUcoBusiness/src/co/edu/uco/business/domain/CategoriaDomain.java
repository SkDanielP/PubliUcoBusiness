package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class CategoriaDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    private EstadoCategoriaDomain estado;

    public CategoriaDomain(UUID identificador, String nombre, String descripcion, EstadoCategoriaDomain estado) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.DEFAULT_UUID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
    }

    public EstadoCategoriaDomain getEstado() {
        return estado;
    }

    public void setEstado(EstadoCategoriaDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoCategoriaDomain.getDefaultObject());
    }
}

