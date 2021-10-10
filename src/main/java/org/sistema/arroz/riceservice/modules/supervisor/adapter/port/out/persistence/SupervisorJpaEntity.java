package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_SUPERVISOR")
public class SupervisorJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productor_agricola")
    private Long supervisorId;

    @Column(name = "DNI", unique = true)
    private String dni;

    @Column(name = "nombre")
    private String supervisorName;

    @Column(name = "apellido_paterno")
    private String supervisorFirstLastName;

    @Column(name = "apellido_materno")
    private String supervisorSecondLastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UserJpaEntity user;
}
