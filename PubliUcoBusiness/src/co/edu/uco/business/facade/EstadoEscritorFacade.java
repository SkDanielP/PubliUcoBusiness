package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoEscritorDTO;

public interface EstadoEscritorFacade {

    void register(EstadoEscritorDTO dto);

    List<EstadoEscritorDTO> list(EstadoEscritorDTO dto);

    void modify(EstadoEscritorDTO dto);

    void drop(EstadoEscritorDTO dto);

}
