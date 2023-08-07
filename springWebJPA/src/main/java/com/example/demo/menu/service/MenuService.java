package com.example.demo.menu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.paging.SelectCriteria;
import com.example.demo.menu.dto.StudyDTO;
import com.example.demo.menu.entity.Study;
import com.example.demo.menu.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final ModelMapper modelMapper;			
	
	@Autowired
	public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
		this.menuRepository = menuRepository;
		this.modelMapper = modelMapper;
	}

	public StudyDTO findMenuByCode(int menuCode) {

		/* findById메소드로 Optional 객체 조회후 Optional객체의 get메소드를 통해 조회 */
		Study menu = menuRepository.findById(menuCode).get();
		
		/* ModelMapper를 이용하여 entity를 DTO로 변환 후 MenuDTO로 반환 */
		return modelMapper.map(menu, StudyDTO.class);
	}

	public List<StudyDTO> findMenuList() {

		List<Study> menuList = menuRepository.findAll(Sort.by("studyId"));					// Sort는 org.springframework.data.domain패키지로 import
		
		/* ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return menuList.stream().map(menu -> modelMapper.map(menu, StudyDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public void registNewMenu(StudyDTO newMenu) {

		menuRepository.save(modelMapper.map(newMenu, Study.class));
	}

	@Transactional
	public void modifyMenu(StudyDTO menu) {

		Study foundMenu = menuRepository.findById(menu.getStudyID()).get();
		foundMenu.setName(menu.getName());
		foundMenu.setDescription(menu.getDescription());
	}

	public int selectTotalCount(String searchCondition, String searchValue) {

		int count = 0;
		if(searchValue != null) {
			
			if("name".equals(searchCondition)) {
				count = menuRepository.countByNameContaining(searchValue);
			}

			if("description".equals(searchCondition)) {
				count = menuRepository.countByDescriptionContaining(searchValue);
			}
		} else {
			count = (int)menuRepository.count();
		}

		return count;
	}

	public List<StudyDTO> searchMenuList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;			
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		/* 페이징 처리와 정렬을 위한 객체 생성 */
		Pageable paging = PageRequest.of(index, count, Sort.by("studyId"));	

		List<Study> menuList = new ArrayList<Study>();
		if(searchValue != null) {

			/* 이름 검색일 경우 */
			if("name".equals(selectCriteria.getSearchCondition())) {
				menuList = menuRepository.findByNameContaining(selectCriteria.getSearchValue(), paging);
			}

			/* 설명 검색일 경우 */
			if("description".equals(selectCriteria.getSearchCondition())) {
				menuList = menuRepository.findByDescriptionContaining(selectCriteria.getSearchValue(), paging);
			}
			
		} else {
			menuList = menuRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return menuList.stream().map(menu -> modelMapper.map(menu, StudyDTO.class)).collect(Collectors.toList());
	}
}