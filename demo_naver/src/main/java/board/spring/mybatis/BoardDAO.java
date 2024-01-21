package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {
	
	int insertBoard(BoardDTO dto);
	
	List<BoardDTO> boardList(int[] limit);
	
	int getTotalBoard();
	
	int updateViewcount(int seq);
	
	BoardDTO getDetail(int seq);
	
	int deleteBoard(int seq);
	
	int updateBoard(BoardDTO dto);
}






