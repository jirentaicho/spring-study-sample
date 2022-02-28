package com.volkruss.misaka.domain.model.basetest;

import com.volkruss.misaka.domain.context.DataAccessObject;
import com.volkruss.misaka.domain.repository.base.BaseRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repositoryに自分自身を渡してデータアクセスを行う
 *
 */
@Entity
@Setter
@Getter
@Table(name="cards")
@NamedQueries({
        @NamedQuery(name="Card.findAllCard",query="select a from Card a where a.user_id = :id")
})
/**
 * NamedQueryはテーブル名でなくてClass名を指定します。
 */
public class Card extends DataAccessObject {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "name")
    private String name;

    public static List<Card> findAllById(final BaseRepository repository, Map<String,Object> args){
        // NamedQueryを利用する場合はcreateNamedQueryメソッドをコールします
        return repository.findAll("Card.findAllCard",args);
        // return repository.findAllByQuery("select a from Card a where a.user_id = :id", args);
    }

}
