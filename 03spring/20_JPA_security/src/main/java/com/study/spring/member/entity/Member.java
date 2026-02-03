package com.study.spring.member.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "memberRoleList")
public class Member {
	
	@Id
	private String email;
	private String pw;
	private String nickname;
	private boolean social;
	
	// 엔티티가 아닌 값 타입(List, Set, Map 등)을 컬렉션으로 관리할 때 사용
	@ElementCollection(fetch = FetchType.LAZY)
	// Builder로 객체를 만들 때도 필드의 초기값을 유지하겠다
	@Builder.Default
	private List<MemberRole> memberRoleList = new ArrayList<>();
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	// 자동으로 생성(맨 처음)
	@PrePersist
	public void onCreate() {
		this.createAt = LocalDateTime.now();
		this.updateAt = LocalDateTime.now();
	}
	
	// 업데이트시
	@PreUpdate
	public void onUpdate() {
		this.updateAt = LocalDateTime.now();
	}
	
	public void addRole(MemberRole memberRole) {
		memberRoleList.add(memberRole);
	}
	
	public void clearRole() {
		memberRoleList.clear();
	}

	public void changePw(String pw) {
		this.pw = pw;
	}

	public void changeNickname(String nickname) {
		this.nickname = nickname;
	}

	public void changeSocial(boolean social) {
		this.social = social;
	}
}
