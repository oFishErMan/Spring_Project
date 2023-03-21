package com.CustomSoft.Controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CustomSoft.Service.BoardService;
import com.CustomSoft.db.PagingVo;
import com.CustomSoft.db.ReplyDto;
import com.CustomSoft.db.dto.board.BoardDto;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private BoardService service;

	@RequestMapping("regBoard")
	public String regBoard() {
		return "board/regBoard";
	}

	// modifyBoard.jsp 호출 및 기존 내용 유지
	@GetMapping("modifyBoard")
	public String modifyBoard(@RequestParam(value = "board_seq", required = false) int board_seq, Model model)
			throws Exception {
		BoardDto dto = service.detailBoard(board_seq);
		model.addAttribute("list", dto);
		return "board/modifyBoard";
	}

	// 글쓰기
	@PostMapping("addBoard")
	public String addBoard(BoardDto dto) throws Exception {
		String path = context.getRealPath("/img/");
		String board_img_path = null;

		File savefile = new File(path, dto.getBoard_file().getOriginalFilename());
		try {
			dto.getBoard_file().transferTo(savefile);
		} catch (Exception e) { 
		}
		board_img_path = path + dto.getBoard_file().getOriginalFilename();
		dto.setBoard_img_path(board_img_path);
		service.addBoard(dto);
		return "redirect:boardList";
	}

	// 게시판 페이징 및 게시글 구현
	@GetMapping("boardList")
	public String boardList(PagingVo vo, Model model,
			@RequestParam(value = "search", required = false) String searchBoard,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		int total = service.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		vo = new PagingVo(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), searchBoard);
		List<BoardDto> lDto = service.selectBoard(vo);
		try {
			for (int i = 0; i < lDto.size(); i++) {
				if (lDto.get(i).getBoard_text().length() >=30)
					lDto.get(i).setBoard_text(lDto.get(i).getBoard_text().substring(0, 30)+".."); //게시글 내용 30글자 제한
				if (lDto.get(i).getBoard_title().length() >=20)
					lDto.get(i).setBoard_title(lDto.get(i).getBoard_title().substring(0, 20)+".."); //게시글 제목 20글자 제한
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("paging", vo);
		model.addAttribute("list", lDto);
		return "board/boardList";
	}

	// 게시글 삭제
	@PostMapping("delBoard")
	@ResponseBody
	public void delBoard(@RequestParam("valueArr[]") int[] seq_list) throws Exception {
		for (int i = 0; i < seq_list.length; i++) {
			service.delBoard(seq_list[i]);
		}
	}

	// 게시글 상세페이지
	@GetMapping("detailBoard")
	public String detailBoard(@RequestParam(value = "board_seq", required = false) int board_seq, Model model) {
		BoardDto dto = service.detailBoard(board_seq);
		List<ReplyDto> re_dto = service.getReply(board_seq);
		service.incView(board_seq);
		try {
			dto.setBoard_img_path(dto.getBoard_img_path().substring(63));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(dto.getBoard_good());
		model.addAttribute("reply_list", re_dto);
		model.addAttribute("list", dto);
		return "board/detailBoard";
	}

	// 게시글 수정
	@PostMapping("modifyBoardGo")
	@ResponseBody
	public String modifyBoardGo(@RequestParam Map<String, String> map) throws Exception {
		System.out.println(map);
		service.modifyBoard(map);
		return null;
	}
	
	//댓글 등록
	@PostMapping("addReply")
	public String addReply(ReplyDto dto) {
		service.addReply(dto);
		String seq = Integer.toString(dto.getReply_seq());
		String add = "redirect:detailBoard?board_seq=";
		return add+seq;
	}
	
	@PostMapping("incGood")
	@ResponseBody
	public int incGood(@RequestBody Map<, V>) {
		int num = service.incGood(seq);
		if(num==1) {
			service.incGood(seq);
			return num;
		}
		else {
			return num;
		}
	}
}
