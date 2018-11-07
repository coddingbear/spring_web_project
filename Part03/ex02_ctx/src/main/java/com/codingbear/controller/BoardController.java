package com.codingbear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbear.domain.BoardVO;
import com.codingbear.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 10 프리젠테이션(웹) 계층의 CRUD 구현 - Cotroller 구현
@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list ..... ");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register form.....");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping(value={"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get or modify ..... bno = " + bno);
		log.info(service.get(bno));
		model.addAttribute("board", service.get(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..... " + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
