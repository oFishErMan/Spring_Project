package com.CustomSoft.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomSoft.Mapper.BoardMapper;
import com.CustomSoft.db.PagingVo;
import com.CustomSoft.db.ReplyDto;
import com.CustomSoft.db.dto.board.BoardDto;

@Service
public class BoardService {

	@Autowired
	BoardMapper mapper;

	// 글 쓰기
	public void addBoard(BoardDto dto) throws Exception {
		System.out.println("Boardservice addBoard 호출" + dto.getBoard_text());
		mapper.addBoard(dto);
		int num = mapper.selectSeq();
		mapper.addGood(num);
	}

	// 게시글 삭제
	public void delBoard(int seq_list) {
		System.out.println("BoardService의 delBoard 호출");
		mapper.delBoard(seq_list);
	}

	// 페이징을 위한 전체 게시글 갯수 불러오기
	public int countBoard() {
		return mapper.countBoard();
	}

	// 게시글 리스트 불러오기
	public List<BoardDto> selectBoard(PagingVo vo) {
		System.out.println("BoardService selectBoard() 호출");
		return mapper.selectBoard(vo);
	}

	// 게시글 상세 페이지
	public BoardDto detailBoard(int board_seq) {
		System.out.println("BoardService detailBoard() 호출");
		BoardDto dto = mapper.detailBoard(board_seq);
		return dto;
	}

	// 게시글 수정
	public void modifyBoard(Map<String, String> map) throws Exception {
		System.out.println("Boardservice modifyBoard 호출");
		mapper.modifyBoard(map);
	}

	// 댓글 불러오기
	public List<ReplyDto> getReply(int seq) {
		System.out.println("Boardservice getReply 호출");

		return mapper.getReply(seq);
	};

	// 댓글 쓰기
	public void addReply(ReplyDto dto) {
		System.out.println("Boardservice addReply 호출");
		mapper.addReply(dto);
	}

	// 조회수 증가
	public void incView(int seq) {
		mapper.incView(seq);
	}

	// 댓글 갯수 카운트
	public int[] cntReply(int seq) {
		return mapper.cntReply(seq);
	}
	
	public int incGood(int seq) {
		return mapper.incGood(seq);
	}
	
}
