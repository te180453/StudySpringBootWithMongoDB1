package com.example.mongoDBTest;

import lombok.*;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Entity
//コレクション名を@Documentアノテーションで指定
@Data
@Document(collection = "会員表")
@NoArgsConstructor
@AllArgsConstructor
public class MemberBean {
    @Id
    Integer _id;
    String 姓;
    String 名;
    String 性別;
    String 電話番号;
    LocalDate 生年月日;
    Integer 年齢;
    Integer ランク;

    @ManyToOne
    @JoinColumn(name="ランク")
    RankBean ランク詳細;
}
