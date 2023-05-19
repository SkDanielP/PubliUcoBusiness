package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.TipoRevisionDTO;

public interface TipoRevisionFacade {

    void register(TipoRevisionDTO dto);

    List<TipoRevisionDTO> list(TipoRevisionDTO dto);

    void modify(TipoRevisionDTO dto);

    void drop(TipoRevisionDTO dto);

}
