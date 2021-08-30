package com.example.mongoDBTest;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
public class RankForm {
    private Integer _id;
    private String ランク階級;

    List<MemberForm> 会員;
}