package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Getter;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

@Getter
public class MerchandiseSupplyPageDTO  extends MerchandiseEntryPageDTO{
    Paginator<MerchandiseFlowDetail> detailPage;

    @Builder
    public MerchandiseSupplyPageDTO(MerchandiseFlow merchandiseFlow, Paginator<MerchandiseFlowDetail> detailPage){
        super(merchandiseFlow);
        this.detailPage = detailPage;
    }
}
