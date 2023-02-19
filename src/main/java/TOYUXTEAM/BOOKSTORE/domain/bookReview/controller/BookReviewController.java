package TOYUXTEAM.BOOKSTORE.domain.bookReview.controller;


import TOYUXTEAM.BOOKSTORE.domain.bookReview.dto.BookReviewRes;
import TOYUXTEAM.BOOKSTORE.domain.bookReview.dto.UpdateBookReviewReq;
import TOYUXTEAM.BOOKSTORE.domain.bookReview.dto.WriteBookReviewReq;
import TOYUXTEAM.BOOKSTORE.domain.bookReview.service.BookReviewService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
public class BookReviewController { // aaa

    private final BookReviewService bookReviewService;

    @PostMapping("/book-review")
    public void writeBookReview(@RequestBody WriteBookReviewReq writeBookReviewReq){

        bookReviewService.write(writeBookReviewReq);

    }
    @PatchMapping("/book-review/{reviewId}")
    public void updateBookReview(@PathVariable(value = "reviewId") String reviewId, @RequestBody UpdateBookReviewReq updateBookReviewReq)
    {
        bookReviewService.update(Long.parseLong(reviewId), updateBookReviewReq);

    }

    @DeleteMapping("/bookReview/{id}")
    public void deleteBookReview(@PathVariable("id") Long id)
    {
        bookReviewService.delete(id);
    }
    @GetMapping("book-review/{reviewId}")
    public BookReviewRes getBookReview(@PathVariable("reviewId") Long id)
    {
        return bookReviewService.get(id);
    }

    @GetMapping("book-reviews")
    public List<BookReviewRes> getAllBookReview()
    {
        return bookReviewService.getAll();
    }


}
