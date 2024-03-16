package ma.enset.studentsapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Utilisateur {
    @Id
    private String id;
    @Column(unique = true, length = 20)
    private String name;
    private String password;
    @ManyToMany(mappedBy = "utilisateurs", fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
