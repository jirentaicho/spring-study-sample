package com.volkruss.misaka.domain.context;

import com.volkruss.misaka.domain.repository.base.BaseRepository;

import javax.transaction.Transactional;

public abstract class DataAccessObject<T extends Entity> implements Entity{

    public T save(final BaseRepository repository){
        return (T) repository.save(this);
    }
}
