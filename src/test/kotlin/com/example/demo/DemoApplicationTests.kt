package com.example.demo

import com.example.demo.mgr.ListMgr
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration

@SpringBootTest
@WebAppConfiguration
class DemoApplicationTests {

	@Test
	fun contextLoads(@Autowired mgr: ListMgr) {
		val result = mgr.getList().size
		val requiredValue = 112
		Assertions.assertEquals(requiredValue, result, "DemoApplicationTests의 값 미동일");
	}

}
