package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoPublicacionDTO;

public interface EstadoPublicacionFacade {

    void register(EstadoPublicacionDTO dto);

    List<EstadoPublicacionDTO> list(EstadoPublicacionDTO dto);

    void modify(EstadoPublicacionDTO dto);

    void drop(EstadoPublicacionDTO dto);

}
