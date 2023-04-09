package com.appliance.AFAPP.Model;

import com.appliance.AFAPP.dto.PovDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Date date_debut;
    private Date date_fin;

    private String description;

    private String dompte_Manager;

    private String ingenieurCyberSecurite;

    private String analyseurCyberSecurite;

    private String libelepov;

    @ManyToOne
    @JoinColumn(name="app_id")
    private Appliance appliance;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(mappedBy = "pov", cascade = CascadeType.REMOVE)
    public List<Seance> seances;




}
