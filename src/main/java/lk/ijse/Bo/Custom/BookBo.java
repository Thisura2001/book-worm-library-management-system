package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dto.BookDto;

import java.util.List;

public interface BookBo extends SuperBo {
    boolean AddBook(BookDto bookDto);

    boolean updateBook(BookDto bookDto);

    List<BookDto> getAll();
}