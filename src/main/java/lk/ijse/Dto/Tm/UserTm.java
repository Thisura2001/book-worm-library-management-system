package lk.ijse.Dto.Tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserTm {
    private String id;
    private String name;
    private String address;
    private int contact;
    private String gender;
}
