package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoLectorDTO;

public interface EstadoLectorFacade {

    void register(EstadoLectorDTO dto);

    List<EstadoLectorDTO> list(EstadoLectorDTO dto);

    void modify(EstadoLectorDTO dto);

    void drop(EstadoLectorDTO dto);

}
