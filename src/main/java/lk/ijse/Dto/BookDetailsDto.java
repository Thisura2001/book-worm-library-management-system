package lk.ijse.Dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDetailsDto {
    private String id;
    private UserDto userDto;
    private Date date;
    private BookDto bookDto;
    private String status;
}
