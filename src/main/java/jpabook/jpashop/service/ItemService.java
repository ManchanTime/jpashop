package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    //변경 감지를 통한 업데이트 방법 -> 대부분 이 방법이 좋음
    //필요한 속성만 변경할 수 있음
    @Transactional
    public void updateItem(Long itemId, UpdateItemDTO updateItemDTO){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(updateItemDTO.getName());
        findItem.setPrice(updateItemDTO.getPrice());
        findItem.setStockQuantity(updateItemDTO.getStockQuantity());
        //이미 영속 상태이기 때문에 commit 시 자동 업데이트
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
