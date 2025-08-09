package daofiles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springprograms.VehicleJDBCBean;

/*
 * JdbcTemplate Class Methods:
 * 
 * | Operation       | Method                                |
| --------------- | ------------------------------------- |
| Insert/Update   | `update()`                            |
| Select (List)   | `query()`                             |
| Select (Single) | `queryForObject()`                    |
| Count           | `queryForInt()` or `queryForObject()` |
| Batch Insert    | `batchUpdate()`                       |

 */

/*
 * | Feature                   | `JdbcTemplate`          | `Statement` | `PreparedStatement` |
| ------------------------- | ----------------------- | ----------- | ------------------- |
| SQL injection safe        | ✅ Yes                   | ❌ No        | ✅ Yes               |
| Placeholder support (`?`) | ✅ Yes                   | ❌ No        | ✅ Yes               |
| Reusability of query plan | ✅ Yes                   | ❌ No        | ✅ Yes               |
| Cleaner syntax            | ✅ Very clean            | ❌ Verbose   | ❌ Verbose           |
| Manages connection/close  | ✅ Yes                   | ❌ No        | ❌ No                |
| Requires boilerplate      | ❌ No                    | ✅ Yes       | ✅ Yes               |
| Return mapping            | ✅ Auto with `RowMapper` | ❌ Manual    | ❌ Manual            |
| Exception Handling        | ✅ Done by Spring        | ❌ Manual    | ❌ Manual            |

 */
public class VehicleJDBCDAOImpl implements VehicleJDBCDAO 
{

    private JdbcTemplate jdbcTemplate11;
    
    public void setJdbcTemplate11(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate11 = jdbcTemplate;
    }

	@Override
	public int insertVehicle(VehicleJDBCBean v) {
	       String sql = "INSERT INTO vehicle VALUES (?, ?, ?, ?)";
	        return jdbcTemplate11.update(sql, v.getId(), v.getModel(), v.getColor(), v.getYear());
	 	}

	@Override
	public int updateVehicle(VehicleJDBCBean v) {
	       String sql = "UPDATE vehicle SET model=?, color=?, year=? WHERE id=?";
	        return jdbcTemplate11.update(sql, v.getModel(), v.getColor(), v.getYear(), v.getId());
	 
	}

	@Override
	public int deleteVehicle(int id) {
	       String sql = "DELETE FROM vehicle WHERE id=?";
	        return jdbcTemplate11.update(sql, id);
	 }
/*
 * | Feature                    | `executeQuery()`           | `queryForObject()`                          |
| -------------------------- | -------------------------- | ------------------------------------------- |
| Belongs to                 | JDBC (`PreparedStatement`) | Spring (`JdbcTemplate`)                     |
| Return type                | `ResultSet`                | Any object (like `String`, `Integer`, POJO) |
| Needs manual mapping       | ✅ Yes                      | ❌ No (uses `RowMapper`)                     |
| Handles connection/cleanup | ❌ No                       | ✅ Yes                                       |
| Handles exceptions         | ❌ You do                   | ✅ Spring does                               |
| Use case                   | When using pure JDBC       | When using Spring JDBC and expecting 1 row  |
*/
	@Override
	public VehicleJDBCBean getVehicle(int id) {
        String sql = "SELECT * FROM vehicle WHERE id=?";
        try
        {
        return jdbcTemplate11.queryForObject(sql, new Object[]{id}, new VehicleMapper());
        }
        catch (EmptyResultDataAccessException e) 
        {
        	//System.out.println("Record Not Found!");
        	return null;
        }
}
//A RowMapper<T> is a Spring JDBC interface used to map a row of a ResultSet to a Java object (T) — typically a POJO.
    class VehicleMapper implements RowMapper<VehicleJDBCBean> 
    {
        public VehicleJDBCBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        	VehicleJDBCBean v = new VehicleJDBCBean();
            v.setId(rs.getInt("id"));
            v.setModel(rs.getString("model"));
            v.setColor(rs.getString("color"));
            v.setYear(rs.getInt("year"));
            return v;
        }
    }
	@Override
	public List<VehicleJDBCBean> getAllVehicles() {
	       String sql = "SELECT * FROM vehicle";
	       return jdbcTemplate11.query(sql, new VehicleMapper());
	      }

}
