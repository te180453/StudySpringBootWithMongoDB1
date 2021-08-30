package com.example.mongoDBTest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemberRepository extends MongoRepository<MemberBean, Integer>{
}