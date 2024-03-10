package lk.ijse.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class BookDetails {
    @Id
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    private String status;
}
