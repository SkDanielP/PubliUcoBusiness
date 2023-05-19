package co.edu.uco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.TipoReporteDTO;

public interface TipoReporteFacade {

    void register(TipoReporteDTO dto);

    List<TipoReporteDTO> list(TipoReporteDTO dto);

    void modify(TipoReporteDTO dto);

    void drop(TipoReporteDTO dto);

}
