package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired private ItemRepository itemRepository;
    @Autowired private ItemService itemService;

    @Test
    public void 아이템_저장(){
        //given
        Item item = new Book();
        item.setName("JPA");
        //when
        itemService.saveItem(item);
        Item findItem = itemService.findOne(item.getId());
        //then
        Assertions.assertThat(findItem).isEqualTo(item);
    }
}