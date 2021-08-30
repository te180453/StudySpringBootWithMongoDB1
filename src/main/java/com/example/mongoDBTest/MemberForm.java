package com.example.mongoDBTest;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

// バリデーションしてないからでたらめなデータが挿入できてしまう。
// 特にランクとランク詳細についてはランクとして存在しないデータも挿入できる
// ランクだけ挿入時に必須として、ランク詳細はDBから取り出す。

@Data
@NoArgsConstructor
public class MemberForm {
    private Integer _id;
    private String 姓;
    private String 名;
    private String 性別;
    private String 電話番号;
    private LocalDate 生年月日;
    private Integer 年齢;

    private Integer ランク;

    private RankForm ランク詳細;
}