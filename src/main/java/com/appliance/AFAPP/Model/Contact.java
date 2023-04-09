package com.appliance.AFAPP.Model;
import com.appliance.AFAPP.dto.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Contact  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String prenom;
    private String telephone ;
    private String fonction ;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    public Client client;




   // #cleetrangere Client








  //  private List<Individu> employes = new ArrayList<>();

}
