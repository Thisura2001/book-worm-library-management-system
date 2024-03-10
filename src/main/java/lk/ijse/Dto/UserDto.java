package lk.ijse.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    List<BookDto>bookDtoList = new ArrayList<>();
}
