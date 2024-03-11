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
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setTitle(book.getTitle());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setAvailability(book.getAvailability());

            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public String generateNewBookID() {
        return bookDao.generateNewId();
    }

    @Override
    public boolean deleteBook(String id) {
        return bookDao.Delete(id);
    }

    @Override
    public BookDto searchBook(String id) {
        Book book = bookDao.search(id);
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setAvailability(book.getAvailability());

        return bookDto;
    }

}
