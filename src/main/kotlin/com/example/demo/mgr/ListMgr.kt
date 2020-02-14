package com.example.demo.mgr

import com.example.demo.dao.BoardDao
import com.example.demo.model.BoardDto
import org.springframework.stereotype.Service

interface ListMgr{
	fun getList():List<BoardDto>
	fun getPostByNum(num:Int):BoardDto
}

@Service
class ListMgrImpl(private val dao:BoardDao): ListMgr {
	override fun getList(): List<BoardDto> = dao.selectGetList()?: arrayListOf()
	override fun getPostByNum(num:Int): BoardDto = dao.selectGetPost(num)?: BoardDto()
}
