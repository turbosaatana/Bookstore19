package com.example.bookstore19.web;

import com.example.bookstore19.domain.Book;
import com.example.bookstore19.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
//testitesti
    @RequestMapping("/booklist")
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id")Long bookid, Model model){
        repository.deleteById(bookid);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id")Long bookid, Model model) {
        model.addAttribute("book", repository.findById(bookid));
        return "editbook";
    }


    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
