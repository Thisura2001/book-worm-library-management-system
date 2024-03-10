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
    private String user;
    private Date date;
    private String book;
    private String status;
}
