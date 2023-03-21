package com.CustomSoft.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.CustomSoft.db.PagingVo;
import com.CustomSoft.db.ReplyDto;
import com.CustomSoft.db.dto.board.*;

@Mapper
public interface BoardMapper {
	
	//게시글 등록
	public void addBoard(BoardDto dto) throws Exception;
	
	//게시글 삭제
	public void delBoard(int seq);
	
	//게시판 출력
	public List<BoardDto> getBoard(String searchBoard);
	
	//게시글 총 갯수
	public int countBoard();
	
	//페이징처리 게시글 조회
	public List<BoardDto> selectBoard(PagingVo vo);
	
	//게시글 상세페이지
	public BoardDto detailBoard(int board_seq);
	
	//게시글 수정
	public void modifyBoard(Map<String, String> map) throws Exception;
	
	//댓글 불러오기
	public List<ReplyDto> getReply(int seq);
	
	//댓글 쓰기
	public void addReply(ReplyDto dto);
	
	//조회수 증가
	public void incView(int seq);
	
	//댓글 갯수 카운트
	public int[] cntReply(int seq);
	
	public int selectSeq();
	
	public void addGood(int seq);
	
	public int incGood(int seq);
}
