package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoObservacionRevisorDTO;

public interface EstadoObservacionRevisorFacade {

    void register(EstadoObservacionRevisorDTO dto);

    List<EstadoObservacionRevisorDTO> list(EstadoObservacionRevisorDTO dto);

    void modify(EstadoObservacionRevisorDTO dto);

    void drop(EstadoObservacionRevisorDTO dto);

}
