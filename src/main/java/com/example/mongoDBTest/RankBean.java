package com.example.mongoDBTest;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
//コレクション名を@Documentアノテーションで指定
@Data
@Document(collection = "ランク表")
@NoArgsConstructor
@AllArgsConstructor
public class RankBean {
    @Id
    Integer _id;
    String ランク階級;

    @OneToMany(mappedBy = "ランク表")
    List<MemberBean> 会員;
}
