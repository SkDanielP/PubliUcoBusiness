package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoPreferenciaDTO;

public interface EstadoPreferenciaFacade {

    void register(EstadoPreferenciaDTO dto);

    List<EstadoPreferenciaDTO> list(EstadoPreferenciaDTO dto);

    void modify(EstadoPreferenciaDTO dto);

    void drop(EstadoPreferenciaDTO dto);

}
