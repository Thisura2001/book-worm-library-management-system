package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Dao.Custom.BookDetailsDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.BookDetailsDto;
import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.UserDto;
import lk.ijse.Entity.BookDetails;

import java.util.ArrayList;
import java.util.List;

public class BookDetailsBoImpl implements BookDetailsBo {
    BookDetailsDao bookDetailsDao = (BookDetailsDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.BookDetails);
    @Override
    public List<BookDetailsDto> getAllBookDetails() {
        ArrayList<BookDetailsDto> bookDetailsDtos = new ArrayList<>();
        List<BookDetails> bookDetails = bookDetailsDao.getAll();
        for (BookDetails bookDetail : bookDetails) {

            BookDetailsDto bookDetailsDto = new BookDetailsDto();
            bookDetailsDto.setId(bookDetail.getId());
            bookDetailsDto.setDate(bookDetail.getDate());
            bookDetailsDto.setStatus(bookDetail.getStatus());


            UserDto userDto = new UserDto();
            userDto.setId(bookDetail.getUser().getId());
            userDto.setName(bookDetail.getUser().getName());
            userDto.setAddress(bookDetail.getUser().getAddress());
            userDto.setContact(bookDetail.getUser().getContact());
            bookDetailsDto.setUserDto(userDto);

            BookDto bookDto = new BookDto();
            bookDto.setId(bookDetail.getBook().getId());
            bookDto.setTitle(bookDetail.getBook().getTitle());
            bookDto.setAuthor(bookDetail.getBook().getAuthor());
            bookDto.setAvailability(bookDetail.getBook().getAvailability());
            bookDetailsDto.setBookDto(bookDto);

            bookDetailsDtos.add(bookDetailsDto);
        }
        return bookDetailsDtos;
    }
}
