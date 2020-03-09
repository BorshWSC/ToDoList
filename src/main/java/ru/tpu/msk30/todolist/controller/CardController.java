package ru.tpu.msk30.todolist.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.msk30.todolist.domain.Card;
import ru.tpu.msk30.todolist.domain.CheckablePoint;
import ru.tpu.msk30.todolist.repo.CardRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardRepo cardRepo;

    @Autowired
    public CardController(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }


    @GetMapping
    public List<Card> list(){
        List<Card> allCards = cardRepo.findAll();
        Comparator<CheckablePoint> comparator = new Comparator<CheckablePoint>() {
            @Override
            public int compare(CheckablePoint o1, CheckablePoint o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        for(Card card: allCards){
            card.getCheckablePoints().sort(comparator);
        }
        return allCards;

    }

    @GetMapping("{id}")
    public Card getOne(@PathVariable("id") Card card){
        return card;
    }

    @PostMapping
    public Card create(@RequestBody Card card){

        List<CheckablePoint> newCheckablePoints = new ArrayList<>();
        for (CheckablePoint point: card.getCheckablePoints()){
            CheckablePoint newPoint = new CheckablePoint(point.getText());
            newCheckablePoints.add(newPoint);
        }

        Card newCard = new Card(card.getTitle(), card.getDescription());
        newCard.setCreationDate(LocalDateTime.now());
        cardRepo.save(newCard);
        newCard.setCheckablePoints(newCheckablePoints);
        return cardRepo.save(newCard);

    }

    @PutMapping
    public Card update(
            @PathVariable("id") Card cardFromDB,
            @RequestBody Card card
    ){

        BeanUtils.copyProperties(card, cardFromDB, "id");
        return cardRepo.save(cardFromDB);
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = {RequestMethod.DELETE})
    public void delete(@PathVariable("id") Card card){
        cardRepo.delete(card);
    }

    @GetMapping("{id}/points")
    public List<CheckablePoint> getCheckablePoints(@PathVariable("id") Card card){
        return card.getCheckablePoints();
    }

}
