package lk.ijse.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String id;
    private String name;
    private String address;
    private int contact;
    private String gender;
}
