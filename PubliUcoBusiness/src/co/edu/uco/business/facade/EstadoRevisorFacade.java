package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoRevisorDTO;

public interface EstadoRevisorFacade {

    void register(EstadoRevisorDTO dto);

    List<EstadoRevisorDTO> list(EstadoRevisorDTO dto);

    void modify(EstadoRevisorDTO dto);

    void drop(EstadoRevisorDTO dto);

}
