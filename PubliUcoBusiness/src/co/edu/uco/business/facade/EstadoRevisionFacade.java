package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoRevisionDTO;

public interface EstadoRevisionFacade {

    void register(EstadoRevisionDTO dto);

    List<EstadoRevisionDTO> list(EstadoRevisionDTO dto);

    void modify(EstadoRevisionDTO dto);

    void drop(EstadoRevisionDTO dto);

}
