package com.app.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.app.configuration.Configuration;
import com.app.domain.dto.PostDTO;
import com.app.domain.vo.PostVO;

public class PostDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
//	추가하기
	public void insert(PostVO postVO) {
		String query = "INSERT INTO TBL_POST "
				+ "(ID, POST_TITLE, POST_CONTENT, MEMBER_ID) "
				+ "VALUES(SEQ_POST.NEXTVAL, ?, ?, ?)";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, postVO.getPostTitle());
			preparedStatement.setString(2, postVO.getPostContent());
			preparedStatement.setLong(3, postVO.getMemberId());
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
				throw new RuntimeException();
			}
		}
	}

//	조회하기
	public Optional<PostDTO> selectById(Long id) {
		PostDTO post = null;
		String query = "SELECT "
				+ "P.ID, P.POST_TITLE, P.POST_CONTENT, P.POST_READ_COUNT, P.CREATED_DATE, P.UPDATED_DATE, "
				+ "P.MEMBER_ID, M.MEMBER_NAME "
				+ "FROM TBL_MEMBER M "
				+ "JOIN TBL_POST P "
				+ "ON M.ID = P.MEMBER_ID AND P.ID = ?";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				post = new PostDTO();
				
				post.setId(resultSet.getLong(1));
				post.setPostTitle(resultSet.getString(2));
				post.setPostContent(resultSet.getString(3));
				post.setPostReadCount(resultSet.getInt(4));
				post.setCreatedDate(resultSet.getString(5));
				post.setUpdatedDate(resultSet.getString(6));
				post.setMemberId(resultSet.getLong(7));
				post.setMemberName(resultSet.getString(8));
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
				throw new RuntimeException();
			}
		}
		
		return Optional.ofNullable(post);
	}
	
	
//	수정하기
	public void update(PostVO postVO) {
		String query = "UPDATE TBL_POST "
				+ "SET POST_TITLE = ?, POST_CONTENT = ?, UPDATED_DATE = SYSDATE "
				+ "WHERE ID = ?";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, postVO.getPostTitle());
			preparedStatement.setString(2, postVO.getPostContent());
			preparedStatement.setLong(3, postVO.getId());
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
				throw new RuntimeException();
			}
		}
	}
	
	
//	삭제하기
	public void delete(Long id) {
		String query = "DELETE FROM TBL_POST WHERE ID = ?";
		
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
				throw new RuntimeException();
			}
		}
	}
	
//	전체 조회하기
	public ArrayList<PostDTO> selectAll() {
		ArrayList<PostDTO> posts = new ArrayList<PostDTO>();
		PostDTO post = null;
		String query = "SELECT "
				+ "P.ID, P.POST_TITLE, P.POST_CONTENT, P.POST_READ_COUNT, P.CREATED_DATE, P.UPDATED_DATE, "
				+ "P.MEMBER_ID, M.MEMBER_EMAIL, M.MEMBER_PASSWORD, M.MEMBER_NAME, M.MEMBER_AGE, M.MEMBER_GENDER "
				+ "FROM TBL_MEMBER M "
				+ "JOIN TBL_POST P "
				+ "ON M.ID = P.MEMBER_ID";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				post = new PostDTO();
				
				post.setId(resultSet.getLong(1));
				post.setPostTitle(resultSet.getString(2));
				post.setPostContent(resultSet.getString(3));
				post.setPostReadCount(resultSet.getInt(4));
				post.setCreatedDate(resultSet.getString(5));
				post.setUpdatedDate(resultSet.getString(6));
				post.setMemberId(resultSet.getLong(7));
				post.setMemberName(resultSet.getString(8));
				
				posts.add(post);
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
				throw new RuntimeException();
			}
		}
		
		return posts;
	}
}

























