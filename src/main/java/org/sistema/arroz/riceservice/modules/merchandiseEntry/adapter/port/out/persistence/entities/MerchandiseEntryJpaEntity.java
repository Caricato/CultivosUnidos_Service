package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_ENTRADA_MERCANCIA")
public class MerchandiseEntryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada_mercancia")
    private Long merchandiseEntryId;

    @Column(name = "fecha_entrada")
    private LocalDateTime entryDate;

    @Column(name = "tipo_entrada")
    private Integer entryType;

    @ManyToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity community;
}
