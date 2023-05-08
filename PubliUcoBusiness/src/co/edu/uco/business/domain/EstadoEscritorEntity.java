package co.edu.uco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class EstadoEscritorEntity {
    private static final EstadoEscritorEntity DEFAULT_OBJECT = new EstadoEscritorEntity();
    private UUID identificador;
    private String nombre;
    private String descripcion;

    private EstadoEscritorEntity() {
        super();
        setIdentificador(UtilUUID.DEFAULT_UUID);
        setNombre(UtilText.getUtilText().getDefaultValue());
        setDescripcion(UtilText.EMPTY);
    }

    public EstadoEscritorEntity(UUID identificador, String nombre, String descripcion) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public static EstadoEscritorEntity getDefaultObject() {
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

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
    }
}
