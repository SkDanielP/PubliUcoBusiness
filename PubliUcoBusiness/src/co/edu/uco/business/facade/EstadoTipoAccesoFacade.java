package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoTipoAccesoDTO;

public interface EstadoTipoAccesoFacade {

    void register(EstadoTipoAccesoDTO dto);

    List<EstadoTipoAccesoDTO> list(EstadoTipoAccesoDTO dto);

    void modify(EstadoTipoAccesoDTO dto);

    void drop(EstadoTipoAccesoDTO dto);

}
