import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    // Get all employees from DB
    public static ArrayList<Employee> getAllEmployees(Connection conn) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("e_id"),
                        rs.getString("e_name"),
                        rs.getString("e_address"),
                        rs.getString ("e_phone"),
                        rs.getString("e_position"),
                        rs.getInt("e_age"),
                        rs.getLong("e_salary")
                ));
            }
        }
        return employees;
    }

    // Add other DB methods (add, update, delete)
    public static void addEmployee(Connection conn, Employee emp) throws SQLException {
        String sql = "INSERT INTO Employee (...) VALUES (?, ?, ...)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getEmpId());
            stmt.setString(2, emp.getEmpName());
            stmt.setString(3, emp.getEmpAddress());
            stmt.setString(4, emp.getEmpPhone());
            stmt.setString(5, emp.getEmpPost());
            stmt.setInt(6, emp.getEmpAge());
            stmt.setLong(7, emp.getEmpSalary());
            stmt.executeUpdate();
        }
    }

    public static void updateEmployee(Connection conn, int empId, Map<String, Object> updates) throws SQLException {
        if (updates.isEmpty()) return;

        StringBuilder sql = new StringBuilder("UPDATE Employee SET ");
        List<Object> values = new ArrayList<>();
        // Building SET clauses ("e_name=?, e_position = ?")
        updates.forEach((field, value) -> {
            sql.append(field).append(" = ?, ");
            values.add(value);
        });
        sql.setLength(sql.length() - 2); //removing trailing ","
        sql.append(" WHERE e_id = ?");
        values.add(empId);

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i= 0; i<values.size(); i++){
                stmt.setObject(i+1, values.get(i));
            }
            stmt.executeUpdate();
        }
    }

    public static void deleteEmployee(Connection conn, int empId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE e_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            stmt.executeUpdate();
        }
    }

    public static boolean existsById(Connection conn, int empId) throws SQLException{
        String sql = "SELECT * FROM Employee WHERE e_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // returns 'true' if employee exists
            }
        }
    }

    public  static Employee getEmployeeById(Connection conn, int empId) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE e_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("e_id"),
                            rs.getString("e_name"),
                            rs.getString("e_address"),
                            rs.getString ("e_phone"),
                            rs.getString("e_position"),
                            rs.getInt("e_age"),
                            rs.getLong("e_salary")
                    );
                }
            }
        }
        return null;  // if not found
    }
}
