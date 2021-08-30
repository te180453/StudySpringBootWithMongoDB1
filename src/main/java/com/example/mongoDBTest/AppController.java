package com.example.mongoDBTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    MemberService memberService;

    @Autowired
    RankService rankService;

    @GetMapping(path = "/member")
    public
    List<MemberForm> findAllMembers(){
        return memberService.findAll();
    }

    @GetMapping(path = "/rank")
    public
    List<RankForm> findAllRanks(){
        return rankService.findAll();
    }

    @PostMapping(path = "/member")
    public
    ResponseEntity<Map<String, Object>> postMember(@RequestBody MemberForm memberForm){
        Map<String, Object> map = new HashMap<>();
        try{
            MemberBean inserted = memberService.save(memberForm);
            map.put("return", inserted);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(IllegalArgumentException exception){
            map.put("error", exception.getMessage());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
