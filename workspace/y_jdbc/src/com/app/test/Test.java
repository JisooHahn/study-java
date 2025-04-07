package com.app.test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.domain.dao.MemberDAO;
import com.app.domain.dao.PostDAO;
import com.app.domain.dao.ReplyDAO;
import com.app.domain.dto.PostDTO;
import com.app.domain.dto.ReplyDTO;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.ReplyVO;
import com.app.exception.post.PostNotFoundException;

public class Test {
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		PostDAO postDAO = new PostDAO();
		ReplyDAO replyDAO = new ReplyDAO();
		
//		회원가입 화면
//		String memberEmail = "hgd5555@naver.com";
//		String memberPassword = "5555";
//		String memberName = "홍길동";
//		int memberAge = 20;
//		String memberGender = "여자";
//		
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMemberEmail(memberEmail);
//		memberVO.setMemberPassword(memberPassword);
//		memberVO.setMemberName(memberName);
//		memberVO.setMemberAge(memberAge);
//		memberVO.setMemberGender(memberGender);
//		
////		System.out.println(memberVO);
//		
//		memberDAO.insert(memberVO);
		
//		로그인
//		String memberEmail = "hds1234@gmail.com";
//		String memberPassword = "fdsfdsf";
//		
//		MemberVO member = new MemberVO();
//		member.setMemberEmail(memberEmail);
//		member.setMemberPassword(memberPassword);
//		
////		System.out.println(memberDAO.selectByMemberEmailAndMemberPassword(member));
//		member = memberDAO.selectByMemberEmailAndMemberPassword(member).orElseThrow(() -> {
//			throw new LoginException("로그인 실패");
//		});
//		
//		System.out.println(member);
		
//		회원 조회
//		Long id = 1L;
//		System.out.println(memberDAO.selectById(id));
		
//		회원 수정
//		Long id = 1L;
//		MemberVO member = memberDAO.selectById(id);
//		
//		member.setMemberName("홍길동");
//		memberDAO.update(member);
		
//		회원 삭제
//		Long id = 1L;
//		MemberVO member = memberDAO.selectById(id);
//		
//		memberDAO.delete(member.getId());
		
//		회원 전체 조회
//		memberDAO.selectAll().forEach((member) -> {
//			System.out.println(member);
//		});
		
//		이메일 중복검사
//		String memberEmail = "hds@gmail.com";
//		Optional<MemberVO> foundMember = memberDAO.selectByMemberEmail(memberEmail);
//		System.out.println(foundMember.isPresent());
		
//		게시글 추가
//		Long memberId = 21L;
//		MemberVO member = memberDAO.selectById(memberId);
//		PostVO post = new PostVO();
//		
//		post.setPostTitle("테스트 제목1");
//		post.setPostContent("테스트 내용1");
//		post.setMemberId(member.getId());
		
//		postDAO.insert(post);
		
//		memberId = 22L;
//		member = memberDAO.selectById(memberId);
//		post = new PostVO();
//		
//		post.setPostTitle("테스트 제목3");
//		post.setPostContent("테스트 내용3");
//		post.setMemberId(member.getId());
		
//		postDAO.insert(post);
		
//		Optional<PostDTO> foundPost = postDAO.selectById(32321L);
//		foundPost.ifPresent((post) -> {
//			System.out.println(post);
//		});
//		PostDTO post = foundPost.orElse(new PostDTO());
//		System.out.println(post);
		
//		PostDTO post = foundPost.orElseThrow(() -> {throw new PostNotFoundException("게시글 조회 실패");});
//		System.out.println(post);
		
//		게시글 수정
//		Optional<PostDTO> foundPost = postDAO.selectById(1L);
//		PostDTO post = foundPost.orElseThrow(() -> {throw new PostNotFoundException();});
//		PostVO postVO = new PostVO();
//		
//		post.setPostTitle("수정된 제목");
//		
//		postVO.setId(post.getId());
//		postVO.setPostTitle(post.getPostTitle());
//		postVO.setPostContent(post.getPostContent());
//		
//		postDAO.update(postVO);
		
//		게시글 삭제(작성한 게시글인지 검사)
//		게시글을 작성한 member랑 post가 입력받은 id랑 동일한지 검사 후 동일하면 해당 게시글 삭제
//		Long memberId = 21L;
//		Long postId = 2L;
//		MemberVO member = memberDAO.selectById(memberId);
//		Optional<PostDTO> foundPost = postDAO.selectById(postId);
//		PostDTO post = foundPost.orElseThrow(() -> {throw new PostNotFoundException();});
//		if(member.getId() == post.getMemberId()) {
//			postDAO.delete(post.getId());
//		}
		
//		게시글 전체 목록
//		postDAO.selectAll().forEach((post) -> {
//			System.out.println(post);
//		});
		
//		댓글 작성
//		MemberVO member = memberDAO.selectById(21L);
//		Optional<PostDTO> foundPost = postDAO.selectById(1L);
//		PostDTO post = foundPost.orElseThrow(() -> {throw new PostNotFoundException();});
//		ReplyVO reply = new ReplyVO();
//		
//		reply.setMemberId(member.getId());
//		reply.setPostId(post.getId());
//		reply.setReplyContent("테스트 댓글1");
//		
//		replyDAO.insert(reply);
		
//		전체 목록(전체 목록 중, 내가 작성한 댓글인지 검사, 이후 수정 및 삭제 테스트)
		ReplyVO reply = new ReplyVO();
		MemberVO member = memberDAO.selectById(21L);	// 멤버DAO에서 입력한 id로 멤버 조회
		Optional<PostDTO> foundPost = postDAO.selectById(1L);	// 게시글DAO에서 입력한 id로 게시글 조회(Optional)
//		Optional에서 값이 존재하면 PostDTO로 저장, 존재하지 않으면 예외처리(Optional은 예외처리를 해야만 함)
		PostDTO post = foundPost.orElseThrow(() -> {throw new PostNotFoundException();});
		
//		해당 게시글의 모든 댓글을 조회하여 리스트 형태로 가져옴
		ArrayList<ReplyDTO> replies = 
//				게시글 id를 이용해 해당 게시글의 모든 댓글을 조회
				(ArrayList<ReplyDTO>) replyDAO.selectAll(post.getId()).stream()	// 리스트를 stream으로 변환(기능 사용
//				현재 회원이 작성한 댓글만 필터링(입력한 member의 id랑 댓글에 등록된 member의 id가 동일한지 조회)
					.filter((replyDTO) -> replyDTO.getMemberId() == member.getId())
						.collect(Collectors.toList());	// 필터링된 결과를 리스트로 변환하여 저장
		
//		replies 리스트 안에는 현재 회원(member.getId())이 작성한 댓글만 포함(비어있으면 예외)
		
//		System.out.println(replies);
		replies.get(0).setReplyContent("수정된 댓글");	// 첫 번째 댓글 객체를 가져와 해당 댓글의 내용 수정
		
		reply.setId(replies.get(0).getId());	// 수정할 댓글의 id를 reply 객체에 설정
		reply.setReplyContent(replies.get(0).getReplyContent());	// 변경된 댓글 내용을 reply 객체에 설정
		
//		수정
//		replyDAO.update(reply);
		
//		삭제
		replyDAO.delete(replies.get(0).getId());	// 첫 번째 댓글을 데이터베이스에서 삭제
		

	}
}























