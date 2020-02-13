package com.example.demo.model

import java.time.LocalDateTime

data class BoardDto(
		val title: String,
		val description: String,
		val regdate: LocalDateTime
)