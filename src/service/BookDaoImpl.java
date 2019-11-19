package service;

import mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import pojo.BorrowBookUser;

import java.util.List;

@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> borrowBookList() {
        return bookMapper.borrowBookList();
    }

    @Override
    public void borrow(BorrowBookUser b) {
        bookMapper.borrow(b);
    }
}
