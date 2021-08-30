package com.example.mongoDBTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService {

    @Autowired
    RankRepository rankRepository;

    public List<RankForm> findAll(){
        List<RankBean> beans = rankRepository.findAll();
        List<RankForm> rankForms = new ArrayList<>();
        for(RankBean rankBean : beans){
            RankForm rankForm = new RankForm();
            BeanUtils.copyProperties(rankBean, rankForm);
            rankForms.add(rankForm);
        }
        return rankForms;
    }
}
