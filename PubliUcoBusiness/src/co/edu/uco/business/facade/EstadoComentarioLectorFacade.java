package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoComentarioLectorDTO;

public interface EstadoComentarioLectorFacade {

    void register(EstadoComentarioLectorDTO dto);

    List<EstadoComentarioLectorDTO> list(EstadoComentarioLectorDTO dto);

    void modify(EstadoComentarioLectorDTO dto);

    void drop(EstadoComentarioLectorDTO dto);

}
