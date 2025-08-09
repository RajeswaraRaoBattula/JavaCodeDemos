package daofiles;

import java.util.List;

import springprograms.VehicleJDBCBean;

public interface VehicleJDBCDAO 
{
	  int insertVehicle(VehicleJDBCBean v);
	    int updateVehicle(VehicleJDBCBean v);
	    int deleteVehicle(int id);
	    VehicleJDBCBean getVehicle(int id);
	    List<VehicleJDBCBean> getAllVehicles();

}
