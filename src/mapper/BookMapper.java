package mapper;

import pojo.Book;
import pojo.BorrowBookUser;

import java.util.List;

public interface BookMapper {
    public List<Book> borrowBookList();

    public void borrow(BorrowBookUser b);
}
