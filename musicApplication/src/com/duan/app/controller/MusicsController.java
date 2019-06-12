package com.duan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.duan.app.entity.Musics;
import com.duan.app.service.MusicsService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName:MusicController.java
 * @Description 歌曲Controller
 * @author duan
 * @Time 2019年5月21日下午10:35:54
 * 
 */
@Controller
@RequestMapping("/musics")
public class MusicsController {

    @Autowired
    private MusicsService musicsService;

    @RequestMapping("/selectAllMusics")
    public ModelAndView selectAllMusics(Musics musics) throws Exception {

	List<Musics> musicList = musicsService.selectMusicsByName(musics);

	ModelAndView modelAndView = new ModelAndView();

	ObjectMapper objectMapper = new ObjectMapper();

	String list = objectMapper.writeValueAsString(musicList);

	modelAndView.addObject("musicList", list);
	modelAndView.setViewName("musicList");

	return modelAndView;
    }
    
    @RequestMapping("/selectMusicsByName")
    public @ResponseBody List<Musics> selectMusicsByName(Musics musics) throws Exception {

	List<Musics> musicList = musicsService.selectMusicsByName(musics);

	return musicList;
    }

    @RequestMapping("/findMusicsById")
    public @ResponseBody Musics playMusics(Integer id) throws Exception {

	Musics musics = musicsService.findMusicsById(id);
	
	return musics;
    }

    @RequestMapping("/editMusics")
    public String editMusics(Model model, Integer id) throws Exception {

	Musics musics = musicsService.findMusicsById(id);

	model.addAttribute("musics", musics);

	return "musics/editMusics";
    }

    @RequestMapping("/editMusicsSubmit")
    public String editMusicsSubmit(Model model, Integer id, @Validated Musics musics, BindingResult bindingResult)
	    throws Exception {

	if (bindingResult.hasErrors()) {
	    // 获取检验不合法信息
	    List<ObjectError> allErrors = bindingResult.getAllErrors();
	    for (ObjectError objectError : allErrors) {
		// 输出错误信息
		System.out.println(objectError.getDefaultMessage());
	    }

	    // 将错误信息传到页面
	    model.addAttribute("allErrors", allErrors);

	    return "musics/";

	}

	musicsService.updateMusics(id, musics);

	return "musics/";
    }

    @RequestMapping("/deleteMusics")
    public String deleteMusics(Integer[] id) throws Exception {

	musicsService.deleteMusics(id);

	return null;
    }

    @RequestMapping("/insertMusics")
    public String insertMusics(Musics musics) throws Exception {

	musicsService.insertMusics(musics);

	return null;
    }

}
