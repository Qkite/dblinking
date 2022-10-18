package seoulhospital;

import java.sql.SQLException;

public class Main {

    String filePath = "C:\\Users\\yeonji\\Desktop\\seoulhospital.csv";





    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDaoHospital userDaoHospital = new UserDaoHospital();
        String[] input1 = {"A1120837", "C", "2", "가산기대찬의원"};

        userDaoHospital.add(input1);
    }



}
