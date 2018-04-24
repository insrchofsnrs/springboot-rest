package by.insrch.sdrw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@EqualsAndHashCode @Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "userId"}))
public class UserRole {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long userRoleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(userRoleId, userRole.userRoleId) &&
                Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), userRoleId, role);
    }
}
