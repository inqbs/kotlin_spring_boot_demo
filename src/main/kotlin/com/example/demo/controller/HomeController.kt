package com.example.demo.controller

import com.example.demo.mgr.ListMgr
import com.example.demo.model.TestDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate

@RestController
class HomeController(private val listMgr: ListMgr){

	companion object{
		private val logger:Logger = LoggerFactory.getLogger(HomeController::class.java)
	}

	@GetMapping("/main")
	fun getMainView (@RequestParam(required=false, defaultValue = "User") name:String):ModelAndView{
		val vo = TestDto(
			id = "test",
			name = name,
			birth = LocalDate.of(2003,3,15)
		)

		val list = listMgr.getList()

		return ModelAndView().apply{
			viewName = "main"
			addObject("list", list)
			addObject("vo", vo)
		}
	}

	@GetMapping("/sub")
	fun getSubView(@RequestParam(required=false, defaultValue = 0.toString()) num:Int):ModelAndView{

		val post = listMgr.getPostByNum(num)

		return ModelAndView().apply{
			viewName="sub"
			addObject("post",post)
		}
	}


}