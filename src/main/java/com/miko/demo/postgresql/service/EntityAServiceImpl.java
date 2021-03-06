package com.miko.demo.postgresql.service;

import com.miko.demo.postgresql.dto.EntityADTO;
import com.miko.demo.postgresql.model.EntityA;
import com.miko.demo.postgresql.model.QEntityA;
import com.miko.demo.postgresql.repository.EntityADataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */

@Service("entityAService")
@SuppressWarnings("unchecked")
public class EntityAServiceImpl implements EntityAService{

    @Autowired
    private EntityADataRepository entityADataRepository;

    private static final QEntityA qEntityA = QEntityA.entityA;

    private Logger logger = LoggerFactory.getLogger(EntityAServiceImpl.class);


    @Override
    public EntityA findByName(String name) {
        return entityADataRepository.findOne(qEntityA.name.eq(name));
    }

    @Override
    public Iterable<EntityA> findAll() {
        return entityADataRepository.findAll();
    }

    @Override
    public List<EntityADTO> findAllDTO() {
        List<EntityADTO> result = new ArrayList<>();

        for(EntityA entityA: findAll()){
            result.add(new EntityADTO(entityA.getName(), entityA.getValue()));
        }

        return result;
    }

    @Override
    public EntityA save(EntityA entityA) {
        return entityADataRepository.save(entityA);
    }

    @Override
    public void delete(EntityA entityA) {
        entityADataRepository.delete(entityA);
    }
}
