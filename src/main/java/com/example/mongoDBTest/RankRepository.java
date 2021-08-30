package com.example.mongoDBTest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RankRepository extends MongoRepository<RankBean, Integer>{
    Optional<RankBean> findById(Integer id);
}


// @Repository
// public class MemberRepository {
//     public List<MemberBean> findAll(){
//         return new ArrayList<MemberBean>();
//     }
// }