package lk.ijse.Dto.Tm;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BranchTm {
    private String id;
    private String name;
    private String address;
    private int contact;
    private String status;
}
