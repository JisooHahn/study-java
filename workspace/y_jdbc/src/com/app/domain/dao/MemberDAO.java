package com.app.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.app.configuration.Configuration;
import com.app.domain.vo.MemberVO;

public class MemberDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

//	회원가입
	public void insert(MemberVO memberVO) {
		String query = "INSERT INTO TBL_MEMBER "
				+ "(ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?)";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberEmail());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			preparedStatement.setString(3, memberVO.getMemberName());
			preparedStatement.setInt(4, memberVO.getMemberAge());
			preparedStatement.setString(5, memberVO.getMemberGender());

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

//	로그인
	public MemberVO selectByMemberEmailAndMemberPassword(MemberVO memberVO) {
		MemberVO member = null;
		String query = "SELECT " + "ID, MEMBER_EMAIL, MEMBER_PASSWORD, "
				+ "MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER, CREATED_DATE, UPDATED_DATE " + "FROM TBL_MEMBER "
				+ "WHERE MEMBER_EMAIL = ? AND MEMBER_PASSWORD = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberEmail());
			preparedStatement.setString(2, memberVO.getMemberPassword());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				member = new MemberVO();

				member.setId(resultSet.getLong(1));
				member.setMemberEmail(resultSet.getString(2));
				member.setMemberPassword(resultSet.getString(3));
				member.setMemberName(resultSet.getString(4));
				member.setMemberAge(resultSet.getInt(5));
				member.setMemberGender(resultSet.getString(6));
				member.setCreatedDate(resultSet.getString(7));
				member.setUpdatedDate(resultSet.getString(8));
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

		return member;
	}

//	아이디로 회원 조회
	public MemberVO selectById(Long id) {
		MemberVO member = null;
		String query = "SELECT " + "ID, MEMBER_EMAIL, MEMBER_PASSWORD, "
				+ "MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER, CREATED_DATE, UPDATED_DATE " + "FROM TBL_MEMBER "
				+ "WHERE ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				member = new MemberVO();

				member.setId(resultSet.getLong(1));
				member.setMemberEmail(resultSet.getString(2));
				member.setMemberPassword(resultSet.getString(3));
				member.setMemberName(resultSet.getString(4));
				member.setMemberAge(resultSet.getInt(5));
				member.setMemberGender(resultSet.getString(6));
				member.setCreatedDate(resultSet.getString(7));
				member.setUpdatedDate(resultSet.getString(8));
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

		return member;
	}

//	회원 정보 수정
	public void update(MemberVO memberVO) {
		String query = "UPDATE TBL_MEMBER " + "SET MEMBER_NAME = ?, MEMBER_AGE = ?, MEMBER_GENDER = ? "
				+ "WHERE ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberName());
			preparedStatement.setInt(2, memberVO.getMemberAge());
			preparedStatement.setString(3, memberVO.getMemberGender());
			preparedStatement.setLong(4, memberVO.getId());

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
		String query = "DELETE FROM TBL_MEMBER WHERE ID = ?";

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

//	전체 회원 조회
	public ArrayList<MemberVO> selectAll() {
		MemberVO member = null;
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();

		String query = "SELECT " + "ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, "
				+ "MEMBER_AGE, MEMBER_GENDER, CREATED_DATE, UPDATED_DATE " + "FROM TBL_MEMBER";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				member = new MemberVO();

				member.setId(resultSet.getLong(1));
				member.setMemberEmail(resultSet.getString(2));
				member.setMemberPassword(resultSet.getString(3));
				member.setMemberName(resultSet.getString(4));
				member.setMemberAge(resultSet.getInt(5));
				member.setMemberGender(resultSet.getString(6));
				member.setCreatedDate(resultSet.getString(7));
				member.setUpdatedDate(resultSet.getString(8));

				members.add(member);
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

		return members;
	}

//	이메일로 회원 정보 조회
	public Optional<MemberVO> selectByMemberEmail(String memberEmail) {
		MemberVO member = null;
		String query = "SELECT " + "ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, "
				+ "MEMBER_AGE, MEMBER_GENDER, CREATED_DATE, UPDATED_DATE " + "FROM TBL_MEMBER "
				+ "WHERE MEMBER_EMAIL = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberEmail);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				member = new MemberVO();

				member.setId(resultSet.getLong(1));
				member.setMemberEmail(resultSet.getString(2));
				member.setMemberPassword(resultSet.getString(3));
				member.setMemberName(resultSet.getString(4));
				member.setMemberAge(resultSet.getInt(5));
				member.setMemberGender(resultSet.getString(6));
				member.setCreatedDate(resultSet.getString(7));
				member.setUpdatedDate(resultSet.getString(8));
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
		
		return Optional.ofNullable(member);
	}
}















