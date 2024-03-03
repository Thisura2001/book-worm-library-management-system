package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Branch {
    @Id
    private String id;
    private String name;
    private String address;
    private int contact;
    private String status;
}
