package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	// 오라클 , MySQL 등등 어떤 DB를 사용하냐에 따라 달라지게 설정.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false , length = 30)
	private String username; // 아이디
	
	@Column(nullable = false , length = 100) // 해쉬(암호화 ) 넉넉히 
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는게 좋다. // admin , user , manager  Enum을 써야 오타를 방지 가능 함.
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
	
}
