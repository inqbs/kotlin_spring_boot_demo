package com.example.demo.mgr

import com.example.demo.dao.BoardDao
import com.example.demo.model.BoardDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface ListMgr{
	fun getList():List<BoardDto>
}

@Service
class ListMgrImpl(@Autowired val dao:BoardDao):ListMgr{
	override fun getList(): List<BoardDto> = dao.selectGetList()?: arrayListOf()
}