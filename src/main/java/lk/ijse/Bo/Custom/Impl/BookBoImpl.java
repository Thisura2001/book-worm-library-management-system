package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.Custom.BookBo;
import lk.ijse.Dao.Custom.BookDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.BookDto;
import lk.ijse.Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBoImpl implements BookBo {
    BookDao bookDao = (BookDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.BOOK);
    @Override
    public boolean AddBook(BookDto bookDto) {
        return bookDao.save(new Book(bookDto.getId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getAvailability()));
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        return bookDao.update(new Book(bookDto.getId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getAvailability()));
    }

    @Override
    public List<BookDto> getAll() {
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        ArrayList<Book>books = bookDao.getAll();
        for (Book book : books) {
            bookDtos.add(new BookDto(book.getId(),book.getTitle(),book.getAuthor(),book.getAvailability()));
        }
        return bookDtos;
    }

    @Override
    public String generateNewBookID() {
        return bookDao.generateNewId();
    }

}
