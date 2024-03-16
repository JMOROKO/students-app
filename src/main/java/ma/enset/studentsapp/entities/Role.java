package ma.enset.studentsapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String roleName;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name="utilisateurs_roles")
    @ToString.Exclude
    private List<Utilisateur> utilisateurs = new ArrayList<>();
}
