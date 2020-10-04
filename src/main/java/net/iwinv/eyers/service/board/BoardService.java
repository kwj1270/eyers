package net.iwinv.eyers.service.board;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers.domain.board.Board;
import net.iwinv.eyers.domain.board.BoardRepository;
import net.iwinv.eyers.dto.board.BoardListResponseDto;
import net.iwinv.eyers.dto.board.BoardResponseDto;
import net.iwinv.eyers.dto.board.BoardSaveRequestDto;
import net.iwinv.eyers.dto.board.BoardUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<BoardListResponseDto> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10);
        return boardRepository.findAll(pageable).map(BoardListResponseDto::new);
    }

    @Transactional
    public long save(BoardSaveRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 유저 정보 삭제
    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + id));
        return new BoardResponseDto(entity);
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 공지가 없습니다" + id));
        board.update(requestDto.getTitle(), requestDto.getSubtitle(), requestDto.getContent());
        return id;
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long id) {
         Board board = boardRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + id));
        boardRepository.delete(board);
    }

}
