package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoTipoEscritorDTO;

public interface EstadoTipoEscritorFacade {

    void register(EstadoTipoEscritorDTO dto);

    List<EstadoTipoEscritorDTO> list(EstadoTipoEscritorDTO dto);

    void modify(EstadoTipoEscritorDTO dto);

    void drop(EstadoTipoEscritorDTO dto);

}

