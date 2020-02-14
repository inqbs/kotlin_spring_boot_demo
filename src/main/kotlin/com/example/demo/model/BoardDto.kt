package com.example.demo.model

import java.time.LocalDateTime

data class BoardDto(
		var num: Int = 0,
		var title: String = "",
		var description: String = "",
		var email: String = "",
		var regdate: LocalDateTime = LocalDateTime.MIN
)