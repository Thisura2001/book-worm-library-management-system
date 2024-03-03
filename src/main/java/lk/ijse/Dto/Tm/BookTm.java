package lk.ijse.Dto.Tm;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookTm {
    private String id;
    private String title;
    private String author;
    private int availability;
}
