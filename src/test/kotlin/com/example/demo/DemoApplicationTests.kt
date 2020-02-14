package com.example.demo

import com.example.demo.dao.BoardDao
import com.example.demo.model.BoardDto
import io.mockk.mockk
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertEquals

@AutoConfigureMockMvc	//	to use mockMvc
@SpringBootTest			//	to use spring boot unit test
@WebAppConfiguration
class DemoApplicationTests(@Autowired private val mockMvc:MockMvc){

	private val testPost: BoardDto = mockk()

	/*@Test
	fun contextLoads(@Autowired mgr: ListMgr) {
		val result = mgr.getPostByNum(112)
		assertEquals(requiredValue, result, "not no.112 post")
	}*/

	@Test
	@Disabled
	fun isGetRequestOk(){
		val requestURL = "/main"

		this.mockMvc.perform(MockMvcRequestBuilders.get(requestURL))
				.andDo{it->print(it.response.status)}
				.andExpect(status().isOk)
	}


	@Test
	@Transactional
	@Disabled
	fun isBoardTable(@Autowired dao: BoardDao){
		val list = dao.selectGetList()?: listOf()
		assertEquals(list.size, 50)
	}

	@Test
	@Disabled
	fun isCopiedObjisEquals(){
		val a = BoardDto().apply {
			num = 12
			title = "test test"
		}

		val b = a.copy()
		val c = a.copy(num = 14)

		assertAll(
				{assertEquals(a,b, "copy 동일")},	//	-> passed
				{assertEquals(b,c, "copy(변경) !동일 ")}	//	-> failed
		)
	}

}
