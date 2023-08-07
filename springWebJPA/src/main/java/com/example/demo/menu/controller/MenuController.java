package com.example.demo.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.paging.Pagenation;
import com.example.demo.common.paging.SelectCriteria;
import com.example.demo.menu.dto.StudyDTO;
import com.example.demo.menu.service.MenuService;

import jakarta.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private final MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("/{menuCode}")
	public ModelAndView findMenuByCode(ModelAndView mv, @PathVariable int menuCode) {

		StudyDTO table = menuService.findMenuByCode(menuCode);
		
		mv.addObject("table", table);
		mv.setViewName("/menu/one");
		
		return mv;
	}
	
	@GetMapping("/list")
	public ModelAndView findMenuList(ModelAndView mv) {

		List<StudyDTO> tableList = menuService.findMenuList();
		
		mv.addObject("tableList", tableList);
		mv.setViewName("menu/list");
		
		return mv;
	}
	
	@GetMapping("/regist")
	public void registPage() {}
	
	@PostMapping("/regist")
	public ModelAndView registMenu(ModelAndView mv, StudyDTO newMenu, RedirectAttributes rttr) {

		menuService.registNewMenu(newMenu);

		rttr.addFlashAttribute("registSuccessMessage", "메뉴 등록에 성공하셨습니다");
		mv.setViewName("redirect:/menu/list");
		
		return mv;
	}
	
	@GetMapping("/modify")
	public void modifyPage() {
		System.out.println("Modify");
	}
	
	@PostMapping("/modify")
	public String modifyPage(RedirectAttributes rttr, @ModelAttribute StudyDTO table) {
		
		System.out.println("ModifyPost");
		menuService.modifyMenu(table);
		
		rttr.addFlashAttribute("modifySuccessMessage", "메뉴 수정에 성공하셨습니다");
		
		System.out.println(table.getStudyID());
		return "redirect:/menu/" + table.getStudyID();
	}

	@GetMapping("/search")
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = menuService.selectTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		List<StudyDTO> tableList = menuService.searchMenuList(selectCriteria);

		mv.addObject("tableList", tableList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("menu/search");

		return mv;
	}
}