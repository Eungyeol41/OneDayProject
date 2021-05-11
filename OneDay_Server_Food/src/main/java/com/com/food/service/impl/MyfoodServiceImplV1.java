package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyfoodVO;
import com.com.food.model.TotalDTO;
import com.com.food.persistence.DBContract;
import com.com.food.service.MyfoodService;

public class MyfoodServiceImplV1 implements MyfoodService {

	protected Connection dbConn;

	public MyfoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {

		ResultSet rSet = pStr.executeQuery();

		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		while (rSet.next()) {

			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setMf_date(rSet.getString("날짜"));
			foodDTO.setMf_code(rSet.getString("식품코드"));
			foodDTO.setMf_name(rSet.getString("식품명"));
			foodDTO.setMf_intake(rSet.getInt("섭취량"));
			foodDTO.setMf_total(rSet.getInt("총내용량"));
			foodDTO.setMf_energy(rSet.getInt("에너지"));
			foodDTO.setMf_protein(rSet.getInt("단백질"));
			foodDTO.setMf_fat(rSet.getInt("지방"));
			foodDTO.setMf_car(rSet.getInt("탄수화물"));
			foodDTO.setMf_sugar(rSet.getInt("총당류"));
			foodList.add(foodDTO);
		} // end while

		return foodList;
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO 전체리스트 보여주기

		String sql = "SELECT * FROM view_나의섭취정보";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();

			List<FoodDTO> foodList = new ArrayList<FoodDTO>();
			while (rSet.next()) {

				FoodDTO foodDTO = new FoodDTO();
				foodDTO.setMf_date(rSet.getString("날짜"));
				foodDTO.setMf_code(rSet.getString("식품코드"));
				foodDTO.setMf_name(rSet.getString("식품명"));
				foodDTO.setMf_intake(rSet.getInt("섭취량"));
				foodDTO.setMf_total(rSet.getInt("총내용량"));
				foodDTO.setMf_energy(rSet.getInt("에너지"));
				foodDTO.setMf_protein(rSet.getInt("단백질"));
				foodDTO.setMf_fat(rSet.getInt("지방"));
				foodDTO.setMf_car(rSet.getInt("탄수화물"));
				foodDTO.setMf_sugar(rSet.getInt("총당류"));
				foodList.add(foodDTO);
			} // end while
			rSet.close();
			pStr.close();
			return foodList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FoodDTO> findByDate(String date) {
		// TODO 날짜로 조회하기

		String sql = "SELECT * FROM view_나의섭취정보";
		sql += " WHERE 날짜 = ? ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);

			ResultSet rSet = pStr.executeQuery();

			List<FoodDTO> foodList = new ArrayList<FoodDTO>();
			while (rSet.next()) {

				FoodDTO foodDTO = new FoodDTO();
				foodDTO.setMf_date(rSet.getString("날짜"));
				foodDTO.setMf_code(rSet.getString("식품코드"));
				foodDTO.setMf_name(rSet.getString("식품명"));
				foodDTO.setMf_intake(rSet.getInt("섭취량"));
				foodDTO.setMf_total(rSet.getInt("총내용량"));
				foodDTO.setMf_energy(rSet.getInt("에너지"));
				foodDTO.setMf_protein(rSet.getInt("단백질"));
				foodDTO.setMf_fat(rSet.getInt("지방"));
				foodDTO.setMf_car(rSet.getInt("탄수화물"));
				foodDTO.setMf_sugar(rSet.getInt("총당류"));
				foodList.add(foodDTO);
			} // end while
			rSet.close();
			pStr.close();
			return foodList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TotalDTO> findByfName(String fd_fname) {
		// TODO 식품명으로 조회하기

		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, fd_fname);

			ResultSet rSet = pStr.executeQuery();

			List<TotalDTO> totalList = new ArrayList<TotalDTO>();
			while (rSet.next()) {
				TotalDTO tDTO = new TotalDTO();
				tDTO.setFd_fcode(rSet.getString("식품코드"));
				tDTO.setFd_fname(rSet.getString("식품명"));
				tDTO.setFd_year(rSet.getInt("출시연도"));
				tDTO.setCp_com(rSet.getString("제조사명"));
				tDTO.setIt_name(rSet.getString("분류명"));
				tDTO.setFd_one(rSet.getInt("1회제공량"));
				tDTO.setFd_total(rSet.getInt("총내용량(g)"));
				tDTO.setFd_energy(rSet.getInt("에너지(kcal)"));
				tDTO.setFd_protein(rSet.getInt("단백질(g)"));
				tDTO.setFd_fat(rSet.getInt("지방(g)"));
				tDTO.setFd_car(rSet.getInt("탄수화물(g)"));
				tDTO.setFd_sugar(rSet.getInt("총당류(g)"));
				totalList.add(tDTO);
			}
			rSet.close();
			pStr.close();
			return totalList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(MyfoodVO myfoodVO) { // myfoodVO or TotalDTO
		// TODO 섭취정보 추가
		String sql = "INSERT INTO tbl_myfoods";
		sql += "(mf_seq, mf_date, mf_fcode, mf_intake) ";
		sql += "VALUES(food_seq.NEXTVAL, ?, ?, ? ) ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_date());
			pStr.setString(2, myfoodVO.getMf_fcode());
			pStr.setInt(3, myfoodVO.getMf_intake());

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
