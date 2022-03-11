package com.volkruss.misaka.effective.pt17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class AnimeTest {

    @Test
    public void test_01(){
        // とあるに出てくるキャラクターを保持しています。
        Anime toaru = new Anime("御坂美琴","白井黒子","食蜂操祈");
        // とあるのキャラクターリストを取得しました。
        List<String> characters = toaru.getCharacters();
        // 俺妹のキャラが入ってきたけど、新しい変数に割り当ててるから大丈夫？？
        characters.add("高坂桐乃");
        // とあるキャラのリストを、Animeとあるから再度取得（桐乃はいないよね？）
        List<String> toarucharacters = toaru.getCharacters();
        // failed
        assertEquals(false, toarucharacters.contains("高坂桐乃"));

        characters.forEach(s->{
            System.out.println(s);
        });
        System.out.println("-------------------");
        toarucharacters.forEach(s->{
            System.out.println(s);
        });

    }
}