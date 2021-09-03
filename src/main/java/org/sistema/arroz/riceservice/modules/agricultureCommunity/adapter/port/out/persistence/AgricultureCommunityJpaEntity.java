package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_COMUNIDAD_AGRICOLA")
public class AgricultureCommunityJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunidad")
    private Long communityId;

    @Column(name = "nom_comunidad", length = 100)
    private String communityName;
}