package alphashk.chatbot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name") // #todo grade systematization
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Question> questions = new HashSet<>();

}
