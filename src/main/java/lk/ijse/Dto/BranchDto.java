package lk.ijse.Dto;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BranchDto {
    private String id;
    private String name;
    private String address;
    private int contact;
    private String status;
}
