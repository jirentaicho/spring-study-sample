package com.volkruss.misaka.effective.pt17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Anime {

    private List<String> characters = new ArrayList<>();

    public Anime(String... args){
        for(String talent : args){
            this.characters.add(talent);
        }
    }

    public List<String> getCharacters(){
        return this.characters.stream().collect(Collectors.toList());
    }

}
