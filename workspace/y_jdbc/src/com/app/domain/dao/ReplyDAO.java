package com.app.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.app.configuration.Configuration;
import com.app.domain.dto.ReplyDTO;
import com.app.domain.vo.ReplyVO;

public class ReplyDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

//	추가
	public void insert(ReplyVO replyVO) {
		String query = "INSERT INTO TBL_REPLY " + "(ID, REPLY_CONTENT, POST_ID, MEMBER_ID) "
				+ "VALUES(SEQ_REPLY.NEXTVAL, ?, ?, ?)";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, replyVO.getReplyContent());
			preparedStatement.setLong(2, replyVO.getPostId());
			preparedStatement.setLong(3, replyVO.getMemberId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	수정
	public void update(ReplyVO replyVO) {
		String query = "UPDATE TBL_REPLY " 
				+ "SET REPLY_CONTENT = ?, UPDATED_DATE = SYSDATE " 
				+ "WHERE ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, replyVO.getReplyContent());
			preparedStatement.setLong(2, replyVO.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	삭제
	public void delete(Long id) {
		String query = "DELETE FROM TBL_REPLY " + "WHERE ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	전체 목록
	public ArrayList<ReplyDTO> selectAll(Long postId) {
		ReplyDTO reply = null;
		ArrayList<ReplyDTO> replies = new ArrayList<ReplyDTO>();
		
		String query = "SELECT "
				+ "R.ID, R.REPLY_CONTENT, R.POST_ID, R.CREATED_DATE, R.UPDATED_DATE, " 
				+ "R.MEMBER_ID, M.MEMBER_NAME "
				+ "FROM TBL_MEMBER M " 
				+ "JOIN TBL_REPLY R " 
				+ "ON M.ID = R.MEMBER_ID AND R.POST_ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, postId);
			resultSet = preparedStatement.executeQuery(); 
			
			while(resultSet.next()) {
	            reply = new ReplyDTO();
	            
	            reply.setId(resultSet.getLong(1));
	            reply.setReplyContent(resultSet.getString(2));
	            reply.setPostId(resultSet.getLong(3));
	            reply.setCreatedDate(resultSet.getString(4));
	            reply.setUpdatedDate(resultSet.getString(5));
	            reply.setMemberId(resultSet.getLong(6));
	            reply.setMemberName(resultSet.getNString(7));
	            
	            replies.add(reply);
	      }
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return replies;
	}

}
