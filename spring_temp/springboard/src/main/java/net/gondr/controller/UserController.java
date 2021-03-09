package net.gondr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.gondr.domain.LoginDTO;
import net.gondr.domain.RegisterDTO;
import net.gondr.domain.UserVO;
import net.gondr.service.UserService;
import net.gondr.util.FileUtil;
import net.gondr.validator.RegisterValidator;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String viewRegisterPage(Model model) {
		model.addAttribute("registerDTO", new RegisterDTO());	
		return "user/register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerProcess(RegisterDTO registerDTO, Errors errors) throws Exception {
		new RegisterValidator().validate(registerDTO, errors);
		
		if(errors.hasErrors()) {
			return "user/register";
		}
		
		String uploadPath = context.getRealPath("/WEB-INF/upload");
		
		MultipartFile file = registerDTO.getProfileImg();
		//업로드한 파일이 존재하면
		String upFile = "";
		
		if(!file.getOriginalFilename().equals("")) {
			upFile = FileUtil.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		
		UserVO user = new UserVO();
		user.setImg(upFile);
		user.setName(registerDTO.getUsername());
		user.setPassword(registerDTO.getPassword());
		user.setUserid(registerDTO.getUserid());
		
		service.register(user);
				
		return "redirect:/";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String userLogin(LoginDTO loginDTO, HttpSession session, Model model, UserVO userVO) {
		if(loginDTO.getUserid().isEmpty() || loginDTO.getPassword().isEmpty()) {
			model.addAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요.");
			return "user/login";
		}
		
		UserVO user = service.login(loginDTO.getUserid(), loginDTO.getPassword());
		
		if(user == null) {
			model.addAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요.");
			return "user/login";
		}
		
		service.updateEXP(userVO);
		
		Integer level = service.getUserLevel(userVO); //현재 유저 레벨
		Integer exp = service.getLevelOnEXP(level); //다음 경험치
		Integer currentEXP = service.getUserEXP(userVO);
		
		if(currentEXP >= exp) {
			service.resetEXP(user);
			service.updateLevel(user);
			user = service.login(loginDTO.getUserid(), loginDTO.getPassword());
		}
		
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String viewLoginPage(Model model) {
		model.addAttribute("loginDTO", new LoginDTO());
		return "user/login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	public String registerProcess(RegisterDTO dto) throws Exception {
		String uploadPath = context.getRealPath("/WEB-INF/upload");
		System.out.println(uploadPath);
		
		MultipartFile file = dto.getProfileImg();
		String upFile = FileUtil.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		System.out.println(uploadPath + "에" + upFile + "로 업로드 되었습니다.");
				
		return "user/register";
	}
	
	@RequestMapping(value="profile/{file:.*}", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getUserProfile(@PathVariable String file) throws IOException {
		String uploadPath = context.getRealPath("/WEB-INF/upload");
		
		String defaultImage = "nouser.png";
		
		try {
			File profile = new File(uploadPath + File.separator + file);
			FileInputStream fis = new FileInputStream(profile);
			return IOUtils.toByteArray(fis);
		} catch (FileNotFoundException e) {
			File profile = new File(uploadPath + File.separator + defaultImage);
			FileInputStream fis = new FileInputStream(profile);
			return IOUtils.toByteArray(fis);
		}
	}
	
}
