package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Getter;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;

@Getter
public class MerchandiseProductPageDTO extends MerchandiseEntryPageDTO{
    Paginator<MerchandiseFlowProductDetail> detailPage;

    @Builder
    public MerchandiseProductPageDTO(MerchandiseFlow merchandiseFlow, Paginator<MerchandiseFlowProductDetail> detailPage){
        super(merchandiseFlow);
        this.detailPage = detailPage;
    }
}
