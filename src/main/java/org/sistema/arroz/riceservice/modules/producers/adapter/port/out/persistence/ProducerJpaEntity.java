package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserJpaEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_PRODUCTOR_AGRICOLA")
public class ProducerJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productor_agricola")
    private Long producerId;

    @Column(name = "DNI", unique = true)
    private String dni;

    @Column(name = "nombre")
    private String producerName;

    @Column(name = "apellido_paterno")
    private String producerFirstLastName;

    @Column(name = "apellido_materno")
    private String producerSecondLastName;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String phone;

    @Column(name = "hectareas")
    private Double hectares;

    @Column(name = "direccion")
    private String address;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime inscriptionDate;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime updateDate;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UserJpaEntity user;

    @ManyToOne
    @JoinColumn(name = "id_comunidad_agricola")
    private AgricultureCommunityJpaEntity community;
}
