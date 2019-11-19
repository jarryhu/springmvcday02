package service;

import pojo.Book;
import pojo.BorrowBookUser;

import java.util.List;

public interface BookDao {
    public List<Book> borrowBookList();
    public void borrow(BorrowBookUser b);
}
