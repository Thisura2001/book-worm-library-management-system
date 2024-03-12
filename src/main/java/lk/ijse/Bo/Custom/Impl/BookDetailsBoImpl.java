package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.Custom.BookDetailsBo;
import lk.ijse.Dao.Custom.BookDetailsDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.BookDetailsDto;
import lk.ijse.Dto.BookDto;
import lk.ijse.Dto.UserDto;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.BookDetails;
import lk.ijse.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class BookDetailsBoImpl implements BookDetailsBo {
    BookDetailsDao bookDetailsDao = (BookDetailsDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.BookDetails);
    @Override
    public List<BookDetailsDto> getAllBookDetails() {

        List<BookDetails> bookDetails = bookDetailsDao.getAll();
        ArrayList<BookDetailsDto> bookDetailsDtos = new ArrayList<>();

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
            userDto.setGender(bookDetail.getUser().getGender());
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

    @Override
    public String generateNewTranceactionID() {
        return bookDetailsDao.generateNewId();
    }

    @Override
    public Boolean addBookDetails(BookDetailsDto bookDetailsDto) {

        BookDetails bookDetails = new BookDetails();
        bookDetails.setId(bookDetailsDto.getId());

        Book book = new Book();
        book.setId(bookDetailsDto.getBookDto().getId());
        book.setTitle(bookDetailsDto.getBookDto().getTitle());
        book.setAuthor(bookDetailsDto.getBookDto().getAuthor());
        book.setAvailability(bookDetailsDto.getBookDto().getAvailability());
        bookDetails.setBook(book);

        bookDetails.setStatus(bookDetailsDto.getStatus());
        bookDetails.setDate(bookDetailsDto.getDate());

        User user = new User();
        user.setId(bookDetailsDto.getUserDto().getId());
        user.setName(bookDetailsDto.getUserDto().getName());
        user.setAddress(bookDetailsDto.getUserDto().getAddress());
        user.setContact(bookDetailsDto.getUserDto().getContact());
        user.setGender(bookDetailsDto.getUserDto().getGender());
        bookDetails.setUser(user);

        return bookDetailsDao.save(bookDetails);
    }

    @Override
    public Boolean deleteDetails(String id) {
        return bookDetailsDao.Delete(id);
    }
}
