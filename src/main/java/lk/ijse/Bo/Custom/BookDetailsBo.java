package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dto.BookDetailsDto;

import java.util.List;

public interface BookDetailsBo extends SuperBo {
    List<BookDetailsDto> getAllBookDetails();

    String generateNewTranceactionID();

    Boolean addBookDetails(BookDetailsDto bookDetailsDto);

    Boolean deleteDetails(String id);
}
