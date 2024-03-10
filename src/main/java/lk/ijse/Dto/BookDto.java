package lk.ijse.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private String id;
    private String title;
    private String author;
    private int availability;
    List<BookDto>bookDtoList = new ArrayList<>();

    public BookDto(String id, String title, String author, int availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }
}
