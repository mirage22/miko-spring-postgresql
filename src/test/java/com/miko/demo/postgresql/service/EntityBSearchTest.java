package com.miko.demo.postgresql.service;

import com.miko.demo.postgresql.model.EntityB;
import com.miko.demo.postgresql.model.QEntityA;
import com.miko.demo.postgresql.model.QEntityB;
import com.miko.demo.postgresql.repository.EntityBDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

import static com.mysema.query.collections.MiniApi.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

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
 * Date: 1/1/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-core-config-test.xml")
public class EntityBSearchTest {

    @Autowired
    EntityBDataRepository entityBDataRepository;

    @Autowired
    EntityBService entityBService;

    private static final QEntityA qEntityA = QEntityA.entityA;
    private static final QEntityB qEntityB = QEntityB.entityB;

    private Logger logger = LoggerFactory.getLogger(EntityBSearchTest.class);


    @Test
    public void searchEntityBListServiceTest(){
        Iterable<EntityB> resultList = entityBService.findAllByParentName("mirage");

        Assert.notNull(resultList);
    }

    @Test
    public void searchEntityBListRepositoryTest(){
        Iterable<EntityB> resultList =  entityBDataRepository.findAll(qEntityB.parent.name.eq("mirage"));

        Assert.notNull(resultList);
    }

    @Test
    public void searchEntityBListByNameTest(){

        List<EntityB> resultList = from(qEntityB, entityBDataRepository.findAll())
                .where(qEntityB.name.contains("tanja"))
                .list(qEntityB);

        for(EntityB entityB: resultList){
            logger.debug("search EntityB Test = " + entityB.getName());
        }

        assertThat(resultList, hasSize(5));
    }
}
