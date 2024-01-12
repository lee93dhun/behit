package com.behit.profile.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.behit.approval.dto.ApprovalDTO;
import com.behit.approval.service.ApprovalService;
import com.behit.chat.dto.ChatRoomDTO;
import com.behit.employee.dto.EmployeeDTO;
import com.behit.employee.dto.WorkDTO;
import com.behit.profile.dto.FileDTO;
import com.behit.profile.service.DashBoardService;
import com.behit.project.dto.ProjectDTO;

@Controller
public class DashBoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired DashBoardService dashService;

	// 기본 정보들
	@GetMapping(value = "/home.go")
	public String homeGo(HttpSession session, Model model) {
		logger.info("home page로 이동");
		EmployeeDTO loginInfo = (EmployeeDTO) session.getAttribute("loginInfo");
		String login_id = loginInfo.getEmp_id();
		logger.info("로그인 아이디 : "+login_id);
		EmployeeDTO dashProfile=dashService.detail(login_id);
		FileDTO photo = dashService.getPhoto(login_id);
		
	
		
		// 대시보드의 결재 리스트
		List<ApprovalDTO> reqAp_list = dashService.reqAp_list(login_id);
		logger.info("reqAp_list"+reqAp_list);
		
		// 대시보드의 프로젝트 리스트
		ArrayList<ProjectDTO> projnow_list = dashService.projnow(login_id);
		
		// 대시보드의 근태관리 섹션
		WorkDTO workToday =dashService.workToday(login_id);
		
		model.addAttribute("reqAp_list", reqAp_list);
		model.addAttribute("projnow_list", projnow_list);
		model.addAttribute("workToday", workToday);
		model.addAttribute("dashProfile", dashProfile);
		model.addAttribute("photo", photo);
		return "home";
	}
	
	
	@RequestMapping(value="/workStarted")
	@ResponseBody
	public HashMap<String, Object> workStarted(HttpSession session){
		HashMap<String, Object> result = new HashMap<String, Object>();
		EmployeeDTO empdto=(EmployeeDTO) session.getAttribute("loginInfo");
		String loginId=empdto.getEmp_id();
		logger.info("출근요청 옴");
		
		// 현재 한국 시간을 YYYY-MM-DD hh:mm:ss 형식으로 변환
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
	    String workStartedTime = sdf.format(new Date());
		int workStarted=dashService.workStarted(loginId, workStartedTime);
		result.put("workStarted", workStarted);
		result.put("loginId", loginId);
		return result;
	}
	
	@RequestMapping(value="/workEnded")
	@ResponseBody
	public HashMap<String, Object> workEnded(HttpSession session){
		HashMap<String, Object> result = new HashMap<String, Object>();
		EmployeeDTO empdto=(EmployeeDTO) session.getAttribute("loginInfo");
		String loginId=empdto.getEmp_id();
		logger.info("퇴근요청 옴");
		
		// 현재 한국 시간을 YYYY-MM-DD hh:mm:ss 형식으로 변환
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
	    String workEndedTime = sdf.format(new Date());
		int workEnded=dashService.workEnded(loginId, workEndedTime);
		result.put("workEnded", workEnded);
		result.put("loginId", loginId);
		return result;
	}
	
	
}
