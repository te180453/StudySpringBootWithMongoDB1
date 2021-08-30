package com.example.mongoDBTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RankRepository rankRepository;

    public
    List<MemberForm> findAll(){
        List<MemberBean> beans = memberRepository.findAll();
        List<MemberForm> memberForms = new ArrayList<>();
        for(MemberBean memberBean : beans){
            MemberForm memberForm = new MemberForm();
            BeanUtils.copyProperties(memberBean, memberForm);
            memberForm.setランク詳細(new RankForm());
            BeanUtils.copyProperties(memberBean.ランク詳細,memberForm.getランク詳細());
            memberForms.add(memberForm);
        }
        return memberForms;
    }

    public
    MemberBean save(MemberForm memberForm) throws IllegalArgumentException{
        // ランクの検証
        // 参照制約
        Optional<RankBean> rank = rankRepository.findById(memberForm.getランク());
        if(rank.isPresent() == false)
            throw new IllegalArgumentException(String.format("指定されたランクIDの%dは存在しません。", memberForm.getランク()));

        // データ追加
        MemberBean memberBean = new MemberBean();
        BeanUtils.copyProperties(memberForm, memberBean);
        memberBean.setランク詳細(new RankBean());
        BeanUtils.copyProperties(rank.get(), memberBean.ランク詳細);
        memberBean._id = getMaxId() + 1;
        memberRepository.save(memberBean);
        return memberBean;
    }

    private int getMaxId(){
        return 
            memberRepository.findAll().stream()
            .mapToInt(e -> { return e.get_id();})
            .max().getAsInt();
    }
}
