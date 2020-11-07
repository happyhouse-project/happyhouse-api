package com.ssafy.happyhouse.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

public class NoticeTest {
	
	@Test
	public void creation() {
		Notice notice = new Notice();
		//assertThat(notice.getTitle(), is("공지 테스트"));
	}
}
