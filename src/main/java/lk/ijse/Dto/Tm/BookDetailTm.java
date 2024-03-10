package lk.ijse.Dto.Tm;

import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.UserDto;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDetailTm {
    private String id;
    private UserDto userDto;
    private Date date;
    private BookDto bookDto;
    private String status;
}
