package com.miko.demo.postgresql.service;

import com.miko.demo.postgresql.model.EntityA;
import com.miko.demo.postgresql.model.EntityB;
import com.miko.demo.postgresql.model.QEntityA;
import com.miko.demo.postgresql.model.QEntityB;
import com.miko.demo.postgresql.repository.EntityADataRepository;
import com.miko.demo.postgresql.repository.EntityBDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

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
 * Date: 12/31/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class EntityACreationTest {

    @Autowired
    EntityADataRepository entityADataRepository;

    @Autowired
    EntityBDataRepository entityBDataRepository;

    private static final QEntityA qEntityA = QEntityA.entityA;
    private static final QEntityB qEntityB = QEntityB.entityB;

    private Logger logger = LoggerFactory.getLogger(EntityACreationTest.class);

    @Test
    public void testEntitiesCreation(){

        EntityA entityA1 = new EntityA("mirage1",22L);
        EntityA entityA2 = new EntityA("mirage2",22L);
        EntityA entityA3 = new EntityA("mirage3",22L);

        EntityB entityB1 = new EntityB("miko1", 1L, entityA1);
        EntityB entityB2 = new EntityB("miko2", 2L, entityA1);
        EntityB entityB3 = new EntityB("miko3", 3L, entityA2);
        EntityB entityB4 = new EntityB("miko4", 4L, entityA2);
        EntityB entityB5 = new EntityB("miko5", 5L, entityA3);

        entityA1 = entityADataRepository.save(entityA1);
        entityA2 = entityADataRepository.save(entityA2);
        entityA3 = entityADataRepository.save(entityA3);
        entityB1 = entityBDataRepository.save(entityB1);
        entityB2 = entityBDataRepository.save(entityB2);
        entityB3 = entityBDataRepository.save(entityB3);
        entityB4 = entityBDataRepository.save(entityB4);
        entityB5 = entityBDataRepository.save(entityB5);

        Assert.notNull(entityA1.getOid());
        Assert.notNull(entityA2.getOid());
        Assert.notNull(entityA3.getOid());

    }



}
