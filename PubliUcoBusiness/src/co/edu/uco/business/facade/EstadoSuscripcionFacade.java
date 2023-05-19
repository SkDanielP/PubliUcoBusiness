package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoSuscripcionDTO;

public interface EstadoSuscripcionFacade {

    void register(EstadoSuscripcionDTO dto);

    List<EstadoSuscripcionDTO> list(EstadoSuscripcionDTO dto);

    void modify(EstadoSuscripcionDTO dto);

    void drop(EstadoSuscripcionDTO dto);

}

