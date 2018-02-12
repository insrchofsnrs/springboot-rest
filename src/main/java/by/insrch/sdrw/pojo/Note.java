package by.insrch.sdrw.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "note")
public class Note implements Serializable {

    @Id
    @JsonProperty("name")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    //@NotBlank
    //@Column(columnDefinition="BLOB")
    private String name;
    //@NotBlank
    @Column(length = 5000)
    private String text;
    /*@ManyToMany
    private Long userId;
*/
}
