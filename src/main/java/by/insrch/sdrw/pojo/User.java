package by.insrch.sdrw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
 //   private LocaleData birthday;
    private boolean enabled;
    private String phone;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<>(0);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), userId, name, surname, email, password, enabled, phone, address);
    }


    /*@OneToMany(mappedBy = "id")
    private Note note;*/
}
