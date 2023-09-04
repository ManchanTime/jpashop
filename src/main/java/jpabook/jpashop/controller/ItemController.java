package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.UpdateItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("form", new BookForm());
        return "/items/createItemForm";
    }

    @PostMapping("/new")
    public String create(BookForm form){
        Book book = new Book();
        book.createBook(form);
        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping("")
    public String items(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "/items/itemList";
    }

    @GetMapping("/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
        Book item = (Book) itemService.findOne(itemId);

        BookForm bookForm = new BookForm();
        bookForm.setId(item.getId());
        bookForm.setName(item.getName());
        bookForm.setPrice(item.getPrice());
        bookForm.setStockQuantity(item.getStockQuantity());
        bookForm.setAuthor(item.getAuthor());
        bookForm.setIsbn(item.getIsbn());

        model.addAttribute("form", bookForm);
        return "/items/updateItemForm";
    }

    @PostMapping("/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm bookForm){
        //어설프게 controller에서 entity 생성하지 않기!!!
//        Book book = new Book();
//        book.setId(bookForm.getId());
//        book.createBook(bookForm);
//        itemService.saveItem(book);

        //변경 감지 메소드에 파라미터로 변경할 속성을 넣어서 변경한다.
        //itemService.updateItem(itemId, bookForm.getName(), bookForm.getPrice(), bookForm.getStockQuantity());

        //만약 업데이트 할 데이터가 많다면 DTO 클래스로 뽑아서 사용 한다.
        UpdateItemDTO updateItemDTO = new UpdateItemDTO();
        updateItemDTO.setName(bookForm.getName());
        updateItemDTO.setPrice(bookForm.getPrice());
        updateItemDTO.setStockQuantity(bookForm.getStockQuantity());
        itemService.updateItem(itemId, updateItemDTO);

        return "redirect:/items";
    }
}
