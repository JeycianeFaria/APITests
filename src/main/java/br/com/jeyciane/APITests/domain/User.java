package br.com.jeyciane.APITests.domain;

import lombok.*;

import javax.persistence.*;

@Data           //o @Data gera todos esses outros automaticamente : @Getter @Setter @EqualsAndHashCode @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

}
