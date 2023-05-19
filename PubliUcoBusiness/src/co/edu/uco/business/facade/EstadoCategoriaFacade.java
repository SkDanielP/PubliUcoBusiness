package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoCategoriaDTO;

public interface EstadoCategoriaFacade {

    void register(EstadoCategoriaDTO dto);

    List<EstadoCategoriaDTO> list(EstadoCategoriaDTO dto);

    void modify(EstadoCategoriaDTO dto);

    void drop(EstadoCategoriaDTO dto);

}

