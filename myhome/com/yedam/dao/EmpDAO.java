package com.yedam.dao;

import com.yedam.common.DAO;

public class EmpDAO {

	public List<MAP<String, Object>> empList(){
		List<MAP<String, Object>> list =
				new ArrayList<Map<String, Object>>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from emp");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("사원번호", rs.getString("emp_no"))
				map.put("사원이름", rs.getString("emp_name"))
				map.put("연락처", rs.getString("emp_phone"))
				map.put("이메일", rs.getString("email"))
				
				list.add(map);
			}
		} catch (SQLexception e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}
}
