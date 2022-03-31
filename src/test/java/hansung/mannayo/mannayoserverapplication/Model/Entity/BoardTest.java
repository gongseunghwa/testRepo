package hansung.mannayo.mannayoserverapplication.Model.Entity;

import hansung.mannayo.mannayoserverapplication.Repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void boardTest(){
        Member member = new Member();
        member.setNickName("aa");
        member.setEmail("tmdhk502@naver.com");
        member.setPassword("tmdghk9609!");
        member.setPhoneNumber("010-0202-0303");
        member.setBirth(LocalDate.now());
        member.setReportCount(1);

        Board board = Board.builder()
                .member(member)
                .title("title")
                .contents("hi")
                .build();

        Board savedBoard1 = boardRepository.save(board);

    }



}