package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 아파트 및 주택정보 관련 뉴스 모델 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {

	/** 뉴스 관리 id */
	private int id;

	/** 뉴스 제목 */
	private String title;

	/** 뉴스 링크 */
	private String link;

	/** 뉴스 등록자 */
	private String register;

	/** 뉴스 등록자 id */
	private int registerId;

	/** 카테고리 */
	private String category;
	
	/** 뉴스 등록일자 */
	private String registerDate;
	
	/** 뉴스 언론사 */
	private String agency;

}
