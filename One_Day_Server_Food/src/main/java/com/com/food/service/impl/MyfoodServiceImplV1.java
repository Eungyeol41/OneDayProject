package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;
import com.com.food.persistence.DBContract;
import com.com.food.service.MyfoodService;

public class MyfoodServiceImplV1 implements MyfoodService{

	protected Connection dbConn;
	public MyfoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	protected List<TotalDTO> select(PreparedStatement pStr) throws SQLException {
		
		ResultSet rSet = pStr.executeQuery();
		
		List<TotalDTO> totalList = new ArrayList<TotalDTO>();
		while(rSet.next()) {
			TotalDTO tVO = new TotalDTO();
			tVO.setMf_date(rSet.getString("날짜"));
			tVO.setMf_intake(rSet.getInt("섭취량"));
			tVO.setFd_fname(rSet.getString("식품명"));
			tVO.setFd_energy(rSet.getInt("에너지"));
			tVO.setFd_protein(rSet.getInt("단백질"));
			tVO.setFd_fat(rSet.getInt("지방"));
			tVO.setFd_car(rSet.getInt("탄수화물"));
			tVO.setFd_sugar(rSet.getInt("총당류"));
			totalList.add(tVO);
		}
		rSet.close();
		
		return totalList;
	}
	
	@Override
	public List<TotalDTO> selectAll() {
		// TODO 전체리스트 보여주기
		
		String sql = "SELECT * FROM view_식품정보, tbl_myfoods";
		sql += "WHERE " + 
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.close();
			return totalList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TotalDTO> findByDate(String date) {
		// TODO 날짜로 조회하기
		
		String sql = "SELECT * FROM tbl_myfoods";
		sql += "WHERE mf_date = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			
			List<TotalDTO> totalList = new ArrayList<TotalDTO>();
			ResultSet rSet = pStr.executeQuery();
			while (rSet.next()) {
				TotalDTO tDTO = new TotalDTO();
				tDTO.setMf_date(rSet.getString("날짜"));
				tDTO.setMf_intake(rSet.getInt("섭취량"));
				tDTO.setFd_fname(rSet.getString("식품명"));
				tDTO.setFd_energy(rSet.getInt("에너지"));
				tDTO.setFd_protein(rSet.getInt("단백질"));
				tDTO.setFd_fat(rSet.getInt("지방"));
				tDTO.setFd_car(rSet.getInt("탄수화물"));
				tDTO.setFd_sugar(rSet.getInt("총당류"));
				totalList.add(tDTO);
			}
			System.out.println(totalList.toString());
			pStr.close();
			return totalList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(MyfoodVO myfoodVO) {
		// TODO 섭취정보 추가
		String sql = "INSERT INTO tbl_myfoods";
		sql += "(mf_seq, mf_date, mf_ccode, mf_intake) ";
		sql += "VALUES(food_seq.NEXTVAL, ?, ?, ? ) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_date());
			pStr.setString(2, myfoodVO.getMf_ccode());
//			pStr.setInt(3, myfoodVO.getMf_intake());
			
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
