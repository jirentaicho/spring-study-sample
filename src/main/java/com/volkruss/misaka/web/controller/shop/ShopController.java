package com.volkruss.misaka.web.controller.shop;

import com.volkruss.misaka.domain.model.basetest.Card;
import com.volkruss.misaka.domain.model.user.Role;
import com.volkruss.misaka.domain.repository.base.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {

    @Autowired
    private DefaultRepository defaultRepository;

    @GetMapping("/")
    public String home(){

        // Cardの取得を行う
        List<Card> cards = Card.findAllById(this.defaultRepository, Map.of("id",1));

        // Cardの新規登録を行う(動きます）
        /*
        Card card = new Card();
        card.setUser_id(1);
        card.setName("GEKOTA");
        card.save(this.defaultRepository);
        */

        System.out.println(cards);

        return "HOME";
}

    @GetMapping("/track")
    public String track(){
        return "TRACK";
    }

    @GetMapping("/system/scan")
    public String system(){
        return "SYSTEM";
    }

    @GetMapping("/admin/scan")
    public String admin(){ return "ADMIN"; }

    @GetMapping("/brows")
    public String brows(){
        return "BROWS";
    }
    @GetMapping("/update")
    public String update(){
        return "UPDATE";
    }

    @GetMapping("/delete")
    public String delete(){
        return "DELETE";
    }

}
