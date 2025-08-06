package com.example.jpaboard.service;

import com.example.jpaboard.dto.BoardResponseDto;
import com.example.jpaboard.entity.Board;
import com.example.jpaboard.entity.Member;
import com.example.jpaboard.repository.BoardRepository;
import com.example.jpaboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class boardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }
}
