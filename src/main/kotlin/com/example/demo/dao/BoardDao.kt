package com.example.demo.dao

import com.example.demo.model.BoardDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BoardDao {
	fun selectGetList():List<BoardDto>?
}