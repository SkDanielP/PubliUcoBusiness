package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;

public interface TipoComentarioRevisorFacade {

    void register(TipoComentarioRevisorDTO dto);

    List<TipoComentarioRevisorDTO> list(TipoComentarioRevisorDTO dto);

    void modify(TipoComentarioRevisorDTO dto);

    void drop(TipoComentarioRevisorDTO dto);

}


