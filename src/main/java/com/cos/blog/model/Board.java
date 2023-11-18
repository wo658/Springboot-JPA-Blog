package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false , length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 
	
	@ColumnDefault("0") // int 값이기 때문에 ' ' 필요 X
	private int count; // 조회수
	
	@ManyToOne(fetch= FetchType.EAGER)	// Many = Board , User = One , OneToOne도가능 
	@JoinColumn(name="userId")    // 그냥 이렇게 정해주는거고
	private User user; // 누가 적었는지 알기 위해 select 나 join 필요한데 ORM에서는
									// user오브젝트를 바로 넣으면 됨.
									// 원래는 DB에 오브젝트 저장 불가능 하지만 ORM이 가능한 것 처럼 바꿔줌
	
	//JoinColumn 필요 없음.
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER)	//mappedBy 연관관계 주인 X (난 FK 아니에요) DB에 컬럼을 만들지 마세요
	private List<Reply> reply;
	// 즉 연관관계의 주인은 board가 되어야 한다. 키를 board로 사용해야 함.
	// user는 보드당 한건이기 때문에 EAGER 전략으로 바로 갖고와서 FK로 사용하지만
	// reply는 너무 많다. 그래서 필요한 것만 들고 와야함. (LAZY 전략)
	// 물론 UI전략에 따라 달라짐.
	
	@CreationTimestamp
	private Timestamp createDate;
}
