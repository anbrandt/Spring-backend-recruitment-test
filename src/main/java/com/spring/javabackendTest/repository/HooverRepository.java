package com.spring.javabackendTest.repository;

import com.spring.javabackendTest.model.HooverResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by andrzej on 23.08.17.
 */

//here mongo db service
public interface HooverRepository extends MongoRepository<HooverResponse, String> {


}
