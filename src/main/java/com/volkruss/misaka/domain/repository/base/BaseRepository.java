package com.volkruss.misaka.domain.repository.base;

import com.volkruss.misaka.domain.context.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class BaseRepository{

    public abstract EntityManager getEntityManager();

    // cannot reliably process 'persist' call
    // トランザクション内でしか呼出すことができません
    @Transactional
    public <T extends Entity> T save(T entity){
        getEntityManager().persist(entity);
        return entity;
    }

    // TODO 型制約をつける
    public <T> T get(Class<T> clazz, Serializable id){
        return getEntityManager().find(clazz,id);
    }

    // TODO CriteriaQueryを作成するテンプレの作成
    public <T extends Entity> List<T> find(CriteriaQuery<T> query) {
        return getEntityManager().createQuery(query).getResultList();
    }

    public <T extends Entity> List<T> findAll(String queryStr, Map<String,Object> args){
        Query query = getEntityManager().createNamedQuery(queryStr);
        for(Map.Entry<String, Object> entry : args.entrySet()){
            query.setParameter(entry.getKey(),entry.getValue());
        }
        return query.getResultList();
    }

    public <T extends Entity> List<T> findAllByQuery(String queryStr, Map<String,Object> args){
        Query query = getEntityManager().createQuery(queryStr);
        for(Map.Entry<String, Object> entry : args.entrySet()){
            query.setParameter(entry.getKey(),entry.getValue());
        }
        return query.getResultList();
    }

    /*
    public <T extends Entity> List<T> findAll(String queryStr, Object... args){
        Query query = getEntityManager().createQuery(queryStr);
        for(int i = 0; i < args.length; i++){
            query.setParameter(i + 1, args[i]);
        }
        return query.getResultList();
    }
     */

}
